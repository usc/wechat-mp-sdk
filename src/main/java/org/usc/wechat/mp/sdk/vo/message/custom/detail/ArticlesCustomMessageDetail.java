package org.usc.wechat.mp.sdk.vo.message.custom.detail;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class ArticlesCustomMessageDetail extends AbstractCustomMessageDetail {
    @JSONField(name = "articles")
    private List<ArticleCustomMessageDetail> articles;

    public ArticlesCustomMessageDetail(List<ArticleCustomMessageDetail> articles) {
        this.articles = articles;
    }

    public List<ArticleCustomMessageDetail> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleCustomMessageDetail> articles) {
        this.articles = articles;
    }

}
