package org.usc.wechat.mp.sdk.util.platform;

import org.usc.wechat.mp.sdk.vo.group.Group;
import org.usc.wechat.mp.sdk.vo.group.GroupWarpper;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class GroupUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) {
        System.out.println(GroupUtil.createGroup(license, new GroupWarpper(new Group("测试create group2"))));
    }
}
