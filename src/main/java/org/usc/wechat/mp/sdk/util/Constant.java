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

    String WECHAT_CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";
    String WECHAT_GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get";
    String WECHAT_DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete";

    String WECHAT_GET_GROUPS_URL = "https://api.weixin.qq.com/cgi-bin/groups/get";
    String WECHAT_CREATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/create";
    String WECHAT_GET_GROUP_BY_OPEN_ID_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid";
    String WECHAT_UPDATE_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/update";
    String WECHAT_MOVE_MEMBER_GROUP_URL = "https://api.weixin.qq.com/cgi-bin/groups/members/update";

    String WECHAT_GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
    String WECHAT_GET_USERS_URL = "https://api.weixin.qq.com/cgi-bin/user/get";

    String WECHAT_CREATE_QRCODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    String WECHAT_SHOW_QRCODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

    String WECHAT_GLOBAL_MESSAGE_FILE_NAME = "wechate-global-message";
    String WECHAT_JSON_RTN_SUCCESS_CODE = "0";
}
