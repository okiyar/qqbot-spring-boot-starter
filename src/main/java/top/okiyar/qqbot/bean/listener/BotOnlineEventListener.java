package top.okiyar.qqbot.bean.listener;

import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.BotOnlineEvent;

public abstract class BotOnlineEventListener extends EventListener<BotOnlineEvent> {
    @Override
    public Class getEventType() {
        return BotOnlineEvent.class;
    }
}
