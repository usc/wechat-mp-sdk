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
    TEXT("text") {
        @Override
        protected ReplyBuilder getReplyBuilder() {
            return new TextReplyBuilder();
        }
    },
    NEWS("news") {
        @Override
        protected ReplyBuilder getReplyBuilder() {
            return new NewsReplyBuilder();
        }
    },
    MUSIC("music") {
        @Override
        protected ReplyBuilder getReplyBuilder() {
            return new MusicReplyBuilder();
        }
    },
    IMAGE("image") {
        @Override
        protected ReplyBuilder getReplyBuilder() {
            return new ImageReplyBuilder();
        }
    },
    VOICE("voice") {
        @Override
        protected ReplyBuilder getReplyBuilder() {
            return new VoiceReplyBuilder();
        }
    },
    VIDEO("video") {
        @Override
        protected ReplyBuilder getReplyBuilder() {
            return new VideoReplyBuilder();
        }
    };

    private String replyType;

    private ReplyEnumFactory(String replyType) {
        this.replyType = replyType;
    }

    protected abstract ReplyBuilder getReplyBuilder();

    public Reply buildReply(List<ReplyDetail> replyDetails) {
        if (replyDetails == null || replyDetails.isEmpty()) {
            return null;
        }

        return getReplyBuilder().buildReply(replyDetails);
    }

    public String getReplyType() {
        return replyType;
    }

}
