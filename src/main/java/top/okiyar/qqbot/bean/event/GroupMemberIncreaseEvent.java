package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.GroupNotifyMessage;

public class GroupMemberIncreaseEvent extends Event<GroupNotifyMessage> {
    public GroupMemberIncreaseEvent(GroupNotifyMessage message) {
        super(message);
    }
}
