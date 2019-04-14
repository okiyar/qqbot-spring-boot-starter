package top.okiyar.qqbot.bean.base;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
public abstract class Message {
    /**
     * 消息时间
     */
    private long time;

    /**
     * 当前登录QQ号
     */
    @SerializedName("self_id")
    private long selfId;

    public long getTimestamp() {
        return time;
    }

    public String getLocalTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .format(LocalDateTime.ofInstant(Instant.ofEpochSecond(time), ZoneId.systemDefault()));
    }
}
