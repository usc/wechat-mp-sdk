package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.push.LinkPush;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class LinkPushParser extends AbstractPushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof LinkPush)) {
            return null;
        }

        return null;
    }

}
