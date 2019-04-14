package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.base.Message;

public class BotOfflineEvent extends Event {
    public BotOfflineEvent(Message message) {
        super(message);
    }
}
