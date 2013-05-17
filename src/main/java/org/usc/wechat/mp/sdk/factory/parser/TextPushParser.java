package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.push.TextPush;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class TextPushParser extends PushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof TextPush)) {
            return null;
        }

        return null;
    }

}
