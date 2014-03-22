package org.usc.wechat.mp.sdk.vo.qrcode;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class QRcodeTicket {
    @JSONField(name = "action_name")
    private String actionName;

    @JSONField(name = "expire_seconds")
    private int expireSeconds;

    @JSONField(name = "action_info")
    private QRcodeActionInfo actionInfo;

    public QRcodeTicket() {
    }

    public QRcodeTicket(String actionName, QRcodeActionInfo actionInfo) {
        this.actionName = actionName;
        this.actionInfo = actionInfo;
    }

    public QRcodeTicket(String actionName, int expireSeconds, QRcodeActionInfo actionInfo) {
        this.actionName = actionName;
        this.expireSeconds = expireSeconds;
        this.actionInfo = actionInfo;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public QRcodeActionInfo getActionInfo() {
        return actionInfo;
    }

    public void setActionInfo(QRcodeActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }

}
