package org.usc.wechat.mp.sdk.vo.menu;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MultiMenuInfo extends MenuInfo {
    @JSONField(name = "sub_button")
    private List<SingleMenuInfo> subMenuInfos;

    public MultiMenuInfo() {
    }

    public MultiMenuInfo(String name, List<SingleMenuInfo> subMenuInfos) {
        super(name);
        this.subMenuInfos = subMenuInfos;
    }

    public List<SingleMenuInfo> getSubMenuInfos() {
        return subMenuInfos;
    }

    public void setSubMenuInfos(List<SingleMenuInfo> subMenuInfos) {
        this.subMenuInfos = subMenuInfos;
    }

}
