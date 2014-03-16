package org.usc.wechat.mp.sdk.vo.news;

import org.usc.wechat.mp.sdk.factory.NewsEnumFactory;
import org.usc.wechat.mp.sdk.vo.news.detail.TextNewsDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class TextNews extends News {
    @JSONField(name = "text")
    private TextNewsDetail textDetail;

    {
        super.setMsgType(NewsEnumFactory.TEXT.getMsgType());
    }

    public TextNews(TextNewsDetail textDetail) {
        this.textDetail = textDetail;
    }

    public TextNewsDetail getTextDetail() {
        return textDetail;
    }

    public void setTextDetail(TextNewsDetail textDetail) {
        this.textDetail = textDetail;
    }

}
