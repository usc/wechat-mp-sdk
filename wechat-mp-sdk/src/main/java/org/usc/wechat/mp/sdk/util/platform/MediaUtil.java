package org.usc.wechat.mp.sdk.util.platform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ObjectUtils;
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
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.media.MediaFile;
import org.usc.wechat.mp.sdk.vo.media.MediaJsonRtn;
import org.usc.wechat.mp.sdk.vo.media.MediaType;
import org.usc.wechat.mp.sdk.vo.media.MimeType;
import org.usc.wechat.mp.sdk.vo.media.NewsMedia;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class MediaUtil {
    private final static Logger log = LoggerFactory.getLogger(MediaUtil.class);

    // TODO-Shunli: now upload video always failed, tip system error, check later
    public static MediaJsonRtn uploadMedia(License license, MediaFile mediaFile) {
        if (mediaFile == null) {
            return JsonRtnUtil.buildFailureJsonRtn(MediaJsonRtn.class, "missing mediaFile");
        }
        // maybe todo more mediaFile legality check

        String accessToken = AccessTokenUtil.getAccessToken(license);
        String url = WechatRequest.UPLOAD_MEDIA.getUrl();
        try {
            MediaType mediaType = mediaFile.getMediaType();
            URI uri = new URIBuilder(url)
                    .setParameter("access_token", accessToken)
                    .setParameter("type", mediaType.getName())
                    .build();

            HttpEntity httpEntity = MultipartEntityBuilder.create()
                    .addBinaryBody("body", mediaFile.getFile())
                    .build();

            String rtnJson = Request.Post(uri)
                    .connectTimeout(HttpUtil.CONNECT_TIMEOUT)
                    .socketTimeout(HttpUtil.SOCKET_TIMEOUT)
                    .body(httpEntity)
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);

            MediaJsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(rtnJson, MediaJsonRtn.class);
            log.info("upload media:\n url={},\n body={},\n rtn={},{}", uri, mediaFile, rtnJson, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "upload media failed:\n " +
                    "url=" + url + "?access_token=" + accessToken + ",\n body=" + mediaFile;
            log.error(msg, e);
            return JsonRtnUtil.buildFailureJsonRtn(MediaJsonRtn.class, "uploadMedia failed");
        }
    }

    public static MediaJsonRtn uploadNewsMedia(License license, NewsMedia newsMedia) {
        if (newsMedia == null) {
            return JsonRtnUtil.buildFailureJsonRtn(MediaJsonRtn.class, "missing newsMedia");
        }

        return HttpUtil.postBodyRequest(WechatRequest.UPLOAD_NEWS_MEDIA, license, newsMedia, MediaJsonRtn.class);
    }

    public static File getMedia(License license, String mediaId, String path) {
        if (StringUtils.isEmpty(mediaId) || StringUtils.isEmpty(path)) {
            return null;
        }

        String accessToken = AccessTokenUtil.getAccessToken(license);
        String url = WechatRequest.GET_MEDIA.getUrl();
        try {
            URI uri = new URIBuilder(url)
                    .setParameter("access_token", accessToken)
                    .setParameter("media_id", mediaId)
                    .build();

            HttpResponse response = Request.Get(uri)
                    .connectTimeout(HttpUtil.CONNECT_TIMEOUT)
                    .socketTimeout(HttpUtil.SOCKET_TIMEOUT)
                    .execute().returnResponse();
            return downloadFile(response, mediaId, path, uri);
        } catch (Exception e) {
            String msg = "get media failed:\n " +
                    "url=" + url + "?access_token=" + accessToken + "&media_id=" + mediaId;
            log.error(msg, e);
            return null;
        }
    }

    private static File downloadFile(HttpResponse response, String mediaId, String path, URI uri) throws IOException, FileNotFoundException {
        HttpEntity entity = response.getEntity();
        if (entity == null) {
            return null;
        }

        String fileName = StringUtils.defaultIfEmpty(getFileNameFromContentDisposition(response), getFileNameFromContentType(response, mediaId));
        if (StringUtils.isEmpty(fileName)) {
            String rtnString = EntityUtils.toString(entity);
            JsonRtn rtn = JsonRtnUtil.parseJsonRtn(rtnString, JsonRtn.class);
            log.info("missing media:\n url={},\n rtn={},{}", uri, rtnString, rtn);
            // maybe throw a runtime exception
            return null;
        }

        File directory = new File(path);
        FileUtils.forceMkdir(directory);
        File file = new File(directory, fileName);
        if (!file.exists()) {
            OutputStream output = new FileOutputStream(file);
            IOUtils.copy(entity.getContent(), output);
            IOUtils.closeQuietly(output);
        }

        log.info("get media:\n url={},\n fileName={},{}", uri, fileName, file);
        return file;
    }

    private static String getFileNameFromContentDisposition(HttpResponse response) {
        Header header = ObjectUtils.firstNonNull(response.getFirstHeader("Content-disposition"), response.getFirstHeader("Content-Disposition"));
        if (header == null) {
            return null;
        }

        return StringUtils.substringBetween(header.getValue(), "filename=\"", "\"");
    }

    private static String getFileNameFromContentType(HttpResponse response, String mediaId) {
        Header header = response.getFirstHeader("Content-Type");
        if (header == null) {
            return null;
        }

        String contentType = header.getValue();
        String ext = MimeType.getExtensionFromContentType(contentType);
        if (StringUtils.isEmpty(ext)) {
            return null;
        }

        return StringUtils.join(mediaId, FilenameUtils.EXTENSION_SEPARATOR_STR, ext);
    }
}
