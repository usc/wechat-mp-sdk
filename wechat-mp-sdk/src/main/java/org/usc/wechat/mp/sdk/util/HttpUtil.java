package org.usc.wechat.mp.sdk.util;

import java.io.IOException;
import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.platform.AccessTokenUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class HttpUtil {
    private final static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * handle response's entity to utf8 text
     */
    public static final ResponseHandler<String> UTF8_CONTENT_HANDLER = new ResponseHandler<String>() {
        @Override
        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
            final StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, "UTF-8");
            }

            return StringUtils.EMPTY;
        }
    };

    public static <T extends JsonRtn> T postBodyRequest(WechatRequest request, License license, Object requestBody, Class<T> jsonRtnClazz) {
        if (request == null || license == null || requestBody == null || jsonRtnClazz == null) {
            return null;
        }

        String requestUrl = request.getUrl();
        String requestName = request.getName();
        String accessToken = AccessTokenUtil.getAccessToken(license);
        String body = JSONObject.toJSONString(requestBody);
        try {
            URI uri = new URIBuilder(requestUrl)
                    .setParameter("access_token", accessToken)
                    .build();

            String rtnJson = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnContent().asString();

            T jsonRtn = JsonRtnUtil.parseJsonRtn(rtnJson, jsonRtnClazz);
            log.info(requestName + ":\n url={},\n body={},\n rtn={},{}", uri, body, rtnJson, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = requestName + " failed:\n url=" + requestUrl + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }
}
