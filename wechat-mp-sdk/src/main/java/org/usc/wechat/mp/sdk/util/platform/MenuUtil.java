package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
import org.usc.wechat.mp.sdk.vo.WechatRequest;
import org.usc.wechat.mp.sdk.vo.menu.Menu;
import org.usc.wechat.mp.sdk.vo.menu.MenuInfo;
import org.usc.wechat.mp.sdk.vo.menu.MultiMenuInfo;
import org.usc.wechat.mp.sdk.vo.menu.SingleMenuInfo;
import org.usc.wechat.mp.sdk.vo.token.License;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Shunli
 */
public class MenuUtil {
    private final static Logger log = LoggerFactory.getLogger(MenuUtil.class);

    public static JsonRtn createMenu(License license, Menu menu) {
        if (menu == null) {
            return JsonRtnUtil.buildFailureJsonRtn(JsonRtn.class, "missing menu");
        }

        return HttpUtil.postBodyRequest(WechatRequest.CREATE_MENU, license, menu, JsonRtn.class);
    }

    public static Menu getMenu(License license) {
        String accessToken = AccessTokenUtil.getAccessToken(license);
        String url = WechatRequest.GET_MENU.getUrl();
        try {
            URI uri = new URIBuilder(url)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Get(uri)
                    .connectTimeout(HttpUtil.CONNECT_TIMEOUT)
                    .socketTimeout(HttpUtil.SOCKET_TIMEOUT)
                    .execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);
            Menu menu = buildMenu(json);
            log.info("get menu:\n url={},\n rtn={},{}", uri, json, menu);
            return menu;
        } catch (Exception e) {
            String msg = "get menu failed: url=" + url + "?access_token=" + accessToken;
            log.error(msg, e);
            return null;
        }
    }

    private static Menu buildMenu(String json) {
        JSONObject parseObject = JSONObject.parseObject(json);
        if (json == null) {
            return null;
        }

        JSONObject menuObject = parseObject.getJSONObject("menu");
        if (menuObject == null) {
            return null;
        }

        JSONArray jsonArray = menuObject.getJSONArray("button");
        if (jsonArray == null) {
            return null;
        }

        List<MenuInfo> menuInfos = new ArrayList<MenuInfo>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject subJsonObject = jsonArray.getJSONObject(i);

            String type = subJsonObject.getString("type");
            String jsonString = subJsonObject.toString();
            if (StringUtils.isNotEmpty(type)) {
                menuInfos.add(JSONObject.parseObject(jsonString, SingleMenuInfo.class));
            } else {
                menuInfos.add(JSONObject.parseObject(jsonString, MultiMenuInfo.class));
            }
        }

        return new Menu(menuInfos);
    }

    public static JsonRtn deleteMenu(License license) {
        return HttpUtil.getRequest(WechatRequest.DELETE_MENU, license, JsonRtn.class);
    }
}
