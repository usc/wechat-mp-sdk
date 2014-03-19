package org.usc.wechat.mp.sdk.vo.menu;

/**
 *
 * @author Shunli
 */
public class SingleMenuInfo extends MenuInfo {
    private String type;
    private String url;
    private String key;

    public SingleMenuInfo() {
    }

    public SingleMenuInfo(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
