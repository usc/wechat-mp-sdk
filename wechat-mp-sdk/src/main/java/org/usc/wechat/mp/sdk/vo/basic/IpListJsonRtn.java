package org.usc.wechat.mp.sdk.vo.basic;

import java.util.List;

import org.usc.wechat.mp.sdk.vo.JsonRtn;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class IpListJsonRtn extends JsonRtn {
    @JSONField(name = "ip_list")
    private List<String> ipList;

    public IpListJsonRtn() {
    }

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

}
