package org.usc.wechat.mp.sdk.util.platform;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.vo.token.License;
import org.usc.wechat.mp.sdk.vo.user.UsersJsonRtn;

/**
 *
 * @author Shunli
 */
public class UserUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) {
        UsersJsonRtn users = UserUtil.getUsers(license);
        System.out.println(users);
        System.out.println();

        String openId = users != null ? users.getNextOpenId() : StringUtils.EMPTY;
        System.out.println(UserUtil.getUserInfo(license, openId));
    }
}
