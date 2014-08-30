package org.usc.wechat.mp.sdk.vo;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public enum WechatRequest {
    GET_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token"),

    SEND_CUSTOM_MESSAGE("https://api.weixin.qq.com/cgi-bin/message/custom/send"),
    SEND_MASS_MESSAGE("https://api.weixin.qq.com/cgi-bin/message/mass/sendall"),
    DELETE_MASS_MESSAGE("https://api.weixin.qq.com//cgi-bin/message/mass/delete"),

    UPLOAD_MEDIA("http://file.api.weixin.qq.com/cgi-bin/media/upload"),
    GET_MEDIA("http://file.api.weixin.qq.com/cgi-bin/media/get"),
    UPLOAD_NEWS_MEDIA("https://api.weixin.qq.com/cgi-bin/media/uploadnews"),

    CREATE_MENU("https://api.weixin.qq.com/cgi-bin/menu/create"),
    GET_MENU("https://api.weixin.qq.com/cgi-bin/menu/get"),
    DELETE_MENU("https://api.weixin.qq.com/cgi-bin/menu/delete"),

    GET_GROUPS("https://api.weixin.qq.com/cgi-bin/groups/get"),
    CREATE_GROUP("https://api.weixin.qq.com/cgi-bin/groups/create"),
    GET_GROUP_BY_OPEN_ID("https://api.weixin.qq.com/cgi-bin/groups/getid"),
    UPDATE_GROUP("https://api.weixin.qq.com/cgi-bin/groups/update"),
    MOVE_MEMBER_GROUP("https://api.weixin.qq.com/cgi-bin/groups/members/update"),

    GET_USER_INFO("https://api.weixin.qq.com/cgi-bin/user/info"),
    GET_USERS("https://api.weixin.qq.com/cgi-bin/user/get"),
    UPDATE_REMARK("https://api.weixin.qq.com/cgi-bin/user/info/updateremark"),

    CREATE_QRCODE("https://api.weixin.qq.com/cgi-bin/qrcode/create"),
    SHOW_QRCODE("https://mp.weixin.qq.com/cgi-bin/showqrcode");

    private String url;

    private WechatRequest(String url) {
        this.url = url;
    }

    public String getName() {
        return StringUtils.lowerCase(StringUtils.replace(name(), "_", " "));
    }

    public String getUrl() {
        return url;
    }

}
