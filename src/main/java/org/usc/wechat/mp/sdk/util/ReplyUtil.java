package org.usc.wechat.mp.sdk.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.EnumUtils;
import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.ReplyDetailWarpper;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.ArticleDetail;
import org.usc.wechat.mp.sdk.vo.reply.MusicDetail;
import org.usc.wechat.mp.sdk.vo.reply.MusicReply;
import org.usc.wechat.mp.sdk.vo.reply.NewsReply;
import org.usc.wechat.mp.sdk.vo.reply.Reply;
import org.usc.wechat.mp.sdk.vo.reply.TextReply;

/**
 *
 * @author Shunli
 */
public class ReplyUtil {
    public static Reply buildReply(Reply reply, Push push) {
        try {
            if (reply != null) {
                // keep is new instance
                Reply newReply = (Reply) BeanUtils.cloneBean(reply);

                newReply.setToUserName(push.getFromUserName());
                newReply.setFromUserName(push.getToUserName());
                newReply.setCreateTime(getUnixTimeStamp());

                return newReply;
            }
        } catch (Exception e) {
        }

        return null;
    }

    public static long getUnixTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    public static Reply parseReplyWarpper(ReplyDetailWarpper replyDetailWarpper) {
        if (replyDetailWarpper == null) {
            return null;
        }

        String replyType = replyDetailWarpper.getReplyType();
        List<ReplyDetail> replyDetails = replyDetailWarpper.getReplyDetails();

        ReplyEnumFactory replyEnumFactory = EnumUtils.getEnum(ReplyEnumFactory.class, replyType);
        if (replyEnumFactory == null) {
            return null;
        }

        return replyEnumFactory.buildReply(replyDetails);
    }

    public static TextReply buildTextReply(List<ReplyDetail> replyDetails, String replyType) {
        if (replyDetails.isEmpty()) {
            return null;
        }

        ReplyDetail detail = replyDetails.get(0);

        TextReply textReply = new TextReply();
        textReply.setMsgType(replyType);
        textReply.setContent(detail.getDescription());

        return textReply;
    }

    public static NewsReply buildNewsReply(List<ReplyDetail> replyDetails, String replyType) {
        if (replyDetails.isEmpty()) {
            return null;
        }

        int size = replyDetails.size();
        List<ArticleDetail> articles = new ArrayList<ArticleDetail>(size);

        NewsReply newsReply = new NewsReply();
        newsReply.setMsgType(replyType);
        newsReply.setArticleCount(size);
        newsReply.setArticles(articles);
        for (ReplyDetail replyDetailVo : replyDetails) {
            articles.add(new ArticleDetail(replyDetailVo.getTitle(), replyDetailVo.getDescription(), replyDetailVo.getMediaUrl(), replyDetailVo.getUrl()));
        }

        return newsReply;
    }

    public static MusicReply buildMusicReply(List<ReplyDetail> replyDetails, String replyType) {
        if (replyDetails.isEmpty()) {
            return null;
        }

        ReplyDetail detail = replyDetails.get(0);

        MusicReply musicReply = new MusicReply();
        musicReply.setMsgType(replyType);
        MusicDetail musicDetail = new MusicDetail(detail.getTitle(), detail.getDescription(), detail.getMediaUrl(), detail.getUrl());
        musicReply.setMusicDetail(musicDetail);

        return musicReply;
    }
}
