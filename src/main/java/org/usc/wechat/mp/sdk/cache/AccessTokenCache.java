package org.usc.wechat.mp.sdk.cache;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.vo.token.AccessTokeJsonRtn;
import org.usc.wechat.mp.sdk.vo.token.DelayItem;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.primitives.Ints;

public class AccessTokenCache {
    private final static Logger log = LoggerFactory.getLogger(AccessTokenCache.class);
    private final static String JSON_RTN_SUCCESS_CODE = "0";

    private final static DelayQueue<DelayItem<License>> queue = new DelayQueue<DelayItem<License>>();
    private final static LoadingCache<License, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<License, String>() {
        @Override
        public String load(License license) throws Exception {
            URIBuilder uriBuilder = new URIBuilder("https://api.weixin.qq.com/cgi-bin/token");
            uriBuilder.addParameter("grant_type", "client_credential");
            uriBuilder.addParameter("appid", license.getAppId());
            uriBuilder.addParameter("secret", license.getAppSecret());

            log.info("get access token for {}, url = {}", license, uriBuilder);
            HttpGet httpget = new HttpGet(uriBuilder.build());
            try {
                HttpResponse response = HttpClientBuilder.create().build().execute(httpget);
                if (response == null) {
                    log.info("http no response when get access token for {}", license);
                    return StringUtils.EMPTY;
                }

                String json = EntityUtils.toString(response.getEntity());
                log.info("get access token for {}, rtn = {}", license, json);

                AccessTokeJsonRtn rtn = JSONObject.parseObject(json, AccessTokeJsonRtn.class);
                if (rtn == null) {
                    log.info("parse return json msg failed when get access token for {}, rtn = {}", license, json);
                    return StringUtils.EMPTY;
                }

                if (StringUtils.isNotEmpty(rtn.getErrCode()) && !StringUtils.equals(JSON_RTN_SUCCESS_CODE, rtn.getErrCode())) {
                    log.info("get access token for {} failed, rtn = {}", license, rtn);
                    return StringUtils.EMPTY;
                }

                // for safe, expiresSeconds - 60s
                int expiresSeconds = Ints.max(rtn.getExpiresIn() - 60, 0);
                queue.put(new DelayItem<License>(license, TimeUnit.NANOSECONDS.convert(expiresSeconds, TimeUnit.SECONDS)));

                String accessToken = rtn.getAccessToken();
                log.info("get access token for {} success, rtn = {}", license, accessToken);
                return accessToken;
            } finally {
                httpget.releaseConnection();
            }

        }
    });

    static {
        Thread daemonThread = new Thread(new Runnable() {
            public void run() {
                delayCheck();
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
    }

    private static void delayCheck() {
        while (true) {
            try {
                DelayItem<License> delayItem = queue.take();
                if (delayItem != null) {
                    cache.invalidate(delayItem.getItem());// invalidate cache for expiry/delay item
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static String getAccessToken(License license) {
        try {
            return cache.get(license);
        } catch (Exception e) {
            log.error("get access token failed at " + license, e);
            return StringUtils.EMPTY;
        }
        // maybe throw exception when accessToken is empty,
    }
}
