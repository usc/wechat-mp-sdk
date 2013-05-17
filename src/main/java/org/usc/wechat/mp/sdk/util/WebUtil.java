package org.usc.wechat.mp.sdk.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class WebUtil {
    /**
     * 简单的返回字符串类型
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
     * 禁用cache
     *
     * @param response
     */
    public static void disableCache(HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
    }

}
