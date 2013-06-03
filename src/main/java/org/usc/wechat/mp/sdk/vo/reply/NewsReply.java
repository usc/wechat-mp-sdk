package org.usc.wechat.mp.sdk.vo.reply;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.vo.reply.detail.NewsDetail;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsReply extends Reply {
    @XmlElement(name = "ArticleCount")
    private int ArticleCount;

    @XmlElementWrapper(name = "Articles")
    @XmlElement(name = "item")
    private List<NewsDetail> articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<NewsDetail> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsDetail> articles) {
        this.articles = articles;
    }

}
