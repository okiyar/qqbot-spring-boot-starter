package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.base.Message;

public class BotOnlineEvent extends Event {
    public BotOnlineEvent(Message message) {
        super(message);
    }
}
