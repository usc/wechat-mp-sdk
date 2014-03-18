package org.usc.wechat.mp.sdk.factory;

import org.usc.wechat.mp.sdk.factory.parser.EventPushParser;
import org.usc.wechat.mp.sdk.factory.parser.ImagePushParser;
import org.usc.wechat.mp.sdk.factory.parser.LinkPushParser;
import org.usc.wechat.mp.sdk.factory.parser.LocationPushParser;
import org.usc.wechat.mp.sdk.factory.parser.PushParser;
import org.usc.wechat.mp.sdk.factory.parser.TextPushParser;
import org.usc.wechat.mp.sdk.factory.parser.VideoPushParser;
import org.usc.wechat.mp.sdk.factory.parser.VoicePushParser;
import org.usc.wechat.mp.sdk.util.XmlUtil;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.push.EventPush;
import org.usc.wechat.mp.sdk.vo.push.ImagePush;
import org.usc.wechat.mp.sdk.vo.push.LinkPush;
import org.usc.wechat.mp.sdk.vo.push.LocationPush;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.push.TextPush;
import org.usc.wechat.mp.sdk.vo.push.VideoPush;
import org.usc.wechat.mp.sdk.vo.push.VoicePush;

/**
 *
 * @author Shunli
 */
public enum PushEnumFactory {
    TEXT {
        @Override
        protected Class<? extends Push> getPushClass() {
            return TextPush.class;
        }

        @Override
        protected PushParser getPushParser() {
            return new TextPushParser();
        }
    },
    EVENT {
        @Override
        protected Class<? extends Push> getPushClass() {
            return EventPush.class;
        }

        @Override
        protected PushParser getPushParser() {
            return new EventPushParser();
        }
    },
    IMAGE {
        @Override
        protected Class<? extends Push> getPushClass() {
            return ImagePush.class;
        }

        @Override
        protected PushParser getPushParser() {
            return new ImagePushParser();
        }
    },
    LINK {
        @Override
        protected Class<? extends Push> getPushClass() {
            return LinkPush.class;
        }

        @Override
        protected PushParser getPushParser() {
            return new LinkPushParser();
        }
    },
    LOCATION {
        @Override
        protected Class<? extends Push> getPushClass() {
            return LocationPush.class;
        }

        @Override
        protected PushParser getPushParser() {
            return new LocationPushParser();
        }
    },
    VOICE {
        @Override
        protected Class<? extends Push> getPushClass() {
            return VoicePush.class;
        }

        @Override
        protected PushParser getPushParser() {
            return new VoicePushParser();
        }
    },
    VIDEO {
        @Override
        protected Class<? extends Push> getPushClass() {
            return VideoPush.class;
        }

        @Override
        protected PushParser getPushParser() {
            return new VideoPushParser();
        }
    };

    protected abstract Class<? extends Push> getPushClass();
    protected abstract PushParser getPushParser();

    public Push convert(String message) {
        return XmlUtil.unmarshal(message, getPushClass());
    }

    public Reply parse(Push push) {
        return getPushParser().parse(push);
    }
}
