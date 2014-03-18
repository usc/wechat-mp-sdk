package org.usc.wechat.mp.sdk.vo.message.custom;

import org.usc.wechat.mp.sdk.factory.CustomMessageEnumFactory;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.VideoCustomMessageDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class VideoCustomMessage extends CustomMessage {
    @JSONField(name = "video")
    private VideoCustomMessageDetail videoDetail;

    {
        super.setMsgType(CustomMessageEnumFactory.VIDEO.getMsgType());
    }

    public VideoCustomMessage(VideoCustomMessageDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

    public VideoCustomMessageDetail getVideoDetail() {
        return videoDetail;
    }

    public void setVideoDetail(VideoCustomMessageDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

}
