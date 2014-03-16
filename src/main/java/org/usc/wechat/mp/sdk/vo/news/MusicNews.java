package org.usc.wechat.mp.sdk.vo.news;

import org.usc.wechat.mp.sdk.factory.NewsEnumFactory;
import org.usc.wechat.mp.sdk.vo.news.detail.MusicNewsDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MusicNews extends News {
    @JSONField(name = "music")
    private MusicNewsDetail musicDetail;

    {
        super.setMsgType(NewsEnumFactory.MUSIC.getMsgType());
    }

    public MusicNews(MusicNewsDetail musicDetail) {
        this.musicDetail = musicDetail;
    }

    public MusicNewsDetail getMusicDetail() {
        return musicDetail;
    }

    public void setMusicDetail(MusicNewsDetail musicDetail) {
        this.musicDetail = musicDetail;
    }

}
