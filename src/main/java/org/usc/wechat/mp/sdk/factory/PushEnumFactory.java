package org.usc.wechat.mp.sdk.factory;

import org.usc.wechat.mp.sdk.factory.parser.EventPushParser;
import org.usc.wechat.mp.sdk.factory.parser.ImagePushParser;
import org.usc.wechat.mp.sdk.factory.parser.LinkPushParser;
import org.usc.wechat.mp.sdk.factory.parser.LocationPushParser;
import org.usc.wechat.mp.sdk.factory.parser.TextPushParser;
import org.usc.wechat.mp.sdk.util.XmlUtil;
import org.usc.wechat.mp.sdk.vo.push.EventPush;
import org.usc.wechat.mp.sdk.vo.push.ImagePush;
import org.usc.wechat.mp.sdk.vo.push.LinkPush;
import org.usc.wechat.mp.sdk.vo.push.LocationPush;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.push.TextPush;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
public enum PushEnumFactory {
    TEXT {
        @Override
        public Push convert(String message) {
            return XmlUtil.unmarshal(message, TextPush.class);
        }

        @Override
        public Reply parse(Push push) {
            return new TextPushParser().parse(push);
        }
    },
    EVENT {
        @Override
        public Push convert(String message) {
            return XmlUtil.unmarshal(message, EventPush.class);
        }

        @Override
        public Reply parse(Push push) {
            return new EventPushParser().parse(push);
        }
    },
    IMAGE {
        @Override
        public Push convert(String message) {
            return XmlUtil.unmarshal(message, ImagePush.class);
        }

        @Override
        public Reply parse(Push push) {
            return new ImagePushParser().parse(push);
        }
    },
    LINK {
        @Override
        public Push convert(String message) {
            return XmlUtil.unmarshal(message, LinkPush.class);
        }

        @Override
        public Reply parse(Push push) {
            return new LinkPushParser().parse(push);
        }
    },
    LOCATION {
        @Override
        public Push convert(String message) {
            return XmlUtil.unmarshal(message, LocationPush.class);
        }

        @Override
        public Reply parse(Push push) {
            return new LocationPushParser().parse(push);
        }
    };

    public abstract Push convert(String message);
    public abstract Reply parse(Push push);
}
