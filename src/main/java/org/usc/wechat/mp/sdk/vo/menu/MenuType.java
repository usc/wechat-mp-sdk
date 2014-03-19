package org.usc.wechat.mp.sdk.vo.menu;

/**
 *
 * @author Shunli
 */
public enum MenuType {
    CLICK("click") {
        @Override
        protected SingleMenuInfo buildSingleMenuInfo(SingleMenuInfo menuInfo, String menuUrlOrKey) {
            menuInfo.setKey(menuUrlOrKey);
            return menuInfo;
        }
    },
    VIEW("view") {
        @Override
        protected SingleMenuInfo buildSingleMenuInfo(SingleMenuInfo menuInfo, String menuUrlOrKey) {
            menuInfo.setUrl(menuUrlOrKey);
            return menuInfo;
        }
    },
    ;

    private String type;

    private MenuType(String type) {
        this.type = type;
    }

    protected abstract SingleMenuInfo buildSingleMenuInfo(SingleMenuInfo menuInfo, String menuUrlOrKey);

    public SingleMenuInfo buildSingleMenuInfo(String menuName, String menuUrlOrKey) {
        return buildSingleMenuInfo(new SingleMenuInfo(menuName, type), menuUrlOrKey);
    }

}
