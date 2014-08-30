package org.usc.wechat.mp.sdk.util;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.vo.JsonRtn;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class JsonRtnUtil {
    private static final String WECHAT_GLOBAL_MESSAGE_FILE_NAME = "wechate-global-message";
    private static final String WECHAT_JSON_RTN_SUCCESS_CODE = "0";
    private static ResourceBundle bundle;

    static {
        try {
            bundle = ResourceBundle.getBundle(WECHAT_GLOBAL_MESSAGE_FILE_NAME);
        } catch (Exception e) {
        }
    }

    /**
     * parse json text to specified class
     *
     * @param jsonRtn
     * @param jsonRtnClazz
     * @return
     */
    public static <T extends JsonRtn> T parseJsonRtn(String jsonRtn, Class<T> jsonRtnClazz) {
        T rtn = JSONObject.parseObject(jsonRtn, jsonRtnClazz);
        appendErrorHumanMsg(rtn);
        return rtn;
    }

    /**
     * append human message to JsonRtn class
     *
     * @param jsonRtn
     * @return
     */
    private static JsonRtn appendErrorHumanMsg(JsonRtn jsonRtn) {
        if (bundle == null || jsonRtn == null || StringUtils.isEmpty(jsonRtn.getErrCode())) {
            return null;
        }

        try {
            jsonRtn.setErrHumanMsg(bundle.getString(jsonRtn.getErrCode()));
            return jsonRtn;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * return request is success by JsonRtn object
     *
     * @param jsonRtn
     * @return
     */
    public static boolean isSuccess(JsonRtn jsonRtn) {
        if (jsonRtn == null) {
            return false;
        }

        String errCode = jsonRtn.getErrCode();
        if (StringUtils.isEmpty(errCode) || StringUtils.equals(WECHAT_JSON_RTN_SUCCESS_CODE, errCode)) {
            return true;
        }

        return false;
    }

    public static <T extends JsonRtn> T buildFailureJsonRtn(Class<T> jsonRtnClazz, String errMsg) {
        try {
            T jsonRtn = jsonRtnClazz.newInstance();
            jsonRtn.setErrCode("-1");
            jsonRtn.setErrMsg(errMsg);

            appendErrorHumanMsg(jsonRtn);

            return jsonRtn;
        } catch (Exception e) {
            return null;
        }
    }
}
