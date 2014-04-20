package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.util.WechatUrl;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.group.Group;
import org.usc.wechat.mp.sdk.vo.group.GroupIdJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.GroupJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.GroupWarpper;
import org.usc.wechat.mp.sdk.vo.group.GroupsJsonRtn;
import org.usc.wechat.mp.sdk.vo.group.MemberMovement;
import org.usc.wechat.mp.sdk.vo.group.OpenId;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class GroupUtil {
    private final static Logger log = LoggerFactory.getLogger(GroupUtil.class);

    public static GroupsJsonRtn getGroups(License license) {
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.GET_GROUPS_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Get(uri).execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);
            GroupsJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, GroupsJsonRtn.class);
            log.info("get groups:\n url={},\n rtn={},{}", uri, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "get groups failed:\n url=" + WechatUrl.GET_GROUPS_URL + "?access_token=" + accessToken;
            log.error(msg, e);
            return null;
        }
    }

    public static GroupIdJsonRtn getGroupIdByOpenId(License license, String openId) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.GET_GROUP_BY_OPEN_ID, license, new OpenId(openId), GroupIdJsonRtn.class);
    }

    public static GroupJsonRtn createGroup(License license, String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.CREATE_GROUP, license, new GroupWarpper(new Group(groupName)), GroupJsonRtn.class);
    }

    // TODO-Shunli: now update group always failed, tip system error, check later
    public static JsonRtn updateGroup(License license, Group group) {
        if (group == null) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.UPDATE_GROUP, license, new GroupWarpper(group), GroupJsonRtn.class);
    }

    public static JsonRtn moveMember(License license, String openId, int toGroupId) {
        if (StringUtils.isEmpty(openId)) {
            return null;
        }

        return HttpUtil.postBodyRequest(WechatRequest.MOVE_MEMBER_GROUP, license, new MemberMovement(openId, toGroupId), GroupJsonRtn.class);
    }
}
