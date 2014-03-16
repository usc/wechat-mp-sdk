package org.usc.wechat.mp.sdk.vo.news.detail;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class ArticlesNewsDetail extends AbstractNewsDetail {
    @JSONField(name = "articles")
    private List<ArticleNewsDetail> articles;

    public ArticlesNewsDetail(List<ArticleNewsDetail> articles) {
        this.articles = articles;
    }

    public List<ArticleNewsDetail> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleNewsDetail> articles) {
        this.articles = articles;
    }

}
