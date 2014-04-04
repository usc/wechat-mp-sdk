package org.usc.wechat.mp.sdk.vo.menu;

import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class Menu {
    @JSONField(name = "button")
    private List<MenuInfo> menuInfos = new ArrayList<MenuInfo>();

    public Menu() {
    }

    public Menu(List<MenuInfo> menuInfos) {
        this.menuInfos = menuInfos;
    }

    public List<MenuInfo> getMenuInfos() {
        return menuInfos;
    }

    public void setMenuInfos(List<MenuInfo> menuInfos) {
        this.menuInfos = menuInfos;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
