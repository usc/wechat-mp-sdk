package org.usc.wechat.mp.sdk.factory;


/**
 *
 * @author Shunli
 */
public enum CustomMessageEnumFactory {
    TEXT("text"),
    IMAGE("image"),
    VIDEO("video"),
    VOICE("voice"),
    MESSAGE("news"),
    MUSIC("music");

    private String msgType;

    private CustomMessageEnumFactory(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

}
