package top.okiyar.qqbot.bean.event;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.message.FriendAddMessage;

public class FriendAddEvent extends Event<FriendAddMessage> {
    public FriendAddEvent(FriendAddMessage message) {
        super(message);
    }
}
