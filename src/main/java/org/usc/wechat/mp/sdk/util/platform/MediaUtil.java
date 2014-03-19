package org.usc.wechat.mp.sdk.util.platform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.cache.AccessTokenCache;
import org.usc.wechat.mp.sdk.util.Constant;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.media.MediaFile;
import org.usc.wechat.mp.sdk.vo.media.MediaJsonRtn;
import org.usc.wechat.mp.sdk.vo.media.MediaType;
import org.usc.wechat.mp.sdk.vo.media.MimeType;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class MediaUtil {
    private final static Logger log = LoggerFactory.getLogger(MediaUtil.class);

    public static MediaJsonRtn uploadMedia(License license, MediaFile mediaFile) {
        if (mediaFile == null) {
            return null;
        }
        // maybe todo more mediaFile legality check

        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            MediaType mediaType = mediaFile.getMediaType();
            URI uri = new URIBuilder(Constant.WECHAT_UPLOAD_MEDIA_URL)
                    .setParameter("access_token", accessToken)
                    .setParameter("type", mediaType.getName())
                    .build();

            HttpEntity httpEntity = MultipartEntityBuilder.create()
                    .addBinaryBody("body", mediaFile.getFile())
                    .build();

            String rtnJson = Request.Post(uri)
                    // .connectTimeout(100000)
                    // .socketTimeout(100000)
                    .body(httpEntity)
                    .execute().returnContent().asString();

            MediaJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(rtnJson, MediaJsonRtn.class);
            log.info("upload media:\n url={},\n body={},\n rtn={},{}", uri, mediaFile, rtnJson, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "upload media failed:\n " +
                    "url=" + Constant.WECHAT_UPLOAD_MEDIA_URL + "?access_token=" + accessToken + ",\n body=" + mediaFile;
            log.error(msg, e);
            return null;
        }
    }

    public static File getMedia(License license, String mediaId, String targetFolder) {
        if (StringUtils.isEmpty(mediaId) || StringUtils.isEmpty(targetFolder)) {
            return null;
        }

        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_GET_MEDIA_URL)
                    .setParameter("access_token", accessToken)
                    .setParameter("media_id", mediaId)
                    .build();

            HttpResponse response = Request.Get(uri).execute().returnResponse();
            HttpEntity entity = response.getEntity();

            String fileName = getFileNameFromContentDisposition(response);
            if (StringUtils.isEmpty(fileName)) {
                fileName = getFileNameFromContentType(response);
            }
            if (StringUtils.isEmpty(fileName)) {
                String rtnString = EntityUtils.toString(entity);
                JsonRtn rtn = JsonRtnUtil.parseJsonRtn(rtnString, JsonRtn.class);
                log.info("missing media:\n url={},\n rtn={},{}", uri, rtnString, rtn);
                // maybe throw a runtime exception
                return null;
            }

            File directory = new File(targetFolder);
            FileUtils.forceMkdir(directory);
            File file = new File(directory, fileName);
            if (!file.exists()) {
                OutputStream output = new FileOutputStream(file);
                InputStream input = entity.getContent();
                IOUtils.copy(input, output);
                IOUtils.closeQuietly(output);
                IOUtils.closeQuietly(input);
            }

            log.info("get media:\n url={},\n fileName={},{}", uri, fileName, file);
            return file;
        } catch (Exception e) {
            String msg = "get media failed:\n " +
                    "url=" + Constant.WECHAT_GET_MEDIA_URL + "?access_token=" + accessToken + "&media_id=" + mediaId;
            log.error(msg, e);
            return null;
        }
    }

    private static String getFileNameFromContentDisposition(HttpResponse response) {
        Header header = response.getFirstHeader("Content-disposition");
        if (header == null) {
            return null;
        }

        return StringUtils.substringBetween(header.getValue(), "filename=\"", "\"");
    }

    private static String getFileNameFromContentType(HttpResponse response) {
        Header header = response.getFirstHeader("Content-Type");
        if (header == null) {
            return null;
        }

        String contentType = header.getValue();
        String ext = MimeType.getExtensionFromContentType(contentType);
        if (StringUtils.isEmpty(ext)) {
            return null;
        }

        return StringUtils.join(System.currentTimeMillis() + "", FilenameUtils.EXTENSION_SEPARATOR_STR, ext);
    }
}
