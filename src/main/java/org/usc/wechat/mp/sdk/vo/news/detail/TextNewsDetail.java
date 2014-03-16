package org.usc.wechat.mp.sdk.vo.news.detail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class TextNewsDetail extends AbstractNewsDetail {
    @JSONField(name = "content")
    private String content;

    protected TextNewsDetail() {
    }

    public TextNewsDetail(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
