package org.usc.wechat.mp.sdk.vo.message.custom.detail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class VideoCustomMessageDetail extends MediaCustomMessageDetail {
    @JSONField(name = "title")
    private String title;

    @JSONField(name = "description")
    private String description;

    protected VideoCustomMessageDetail() {
    }

    public VideoCustomMessageDetail(String mediaId) {
        super(mediaId);
    }

    public VideoCustomMessageDetail(String mediaId, String title, String description) {
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
