package org.usc.wechat.mp.sdk.util.platform;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.util.WechatUrl;
import org.usc.wechat.mp.sdk.util.HttpUtil;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.JsonRtn;
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
            return null;
        }

        String body = JSONObject.toJSONString(menu);
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.WECHAT_CREATE_MENU_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Post(uri)
                    .bodyString(body, ContentType.create("text/html", Consts.UTF_8))
                    .execute().returnContent().asString();

            JsonRtn jsonRtn = JsonRtnUtil.parseJsonRtn(json, JsonRtn.class);
            log.info("create menu:\n url={},\n body={},\n rtn={},{}", uri, body, json, jsonRtn);
            return jsonRtn;
        } catch (Exception e) {
            String msg = "create menu failed:\n " +
                    "url=" + WechatUrl.WECHAT_CREATE_MENU_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

    public static Menu getMenu(License license) {
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.WECHAT_GET_MENU_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Get(uri).execute().handleResponse(HttpUtil.UTF8_CONTENT_HANDLER);
            Menu menu = buildMenu(json);
            log.info("get menu:\n url={},\n rtn={},{}", uri, json, menu);
            return menu;
        } catch (Exception e) {
            String msg = "get menu failed: url=" + WechatUrl.WECHAT_GET_MENU_URL + "?access_token=" + accessToken;
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
        String accessToken = AccessTokenUtil.getAccessToken(license);
        try {
            URI uri = new URIBuilder(WechatUrl.WECHAT_DELETE_MENU_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Get(uri).execute().returnContent().asString();
            JsonRtn rtn = JsonRtnUtil.parseJsonRtn(json, JsonRtn.class);

            log.info("delete menu:\n url={},\n rtn={},{}", uri, json, rtn);
            return rtn;
        } catch (Exception e) {
            String msg = "delete menu failed: url=" + WechatUrl.WECHAT_DELETE_MENU_URL + "?access_token=" + accessToken;
            log.error(msg, e);
            return null;
        }
    }
}
