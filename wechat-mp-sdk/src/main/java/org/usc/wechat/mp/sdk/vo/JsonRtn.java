package org.usc.wechat.mp.sdk.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class JsonRtn extends AbstractToStringBuilder{
    @JSONField(name = "errcode")
    private String errCode;

    @JSONField(name = "errmsg")
    private String errMsg;

    private String errHumanMsg;

    public JsonRtn() {
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrHumanMsg() {
        return errHumanMsg;
    }

    public void setErrHumanMsg(String errHumanMsg) {
        this.errHumanMsg = errHumanMsg;
    }

}
