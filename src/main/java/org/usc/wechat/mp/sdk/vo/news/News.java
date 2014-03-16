package org.usc.wechat.mp.sdk.vo.news;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public abstract class News {
    @JSONField(name = "touser")
    private String toUser;

    @JSONField(name = "msgtype")
    private String msgType;

    public News() {
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
