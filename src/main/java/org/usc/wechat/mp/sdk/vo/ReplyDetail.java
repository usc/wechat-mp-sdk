package org.usc.wechat.mp.sdk.vo;

/**
 *
 * @author Shunli
 */
public class ReplyDetail {
    private String title;
    private String mediaUrl;// in the presence MediaId when Media file Reply
    private String url; // in the presence ThumbMediaId when Media file Reply
    private String description;

    public ReplyDetail() {
    }

    public ReplyDetail(String title, String mediaUrl, String url, String description) {
        this.title = title;
        this.mediaUrl = mediaUrl;
        this.url = url;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
