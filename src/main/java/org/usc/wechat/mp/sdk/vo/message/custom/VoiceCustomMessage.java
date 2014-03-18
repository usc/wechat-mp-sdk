package org.usc.wechat.mp.sdk.vo.message.custom;

import org.usc.wechat.mp.sdk.vo.message.custom.detail.MediaCustomMessageDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class VoiceCustomMessage extends CustomMessage {
    @JSONField(name = "voice")
    private MediaCustomMessageDetail voiceDetail;

    {
        super.setMsgType(CustomMessageType.VOICE.getMsgType());
    }

    public VoiceCustomMessage(MediaCustomMessageDetail voiceDetail) {
        this.voiceDetail = voiceDetail;
    }

    public MediaCustomMessageDetail getVoiceDetail() {
        return voiceDetail;
    }

    public void setVoiceDetail(MediaCustomMessageDetail voiceDetail) {
        this.voiceDetail = voiceDetail;
    }

}
