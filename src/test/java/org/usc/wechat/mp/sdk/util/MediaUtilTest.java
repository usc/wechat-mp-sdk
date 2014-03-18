package org.usc.wechat.mp.sdk.util;

import java.io.File;

import org.usc.wechat.mp.sdk.vo.media.MediaFile;
import org.usc.wechat.mp.sdk.vo.media.MediaType;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class MediaUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) throws Exception {
//        MediaFile mediaFile = new MediaFile(MediaType.IMAGE, new File("D:\\media\\image.jpg"));
//        System.out.println(MediaUtil.uploadMedia(license, mediaFile));
//        System.out.println();
//
//        mediaFile = new MediaFile(MediaType.THUMB, new File("D:\\media\\thumb.jpg"));
//        System.out.println(MediaUtil.uploadMedia(license, mediaFile));
//        System.out.println();
//
//        mediaFile = new MediaFile(MediaType.VOICE, new File("D:\\media\\voice.amr"));
//        System.out.println(MediaUtil.uploadMedia(license, mediaFile));
//        System.out.println();

        // now always failed, tip system error
        // MediaFile mediaFile = new MediaFile(MediaType.VIDEO, new File("D:\\media\\video.mp4"));
        // System.out.println(MediaUtil.uploadMedia(license, mediaFile));

        String mediaId = "9GEOkB0qgK2YZ4GuBrtCEyjEr2WBdu71eX304MteZXTZL-GROo2tJ9Oj-Yo2wH8B";
        MediaUtil.getMedia(license, mediaId, "D:\\media");
    }

}
