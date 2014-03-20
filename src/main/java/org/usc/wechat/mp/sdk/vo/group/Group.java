package org.usc.wechat.mp.sdk.vo.group;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

/**
 *
 * @author Shunli
 */
public class Group {
    private int id;
    private String name;
    private int count;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }
}
