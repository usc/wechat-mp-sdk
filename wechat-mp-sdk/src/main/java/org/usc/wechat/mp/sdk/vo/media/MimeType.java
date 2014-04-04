package org.usc.wechat.mp.sdk.vo.media;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public enum MimeType {
    IMAGE_JPG("jpg", "image/jpeg"),
    VOICE_AMR("amr", "audio/amr"),
    VOICE_MP3("mp3", "audio/mp3"),
    VIDEO_MP4("mp4", "video/mp4"),
    THUMB_JPG("jpg", "image/jpeg"), ;

    private String extension;
    private String contentType;

    private MimeType(String extension, String contentType) {
        this.extension = extension;
        this.contentType = contentType;
    }

    public String getExtension() {
        return extension;
    }

    public String getContentType() {
        return contentType;
    }

    public static String getExtensionFromContentType(String ContentType) {
        for (MimeType mimeType : values()) {
            if (StringUtils.equalsIgnoreCase(mimeType.getContentType(), ContentType)) {
                return mimeType.getExtension();
            }
        }

        return StringUtils.EMPTY;
    }
}
