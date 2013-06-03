package org.usc.wechat.mp.sdk.factory.builder;

import java.util.List;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;
import org.usc.wechat.mp.sdk.vo.ReplyDetail;
import org.usc.wechat.mp.sdk.vo.reply.ImageReply;
import org.usc.wechat.mp.sdk.vo.reply.Reply;
import org.usc.wechat.mp.sdk.vo.reply.detail.MediaDetail;

/**
 *
 * @author Shunli
 */
public class ImageReplyBuilder implements ReplyBuilder {
    @Override
    public Reply buildReply(List<ReplyDetail> replyDetails) {
        ReplyDetail detail = replyDetails.get(0);

        MediaDetail imageDetail = new MediaDetail();
        imageDetail.setMediaId(detail.getMediaUrl());

        ImageReply imageReply = new ImageReply();
        imageReply.setMsgType(ReplyEnumFactory.IMAGE.getReplyType());
        imageReply.setImageDetail(imageDetail);

        return imageReply;
    }

}
