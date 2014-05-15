package org.usc.wechat.mp.sdk.vo.push.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MassEndJobFinishEventPush extends EventPush {
    @XmlElement(name = "MsgID")
    private String massMsgId;

    @XmlElement(name = "Status")
    private String status;

    @XmlElement(name = "TotalCount")
    private long totalCount;

    @XmlElement(name = "FilterCount")
    private long filterCount;

    @XmlElement(name = "SentCount")
    private long sentCount;

    @XmlElement(name = "ErrorCount")
    private long errorCount;

    public MassEndJobFinishEventPush() {
    }

    public String getMassMsgId() {
        return massMsgId;
    }

    public void setMassMsgId(String massMsgId) {
        this.massMsgId = massMsgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(long filterCount) {
        this.filterCount = filterCount;
    }

    public long getSentCount() {
        return sentCount;
    }

    public void setSentCount(long sentCount) {
        this.sentCount = sentCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

}
