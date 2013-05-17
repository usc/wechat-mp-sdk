package org.usc.wechat.mp.sdk.vo;

/**
 *
 * @author Shunli
 */
public enum EventPushType {
    SUBSCRIBE("subscribe"), UNSUBSCRIBE("unsubscribe"), CLICK("CLICK");

    private String typeInDb;

    private EventPushType(String typeInDb) {
        this.typeInDb = typeInDb;
    }

    public String getTypeInDb() {
        return typeInDb;
    }

}
