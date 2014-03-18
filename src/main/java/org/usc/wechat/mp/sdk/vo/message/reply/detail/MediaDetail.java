package org.usc.wechat.mp.sdk.vo.message.reply.detail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

/**
 *
 * @author Shunli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MediaDetail {
    @XmlElement(name = "MediaId")
    private String mediaId;

    protected MediaDetail() {
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

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
