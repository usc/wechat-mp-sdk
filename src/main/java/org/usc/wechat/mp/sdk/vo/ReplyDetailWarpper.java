package org.usc.wechat.mp.sdk.vo;

import java.util.List;

/**
 *
 * @author Shunli
 */
public class ReplyDetailWarpper {
    private String replyType;
    private int funcFlag = 0;
    private List<ReplyDetail> replyDetails;

    public ReplyDetailWarpper(String replyType, List<ReplyDetail> replyDetails) {
        this(replyType, 0, replyDetails);
    }

    public ReplyDetailWarpper(String replyType, int funcFlag, List<ReplyDetail> replyDetails) {
        this.replyType = replyType;
        this.funcFlag = funcFlag;
        this.replyDetails = replyDetails;
    }

    public String getReplyType() {
        return replyType;
    }

    public void setReplyType(String replyType) {
        this.replyType = replyType;
    }

    public int getFuncFlag() {
        return funcFlag;
    }

    public List<ReplyDetail> getReplyDetails() {
        return replyDetails;
    }

    public void setReplyDetails(List<ReplyDetail> replyDetails) {
        this.replyDetails = replyDetails;
    }

}
