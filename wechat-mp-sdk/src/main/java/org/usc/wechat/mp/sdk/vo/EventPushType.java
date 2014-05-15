package org.usc.wechat.mp.sdk.vo;

import org.usc.wechat.mp.sdk.vo.push.event.EventPush;
import org.usc.wechat.mp.sdk.vo.push.event.LocationEventPush;
import org.usc.wechat.mp.sdk.vo.push.event.MassEndJobFinishEventPush;
import org.usc.wechat.mp.sdk.vo.push.event.NormalEventPush;

/**
 *
 * @author Shunli
 */
public enum EventPushType {
    SUBSCRIBE("subscribe", NormalEventPush.class),
    UNSUBSCRIBE("unsubscribe", NormalEventPush.class),
    CLICK("CLICK", NormalEventPush.class),
    VIEW("VIEW", NormalEventPush.class),
    SCAN("scan", NormalEventPush.class),
    LOCATION("LOCATION", LocationEventPush.class),
    MASSSENDJOBFINISH("MASSSENDJOBFINISH", MassEndJobFinishEventPush.class);

    private String type;
    private Class<? extends EventPush> eventPushClass;

    private EventPushType(String type, Class<? extends EventPush> eventPushClass) {
        this.type = type;
        this.eventPushClass = eventPushClass;
    }

    public String getType() {
        return type;
    }

    public Class<? extends EventPush> getEventPushClass() {
        return eventPushClass;
    }
}
