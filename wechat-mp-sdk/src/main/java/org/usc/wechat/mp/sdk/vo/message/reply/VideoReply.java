package org.usc.wechat.mp.sdk.vo.message.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.VideoDetail;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoReply extends Reply {
    @XmlElement(name = "Video")
    private VideoDetail videoDetail;

    {
        super.setMsgType(ReplyEnumFactory.VIDEO.getReplyType());
    }

    public VideoReply() {
    }

    public VideoReply(VideoDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

    public VideoDetail getVideoDetail() {
        return videoDetail;
    }

    public void setVideoDetail(VideoDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

}
