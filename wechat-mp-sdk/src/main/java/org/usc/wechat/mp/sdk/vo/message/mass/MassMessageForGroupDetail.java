package org.usc.wechat.mp.sdk.vo.message.mass;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MassMessageForGroupDetail {
    @JSONField(name = "group_id")
    private String groupId;

    public MassMessageForGroupDetail() {
    }

    public MassMessageForGroupDetail(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
