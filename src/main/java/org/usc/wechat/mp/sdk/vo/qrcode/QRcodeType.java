package org.usc.wechat.mp.sdk.vo.qrcode;

/**
 *
 * @author Shunli
 */
public enum QRcodeType {
    TEMPORARY("QR_SCENE"),
    PERMANENT("QR_LIMIT_SCENE");

    private String actionName;

    private QRcodeType(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

}
