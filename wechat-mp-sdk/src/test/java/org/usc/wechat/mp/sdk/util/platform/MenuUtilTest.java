package org.usc.wechat.mp.sdk.util.platform;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.usc.wechat.mp.sdk.vo.menu.Menu;
import org.usc.wechat.mp.sdk.vo.menu.MenuInfo;
import org.usc.wechat.mp.sdk.vo.menu.MenuType;
import org.usc.wechat.mp.sdk.vo.menu.MultiMenuInfo;
import org.usc.wechat.mp.sdk.vo.menu.SingleMenuInfo;

/**
 *
 * @author Shunli
 */
public class MenuUtilTest {
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
        System.out.println(MenuUtil.createMenu(Constants.LICENSE, menu));

        System.out.println(MenuUtil.getMenu(Constants.LICENSE));

        System.out.println(MenuUtil.deleteMenu(Constants.LICENSE));
    }
}
