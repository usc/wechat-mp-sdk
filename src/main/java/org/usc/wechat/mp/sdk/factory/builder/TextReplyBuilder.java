package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.reply.Reply;
import org.usc.wechat.mp.sdk.vo.reply.TextReply;

/**
 *
 * @author Shunli
 */
public class TextReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);

        TextReply textReply = new TextReply();
        textReply.setMsgType(ReplyEnumFactory.TEXT.getReplyType());
        textReply.setContent(detail.getDescription());

        return textReply;
    }

}
