package org.usc.wechat.mp.sdk.util;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Shunli
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String disposition = "attachment; filename=\"rN9mSGV8XB8TSavr3YArPKW8I8DP4MhfY40gdY93cANpQ4LXg4EAEyMwN8tVgA3G.jpg\"";
        System.out.println(StringUtils.substringBetween(disposition, "filename=\"", "\""));
    }

}
