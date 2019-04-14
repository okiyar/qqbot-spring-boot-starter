package top.okiyar.qqbot.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Message;

@Getter
@Setter
@ToString
public class GroupJoinMessage extends Message {
    /**
     * 添加群标志信息
     */
    private String flag;
    /**
     * 添加好友附加内容
     */
    @SerializedName("comment")
    private String helloContent;
    @SerializedName("user_id")
    private long userId;
    @SerializedName("group_id")
    private long groupId;
    @SerializedName("sub_type")
    private String subType;
}
