package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.message.reply.VoiceReply;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.MediaDetail;

/**
 *
 * @author Shunli
 */
public class VoiceReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);
        return new VoiceReply(new MediaDetail(detail.getMediaId()));
    }

}
