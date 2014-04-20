package org.usc.wechat.mp.sdk.vo.message.mass;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MassNews extends AbstractToStringBuilder{
    @JSONField(name = "media_id")
    private String mediaId;

    public MassNews() {
    }

    public MassNews(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
