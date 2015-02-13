package org.usc.wechat.mp.sdk.util.platform;

import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.basic.IpListJsonRtn;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class BasicUtil {
    public static IpListJsonRtn getCallbackIp(License license) {
        return HttpUtil.getRequest(WechatRequest.GET_CALLBACK_IP, license, IpListJsonRtn.class);
    }
}
