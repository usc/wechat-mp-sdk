package org.usc.wechat.mp.sdk.factory.parser;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.util.ReplyUtil;
import org.usc.wechat.mp.sdk.vo.EventPushType;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.ReplyDetailWarpper;
import org.usc.wechat.mp.sdk.vo.push.EventPush;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class EventPushParser extends AbstractPushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof EventPush)) {
            return null;
        }

        EventPush eventPush = (EventPush) push;
        String event = eventPush.getEvent();

        EventPushType eventPushType = EnumUtils.getEnum(EventPushType.class, StringUtils.upperCase(event));
        Validate.notNull(eventPushType, "don't-support-%s-event-push", event);

        // TODO please custom it.
        if (eventPushType == EventPushType.SUBSCRIBE) {
            ReplyDetail replyDetail = new ReplyDetail();
            replyDetail.setDescription("欢迎订阅javatech，这是微信公众平台开发模式的一个尝试，更多详情请见 https://github.com/usc/wechat-mp-sdk \n" +
                    "Welcome subscribe javatech, this is an attempt to development model of wechat management platform, please via https://github.com/usc/wechat-mp-sdk to see more details");
            List<ReplyDetail> replyDetails = Arrays.asList(replyDetail);
            ReplyDetailWarpper replyDetailWarpper = new ReplyDetailWarpper(ReplyEnumFactory.TEXT.getReplyType(), replyDetails);

            Reply reply = ReplyUtil.parseReplyWarpper(replyDetailWarpper);
            return ReplyUtil.buildReply(reply, eventPush);
        }

        return  null;
    }
}
