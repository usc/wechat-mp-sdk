package org.usc.wechat.mp.sdk.vo.message.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.MediaDetail;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoiceReply extends Reply {
    @XmlElement(name = "Voice")
    private MediaDetail voiceDetail;

    {
        super.setMsgType(ReplyEnumFactory.VOICE.getReplyType());
    }

    public VoiceReply() {
    }

    public VoiceReply(MediaDetail voiceDetail) {
        this.voiceDetail = voiceDetail;
    }

    public MediaDetail getVoiceDetail() {
        return voiceDetail;
    }

    public void setVoiceDetail(MediaDetail voiceDetail) {
        this.voiceDetail = voiceDetail;
    }

}
