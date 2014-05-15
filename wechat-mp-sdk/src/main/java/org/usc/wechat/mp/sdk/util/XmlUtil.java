package org.usc.wechat.mp.sdk.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * xml <-> object
 *
 * @author Shunli
 */
public class XmlUtil {
    private static List<Class<?>> getAllSuperTypes(Class<?> type) {
        List<Class<?>> result = new ArrayList<Class<?>>();
        for (; type != null; type = type.getSuperclass()) {
            result.add(type);
        }

        return result;
    }

    /**
     * xml -> object
     *
     * @param message
     * @param childClass
     * @return
     */
    public static Object unmarshal(String message, Class<?> childClass) {
        try {
            Class<?>[] reverseAndToArray = Iterables.toArray(Lists.reverse(getAllSuperTypes(childClass)), Class.class);
            JAXBContext jaxbCtx = JAXBContext.newInstance(reverseAndToArray);
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            return unmarshaller.unmarshal(new StringReader(message));
        } catch (Exception e) {
        }

        return null;
    }

    /**
     * object -> xml
     *
     * @param object
     * @param childClass
     */
    public static String marshal(Object object) {
        if (object == null) {
            return null;
        }

        try {
            JAXBContext jaxbCtx = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            marshaller.marshal(object, sw);

            return sw.toString();
        } catch (Exception e) {
        }

        return null;
    }
}
