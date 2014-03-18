package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.message.reply.VideoReply;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.VideoDetail;

/**
 *
 * @author Shunli
 */
public class VideoReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);

        VideoDetail videoDetail = new VideoDetail(detail.getMediaId());
        videoDetail.setTitle(detail.getTitle());
        videoDetail.setDescription(detail.getDescription());

        return new VideoReply(videoDetail);
    }

}
