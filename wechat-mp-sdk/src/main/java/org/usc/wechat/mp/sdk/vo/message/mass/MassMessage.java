package org.usc.wechat.mp.sdk.vo.message.mass;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public abstract class MassMessage {
    @JSONField(name = "mpnews")
    private MassNews mpNews;

    @JSONField(name = "msgtype")
    private String msgType = "mpnews";

    public MassMessage() {
    }

    public MassMessage(MassNews mpNews, String msgType) {
        this.mpNews = mpNews;
        this.msgType = msgType;
    }

    public MassNews getMpNews() {
        return mpNews;
    }

    public void setMpNews(MassNews mpNews) {
        this.mpNews = mpNews;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
