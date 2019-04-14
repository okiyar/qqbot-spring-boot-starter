package top.okiyar.qqbot.bean.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Message;

@Getter
@Setter
@ToString
public class PrivateMessage extends Message {
    @SerializedName("user_id")
    @JsonProperty("user_id")
    private long userId;

    @SerializedName("message_id")
    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("raw_message")
    @SerializedName("raw_message")
    private String message;
}
