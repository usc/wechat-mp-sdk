package org.usc.wechat.mp.sdk.factory.parser;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.EnumUtils;
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

        EventPushType eventPushType = EnumUtils.getEnum(EventPushType.class, event);
        Validate.notNull(eventPushType, "don't-support-%s-event-push", event);

        if (eventPushType == EventPushType.SUBSCRIBE) {
            ReplyDetail replyDetail = new ReplyDetail();
            replyDetail.setDescription("感谢您的关注");
            List<ReplyDetail> replyDetails = Arrays.asList(replyDetail);
            ReplyDetailWarpper replyDetailWarpper = new ReplyDetailWarpper(ReplyEnumFactory.TEXT.getReplyType(), replyDetails);

            Reply reply = ReplyUtil.parseReplyWarpper(replyDetailWarpper);
            return ReplyUtil.buildReply(reply, eventPush);
        }

        return null;
    }
}
