package top.okiyar.qqbot.bean.listener;

import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.GroupNotifyEvent;

public abstract class GroupNotifyEventListener extends EventListener<GroupNotifyEvent> {
    @Override
    public Class getEventType() {
        return GroupNotifyEvent.class;
    }
}
