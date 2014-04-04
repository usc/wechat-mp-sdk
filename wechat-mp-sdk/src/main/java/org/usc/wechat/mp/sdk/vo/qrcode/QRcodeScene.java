package org.usc.wechat.mp.sdk.vo.qrcode;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *
 * @author Shunli
 */
public class QRcodeScene {
    @JSONField(name = "scene_id")
    private long sceneId;

    public QRcodeScene() {
    }

    public QRcodeScene(long sceneId) {
        this.sceneId = sceneId;
    }

    public long getSceneId() {
        return sceneId;
    }

    public void setSceneId(long sceneId) {
        this.sceneId = sceneId;
    }
}
