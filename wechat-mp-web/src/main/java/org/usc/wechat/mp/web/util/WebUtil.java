package org.usc.wechat.mp.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * @author Shunli
 *
 */
public class WebUtil {
    public static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * get string from post stream, and use UTF-8 encoding
     *
     * @param is
     * @return
     */
    public static String getPostString(InputStream is) {
        return getPostString(is, DEFAULT_ENCODING);
    }

    /**
     * get string from post stream
     *
     * @param is
     * @param encoding
     * @return
     */
    public static String getPostString(InputStream is, String encoding) {
        try {
            StringWriter sw = new StringWriter();
            IOUtils.copy(is, sw, encoding);

            return sw.toString();
        } catch (IOException e) {
            // no op
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    /**
     * response simple String
     *
     * @param response
     * @param obj
     */
    public static void outputString(final HttpServletResponse response, final Object obj) {
        try {
            response.setContentType("text/javascript");
            response.setCharacterEncoding("utf-8");
            disableCache(response);
            response.getWriter().write(obj.toString());
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
        }
    }

    /**
     * disable cache
     *
     * @param response
     */
    public static void disableCache(HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
    }

}
