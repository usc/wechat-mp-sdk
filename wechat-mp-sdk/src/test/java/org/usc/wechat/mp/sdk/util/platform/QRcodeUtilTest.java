package org.usc.wechat.mp.sdk.util.platform;

import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.qrcode.QRcodeTicketJsonRtn;

/**
 *
 * @author Shunli
 */
public class QRcodeUtilTest {
    public static void main(String[] args) {
        QRcodeTicketJsonRtn jsonRtn = QRcodeUtil.createPermanentQRcode(Constants.LICENSE, 1);
        handleTicket(jsonRtn);

        jsonRtn = QRcodeUtil.createTemporaryQRcode(Constants.LICENSE, 2, 1800);
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
