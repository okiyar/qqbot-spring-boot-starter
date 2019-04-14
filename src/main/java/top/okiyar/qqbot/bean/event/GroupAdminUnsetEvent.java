package top.okiyar.qqbot.bean.event;


import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.GroupNotifyMessage;

public class GroupAdminUnsetEvent extends Event<GroupNotifyMessage> {
    public GroupAdminUnsetEvent(GroupNotifyMessage message) {
        super(message);
    }
}
