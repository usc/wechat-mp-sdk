package org.usc.wechat.mp.sdk.vo.reply.detail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Shunli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsDetail {
    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "PicUrl")
    private String picUrl;

    @XmlElement(name = "Url")
    private String url;

    public NewsDetail() {
    }

    public NewsDetail(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
