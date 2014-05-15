package org.usc.wechat.mp.sdk.vo.message.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.MusicDetail;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicReply extends Reply {
    @XmlElement(name = "Music")
    private MusicDetail musicDetail;

    {
        super.setMsgType(ReplyEnumFactory.MUSIC.getReplyType());
    }

    public MusicReply() {
    }

    public MusicReply(MusicDetail musicDetail) {
        this.musicDetail = musicDetail;
    }

    public MusicDetail getMusicDetail() {
        return musicDetail;
    }

    public void setMusicDetail(MusicDetail musicDetail) {
        this.musicDetail = musicDetail;
    }

}
