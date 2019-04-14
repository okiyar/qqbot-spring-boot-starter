package top.okiyar.qqbot.bean.info;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Info;

@Getter
@Setter
@ToString(callSuper = true)
public class CSRFTokenInfo extends Info {
    private long token;

    public static CSRFTokenInfo objectFromData(String str) {
        return new Gson().fromJson(str, CSRFTokenInfo.class);
    }
}
