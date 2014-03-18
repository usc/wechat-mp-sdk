package org.usc.wechat.mp.sdk.vo.message.custom;

import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.vo.message.custom.ArticleCustomMessage;
import org.usc.wechat.mp.sdk.vo.message.custom.CustomMessage;
import org.usc.wechat.mp.sdk.vo.message.custom.ImageCustomMessage;
import org.usc.wechat.mp.sdk.vo.message.custom.MusicCustomMessage;
import org.usc.wechat.mp.sdk.vo.message.custom.TextCustomMessage;
import org.usc.wechat.mp.sdk.vo.message.custom.VideoCustomMessage;
import org.usc.wechat.mp.sdk.vo.message.custom.VoiceCustomMessage;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.ArticleCustomMessageDetail;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.ArticlesCustomMessageDetail;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.MediaCustomMessageDetail;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.MusicCustomMessageDetail;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.TextCustomMessageDetail;
import org.usc.wechat.mp.sdk.vo.message.custom.detail.VideoCustomMessageDetail;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *
 * @author Shunli
 */
public class CustomMessageTest {
    public static void main(String[] args) {
        TextCustomMessageDetail textDeatil = new TextCustomMessageDetail("t_content");
        TextCustomMessage textCustomMessage = new TextCustomMessage(textDeatil);
        toJson(textCustomMessage);

        MediaCustomMessageDetail imageDetail = new MediaCustomMessageDetail("i_mediaId");
        ImageCustomMessage imageCustomMessage = new ImageCustomMessage(imageDetail);
        toJson(imageCustomMessage);

        MediaCustomMessageDetail voiceDetail = new MediaCustomMessageDetail("voice_mediaId");
        VoiceCustomMessage voiceCustomMessage = new VoiceCustomMessage(voiceDetail);
        toJson(voiceCustomMessage);

        VideoCustomMessageDetail videoDetail = new VideoCustomMessageDetail("video_mediaId", "video_title", "video_description");
        VideoCustomMessage videoCustomMessage = new VideoCustomMessage(videoDetail);
        toJson(videoCustomMessage);

        MusicCustomMessageDetail musicDetail = new MusicCustomMessageDetail("m_title", "m_description", "m_musicUrl", "m_hQMusicUrl", "m_thumbMediaId");
        MusicCustomMessage musiceCustomMessage = new MusicCustomMessage(musicDetail);
        toJson(musiceCustomMessage);

        List<ArticleCustomMessageDetail> articles = new ArrayList<ArticleCustomMessageDetail>();
        articles.add(new ArticleCustomMessageDetail("a_title1", "a_description1", "a_picUrl1", "a_url1"));
        articles.add(new ArticleCustomMessageDetail("a_title2", "a_description2", "a_picUrl2", "a_url2"));
        articles.add(new ArticleCustomMessageDetail("a_title3", "a_description3", "a_picUrl3", "a_url3"));
        ArticleCustomMessage articleCustomMessage = new ArticleCustomMessage(new ArticlesCustomMessageDetail(articles));
        toJson(articleCustomMessage);
    }

    private static void buildReply(CustomMessage news) {
        news.setToUser("oVDIDt3_SMFnLBBfmQtr67oYT3NI");
    }

    private static void toJson(CustomMessage news) {
        buildReply(news);

        System.out.println(JSONObject.toJSONString(news, SerializerFeature.PrettyFormat));
    }
}
