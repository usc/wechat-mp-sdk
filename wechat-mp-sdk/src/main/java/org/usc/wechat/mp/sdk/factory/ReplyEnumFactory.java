package org.usc.wechat.mp.sdk.factory;

import java.util.List;

import org.usc.wechat.mp.sdk.factory.builder.ImageReplyBuilder;
import org.usc.wechat.mp.sdk.factory.builder.MusicReplyBuilder;
import org.usc.wechat.mp.sdk.factory.builder.NewsReplyBuilder;
import org.usc.wechat.mp.sdk.factory.builder.ReplyBuilder;
import org.usc.wechat.mp.sdk.factory.builder.TextReplyBuilder;
import org.usc.wechat.mp.sdk.factory.builder.VideoReplyBuilder;
import org.usc.wechat.mp.sdk.factory.builder.VoiceReplyBuilder;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;

/**
 *
 * @author Shunli
 */
public enum ReplyEnumFactory {
    TEXT("text", new TextReplyBuilder()),
    NEWS("news", new NewsReplyBuilder()),
    MUSIC("music", new MusicReplyBuilder()),
    IMAGE("image", new ImageReplyBuilder()),
    VOICE("voice", new VoiceReplyBuilder()),
    VIDEO("video", new VideoReplyBuilder());

    private String replyType;
    private ReplyBuilder replyBuilder;

    private ReplyEnumFactory(String replyType, ReplyBuilder replyBuilder) {
        this.replyType = replyType;
        this.replyBuilder = replyBuilder;
    }

    public String getReplyType() {
        return replyType;
    }

    public Reply buildReply(List<ReplyDetail> replyDetails) {
        if (replyDetails == null || replyDetails.isEmpty()) {
            return null;
        }

        return replyBuilder.buildReply(replyDetails);
    }

}
