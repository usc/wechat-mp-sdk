package org.usc.wechat.mp.sdk.util.platform;

import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeTicketJsonRtn;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class QRcodeUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) {
        QRcodeTicketJsonRtn jsonRtn = QRcodeUtil.createPermanentQRcode(license, 1);
        handleTicket(jsonRtn);

        jsonRtn = QRcodeUtil.createTemporaryQRcode(license, 2, 1800);
        handleTicket(jsonRtn);
    }

    private static void handleTicket(QRcodeTicketJsonRtn jsonRtn) {
        if (jsonRtn == null) {
            System.out.println("null");
            return;
        }

        if (!JsonRtnUtil.isSuccess(jsonRtn)) {
            System.out.println("create qrcode failed");
            return;
        }

        String ticket = jsonRtn.getTicket();
        System.out.println(jsonRtn);
        System.out.println(QRcodeUtil.bulidQRcodeImgUrl(ticket));
        System.out.println();
    }
}
