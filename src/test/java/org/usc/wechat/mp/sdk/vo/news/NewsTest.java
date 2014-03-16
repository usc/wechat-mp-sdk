package org.usc.wechat.mp.sdk.vo.news;

import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.vo.news.detail.ArticleNewsDetail;
import org.usc.wechat.mp.sdk.vo.news.detail.ArticlesNewsDetail;
import org.usc.wechat.mp.sdk.vo.news.detail.MediaNewsDetail;
import org.usc.wechat.mp.sdk.vo.news.detail.MusicNewsDetail;
import org.usc.wechat.mp.sdk.vo.news.detail.TextNewsDetail;
import org.usc.wechat.mp.sdk.vo.news.detail.VideoNewsDetail;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *
 * @author Shunli
 */
public class NewsTest {
    public static void main(String[] args) {
        TextNewsDetail textDeatil = new TextNewsDetail("t_content");
        TextNews textNews = new TextNews(textDeatil);
        toJson(textNews);

        MediaNewsDetail imageDetail = new MediaNewsDetail("i_mediaId");
        ImageNews imageNews = new ImageNews(imageDetail);
        toJson(imageNews);

        MediaNewsDetail voiceDetail = new MediaNewsDetail("voice_mediaId");
        VoiceNews voiceNews = new VoiceNews(voiceDetail);
        toJson(voiceNews);

        VideoNewsDetail videoDetail = new VideoNewsDetail("video_mediaId", "video_title", "video_description");
        VideoNews videoNews = new VideoNews(videoDetail);
        toJson(videoNews);

        MusicNewsDetail musicDetail = new MusicNewsDetail("m_title", "m_description", "m_musicUrl", "m_hQMusicUrl", "m_thumbMediaId");
        MusicNews musiceNews = new MusicNews(musicDetail);
        toJson(musiceNews);

        List<ArticleNewsDetail> articles = new ArrayList<ArticleNewsDetail>();
        articles.add(new ArticleNewsDetail("a_title1", "a_description1", "a_picUrl1", "a_url1"));
        articles.add(new ArticleNewsDetail("a_title2", "a_description2", "a_picUrl2", "a_url2"));
        articles.add(new ArticleNewsDetail("a_title3", "a_description3", "a_picUrl3", "a_url3"));
        ArticleNews articleNews = new ArticleNews(new ArticlesNewsDetail(articles));
        toJson(articleNews);
    }

    private static void buildReply(News news) {
        news.setToUser("t_toUser");
    }

    private static void toJson(News news) {
        buildReply(news);

        System.out.println(JSONObject.toJSONString(news, SerializerFeature.PrettyFormat));
    }
}
