package org.usc.wechat.mp.sdk.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.ReplyDetailWarpper;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class ReplyUtil {
    public static Reply buildReply(Reply reply, Push push) {
        try {
            if (reply != null) {
                // keep is new instance
                Reply newReply = (Reply) BeanUtils.cloneBean(reply);

                newReply.setCreateTime(getUnixTimeStamp());
                newReply.setToUserName(push.getFromUserName());
                newReply.setFromUserName(push.getToUserName());

                return newReply;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static long getUnixTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    public static Reply parseReplyDetailWarpper(ReplyDetailWarpper replyDetailWarpper) {
        if (replyDetailWarpper == null) {
            return null;
        }

        String replyType = replyDetailWarpper.getReplyType();
        ReplyEnumFactory replyEnumFactory = EnumUtils.getEnum(ReplyEnumFactory.class, StringUtils.upperCase(replyType));
        if (replyEnumFactory == null) {
            return null;
        }

        Reply buildReply = replyEnumFactory.buildReply(replyDetailWarpper.getReplyDetails());
        if (buildReply != null) {
            buildReply.setFuncFlag(replyDetailWarpper.getFuncFlag());

            return buildReply;
        }

        return null;
    }
}
