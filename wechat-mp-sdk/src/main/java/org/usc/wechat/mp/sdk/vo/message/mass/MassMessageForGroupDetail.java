package org.usc.wechat.mp.sdk.vo.message.mass;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MassMessageForGroupDetail extends AbstractToStringBuilder {
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

}
