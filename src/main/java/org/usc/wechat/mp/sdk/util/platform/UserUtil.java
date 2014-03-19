package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.cache.AccessTokenCache;
import org.usc.wechat.mp.sdk.util.Constant;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.token.License;
import org.usc.wechat.mp.sdk.vo.user.GroupJsonRtn;
import org.usc.wechat.mp.sdk.vo.user.GroupWarpper;
import org.usc.wechat.mp.sdk.vo.user.UserInfoJsonRtn;
import org.usc.wechat.mp.sdk.vo.user.UsersJsonRtn;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class UserUtil {
    private final static Logger log = LoggerFactory.getLogger(MenuUtil.class);

    public static GroupJsonRtn createGroup(License license, GroupWarpper groupWarpper) {
        if (groupWarpper == null || groupWarpper.getGroup() == null) {
            return null;
        }

        String body = JSONObject.toJSONString(groupWarpper);
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_CREATE_GROUP_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);

            GroupJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupJsonRtn.class);
            log.info("create group:\n url={},\n body={},\n rtn={},{}", uri, groupWarpper, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "create group failed:\n " +
                    "url=" + Constant.WECHAT_CREATE_GROUP_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

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
