package org.usc.wechat.mp.sdk.vo;

/**
 *
 * @author Shunli
 */
public enum EventPushType {
    SUBSCRIBE("subscribe"), UNSUBSCRIBE("unsubscribe"), CLICK("CLICK"), SCAN("scan"), LOCATION("LOCATION");

    private String type;

    private EventPushType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
