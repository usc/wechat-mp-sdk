package org.usc.wechat.mp.sdk.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.factory.PushEnumFactory;
import org.usc.wechat.mp.sdk.util.EnumUtil;
import org.usc.wechat.mp.sdk.util.WebUtil;
import org.usc.wechat.mp.sdk.util.XmlUtil;
import org.usc.wechat.mp.sdk.vo.Signature;
import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 *
 * @author Shunli
 */
@WebServlet(urlPatterns = "/access")
public class AccessServlet extends HttpServlet {
    private static final long serialVersionUID = 8022360243246207991L;
    private static final Logger log = LoggerFactory.getLogger(AccessServlet.class);

    private static final String TOKEN = "token"; // TODO please custom it.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Signature signature = new Signature();

            BeanUtils.populate(signature, request.getParameterMap());
            signature.setToken(TOKEN);

            String sign = DigestUtils.sha1Hex(buildSignatureText(signature));
            if (!sign.equalsIgnoreCase(signature.getSignature())) {
                log.info("sign-not-match:{},{}", sign, signature);
                return;
            }

            log.info("signature-success:{}", signature);
            WebUtil.outputString(response, signature.getEchostr());
        } catch (Exception e) {
            log.error("sign-error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Signature signature = new Signature();

            BeanUtils.populate(signature, request.getParameterMap());
            signature.setToken(TOKEN);

            String sign = DigestUtils.sha1Hex(buildSignatureText(signature));
            if (!sign.equalsIgnoreCase(signature.getSignature())) {
                log.info("sign-not-match:{},{}", sign, signature);
                return;
            }

            String sessionid = request.getSession().getId();

            String message = getPostString(request.getInputStream(), "utf-8");
            log.info("push-xml:{},{}", sessionid, message);

            String messageType = getMsgType(message);
            PushEnumFactory pushEnum = EnumUtil.getEnumFromString(PushEnumFactory.class, messageType);
            Validate.notNull(pushEnum, "don't-support-%s-type-message", messageType);

            Push push = pushEnum.convert(message);
            log.info("push-obj:{},{}", sessionid, push);

            Reply reply = pushEnum.parse(push);
            String replyXml = XmlUtil.marshal(reply);
            Validate.notEmpty(replyXml, "no-reply:%s,%s", sessionid, reply);

            log.info("reply-xml:{},{}", sessionid, replyXml);
            log.info("reply-obj:{},{}", sessionid, reply);
            WebUtil.outputString(response, replyXml);
        } catch (Exception e) {
            log.error("push-reply-error", e);
        }
    }

    private String buildSignatureText(Signature signature) {
        List<String> list = new ArrayList<String>();
        list.add(Validate.notNull(signature.getToken(), "missing-token"));
        list.add(Validate.notNull(signature.getTimestamp(), "missing-timestamp"));
        list.add(Validate.notNull(signature.getNonce(), "missing-nonce"));
        Collections.sort(list);

        return StringUtils.join(list, "");
    }

    private String getPostString(InputStream is, String charset) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, charset));
        String line = "";
        for (line = br.readLine(); line != null; line = br.readLine()) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    private String getMsgType(String message) {
        return StringUtils.substringBetween(message, "<MsgType><![CDATA[", "]]></MsgType>");
    }

}
