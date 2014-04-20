package org.usc.wechat.mp.sdk.util.platform;

import java.util.List;

import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.message.custom.CustomMessage;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessage;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageForGroup;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageForGroupDetail;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageForUser;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageId;
import org.usc.wechat.mp.sdk.vo.message.mass.MassMessageJsonRtn;
import org.usc.wechat.mp.sdk.vo.message.mass.MassNews;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class MessageUtil {
    public static JsonRtn sendCustomMessage(License license, CustomMessage customMessage) {
        return HttpUtil.postBodyRequest(WechatRequest.SEND_CUSTOM_MESSAGE, license, customMessage, JsonRtn.class);
    }

    public static MassMessageJsonRtn sendMassMessageByGroup(License license, String groupId, String mediaId) {
        return sendMassMessageByGroup(license, groupId, mediaId, "mpnews");
    }

    public static MassMessageJsonRtn sendMassMessageByGroup(License license, String groupId, String mediaId, String msgType) {
        return sendMassMessage(license, new MassMessageForGroup(new MassMessageForGroupDetail(groupId), new MassNews(mediaId), msgType));
    }

    public static MassMessageJsonRtn sendMassMessageByUsers(License license, List<String> openIds, String mediaId) {
        return sendMassMessageByUsers(license, openIds, mediaId, "mpnews");
    }

    public static MassMessageJsonRtn sendMassMessageByUsers(License license, List<String> openIds, String mediaId, String msgType) {
        return sendMassMessage(license, new MassMessageForUser(openIds, new MassNews(mediaId), msgType));
    }

    public static MassMessageJsonRtn sendMassMessage(License license, MassMessage massMessage) {
        return HttpUtil.postBodyRequest(WechatRequest.SEND_MASS_MESSAGE, license, massMessage, MassMessageJsonRtn.class);
    }

    public static JsonRtn deleteMassMessage(License license, long msgId) {
        return HttpUtil.postBodyRequest(WechatRequest.DELETE_MASS_MESSAGE, license, new MassMessageId(msgId), JsonRtn.class);
    }

}
