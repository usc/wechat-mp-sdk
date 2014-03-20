package org.usc.wechat.mp.sdk.vo.group;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class OpenId {
    @JSONField(name = "openid")
    private String openId;

    public OpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
