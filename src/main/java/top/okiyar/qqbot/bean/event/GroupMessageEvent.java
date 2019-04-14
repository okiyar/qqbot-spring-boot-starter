package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.GroupMessage;

public class GroupMessageEvent extends Event<GroupMessage> {
    public GroupMessageEvent(GroupMessage message) {
        super(message);
    }
}
