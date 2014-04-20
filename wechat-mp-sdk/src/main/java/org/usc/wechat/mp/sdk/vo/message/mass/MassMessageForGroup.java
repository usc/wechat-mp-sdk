package org.usc.wechat.mp.sdk.vo.message.mass;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class MassMessageForGroup extends MassMessage {
    @JSONField(name = "filter")
    private MassMessageForGroupDetail filter;

    public MassMessageForGroup() {
    }

    public MassMessageForGroup(MassMessageForGroupDetail filter, MassNews mpNews, String msgType) {
        super(mpNews, msgType);
        this.filter = filter;
    }

    public MassMessageForGroupDetail getFilter() {
        return filter;
    }

    public void setFilter(MassMessageForGroupDetail filter) {
        this.filter = filter;
    }

}
