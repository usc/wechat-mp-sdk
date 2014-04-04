package org.usc.wechat.mp.sdk.vo.group;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MemberMovement {
    @JSONField(name = "openid")
    private String openId;

    @JSONField(name = "to_groupid")
    private int toGroupId;

    public MemberMovement() {
    }

    public MemberMovement(String openId, int toGroupId) {
        this.openId = openId;
        this.toGroupId = toGroupId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(int toGroupId) {
        this.toGroupId = toGroupId;
    }

}
