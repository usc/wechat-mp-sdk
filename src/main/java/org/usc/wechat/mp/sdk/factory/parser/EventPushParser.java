package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.push.EventPush;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class EventPushParser extends PushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof EventPush)) {
            return null;
        }

        return null;
    }
}
