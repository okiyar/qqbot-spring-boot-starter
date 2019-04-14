package top.okiyar.qqbot.bean.listener;

import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.GroupAdminSetEvent;

public abstract class GroupAdminSetEventListener extends EventListener<GroupAdminSetEvent> {
    @Override
    public Class getEventType() {
        return GroupAdminSetEvent.class;
    }
}
