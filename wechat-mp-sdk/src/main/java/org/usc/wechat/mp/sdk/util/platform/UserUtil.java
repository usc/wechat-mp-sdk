package org.usc.wechat.mp.sdk.util.platform;

import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.token.License;
import org.usc.wechat.mp.sdk.vo.user.UserInfoJsonRtn;
import org.usc.wechat.mp.sdk.vo.user.UsersJsonRtn;

import com.google.common.collect.ImmutableMap;

/**
 *
 * @author Shunli
 */
public class UserUtil {
    public static UserInfoJsonRtn getUserInfo(License license, String openId) {
        return getUserInfo(license, openId, null);
    }

    public static UserInfoJsonRtn getUserInfo(License license, String openId, Locale local) {
        if (StringUtils.isEmpty(openId)) {
            return JsonRtnUtil.buildFailureJsonRtn(UserInfoJsonRtn.class, "missing openId");
        }

        String lang = local != null ? local.toString() : StringUtils.EMPTY;
        Map<String, String> paramMap = ImmutableMap.of("openid", openId, "lang", lang);
        return HttpUtil.getRequest(WechatRequest.GET_USER_INFO, license, paramMap, UserInfoJsonRtn.class);
    }

    public static UsersJsonRtn getUsers(License license) {
        return getUsers(license, null);
    }

    public static UsersJsonRtn getUsers(License license, String nextOpenId) {
        Map<String, String> paramMap = ImmutableMap.of("next_openid", StringUtils.defaultString(nextOpenId));
        return HttpUtil.getRequest(WechatRequest.GET_USERS, license, paramMap, UsersJsonRtn.class);
    }

    public static JsonRtn updateRemark(License license, String openId, String remark) {
        if (StringUtils.isEmpty(openId)) {
            return JsonRtnUtil.buildFailureJsonRtn(JsonRtn.class, "missing openId");
        }

        if (StringUtils.isEmpty(remark)) {
            return JsonRtnUtil.buildFailureJsonRtn(JsonRtn.class, "missing remark");
        }

        Map<String, String> paramMap = ImmutableMap.of("openid", openId, "remark", remark);
        return HttpUtil.getRequest(WechatRequest.UPDATE_REMARK, license, paramMap, JsonRtn.class);
    }

}
