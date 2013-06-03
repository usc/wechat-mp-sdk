package org.usc.wechat.mp.sdk.vo.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.vo.reply.detail.ThumbMediaDetail;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoReply extends Reply {
    @XmlElement(name = "Video")
    private ThumbMediaDetail thumbMediaDetail;

    public ThumbMediaDetail getThumbMediaDetail() {
        return thumbMediaDetail;
    }

    public void setThumbMediaDetail(ThumbMediaDetail thumbMediaDetail) {
        this.thumbMediaDetail = thumbMediaDetail;
    }

}
