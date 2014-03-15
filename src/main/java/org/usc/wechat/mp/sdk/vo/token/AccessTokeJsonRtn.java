package org.usc.wechat.mp.sdk.vo.token;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class AccessTokeJsonRtn extends JsonRtn {
    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private int expiresIn;

    public AccessTokeJsonRtn() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

}
