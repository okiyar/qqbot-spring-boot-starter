package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.GroupNotifyMessage;

public class GroupAdminSetEvent extends Event<GroupNotifyMessage> {
    public GroupAdminSetEvent(GroupNotifyMessage message) {
        super(message);
    }
}
