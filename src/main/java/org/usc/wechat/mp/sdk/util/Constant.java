package org.usc.wechat.mp.sdk.util;

/**
 *
 * @author Shunli
 */
public interface Constant {
    String WECHAT_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    String WECHAT_SEND_CUSTOM_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

    String WECHAT_UPLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload";
    String WECHAT_GET_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get";

    String WECHAT_GLOBAL_MESSAGE_FILE_NAME = "wechate-global-message";
    String WECHAT_JSON_RTN_SUCCESS_CODE = "0";
}
