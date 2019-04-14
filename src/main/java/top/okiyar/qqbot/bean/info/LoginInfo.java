package top.okiyar.qqbot.bean.info;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Info;

@Getter
@Setter
@ToString(callSuper = true)
public class LoginInfo extends Info {
    private String nickname;
    @SerializedName("user_id")
    private long userId;

    public static LoginInfo objectFromData(String str) {
        return new Gson().fromJson(str, LoginInfo.class);
    }
}
