package top.okiyar.qqbot.bean.listener;


import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.PrivateMessageEvent;

public abstract class PrivateMessageEventListener extends EventListener<PrivateMessageEvent> {
    @Override
    public Class getEventType() {
        return PrivateMessageEvent.class;
    }
}
