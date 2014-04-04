package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.message.reply.TextReply;

/**
 *
 * @author Shunli
 */
public class TextReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        String content = replyDetails.get(0).getDescription();
        if (StringUtils.isEmpty(content)) {
            return null;
        }

        return new TextReply(content);

    }
}
