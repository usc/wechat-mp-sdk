package org.usc.wechat.mp.sdk.vo.message.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.usc.wechat.mp.sdk.factory.ReplyEnumFactory;

/**
 *
 * @author Shunli
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextReply extends Reply {
    @XmlElement(name = "Content")
    private String content;

    {
        super.setMsgType(ReplyEnumFactory.TEXT.getReplyType());
    }

    public TextReply() {
    }

    public TextReply(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
