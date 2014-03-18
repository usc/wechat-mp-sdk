package org.usc.wechat.mp.sdk.vo.json;


import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class AccessTokenJsonRtn extends JsonRtn {
    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private int expiresIn;

    public AccessTokenJsonRtn() {
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
