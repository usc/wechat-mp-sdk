package org.usc.wechat.mp.sdk.vo.media;

import java.io.File;

import org.usc.wechat.mp.sdk.vo.AbstractToStringBuilder;

/**
 *
 * @author Shunli
 */
public class MediaFile extends AbstractToStringBuilder {
    private MediaType mediaType;
    private File file;

    public MediaFile() {
    }

    public MediaFile(MediaType mediaType, File file) {
        this.mediaType = mediaType;
        this.file = file;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
