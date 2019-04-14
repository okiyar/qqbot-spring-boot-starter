package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.GroupNotifyMessage;

public class GroupNotifyEvent extends Event<GroupNotifyMessage> {
    public GroupNotifyEvent(GroupNotifyMessage message) {
        super(message);
    }
}
