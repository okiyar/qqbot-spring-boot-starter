package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.GroupJoinMessage;

public class GroupJoinEvent extends Event<GroupJoinMessage> {
    public GroupJoinEvent(GroupJoinMessage message) {
        super(message);
    }
}
