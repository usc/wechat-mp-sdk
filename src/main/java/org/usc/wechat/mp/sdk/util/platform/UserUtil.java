package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.cache.AccessTokenCache;
import org.usc.wechat.mp.sdk.util.Constant;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.token.License;
import org.usc.wechat.mp.sdk.vo.user.UserInfoJsonRtn;
import org.usc.wechat.mp.sdk.vo.user.UsersJsonRtn;

/**
 *
 * @author Shunli
 */
public class UserUtil {
    private final static Logger log = LoggerFactory.getLogger(UserUtil.class);

    public static UserInfoJsonRtn getUserInfo(License license, String openId) {
        return getUserInfo(license, openId, null);
    }

    public static UserInfoJsonRtn getUserInfo(License license, String openId, Locale local) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        String accessToken = AccessTokenCache.getAccessToken(license);
        String lang = local != null ? local.toString() : StringUtils.EMPTY;
        try {
            URI uri = new URIBuilder(Constant.WECHAT_GET_USER_INFO_URL)
                    .setParameter("access_token", accessToken)
                    .setParameter("openid", openId)
                    .setParameter("lang", lang)
                    .build();

            String json = Request.Get(uri).execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);
            UserInfoJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, UserInfoJsonRtn.class);
            log.info("get user info:\n url={},\n rtn={},{}", uri, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "get user info failed: url=" + Constant.WECHAT_GET_USER_INFO_URL + "?access_token=" + accessToken + "&lang=" + lang;
            log.error(msg, e);
            return null;
        }
    }

    public static UsersJsonRtn getUsers(License license) {
        return getUsers(license, null);
    }

    public static UsersJsonRtn getUsers(License license, String nextOpenId) {
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_GET_USERS_URL)
                    .setParameter("access_token", accessToken)
                    .setParameter("next_openid", StringUtils.defaultString(nextOpenId))
                    .build();

            String json = Request.Get(uri).execute().returnContent().asString();
            UsersJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, UsersJsonRtn.class);
            log.info("get user info:\n url={},\n rtn={},{}", uri, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "get user info failed: url=" + Constant.WECHAT_GET_USERS_URL + "?access_token=" + accessToken + "&next_openid=" + StringUtils.defaultString(nextOpenId);
            log.error(msg, e);
            return null;
        }
    }
}
