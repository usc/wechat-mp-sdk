package org.usc.wechat.mp.sdk.vo.menu;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public abstract class MenuInfo  extends AbstractToStringBuilder{
    @JSONField(name = "name")
    private String name;

    public MenuInfo() {
    }

    public MenuInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
