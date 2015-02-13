package org.usc.wechat.mp.sdk.util.platform;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.basic.IpListJsonRtn;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.google.common.collect.ImmutableMap;

/**
 *
 * @author Shunli
 */
public class BasicUtil {
    public static IpListJsonRtn getCallbackIp(License license) {
        return HttpUtil.getRequest(WechatRequest.GET_CALLBACK_IP, license, IpListJsonRtn.class);
    }

    // TODO-Shunli: now shortUrl always failed, user unauthorized, check later
    public static JsonRtn shortUrl(License license, String url) {
        if (StringUtils.isEmpty(url)) {
            return JsonRtnUtil.buildFailureJsonRtn(JsonRtn.class, "missing url");
        }

        Map<String, String> paramMap = ImmutableMap.of("action", "long2short", "long_url", url);
        return HttpUtil.postBodyRequest(WechatRequest.SHORT_URL, license, paramMap, JsonRtn.class);
    }
}
