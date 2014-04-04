package org.usc.wechat.mp.sdk.vo.qrcode;

import org.usc.wechat.mp.sdk.vo.JsonRtn;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class QRcodeTicketJsonRtn extends JsonRtn {
    @JSONField(name = "ticket")
    private String ticket;

    @JSONField(name = "expire_seconds")
    private int expireSeconds = -1;

    public QRcodeTicketJsonRtn() {
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

}
