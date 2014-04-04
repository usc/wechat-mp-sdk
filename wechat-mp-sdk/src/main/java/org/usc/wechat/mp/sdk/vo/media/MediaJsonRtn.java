package org.usc.wechat.mp.sdk.vo.media;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.vo.JsonRtn;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MediaJsonRtn extends JsonRtn {
    @JSONField(name = "type")
    private String type;

    @JSONField(name = "media_id")
    private String mediaId;

    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    @JSONField(name = "created_at")
    private long createdAt;

    public MediaJsonRtn() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
        this.mediaId = StringUtils.defaultIfEmpty(this.mediaId, thumbMediaId);
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

}
