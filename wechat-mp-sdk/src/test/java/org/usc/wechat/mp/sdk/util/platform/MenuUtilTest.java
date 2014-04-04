package org.usc.wechat.mp.sdk.util.platform;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.vo.menu.Menu;
import org.usc.wechat.mp.sdk.vo.menu.MenuInfo;
import org.usc.wechat.mp.sdk.vo.menu.MenuType;
import org.usc.wechat.mp.sdk.vo.menu.MultiMenuInfo;
import org.usc.wechat.mp.sdk.vo.menu.SingleMenuInfo;
import org.usc.wechat.mp.sdk.vo.token.License;

/**
 *
 * @author Shunli
 */
public class MenuUtilTest {
    private static final License license = new License("test", "wxafc93a29c1e2a59f", "5613787a72659cf3fae3bf1a5152b17b");

    public static void main(String[] args) throws URISyntaxException {
        List<SingleMenuInfo> subMenuInfos = new ArrayList<SingleMenuInfo>();
        subMenuInfos.add(MenuType.VIEW.buildSingleMenuInfo("搜索", "http://www.soso.com/"));
        subMenuInfos.add(MenuType.VIEW.buildSingleMenuInfo("视频", "http://v.qq.com/"));
        subMenuInfos.add(MenuType.CLICK.buildSingleMenuInfo("赞一下我们", "V1001_GOOD"));

        List<MenuInfo> menuInfos = new ArrayList<MenuInfo>();
        menuInfos.add(MenuType.CLICK.buildSingleMenuInfo("今日歌曲", "V1001_TODAY_MUSIC"));
        menuInfos.add(MenuType.CLICK.buildSingleMenuInfo("歌手简介", "V1001_TODAY_SINGER"));
        menuInfos.add(new MultiMenuInfo("菜单", subMenuInfos));
        Menu menu = new Menu(menuInfos);
        System.out.println(MenuUtil.createMenu(license, menu));

        System.out.println(MenuUtil.getMenu(license));

        System.out.println(MenuUtil.deleteMenu(license));
    }
}
