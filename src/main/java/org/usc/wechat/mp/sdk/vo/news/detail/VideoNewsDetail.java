package org.usc.wechat.mp.sdk.vo.news.detail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class VideoNewsDetail extends MediaNewsDetail {
    @JSONField(name = "title")
    private String title;

    @JSONField(name = "description")
    private String description;

    protected VideoNewsDetail() {
    }

    public VideoNewsDetail(String mediaId) {
        super(mediaId);
    }

    public VideoNewsDetail(String mediaId, String title, String description) {
        super(mediaId);
        this.title = title;
        this.description = description;
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

}
