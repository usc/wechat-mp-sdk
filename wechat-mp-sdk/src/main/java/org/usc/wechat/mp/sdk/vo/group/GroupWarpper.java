package org.usc.wechat.mp.sdk.vo.group;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

/**
 *
 * @author Shunli
 */
public class GroupWarpper extends AbstractToStringBuilder{
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

}
