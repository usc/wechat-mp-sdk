package org.usc.wechat.mp.sdk.vo.news;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.news.detail.ArticlesNewsDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class ArticleNews extends News {
    @JSONField(name = "news")
    private ArticlesNewsDetail news;

    {
        super.setMsgType(ReplyEnumFactory.NEWS.getReplyType());
    }

    public ArticleNews(ArticlesNewsDetail news) {
        this.news = news;
    }

    public ArticlesNewsDetail getNews() {
        return news;
    }

    public void setNews(ArticlesNewsDetail news) {
        this.news = news;
    }

}
