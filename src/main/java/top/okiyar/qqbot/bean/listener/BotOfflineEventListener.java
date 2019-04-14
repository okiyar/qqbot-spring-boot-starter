package top.okiyar.qqbot.bean.listener;

import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.BotOfflineEvent;

public abstract class BotOfflineEventListener extends EventListener<BotOfflineEvent> {
    @Override
    public Class getEventType() {
        return BotOfflineEvent.class;
    }
}
