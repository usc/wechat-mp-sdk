package org.usc.wechat.mp.sdk.vo.user;

import org.usc.wechat.mp.sdk.vo.JsonRtn;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class UsersJsonRtn extends JsonRtn {
    @JSONField(name = "total")
    private int total;

    @JSONField(name = "count")
    private int count;

    @JSONField(name = "data")
    private OpenIdsJsonRtn openIds;

    @JSONField(name = "next_openid")
    private String nextOpenId;

    public UsersJsonRtn() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public OpenIdsJsonRtn getOpenIds() {
        return openIds;
    }

    public void setOpenIds(OpenIdsJsonRtn openIds) {
        this.openIds = openIds;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }
}
