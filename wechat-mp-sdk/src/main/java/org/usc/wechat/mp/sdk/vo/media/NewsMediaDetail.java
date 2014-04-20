package org.usc.wechat.mp.sdk.vo.media;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class NewsMediaDetail extends AbstractToStringBuilder {
    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "author")
    private String author;

    @JSONField(name = "content_source_url")
    private String contentSourceUrl;

    @JSONField(name = "digest")
    private String digest;

    public NewsMediaDetail() {
    }

    public NewsMediaDetail(String thumbMediaId, String title, String content) {
        this.thumbMediaId = thumbMediaId;
        this.title = title;
        this.content = content;
    }

    public NewsMediaDetail(String thumbMediaId, String title, String content, String author, String contentSourceUrl, String digest) {
        this.thumbMediaId = thumbMediaId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.contentSourceUrl = contentSourceUrl;
        this.digest = digest;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

}
