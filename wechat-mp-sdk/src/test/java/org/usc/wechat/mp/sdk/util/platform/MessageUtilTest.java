package org.usc.wechat.mp.sdk.util.platform;

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
import org.usc.wechat.mp.sdk.vo.token.License;

import com.google.common.collect.ImmutableList;

/**
 *
 * @author Shunli
 */
public class MessageUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) {
        testCustomMessage();
        testMassMessage();
    }

    private static void testCustomMessage() {
        TextCustomMessageDetail textDeatil = new TextCustomMessageDetail("t_content");
        CustomMessage textNews = new TextCustomMessage(textDeatil);
        doSendMsg(textNews);

        MediaCustomMessageDetail imageDetail = new MediaCustomMessageDetail("mrT269LYOZbwSp8bMsMmkNL0tcW0IroqMyc2Y95qilM6H3M69V9sSI1F0bV9_MP4");
        ImageCustomMessage imageCustomMessage = new ImageCustomMessage(imageDetail);
        doSendMsg(imageCustomMessage);

        MediaCustomMessageDetail voiceDetail = new MediaCustomMessageDetail("voice_mediaId");
        VoiceCustomMessage voiceCustomMessage = new VoiceCustomMessage(voiceDetail);
        doSendMsg(voiceCustomMessage);

        VideoCustomMessageDetail videoDetail = new VideoCustomMessageDetail("video_mediaId", "video_title", "video_description");
        VideoCustomMessage videoCustomMessage = new VideoCustomMessage(videoDetail);
        doSendMsg(videoCustomMessage);

        MusicCustomMessageDetail musicDetail = new MusicCustomMessageDetail("m_title", "m_description", "m_musicUrl", "m_hQMusicUrl", "m_thumbMediaId");
        MusicCustomMessage musiceCustomMessage = new MusicCustomMessage(musicDetail);
        doSendMsg(musiceCustomMessage);

        List<ArticleCustomMessageDetail> articles = new ArrayList<ArticleCustomMessageDetail>();
        articles.add(new ArticleCustomMessageDetail("a_title1", "a_description1", "a_picUrl1", "a_url1"));
        articles.add(new ArticleCustomMessageDetail("a_title2", "a_description2", "a_picUrl2", "a_url2"));
        articles.add(new ArticleCustomMessageDetail("a_title3", "a_description3", "a_picUrl3", "a_url3"));
        ArticleCustomMessage articleCustomMessage = new ArticleCustomMessage(new ArticlesCustomMessageDetail(articles));
        doSendMsg(articleCustomMessage);
    }

    private static void doSendMsg(CustomMessage msg) {
        msg.setToUser("oVDIDt3_SMFnLBBfmQtr67oYT3NI");
        MessageUtil.sendCustomMessage(license, msg);
    }

    private static void testMassMessage() {
        String mediaId = "OS3XEqCEjSgIzp_ggt5yLihCThfcMM2NafRgWj44tRSKjjNGvHDxQbTZ7nIpEhlI";
        System.out.println(MessageUtil.sendMassMessageByGroup(license, "1", mediaId));

        List<String> openIds = ImmutableList.of("oVDIDt3_SMFnLBBfmQtr67oYT3NI", "oVDIDt_SyuhqP7WF7zliVZrqY2wY");
        System.out.println(MessageUtil.sendMassMessageByUsers(license, openIds, mediaId));

        System.out.println(MessageUtil.deleteMassMessage(license, 34182));
    }
}
