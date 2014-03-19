package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;

import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.cache.AccessTokenCache;
import org.usc.wechat.mp.sdk.util.Constant;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.group.GroupJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.GroupWarpper;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class GroupUtil {
    private final static Logger log = LoggerFactory.getLogger(GroupUtilTest.class);

    public static GroupJsonRtn createGroup(License license, GroupWarpper groupWarpper) {
        if (groupWarpper == null || groupWarpper.getGroup() == null) {
            return null;
        }

        String body = JSONObject.toJSONString(groupWarpper);
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_CREATE_GROUP_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);

            GroupJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupJsonRtn.class);
            log.info("create group:\n url={},\n body={},\n rtn={},{}", uri, groupWarpper, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "create group failed:\n " +
                    "url=" + Constant.WECHAT_CREATE_GROUP_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

}
