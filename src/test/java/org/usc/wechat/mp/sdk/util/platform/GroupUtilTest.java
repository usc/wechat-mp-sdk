package org.usc.wechat.mp.sdk.util.platform;

import org.usc.wechat.mp.sdk.vo.group.Group;
import org.usc.wechat.mp.sdk.vo.group.GroupWarpper;
import org.usc.wechat.mp.sdk.vo.group.GroupsJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.MemberMovement;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class GroupUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) {
        System.out.println(GroupUtil.createGroup(license, new GroupWarpper(new Group("xxxxxx"))));
        System.out.println();

        GroupsJsonRtn groups = GroupUtil.getGroups(license);
        System.out.println(groups);
        System.out.println();

        // now always failed, tip system error
        // Group group = groups.getGroups().get(0);
        // group.setName("test");
        // System.out.println(GroupUtil.updateGroup(license, new GroupWarpper(group)));
        // System.out.println();

        String openId = "oVDIDt3_SMFnLBBfmQtr67oYT3NI";
        MemberMovement memberMovement = new MemberMovement(openId, 2);
        System.out.println(GroupUtil.moveMember(license, memberMovement));
        System.out.println();

        System.out.println(GroupUtil.getGroupIdByOpenId(license, openId));

    }
}
