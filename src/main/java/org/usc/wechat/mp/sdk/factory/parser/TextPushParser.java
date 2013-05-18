package org.usc.wechat.mp.sdk.factory.parser;

import java.util.Arrays;
import java.util.List;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.util.ReplyUtil;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.ReplyDetailWarpper;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.push.TextPush;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class TextPushParser extends AbstractPushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof TextPush)) {
            return null;
        }

        // TextPush textPush = (TextPush) push;

        ReplyDetail replyDetail = new ReplyDetail();
        replyDetail.setDescription("hello world");
        List<ReplyDetail> replyDetails = Arrays.asList(replyDetail);

        // TODO-Shunli: TBW
        ReplyDetailWarpper replyDetailWarpper = new ReplyDetailWarpper(ReplyEnumFactory.NEWS.getReplyType(), replyDetails);

        Reply reply = ReplyUtil.parseReplyWarpper(replyDetailWarpper);
        return ReplyUtil.buildReply(reply, push);

    }

}
