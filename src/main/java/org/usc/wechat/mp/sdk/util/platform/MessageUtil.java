package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;

import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.WechatUrl;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.message.custom.CustomMessage;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class MessageUtil {
    private final static Logger log = LoggerFactory.getLogger(MessageUtil.class);

    public static JsonRtn sendCustomMessage(License license, CustomMessage customMessage) {
        if (customMessage == null) {
            return null;
        }

        String body = JSONObject.toJSONString(customMessage);
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.SEND_CUSTOM_MESSAGE_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String rtnJson = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnContent().asString();

            JsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(rtnJson, JsonRtn.class);
            log.info("send custom message:\n url={},\n body={},\n rtn={},{}", uri, body, rtnJson, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "send custom message failed:\n " +
                    "url=" + WechatUrl.SEND_CUSTOM_MESSAGE_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }
}
