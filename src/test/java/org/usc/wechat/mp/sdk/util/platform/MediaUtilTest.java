package org.usc.wechat.mp.sdk.util.platform;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.util.Constant;
import org.usc.wechat.mp.sdk.util.platform.MediaUtil;
import org.usc.wechat.mp.sdk.vo.json.MediaJsonRtn;
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
        MediaFile mediaFile = new MediaFile(MediaType.IMAGE, new File("D:\\media\\image.jpg"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));

        mediaFile = new MediaFile(MediaType.THUMB, new File("D:\\media\\thumb.jpg"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));

        mediaFile = new MediaFile(MediaType.VOICE, new File("D:\\media\\voice.amr"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));

        // now always failed, tip system error
        /* MediaFile */mediaFile = new MediaFile(MediaType.VIDEO, new File("D:\\media\\video.mp4"));
        handleMediaJsonRtn(MediaUtil.uploadMedia(license, mediaFile));
    }

    private static void handleMediaJsonRtn(MediaJsonRtn mediaJsonRtn) {
        if (mediaJsonRtn == null) {
            System.out.println("null");
            return;
        }

        if (StringUtils.isNotEmpty(mediaJsonRtn.getErrCode()) && !StringUtils.equals(Constant.WECHAT_JSON_RTN_SUCCESS_CODE, mediaJsonRtn.getErrCode())) {
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
