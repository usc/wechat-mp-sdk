package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.message.reply.MusicReply;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.MusicDetail;

/**
 *
 * @author Shunli
 */
public class MusicReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);

        MusicDetail musicDetail = new MusicDetail(
                detail.getTitle(),
                detail.getDescription(),
                detail.getMediaUrl(),
                detail.getUrl(),
                detail.getThumbMediaId());

        return new MusicReply(musicDetail);
    }
}
