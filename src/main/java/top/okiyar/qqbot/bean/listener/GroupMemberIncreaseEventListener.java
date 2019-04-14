package top.okiyar.qqbot.bean.listener;


import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.GroupMemberIncreaseEvent;

public abstract class GroupMemberIncreaseEventListener extends EventListener<GroupMemberIncreaseEvent> {
    @Override
    public Class getEventType() {
        return GroupMemberIncreaseEvent.class;
    }
}
