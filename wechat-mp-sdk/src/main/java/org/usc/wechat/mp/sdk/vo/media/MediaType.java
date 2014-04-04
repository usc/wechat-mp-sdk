package org.usc.wechat.mp.sdk.vo.media;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Shunli
 */
public enum MediaType {
    IMAGE("image") {
        @Override
        public MediaLimit getMediaLimit() {
            List<MimeType> allowTypes = Arrays.asList(MimeType.IMAGE_JPG);
            MediaLimit mediaLimit = new MediaLimit(128 * 1024L, allowTypes);
            return mediaLimit;
        }
    },
    VOICE("voice") {
        @Override
        public MediaLimit getMediaLimit() {
            List<MimeType> allowTypes = Arrays.asList(MimeType.VOICE_AMR, MimeType.VOICE_MP3);
            MediaLimit mediaLimit = new MediaLimit(256 * 1024L, 60, allowTypes);
            return mediaLimit;
        }
    },
    VIDEO("video") {
        @Override
        public MediaLimit getMediaLimit() {
            List<MimeType> allowTypes = Arrays.asList(MimeType.VIDEO_MP4);
            MediaLimit mediaLimit = new MediaLimit(1 * 1024 * 1024L, allowTypes);
            return mediaLimit;
        }
    },
    THUMB("thumb") {
        @Override
        public MediaLimit getMediaLimit() {
            List<MimeType> allowTypes = Arrays.asList(MimeType.THUMB_JPG);
            MediaLimit mediaLimit = new MediaLimit(64 * 1024L, allowTypes);
            return mediaLimit;
        }
    },
    ;

    private String name;

    private MediaType(String name) {
        this.name = name;
    }

    public abstract MediaLimit getMediaLimit();

    public String getName() {
        return name;
    }

}
