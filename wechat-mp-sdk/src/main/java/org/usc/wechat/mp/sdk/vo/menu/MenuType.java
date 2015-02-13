package org.usc.wechat.mp.sdk.vo.menu;

/**
 *
 * @author Shunli
 */
public enum MenuType {
    CLICK("click"),
    VIEW("view") {
        @Override
        protected SingleMenuInfo buildSingleMenuInfo(SingleMenuInfo menuInfo, String menuUrlOrKey) {
            menuInfo.setUrl(menuUrlOrKey);
            return menuInfo;
        }
    },
    SCANCODE_PUSH("scancode_push"),
    SCANCODE_WAITMSG("scancode_waitmsg"),
    PIC_SYSPHOTO("pic_sysphoto"),
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),
    PIC_WEIXIN("pic_weixin"),
    LOCATION_SELECT("location_select"), ;

    private String type;

    private MenuType(String type) {
        this.type = type;
    }

    protected SingleMenuInfo buildSingleMenuInfo(SingleMenuInfo menuInfo, String menuUrlOrKey) {
        menuInfo.setKey(menuUrlOrKey);
        return menuInfo;
    }

    public SingleMenuInfo buildSingleMenuInfo(String menuName, String menuUrlOrKey) {
        return buildSingleMenuInfo(new SingleMenuInfo(menuName, type), menuUrlOrKey);
    }

}
