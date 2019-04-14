package top.okiyar.qqbot.bean.listener;

import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.FriendAddEvent;

public abstract class FriendAddEventListener extends EventListener<FriendAddEvent> {
    @Override
    public Class getEventType() {
        return FriendAddEvent.class;
    }
}
