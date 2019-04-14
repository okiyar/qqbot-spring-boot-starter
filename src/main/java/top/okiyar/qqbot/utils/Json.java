package top.okiyar.qqbot.utils;

import com.google.gson.Gson;
import top.okiyar.qqbot.bean.message.*;

public class Json {
    public static PrivateMessage PrivateMessage(String jsonStr) {
        return new Gson().fromJson(jsonStr, PrivateMessage.class);
    }

    public static GroupMessage GroupMessage(String str) {
        GroupMessage gm = new Gson().fromJson(str, GroupMessage.class);
        if (gm.getAnonymous() != null) {
            gm.setAnonymous(true);
        }
        return gm;
    }

    public static FriendAddMessage FriendAddMessage(String str) {
        return new Gson().fromJson(str, FriendAddMessage.class);
    }

    public static GroupJoinMessage GroupJoinMessage(String str) {
        return new Gson().fromJson(str, GroupJoinMessage.class);
    }

    public static GroupNotifyMessage GroupNotifyMessage(String str) {
        return new Gson().fromJson(str, GroupNotifyMessage.class);
    }
}
