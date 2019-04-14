package top.okiyar.qqbot.bean.event;


import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.GroupNotifyMessage;

public class GroupMemberDecreaseEvent extends Event<GroupNotifyMessage> {
    public GroupMemberDecreaseEvent(GroupNotifyMessage message) {
        super(message);
    }
}
