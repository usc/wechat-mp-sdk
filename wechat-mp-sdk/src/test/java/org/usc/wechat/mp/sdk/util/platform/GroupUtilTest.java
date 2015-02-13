package org.usc.wechat.mp.sdk.util.platform;

import org.usc.wechat.mp.sdk.vo.group.GroupsJsonRtn;

/**
 *
 * @author Shunli
 */
public class GroupUtilTest {
    public static void main(String[] args) {
        System.out.println(GroupUtil.createGroup(Constants.LICENSE, "xxxxxx"));
        System.out.println();

        GroupsJsonRtn groups = GroupUtil.getGroups(Constants.LICENSE);
        System.out.println(groups);
        System.out.println();

        // // now always failed, tip system error
        // Group group = groups.getGroups().get(0);
        // group.setName("test");
        // System.out.println(GroupUtil.updateGroup(license, group));
        // System.out.println();

        String openId = "oVDIDt3_SMFnLBBfmQtr67oYT3NI";
        System.out.println(GroupUtil.moveMember(Constants.LICENSE, openId, 2));
        System.out.println();

        System.out.println(GroupUtil.getGroupIdByOpenId(Constants.LICENSE, openId));

    }
}
