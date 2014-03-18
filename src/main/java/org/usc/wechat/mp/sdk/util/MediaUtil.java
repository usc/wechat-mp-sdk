package org.usc.wechat.mp.sdk.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.cache.AccessTokenCache;
import org.usc.wechat.mp.sdk.vo.MediaFile;
import org.usc.wechat.mp.sdk.vo.MediaType;
import org.usc.wechat.mp.sdk.vo.json.MediaJsonRtn;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONObject;

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
                    .body(httpEntity)
                    .execute().returnContent().asString();

            MediaJsonRtn jsonRtn = JSONObject.parseObject(rtnJson, MediaJsonRtn.class);
            JsonRtnUtil.appendErrorHumanMsg(jsonRtn);
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

            // String rtnStr = EntityUtils.toString(entity);
            // System.out.println(rtnStr);
            //
            // JsonRtn rtn = JSONObject.parseObject(rtnStr, JsonRtn.class);
            // System.out.println(rtn);

            // Header[] allHeaders = response.getAllHeaders();
            // for (Header header : allHeaders) {
            // System.out.println(header.getName() + ":" + header.getValue());
            // }

            String fileName = getFileNameFromContentDisposition(response);
            if (StringUtils.isEmpty(fileName)) {
                fileName = getFileNameFromContentType(response);
            }

            File file = new File(targetFolder, fileName);
            OutputStream output = new FileOutputStream(file);
            InputStream input = entity.getContent();
            IOUtils.copy(input, output);
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(input);

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
        String fileName = getRandomFileName();

        Header header = response.getFirstHeader("Content-Type");
        if (header == null) {
            return fileName;
        }

        String contentType = header.getValue();
        String ext = getExtensionFromContentType(contentType);
        if (StringUtils.isEmpty(ext)) {
            return fileName;
        }

        return StringUtils.join(fileName, ".", ext);
    }

    private static String getExtensionFromContentType(String ContentType) {
        // TODO-Shunli: todo later
        return "";
    }

    private static String getRandomFileName() {
        return System.currentTimeMillis() + "";
    }
}
