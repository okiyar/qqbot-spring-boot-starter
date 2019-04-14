package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.PrivateMessage;

public class PrivateMessageEvent extends Event<PrivateMessage> {
    public PrivateMessageEvent(PrivateMessage message) {
        super(message);
    }
}
