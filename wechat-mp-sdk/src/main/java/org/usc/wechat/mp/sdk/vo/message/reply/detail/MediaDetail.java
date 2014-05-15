package org.usc.wechat.mp.sdk.vo.message.reply.detail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

/**
 *
 * @author Shunli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MediaDetail extends AbstractToStringBuilder {
    @XmlElement(name = "MediaId")
    private String mediaId;

    public MediaDetail() {
    }

    public MediaDetail(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
