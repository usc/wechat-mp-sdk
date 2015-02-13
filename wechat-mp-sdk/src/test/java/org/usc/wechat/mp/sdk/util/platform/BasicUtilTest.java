package org.usc.wechat.mp.sdk.util.platform;

import org.usc.wechat.mp.sdk.vo.basic.IpListJsonRtn;

/**
 *
 * @author Shunli
 */
public class BasicUtilTest {
    public static void main(String[] args) {
        IpListJsonRtn callbackIp = BasicUtil.getCallbackIp(Constants.LICENSE);
        for (String ip : callbackIp.getIpList()) {
            System.out.println(ip);
        }

        String url = "www.google.com";
        System.out.println(BasicUtil.shortUrl(Constants.LICENSE, url));
    }
}
