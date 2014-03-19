package org.usc.wechat.mp.sdk.util.platform;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usc.wechat.mp.sdk.cache.AccessTokenCache;
import org.usc.wechat.mp.sdk.util.Constant;
import org.usc.wechat.mp.sdk.util.JsonRtnUtil;
import org.usc.wechat.mp.sdk.vo.json.JsonRtn;
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
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_CREATE_MENU_URL)
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
                    "url=" + Constant.WECHAT_CREATE_MENU_URL + "?access_token=" + accessToken + ",\n body=" + body;
            log.error(msg, e);
            return null;
        }
    }

    public static Menu getMenu(License license) {
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_GET_MENU_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            ResponseHandler<String> handler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                    final StatusLine statusLine = response.getStatusLine();
                    final HttpEntity entity = response.getEntity();
                    if (statusLine.getStatusCode() >= 300) {
                        throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
                    }

                    if (entity != null) {
                        return EntityUtils.toString(entity, "UTF-8");
                    }

                    return StringUtils.EMPTY;
                }
            };

            String json = Request.Get(uri).execute().handleResponse(handler);
            Menu menu = buildMenu(json);
            log.info("get menu:\n url={},\n rtn={},{}", uri, json, menu);
            return menu;
        } catch (Exception e) {
            String msg = "get menu failed: url=" + Constant.WECHAT_GET_MENU_URL + "?access_token=" + accessToken;
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
        String accessToken = AccessTokenCache.getAccessToken(license);
        try {
            URI uri = new URIBuilder(Constant.WECHAT_DELETE_MENU_URL)
                    .setParameter("access_token", accessToken)
                    .build();

            String json = Request.Get(uri).execute().returnContent().asString();
            JsonRtn rtn = JsonRtnUtil.parseJsonRtn(json, JsonRtn.class);

            log.info("delete menu:\n url={},\n rtn={},{}", uri, json, rtn);
            return rtn;
        } catch (Exception e) {
            String msg = "delete menu failed: url=" + Constant.WECHAT_DELETE_MENU_URL + "?access_token=" + accessToken;
            log.error(msg, e);
            return null;
        }
    }
}
