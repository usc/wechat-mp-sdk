package org.usc.wechat.mp.sdk.vo.group;

import java.util.List;

import org.usc.wechat.mp.sdk.vo.JsonRtn;

/**
 *
 * @author Shunli
 */
public class GroupsJsonRtn extends JsonRtn {
    private List<Group> groups;

    public GroupsJsonRtn() {
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}
