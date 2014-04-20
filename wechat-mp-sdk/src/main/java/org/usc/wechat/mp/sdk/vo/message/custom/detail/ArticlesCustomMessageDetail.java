package org.usc.wechat.mp.sdk.vo.message.custom.detail;

import java.util.List;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class ArticlesCustomMessageDetail extends AbstractToStringBuilder {
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
