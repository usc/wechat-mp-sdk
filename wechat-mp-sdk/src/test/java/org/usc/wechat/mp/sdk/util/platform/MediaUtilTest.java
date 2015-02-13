package org.usc.wechat.mp.sdk.util.platform;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.media.MediaFile;
import org.usc.wechat.mp.sdk.vo.media.MediaJsonRtn;
import org.usc.wechat.mp.sdk.vo.media.MediaType;
import org.usc.wechat.mp.sdk.vo.media.NewsMedia;
import org.usc.wechat.mp.sdk.vo.media.NewsMediaDetail;

/**
 *
 * @author Shunli
 */
public class MediaUtilTest {
    public static void main(String[] args) throws Exception {
        MediaFile mediaFile = new MediaFile(MediaType.IMAGE, new File("D:\\New\\media\\image.jpg"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(Constants.LICENSE, mediaFile));

        mediaFile = new MediaFile(MediaType.THUMB, new File("D:\\New\\media\\thumb.jpg"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(Constants.LICENSE, mediaFile));

        mediaFile = new MediaFile(MediaType.VOICE, new File("D:\\New\\media\\voice.amr"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(Constants.LICENSE, mediaFile));

        // now always failed, tip system error
        /* MediaFile */mediaFile = new MediaFile(MediaType.VIDEO, new File("D:\\New\\media\\video.mp4"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(Constants.LICENSE, mediaFile));

        List<NewsMediaDetail> articles = new ArrayList<NewsMediaDetail>();
        articles.add(new NewsMediaDetail("q1lAlpYrHTGOTti-4l2nmGs-7-sgSyL6gyF-8T2dfvFl0DG-rS9IeJJ8kK97UUgW", "Happy Day1", "content1", "xxx1", "www.qq.com", "digest1"));
        articles.add(new NewsMediaDetail("T4vnfwEmQoPM8zOnKadYAWHb3lS23jN99zHOfy3_fQOXNQqgMQ6MNwydtbUgG_lR", "Happy Day2", "content2"));
        MediaUtil.uploadNewsMedia(Constants.LICENSE, new NewsMedia(articles));
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
        System.out.println(MediaUtil.getMedia(Constants.LICENSE, mediaId, "D:\\media"));
        System.out.println();
    }

}
