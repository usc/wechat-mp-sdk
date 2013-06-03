package org.usc.wechat.mp.sdk.vo.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.vo.reply.detail.MediaDetail;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageReply extends Reply {
    @XmlElement(name = "Image")
    private MediaDetail imageDetail;

    public MediaDetail getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(MediaDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

}
