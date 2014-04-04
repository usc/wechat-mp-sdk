package org.usc.wechat.mp.sdk.vo.message.custom;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.ArticlesCustomMessageDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class ArticleCustomMessage extends CustomMessage {
    @JSONField(name = "news")
    private ArticlesCustomMessageDetail news;

    {
        super.setMsgType(ReplyEnumFactory.NEWS.getReplyType());
    }

    public ArticleCustomMessage(ArticlesCustomMessageDetail news) {
        this.news = news;
    }

    public ArticlesCustomMessageDetail getNews() {
        return news;
    }

    public void setNews(ArticlesCustomMessageDetail news) {
        this.news = news;
    }

}
