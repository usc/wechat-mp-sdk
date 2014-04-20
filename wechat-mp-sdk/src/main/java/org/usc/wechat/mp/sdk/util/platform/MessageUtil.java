package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.util.WechatUrl;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.message.custom.CustomMessage;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessage;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageForGroup;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageForGroupDetail;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageForUser;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageId;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageJsonRtn;
import org.usc.wechat.mp.sdk.vo.message.mass.MassNews;
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

    public static MassMessageJsonRtn sendMassMessageByGroup(License license, String groupId, String mediaId) {
        return sendMassMessageByGroup(license, groupId, mediaId, "mpnews");
    }

    public static MassMessageJsonRtn sendMassMessageByGroup(License license, String groupId, String mediaId, String msgType) {
        return sendMassMessage(license, new MassMessageForGroup(new MassMessageForGroupDetail(groupId), new MassNews(mediaId), msgType));
    }

    public static MassMessageJsonRtn sendMassMessageByUsers(License license, List<String> openIds, String mediaId) {
        return sendMassMessageByUsers(license, openIds, mediaId, "mpnews");
    }

    public static MassMessageJsonRtn sendMassMessageByUsers(License license, List<String> openIds, String mediaId, String msgType) {
        return sendMassMessage(license, new MassMessageForUser(openIds, new MassNews(mediaId), msgType));
    }

    public static MassMessageJsonRtn sendMassMessage(License license, MassMessage massMessage) {
        if (massMessage == null) {
            return null;
        }

        String body = JSONObject.toJSONString(massMessage);
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.SEND_MASS_MESSAGE_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String rtnJson = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnContent().asString();

            MassMessageJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(rtnJson, MassMessageJsonRtn.class);
            log.info("send mass message:\n url={},\n body={},\n rtn={},{}", uri, body, rtnJson, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "send mass message failed:\n " +
                    "url=" + WechatUrl.SEND_MASS_MESSAGE_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

    public static JsonRtn deleteMassMessage(License license, long msgId) {
        String body = JSONObject.toJSONString(new MassMessageId(msgId));
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.DELETE_MASS_MESSAGE_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String rtnJson = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnContent().asString();

            JsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(rtnJson, JsonRtn.class);
            log.info("delete mass message:\n url={},\n body={},\n rtn={},{}", uri, body, rtnJson, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "delete mass message failed:\n " +
                    "url=" + WechatUrl.DELETE_MASS_MESSAGE_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

}
