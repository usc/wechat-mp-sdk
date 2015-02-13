package org.usc.wechat.mp.sdk.util.platform;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.vo.user.UsersJsonRtn;

/**
 *
 * @author Shunli
 */
public class UserUtilTest {
    public static void main(String[] args) {
        UsersJsonRtn users = UserUtil.getUsers(Constants.LICENSE);
        System.out.println(users);
        System.out.println();

        String openId = users != null ? users.getNextOpenId() : StringUtils.EMPTY;
        System.out.println(UserUtil.getUserInfo(Constants.LICENSE, openId));
    }
}
