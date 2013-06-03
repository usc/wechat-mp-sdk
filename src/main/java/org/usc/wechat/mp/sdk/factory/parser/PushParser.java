package org.usc.wechat.mp.sdk.factory.parser;

import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public interface PushParser {
    Reply parse(Push push);
}
