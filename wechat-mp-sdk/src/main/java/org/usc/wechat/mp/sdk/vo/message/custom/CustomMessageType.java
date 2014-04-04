package org.usc.wechat.mp.sdk.vo.message.custom;


/**
 *
 * @author Shunli
 */
public enum CustomMessageType {
    TEXT("text"),
    IMAGE("image"),
    VIDEO("video"),
    VOICE("voice"),
    MESSAGE("news"),
    MUSIC("music");

    private String msgType;

    private CustomMessageType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

}
