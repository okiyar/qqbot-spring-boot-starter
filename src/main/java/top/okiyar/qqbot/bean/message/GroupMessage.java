package top.okiyar.qqbot.bean.message;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Message;

@Getter
@Setter
@ToString
public class GroupMessage extends Message {
    // 标识群消息是否为匿名消息
    private boolean isAnonymous;

    @SerializedName("user_id")
    private long userId;

    @SerializedName("group_id")
    private long groupId;

    @SerializedName("message_id")
    private int messageId;

    @SerializedName("raw_message")
    private String message;

    private AnonymousBean anonymous;

    @Getter
    @Setter
    @ToString
    public static class AnonymousBean {
        private int id;
        private String flag;
        private String name;

        public static AnonymousBean objectFromData(String str) {
            return new Gson().fromJson(str, AnonymousBean.class);
        }
    }
}
