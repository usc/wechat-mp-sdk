package org.usc.wechat.mp.sdk.vo.group;

import org.usc.wechat.mp.sdk.vo.JsonRtn;

/**
 *
 * @author Shunli
 */
public class GroupIdJsonRtn extends JsonRtn {
    private int groupId;

    public GroupIdJsonRtn() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
