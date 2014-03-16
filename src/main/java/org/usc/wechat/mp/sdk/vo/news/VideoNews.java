package org.usc.wechat.mp.sdk.vo.news;

import org.usc.wechat.mp.sdk.factory.NewsEnumFactory;
import org.usc.wechat.mp.sdk.vo.news.detail.VideoNewsDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class VideoNews extends News {
    @JSONField(name = "video")
    private VideoNewsDetail videoDetail;

    {
        super.setMsgType(NewsEnumFactory.VIDEO.getMsgType());
    }

    public VideoNews(VideoNewsDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

    public VideoNewsDetail getVideoDetail() {
        return videoDetail;
    }

    public void setVideoDetail(VideoNewsDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

}
