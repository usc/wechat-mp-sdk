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

        // TODO please custom it.
        ReplyDetail replyDetail1 = new ReplyDetail();
        replyDetail1.setTitle("fork me");
        replyDetail1.setMediaUrl("http://c.hiphotos.baidu.com/baike/c%3DbaikeA4%2C10%2C95/sign=c1767bbf4b36acaf4de0c1ad15b2e851/29381f30e924b899a39841be6e061d950b7b02087af4d6b3.jpg");
        replyDetail1.setUrl("https://github.com/usc/wechat-mp-sdk");
        replyDetail1.setDescription("hello world, wechat mp sdk is coming");

        ReplyDetail replyDetail2 = new ReplyDetail();
        replyDetail2.setTitle("star me");
        replyDetail2.setMediaUrl("http://e.hiphotos.baidu.com/baike/pic/item/96dda144ad345982665e49810df431adcaef84c9.jpg");
        replyDetail2.setUrl("https://github.com/usc/wechat-mp-web");
        replyDetail2.setDescription("wechat mp web demo");

        List<ReplyDetail> replyDetails = Arrays.asList(replyDetail1, replyDetail2);
        ReplyDetailWarpper replyDetailWarpper = new ReplyDetailWarpper(ReplyEnumFactory.NEWS.getReplyType(), replyDetails);

        Reply reply = ReplyUtil.parseReplyWarpper(replyDetailWarpper);
        return ReplyUtil.buildReply(reply, push);
    }

}
