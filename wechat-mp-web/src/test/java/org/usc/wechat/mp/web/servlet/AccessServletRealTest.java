package org.usc.wechat.mp.web.servlet;

import java.io.File;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;

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
        String echoStr = RandomStringUtils.randomAlphabetic(36);

        URI uri = new URIBuilder("http://localhost/wechat/mp/access")
                .addParameter("echostr", echoStr)
                .addParameter("nonce", "1366260493")
                .addParameter("timestamp", "1366238018")
                .addParameter("signature", "9498eeaaca0b8a35f1b027498e0c0fb37fec5fa0")
                .build();

        String rtn = Request.Get(uri).execute().returnContent().asString();
        System.out.println(echoStr + " ==> " + rtn);
    }

    private static void testPost() throws Exception {
        URI uri = new URIBuilder("http://localhost/wechat/mp/access")
                .addParameter("nonce", "1366260493")
                .addParameter("timestamp", "1366238018")
                .addParameter("signature", "9498eeaaca0b8a35f1b027498e0c0fb37fec5fa0")
                .build();

        File parent = new File(AccessServletRealTest.class.getClassLoader().getResource("push").toURI());
        for (File pushFile : parent.listFiles()) {
            String body = FileUtils.readFileToString(pushFile);
            String reply = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnContent().asString();
            System.out.println(pushFile + "\n" + body + "\n" + reply + "\n");
        }
    }
}
