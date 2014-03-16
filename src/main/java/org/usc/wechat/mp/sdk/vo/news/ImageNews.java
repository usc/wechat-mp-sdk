package org.usc.wechat.mp.sdk.vo.news;

import org.usc.wechat.mp.sdk.factory.NewsEnumFactory;
import org.usc.wechat.mp.sdk.vo.news.detail.MediaNewsDetail;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class ImageNews extends News {
    @JSONField(name = "image")
    private MediaNewsDetail imageDetail;

    {
        super.setMsgType(NewsEnumFactory.IMAGE.getMsgType());
    }

    public ImageNews(MediaNewsDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

    public MediaNewsDetail getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(MediaNewsDetail imageDetail) {
        this.imageDetail = imageDetail;
    }

}
