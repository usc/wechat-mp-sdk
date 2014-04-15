package org.usc.wechat.mp.sdk.vo.media;

import java.util.List;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class NewsMedia {
    @JSONField(name = "articles")
    private List<NewsMediaDetail> articles;

    public NewsMedia(List<NewsMediaDetail> articles) {
        this.articles = articles;
    }

    public List<NewsMediaDetail> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsMediaDetail> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
