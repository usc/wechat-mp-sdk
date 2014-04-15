package org.usc.wechat.mp.sdk.util.platform;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.media.NewsMediaDetail;
import org.usc.wechat.mp.sdk.vo.media.NewsMedia;
import org.usc.wechat.mp.sdk.vo.media.MediaFile;
import org.usc.wechat.mp.sdk.vo.media.MediaJsonRtn;
import org.usc.wechat.mp.sdk.vo.media.MediaType;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class MediaUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) throws Exception {
        MediaFile mediaFile = new MediaFile(MediaType.IMAGE, new File("D:\\New\\media\\image.jpg"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));

        mediaFile = new MediaFile(MediaType.THUMB, new File("D:\\New\\media\\thumb.jpg"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));

        mediaFile = new MediaFile(MediaType.VOICE, new File("D:\\New\\media\\voice.amr"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));

        // now always failed, tip system error
        /* MediaFile */mediaFile = new MediaFile(MediaType.VIDEO, new File("D:\\New\\media\\video.mp4"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));

        List<NewsMediaDetail> articles = new ArrayList<NewsMediaDetail>();
        articles.add(new NewsMediaDetail("q1lAlpYrHTGOTti-4l2nmGs-7-sgSyL6gyF-8T2dfvFl0DG-rS9IeJJ8kK97UUgW", "Happy Day1", "content1", "xxx1", "www.qq.com", "digest1"));
        articles.add(new NewsMediaDetail("T4vnfwEmQoPM8zOnKadYAWHb3lS23jN99zHOfy3_fQOXNQqgMQ6MNwydtbUgG_lR", "Happy Day2", "content2"));
        MediaUtil.uploadNewsMedia(license, new NewsMedia(articles));
    }

    private static void handleMediaJsonRtn(MediaJsonRtn mediaJsonRtn) {
        if (mediaJsonRtn == null) {
            System.out.println("null");
            return;
        }

        if (!JsonRtnUtil.isSuccess(mediaJsonRtn)) {
            System.out.println("failed");
            return;
        }

        System.out.println(mediaJsonRtn);
        System.out.println();

        String mediaId = mediaJsonRtn.getMediaId();
        System.out.println(MediaUtil.getMedia(license, mediaId, "D:\\media"));
        System.out.println();
    }

}
