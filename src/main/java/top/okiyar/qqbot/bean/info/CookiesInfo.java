package top.okiyar.qqbot.bean.info;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Info;

@Getter
@Setter
@ToString(callSuper = true)
public class CookiesInfo extends Info {
    private String cookies;
    public static CookiesInfo objectFromData(String str) {
        return new Gson().fromJson(str, CookiesInfo.class);
    }
}
