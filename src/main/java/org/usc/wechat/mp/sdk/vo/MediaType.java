package org.usc.wechat.mp.sdk.vo;

/**
 *
 * @author Shunli
 */
public enum MediaType {
    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    THUMB("thumb"), ;

    private String name;

    private MediaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
