package org.usc.wechat.mp.web.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Shunli
 */
public class AccessServletRealTest {
    public static void main(String[] args) throws Exception {
        testGet();
        testPost();
    }

    private static void testGet() throws Exception {
        HttpClient httpclient = new DefaultHttpClient();

        URIBuilder uriBuilder = new URIBuilder("http://localhost/wechat/mp/access");
        uriBuilder.addParameter("echostr", RandomStringUtils.randomAlphabetic(36));
        uriBuilder.addParameter("nonce", "1366260493");
        uriBuilder.addParameter("timestamp", "1366238018");
        uriBuilder.addParameter("signature", "9498eeaaca0b8a35f1b027498e0c0fb37fec5fa0");

        HttpGet httpget = new HttpGet(uriBuilder.build());
        try {
            HttpResponse response = httpclient.execute(httpget);

            if (response != null) {
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpget.releaseConnection();
        }
    }

    private static void testPost() throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://localhost/wechat/mp/access?nonce=1366260493&timestamp=1366238018&signature=9498eeaaca0b8a35f1b027498e0c0fb37fec5fa0");

        File parent = new File(new AccessServletRealTest().getClass().getClassLoader().getResource("push").toURI());
        File push = new File(parent, "text.txt");

        InputStreamEntity streamEntity = new InputStreamEntity(new FileInputStream(push), push.length());
        httppost.setEntity(streamEntity);
        try {
            HttpResponse response = httpclient.execute(httppost);

            if (response != null) {
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            httppost.abort();
        } finally {
            httppost.releaseConnection();
        }

    }
}
