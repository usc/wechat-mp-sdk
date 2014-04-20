package org.usc.wechat.mp.sdk.vo.message.mass;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MassMessageId extends AbstractToStringBuilder{
    @JSONField(name = "msgid")
    private long msgId;

    public MassMessageId() {
    }

    public MassMessageId(long msgId) {
        this.msgId = msgId;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

}
