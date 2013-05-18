package org.usc.wechat.mp.sdk.factory;

import java.util.List;

import org.usc.wechat.mp.sdk.util.ReplyUtil;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public enum ReplyEnumFactory {
    TEXT("text") {
        @Override
        public Reply buildReply(List<ReplyDetail> replyDetails) {
            return ReplyUtil.buildTextReply(replyDetails, getReplyType());
        }
    },
    NEWS("news") {
        @Override
        public Reply buildReply(List<ReplyDetail> replyDetails) {
            return ReplyUtil.buildNewsReply(replyDetails, getReplyType());
        }
    },
    MUSIC("music") {
        @Override
        public Reply buildReply(List<ReplyDetail> replyDetails) {
            return ReplyUtil.buildMusicReply(replyDetails, getReplyType());
        }

    };

    private String replyType;

    private ReplyEnumFactory(String replyType) {
        this.replyType = replyType;
    }

    public abstract Reply buildReply(List<ReplyDetail> replyDetails);

    public String getReplyType() {
        return replyType;
    }

}
