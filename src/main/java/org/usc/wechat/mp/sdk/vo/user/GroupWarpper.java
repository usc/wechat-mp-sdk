package org.usc.wechat.mp.sdk.vo.user;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

/**
 *
 * @author Shunli
 */
public class GroupWarpper {
    private Group group;

    public GroupWarpper() {
    }

    public GroupWarpper(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
