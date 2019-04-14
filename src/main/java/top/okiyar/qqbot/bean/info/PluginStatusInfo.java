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
public class PluginStatusInfo extends Info {
    private boolean online;
    @SerializedName("good")
    private boolean isGood;
    @SerializedName("app_good")
    private boolean isAppGood;
    @SerializedName("app_enabled")
    private boolean isAppEnabled;
    @SerializedName("plugins_good")
    private boolean isPluginsGood;
    @SerializedName("app_initialized")
    private boolean isAppInitialized;

    public static PluginStatusInfo objectFromData(String str) {
        return new Gson().fromJson(str, PluginStatusInfo.class);
    }
}
