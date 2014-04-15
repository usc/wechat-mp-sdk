package org.usc.wechat.mp.sdk.util;

/**
 *
 * @author Shunli
 */
public interface WechatUrl {
    String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    String SEND_CUSTOM_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
    String SEND_MASS_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall";
    String DELETE_MASS_MESSAGE_URL = "https://api.weixin.qq.com//cgi-bin/message/mass/delete";

    String UPLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload";
    String GET_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get";
    String UPLOAD_NEWS_MEDIA_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews";

    String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";
    String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get";
    String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete";

    String GET_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/get";
    String CREATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/create";
    String GET_GROUP_BY_OPEN_ID_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid";
    String UPDATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/update";
    String MOVE_MEMBER_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update";

    String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
    String GET_USERS_URL = "https://api.weixin.qq.com/cgi-bin/user/get";

    String CREATE_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    String SHOW_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode";
}
