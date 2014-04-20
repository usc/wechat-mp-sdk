package org.usc.wechat.mp.sdk.vo.message.custom.detail;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MusicCustomMessageDetail extends AbstractToStringBuilder{
    @JSONField(name = "title")
    private String title;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "musicurl")
    private String musicUrl;

    @JSONField(name = "hqmusicurl")
    private String hqMusicUrl;

    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    protected MusicCustomMessageDetail() {
    }

    public MusicCustomMessageDetail(String musicUrl, String hqMusicUrl, String thumbMediaId) {
        this.musicUrl = musicUrl;
        this.hqMusicUrl = hqMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }

    public MusicCustomMessageDetail(String title, String description, String musicUrl, String hqMusicUrl, String thumbMediaId) {
        this.title = title;
        this.description = description;
        this.musicUrl = musicUrl;
        this.hqMusicUrl = hqMusicUrl;
        this.thumbMediaId = thumbMediaId;
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

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
