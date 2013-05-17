package org.usc.wechat.mp.sdk.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.usc.wechat.mp.sdk.vo.push.Push;
import org.usc.wechat.mp.sdk.vo.reply.Reply;

/**
 * xml <-> object
 *
 * @author Shunli
 */
public class XmlUtil {
    /**
     * xml -> object, hanle push
     *
     * @param message
     * @param childClass
     * @return
     */
    public static Push unmarshal(String message, Class<? extends Push> childClass) {
        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(Push.class, childClass);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            return (Push) unmarshaller.unmarshal(new StringReader(message));
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * object -> xml, handle reply
     *
     * @param reply
     * @param childClass
     */
    public static String marshal(Reply reply) {
        if (reply == null) {
            return null;
        }

        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(reply.getClass());

            Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(reply, sw);

            return sw.toString();
        } catch (Exception e) {
        }

        return null;
    }
}
