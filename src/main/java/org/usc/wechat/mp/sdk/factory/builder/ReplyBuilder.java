package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;

/**
 *
 * @author Shunli
 */
public interface ReplyBuilder {
    Reply buildReply(List<ReplyDetail> replyDetails);
}
