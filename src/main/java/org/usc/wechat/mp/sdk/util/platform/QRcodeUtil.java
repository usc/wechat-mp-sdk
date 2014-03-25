package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.WechatUrl;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeActionInfo;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeScene;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeTicket;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeTicketJsonRtn;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeType;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONObject;
import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class QRcodeUtil {
    private final static Logger log = LoggerFactory.getLogger(QRcodeUtil.class);

    public static QRcodeTicketJsonRtn createTemporaryQRcode(License license, long sceneId, int expireSeconds) {
        if (expireSeconds <= 0) {
            return null;
        }
        expireSeconds = Ints.min(expireSeconds, 1800);
        QRcodeActionInfo actionInfo = new QRcodeActionInfo(new QRcodeScene(sceneId));
        return createQRcode(license, new QRcodeTicket(QRcodeType.TEMPORARY.getActionName(), expireSeconds, actionInfo));
    }

    public static QRcodeTicketJsonRtn createPermanentQRcode(License license, long sceneId) {
        if (sceneId < 0 || sceneId > 100000) {
            return null;
        }

        QRcodeActionInfo actionInfo = new QRcodeActionInfo(new QRcodeScene(sceneId));
        return createQRcode(license, new QRcodeTicket(QRcodeType.PERMANENT.getActionName(), actionInfo));
    }

    private static QRcodeTicketJsonRtn createQRcode(License license, QRcodeTicket ticket) {
        String body = JSONObject.toJSONString(ticket);
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.WECHAT_CREATE_QRCODE_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);

            QRcodeTicketJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, QRcodeTicketJsonRtn.class);
            log.info("create qrcode:\n url={},\n body={},\n rtn={},{}", uri, body, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "create qrcode failed:\n " +
                    "url=" + WechatUrl.WECHAT_CREATE_QRCODE_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

    public static String bulidQRcodeImgUrl(String ticket) {
        if (StringUtils.isEmpty(ticket)) {
            return StringUtils.EMPTY;
        }

        try {
            URI uri = new URIBuilder(WechatUrl.WECHAT_SHOW_QRCODE_URL)
                    .setParameter("ticket", ticket)
                    .build();

            log.info("build qrcode img url: url={}", uri);
            return uri.toString();
        } catch (Exception e) {
            String msg = "build qrcode img url failed: url=" + WechatUrl.WECHAT_SHOW_QRCODE_URL + "?ticket=" + ticket;
            log.error(msg, e);
            return StringUtils.EMPTY;
        }
    }
}
