package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.reply.Reply;
import org.usc.wechat.mp.sdk.vo.reply.VoiceReply;
import org.usc.wechat.mp.sdk.vo.reply.detail.MediaDetail;

/**
 *
 * @author Shunli
 */
public class VoiceReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);

        MediaDetail voiceDetail = new MediaDetail();
        voiceDetail.setMediaId(detail.getMediaUrl());

        VoiceReply voiceReply = new VoiceReply();
        voiceReply.setMsgType(ReplyEnumFactory.VOICE.getReplyType());
        voiceReply.setVoiceDetail(voiceDetail);

        return voiceReply;
    }

}
