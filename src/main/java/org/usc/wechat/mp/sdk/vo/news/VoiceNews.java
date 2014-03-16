package org.usc.wechat.mp.sdk.vo.news;

import org.usc.wechat.mp.sdk.factory.NewsEnumFactory;
import org.usc.wechat.mp.sdk.vo.news.detail.MediaNewsDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class VoiceNews extends News {
    @JSONField(name = "voice")
    private MediaNewsDetail voiceDetail;

    {
        super.setMsgType(NewsEnumFactory.VOICE.getMsgType());
    }

    public VoiceNews(MediaNewsDetail voiceDetail) {
        this.voiceDetail = voiceDetail;
    }

    public MediaNewsDetail getVoiceDetail() {
        return voiceDetail;
    }

    public void setVoiceDetail(MediaNewsDetail voiceDetail) {
        this.voiceDetail = voiceDetail;
    }

}
