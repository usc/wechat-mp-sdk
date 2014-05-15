package org.usc.wechat.mp.sdk.vo.message.reply;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.NewsDetail;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsReply extends Reply {
    @XmlElement(name = "ArticleCount")
    private int articleCount;

    @XmlElementWrapper(name = "Articles")
    @XmlElement(name = "item")
    private List<NewsDetail> articles;

    {
        super.setMsgType(ReplyEnumFactory.NEWS.getReplyType());
    }

    public NewsReply() {
    }

    public NewsReply(int articleCount, List<NewsDetail> articles) {
        this.articleCount = articleCount;
        this.articles = articles;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<NewsDetail> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsDetail> articles) {
        this.articles = articles;
    }

}
