package org.usc.wechat.mp.sdk.vo.message.mass;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MassMessageForUser extends MassMessage {
    @JSONField(name = "touser")
    private List<String> openIds;

    public MassMessageForUser() {
    }

    public MassMessageForUser(List<String> openIds, MassNews mpNews, String msgType) {
        super(mpNews, msgType);
        this.openIds = openIds;
    }

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }

}
