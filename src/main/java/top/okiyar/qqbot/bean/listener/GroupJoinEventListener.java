package top.okiyar.qqbot.bean.listener;


import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.GroupJoinEvent;

public abstract class GroupJoinEventListener extends EventListener<GroupJoinEvent> {
    @Override
    public Class getEventType() {
        return GroupJoinEvent.class;
    }
}
