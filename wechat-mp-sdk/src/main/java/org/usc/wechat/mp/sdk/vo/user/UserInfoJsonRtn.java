package org.usc.wechat.mp.sdk.vo.user;

import org.usc.wechat.mp.sdk.vo.JsonRtn;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class UserInfoJsonRtn extends JsonRtn {
    @JSONField(name = "subscribe")
    private int subscribe;

    @JSONField(name = "openid")
    private String openId;

    @JSONField(name = "nickname")
    private String nickName;

    @JSONField(name = "sex")
    private int sex;

    @JSONField(name = "language")
    private String language;

    @JSONField(name = "city")
    private String city;

    @JSONField(name = "province")
    private String province;

    @JSONField(name = "country")
    private String country;

    @JSONField(name = "headimgurl")
    private String headImgUrl;

    @JSONField(name = "subscribe_time")
    private long subscribeTime;

    public UserInfoJsonRtn() {
    }

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

}
