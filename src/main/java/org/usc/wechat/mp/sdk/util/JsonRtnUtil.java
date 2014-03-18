package org.usc.wechat.mp.sdk.util;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.vo.json.JsonRtn;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class JsonRtnUtil {
    private static ResourceBundle bundle;

    static {
        try {
            bundle = ResourceBundle.getBundle(Constant.WECHAT_GLOBAL_MESSAGE_FILE_NAME);
        } catch (Exception e) {
        }
    }

    public static <T extends JsonRtn> T parseJsonRtn(String jsonRtn, Class<T> jsonRtnClazz) {
        T rtn = JSONObject.parseObject(jsonRtn, jsonRtnClazz);
        appendErrorHumanMsg(rtn);
        return rtn;
    }

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

}
