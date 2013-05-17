package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.push.LocationPush;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class LocationPushParser extends PushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof LocationPush)) {
            return null;
        }

        return null;
    }

}
