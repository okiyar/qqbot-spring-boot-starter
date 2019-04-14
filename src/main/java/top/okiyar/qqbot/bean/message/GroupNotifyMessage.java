package top.okiyar.qqbot.bean.message;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Message;

@Getter
@Setter
@ToString
public class GroupNotifyMessage extends Message {

    @SerializedName("user_id")
    private long userId;

    @SerializedName("sub_type")
    private String subType;

    @SerializedName("group_id")
    private long groupId;

    @SerializedName("notice_type")
    private String noticeType;

    @SerializedName("operator_id")
    private long operatorId;
}
