package top.okiyar.qqbot.bean.listener;


import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.GroupMemberDecreaseEvent;

public abstract class GroupMemberDecreaseEventListener extends EventListener<GroupMemberDecreaseEvent> {
    @Override
    public Class getEventType() {
        return GroupMemberDecreaseEvent.class;
    }
}
