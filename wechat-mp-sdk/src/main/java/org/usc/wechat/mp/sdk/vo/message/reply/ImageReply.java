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
public class ImageReply extends Reply {
    @XmlElement(name = "Image")
    private MediaDetail imageDetail;

    {
        super.setMsgType(ReplyEnumFactory.IMAGE.getReplyType());
    }

    public ImageReply() {
    }

    public ImageReply(MediaDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

    public MediaDetail getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(MediaDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

}
