package org.usc.wechat.mp.sdk.vo.news.detail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MediaNewsDetail extends AbstractNewsDetail {
    @JSONField(name = "media_id")
    private String mediaId;

    protected MediaNewsDetail() {
    }

    public MediaNewsDetail(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
