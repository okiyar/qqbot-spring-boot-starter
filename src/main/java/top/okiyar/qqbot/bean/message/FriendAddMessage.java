package top.okiyar.qqbot.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Message;

@Getter
@Setter
@ToString
public class FriendAddMessage extends Message {
    /**
     * 添加好友附加内容
     */
    @SerializedName("comment")
    private String helloContent;

    /**
     * 添加好友标志信息
     */
    private String flag;

    /**
     * 添加者QQ
     */
    @SerializedName("user_id")
    private long userId;
}