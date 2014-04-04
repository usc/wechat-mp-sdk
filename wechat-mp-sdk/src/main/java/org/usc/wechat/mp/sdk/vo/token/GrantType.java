package org.usc.wechat.mp.sdk.vo.token;

/**
 *
 * @author Shunli
 */
public enum GrantType {
    CLIENT_CREDENTIAL("client_credential");

    private String value;

    private GrantType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
