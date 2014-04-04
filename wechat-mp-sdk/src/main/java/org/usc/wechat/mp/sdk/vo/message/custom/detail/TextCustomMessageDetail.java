package org.usc.wechat.mp.sdk.vo.message.custom.detail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class TextCustomMessageDetail extends AbstractCustomMessageDetail {
    @JSONField(name = "content")
    private String content;

    protected TextCustomMessageDetail() {
    }

    public TextCustomMessageDetail(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
