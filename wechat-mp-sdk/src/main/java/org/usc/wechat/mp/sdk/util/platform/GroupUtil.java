package org.usc.wechat.mp.sdk.util.platform;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
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
    public static GroupsJsonRtn getGroups(License license) {
        return HttpUtil.getRequest(WechatRequest.GET_GROUPS, license, GroupsJsonRtn.class);
    }

    public static GroupIdJsonRtn getGroupIdByOpenId(License license, String openId) {
        if (StringUtils.isEmpty(openId)) {
            return JsonRtnUtil.buildFailureJsonRtn(GroupIdJsonRtn.class, "missing openId");
        }

        return HttpUtil.postBodyRequest(WechatRequest.GET_GROUP_BY_OPEN_ID, license, new OpenId(openId), GroupIdJsonRtn.class);
    }

    public static GroupJsonRtn createGroup(License license, String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return JsonRtnUtil.buildFailureJsonRtn(GroupJsonRtn.class, "missing groupName");
        }

        return HttpUtil.postBodyRequest(WechatRequest.CREATE_GROUP, license, new GroupWarpper(new Group(groupName)), GroupJsonRtn.class);
    }

    // TODO-Shunli: now update group always failed, tip system error, check later
    public static JsonRtn updateGroup(License license, Group group) {
        if (group == null) {
            return JsonRtnUtil.buildFailureJsonRtn(JsonRtn.class, "missing group");
        }

        return HttpUtil.postBodyRequest(WechatRequest.UPDATE_GROUP, license, new GroupWarpper(group), GroupJsonRtn.class);
    }

    public static JsonRtn moveMember(License license, String openId, int toGroupId) {
        if (StringUtils.isEmpty(openId)) {
            return JsonRtnUtil.buildFailureJsonRtn(JsonRtn.class, "missing openId");
        }

        return HttpUtil.postBodyRequest(WechatRequest.MOVE_MEMBER_GROUP, license, new MemberMovement(openId, toGroupId), GroupJsonRtn.class);
    }
}
