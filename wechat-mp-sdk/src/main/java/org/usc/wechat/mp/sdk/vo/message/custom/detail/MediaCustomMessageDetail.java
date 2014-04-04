package org.usc.wechat.mp.sdk.vo.message.custom.detail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MediaCustomMessageDetail extends AbstractCustomMessageDetail {
    @JSONField(name = "media_id")
    private String mediaId;

    protected MediaCustomMessageDetail() {
    }

    public MediaCustomMessageDetail(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
