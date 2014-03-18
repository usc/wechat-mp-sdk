package org.usc.wechat.mp.sdk.factory.builder;

import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.message.reply.NewsReply;
import org.usc.wechat.mp.sdk.vo.message.reply.Reply;
import org.usc.wechat.mp.sdk.vo.message.reply.detail.NewsDetail;

/**
 *
 * @author Shunli
 */
public class NewsReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        int size = replyDetails.size();
        List<NewsDetail> articles = new ArrayList<NewsDetail>(size);
        for (ReplyDetail replyDetailVo : replyDetails) {
            articles.add(new NewsDetail(
                    replyDetailVo.getTitle(),
                    replyDetailVo.getDescription(),
                    replyDetailVo.getMediaUrl(),
                    replyDetailVo.getUrl()));
        }

        return new NewsReply(size, articles);
    }

}
