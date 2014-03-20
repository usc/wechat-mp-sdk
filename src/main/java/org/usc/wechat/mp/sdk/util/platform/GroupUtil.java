package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;

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
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.group.Group;
import org.usc.wechat.mp.sdk.vo.group.GroupIdJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.GroupJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.GroupWarpper;
import org.usc.wechat.mp.sdk.vo.group.GroupsJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.MemberMovement;
import org.usc.wechat.mp.sdk.vo.group.OpenId;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class GroupUtil {
    private final static Logger log = LoggerFactory.getLogger(GroupUtilTest.class);

    public static GroupsJsonRtn getGroups(License license) {
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_GET_GROUPS_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Get(uri).execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);
            GroupsJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupsJsonRtn.class);
            log.info("get groups:\n url={},\n rtn={},{}", uri, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "get groups failed:\n url=" + Constant.WECHAT_GET_GROUPS_URL + "?access_token=" + accessToken;
            log.error(msg, e);
            return null;
        }
    }

    public static GroupIdJsonRtn getGroupIdByOpenId(License license, String openId) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        String body = JSONObject.toJSONString(new OpenId(openId));
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_GET_GROUP_BY_OPEN_ID_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);
            GroupIdJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupIdJsonRtn.class);
            log.info("get group id :\n url={},\n body={},\n rtn={},{}", uri, body, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "get group id failed:\n" +
                    " url=" + Constant.WECHAT_GET_GROUP_BY_OPEN_ID_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

    public static GroupJsonRtn createGroup(License license, String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return null;
        }

        String body = JSONObject.toJSONString(new GroupWarpper(new Group(groupName)));
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_CREATE_GROUP_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);

            GroupJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupJsonRtn.class);
            log.info("create group:\n url={},\n body={},\n rtn={},{}", uri, body, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "create group failed:\n " +
                    "url=" + Constant.WECHAT_CREATE_GROUP_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

    // TODO-Shunli: now update group always failed, tip system error, check later
    public static JsonRtn updateGroup(License license, Group group) {
        if (group == null) {
            return null;
        }

        String body = JSONObject.toJSONString(new GroupWarpper(group));
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_UPDATE_GROUP_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);

            GroupJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupJsonRtn.class);
            log.info("update group:\n url={},\n body={},\n rtn={},{}", uri, body, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "update group failed:\n " +
                    "url=" + Constant.WECHAT_UPDATE_GROUP_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

    public static JsonRtn moveMember(License license, String openId, int toGroupId) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        String body = JSONObject.toJSONString(new MemberMovement(openId, toGroupId));
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_MOVE_MEMBER_GROUP_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);

            GroupJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupJsonRtn.class);
            log.info("move member:\n url={},\n body={},\n rtn={},{}", uri, body, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "move member failed:\n " +
                    "url=" + Constant.WECHAT_MOVE_MEMBER_GROUP_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

}
