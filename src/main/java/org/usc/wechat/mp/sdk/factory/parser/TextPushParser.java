package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.util.ReplyUtil;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.push.TextPush;

/**
 *
 * @author Shunli
 */
public class TextPushParser implements PushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof TextPush)) {
            return null;
        }

        TextPush textPush = (TextPush) push;

        // TODO please custom it.
        Reply reply = ReplyUtil.parseReplyDetailWarpper(ReplyUtil.getDummyNewsReplyDetailWarpper());
        return ReplyUtil.buildReply(reply, textPush);
    }

}
