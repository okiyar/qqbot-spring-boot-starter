package top.okiyar.qqbot.bean.info;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Info;

@Getter
@Setter
@ToString(callSuper = true)
public class RecordInfo extends Info {
    public static RecordInfo objectFromData(String str) {
        return new Gson().fromJson(str, RecordInfo.class);
    }
}
