package org.usc.wechat.mp.sdk.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Shunli
 */
public class ToStringUtil {
    public static String toString(final Object object) {
        return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static String toStringWithSimpleStyle(final Object object) {
        return ToStringBuilder.reflectionToString(object, ToStringStyle.SIMPLE_STYLE);
    }
}
