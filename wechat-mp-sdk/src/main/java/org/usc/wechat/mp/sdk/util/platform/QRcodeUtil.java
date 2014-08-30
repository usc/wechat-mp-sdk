package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeActionInfo;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeScene;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeTicket;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeTicketJsonRtn;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeType;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class QRcodeUtil {
    private final static Logger log = LoggerFactory.getLogger(QRcodeUtil.class);

    public static QRcodeTicketJsonRtn createTemporaryQRcode(License license, long sceneId, int expireSeconds) {
        if (expireSeconds <= 0) {
            return JsonRtnUtil.buildFailureJsonRtn(QRcodeTicketJsonRtn.class, "expireSeconds must be positive");
        }
        expireSeconds = Ints.min(expireSeconds, 1800);
        QRcodeActionInfo actionInfo = new QRcodeActionInfo(new QRcodeScene(sceneId));
        return createQRcode(license, new QRcodeTicket(QRcodeType.TEMPORARY.getActionName(), expireSeconds, actionInfo));
    }

    public static QRcodeTicketJsonRtn createPermanentQRcode(License license, long sceneId) {
        if (sceneId < 0 || sceneId > 100000) {
            return JsonRtnUtil.buildFailureJsonRtn(QRcodeTicketJsonRtn.class, "sceneId must be within the range [0,100000]");
        }

        QRcodeActionInfo actionInfo = new QRcodeActionInfo(new QRcodeScene(sceneId));
        return createQRcode(license, new QRcodeTicket(QRcodeType.PERMANENT.getActionName(), actionInfo));
    }

    private static QRcodeTicketJsonRtn createQRcode(License license, QRcodeTicket ticket) {
        return HttpUtil.postBodyRequest(WechatRequest.CREATE_QRCODE, license, ticket, QRcodeTicketJsonRtn.class);
    }

    public static String bulidQRcodeImgUrl(String ticket) {
        if (StringUtils.isEmpty(ticket)) {
            return StringUtils.EMPTY;
        }

        String url = WechatRequest.SHOW_QRCODE.getUrl();
        try {
            URI uri = new URIBuilder(url)
                    .setParameter("ticket", ticket)
                    .build();

            log.info("build qrcode img url: url={}", uri);
            return uri.toString();
        } catch (Exception e) {
            String msg = "build qrcode img url failed: url=" + url + "?ticket=" + ticket;
            log.error(msg, e);
            return StringUtils.EMPTY;
        }
    }
}
