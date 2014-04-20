package org.usc.wechat.mp.sdk.vo.message.mass;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MassMessageId {
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

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
