package org.usc.wechat.mp.sdk.vo.push;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.usc.wechat.mp.sdk.factory.PushEnumFactory;

/**
 *
 * @author Shunli
 */
public class PushTest {

    public static void main(String[] args) throws Exception {
        File parent = new File(PushTest.class.getClassLoader().getResource("push").toURI());
        for (File pushFile : parent.listFiles()) {
            // if (!StringUtils.startsWithIgnoreCase(pushFile.getName(), "event")) {
            // continue;
            // }
            //
            String message = FileUtils.readFileToString(pushFile, "utf-8");

            String messageType = getMsgType(message);
            PushEnumFactory pushEnum = EnumUtils.getEnum(PushEnumFactory.class, StringUtils.upperCase(messageType));

            Push push = pushEnum.convert(message);

            System.out.println(pushFile + "\n" + message + "\n" + push + "\n");
        }
    }

    private static String getMsgType(String message) {
        return StringUtils.substringBetween(message, "<MsgType><![CDATA[", "]]></MsgType>");
    }

}
