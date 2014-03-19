package org.usc.wechat.mp.sdk.vo.group;

import org.usc.wechat.mp.sdk.util.ToStringUtil;


/**
 *
 * @author Shunli
 */
public class Group {
    private String id;
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
