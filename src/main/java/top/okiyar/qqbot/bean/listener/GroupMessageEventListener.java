package top.okiyar.qqbot.bean.listener;


import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.bean.event.GroupMessageEvent;

public abstract class GroupMessageEventListener extends EventListener<GroupMessageEvent> {
    @Override
    public Class getEventType() {
        return GroupMessageEvent.class;
    }
}
