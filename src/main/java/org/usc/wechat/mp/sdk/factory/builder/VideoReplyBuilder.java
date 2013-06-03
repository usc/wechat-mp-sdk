package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.reply.Reply;
import org.usc.wechat.mp.sdk.vo.reply.VideoReply;
import org.usc.wechat.mp.sdk.vo.reply.detail.ThumbMediaDetail;

/**
 *
 * @author Shunli
 */
public class VideoReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);

        ThumbMediaDetail thumbMediaDetail = new ThumbMediaDetail();
        thumbMediaDetail.setMediaId(detail.getMediaUrl());
        thumbMediaDetail.setThumbMediaId(detail.getUrl());

        VideoReply videoReply = new VideoReply();
        videoReply.setMsgType(ReplyEnumFactory.VIDEO.getReplyType());
        videoReply.setThumbMediaDetail(thumbMediaDetail);

        return videoReply;
    }

}
