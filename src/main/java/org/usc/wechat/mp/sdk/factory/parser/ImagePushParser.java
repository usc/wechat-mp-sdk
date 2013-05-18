package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.push.ImagePush;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public class ImagePushParser extends AbstractPushParser {
    @Override
    public Reply parse(Push push) {
        if (!(push instanceof ImagePush)) {
            return null;
        }

        return null;
    }

}
