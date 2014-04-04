package org.usc.wechat.mp.sdk.vo.media;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shunli
 */
public class MediaLimit {
    private long maxSize;
    private long maxLength;
    private List<MimeType> allowTypes = new ArrayList<MimeType>();

    public MediaLimit() {
    }

    public MediaLimit(List<MimeType> allowTypes) {
        this.allowTypes = allowTypes;
    }

    public MediaLimit(long maxSize, List<MimeType> allowTypes) {
        this.maxSize = maxSize;
        this.allowTypes = allowTypes;
    }

    public MediaLimit(long maxSize, long maxLength, List<MimeType> allowTypes) {
        this.maxSize = maxSize;
        this.maxLength = maxLength;
        this.allowTypes = allowTypes;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }

    public long getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(long maxLength) {
        this.maxLength = maxLength;
    }

    public List<MimeType> getAllowTypes() {
        return allowTypes;
    }

    public void setAllowTypes(List<MimeType> allowTypes) {
        this.allowTypes = allowTypes;
    }

}
