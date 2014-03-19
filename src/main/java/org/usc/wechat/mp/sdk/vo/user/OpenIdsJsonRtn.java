package org.usc.wechat.mp.sdk.vo.user;

import java.util.List;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class OpenIdsJsonRtn {
    @JSONField(name = "openid")
    private List<String> openIds;

    public OpenIdsJsonRtn() {
    }

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
