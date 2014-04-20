package org.usc.wechat.mp.sdk.vo.message.custom.detail;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class ArticleCustomMessageDetail extends AbstractToStringBuilder {
    @JSONField(name = "title")
    private String title;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "picurl")
    private String picUrl;

    @JSONField(name = "url")
    private String url;

    protected ArticleCustomMessageDetail() {
    }

    public ArticleCustomMessageDetail(String url) {
        this.url = url;
    }

    public ArticleCustomMessageDetail(String title, String description, String picUrl, String url) {
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
}
