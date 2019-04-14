package top.okiyar.qqbot.bean.listener;


import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.GroupAdminUnsetEvent;

public abstract class GroupAdminUnsetEventListener extends EventListener<GroupAdminUnsetEvent> {
    @Override
    public Class getEventType() {
        return GroupAdminUnsetEvent.class;
    }
}
