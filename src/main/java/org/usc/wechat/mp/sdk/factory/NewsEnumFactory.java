package org.usc.wechat.mp.sdk.factory;


/**
 *
 * @author Shunli
 */
public enum NewsEnumFactory {
    TEXT("text"),
    IMAGE("image"),
    VIDEO("video"),
    VOICE("voice"),
    MESSAGE("news"),
    MUSIC("music");

    private String msgType;

    private NewsEnumFactory(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

}
