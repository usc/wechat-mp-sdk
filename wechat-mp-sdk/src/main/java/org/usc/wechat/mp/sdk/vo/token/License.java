package org.usc.wechat.mp.sdk.vo.token;

import org.usc.wechat.mp.sdk.util.ToStringUtil;

import com.google.common.base.Objects;

/**
 *
 * @author Shunli
 */
public class License {
    private String app;
    private String appId;
    private String appSecret;

    public License(String app, String appId, String appSecret) {
        this.app = app;
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getApp() {
        return app;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(app, appId, appSecret);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        License other = (License) obj;
        return Objects.equal(this.app, other.app)
                && Objects.equal(this.appId, other.appId)
                && Objects.equal(this.appSecret, other.appSecret);
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

}
