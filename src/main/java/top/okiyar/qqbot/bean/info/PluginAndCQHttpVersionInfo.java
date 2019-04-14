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
public class PluginAndCQHttpVersionInfo extends Info {

    /**
     * coolq_directory : D:\cq-air\data\
     * coolq_edition : air
     * plugin_build_configuration : release
     * plugin_build_number : 406
     * plugin_version : 4.0.0
     */

    @SerializedName("coolq_directory")
    private String CQDirectory;
    @SerializedName("coolq_edition")
    private String CQEdition;
    @SerializedName("plugin_build_configuration")
    private String pluginBuildConfiguration;
    @SerializedName("plugin_build_number")
    private int pluginBuildNumber;
    @SerializedName("plugin_version")
    private String pluginVersion;

    public static PluginAndCQHttpVersionInfo objectFromData(String str) {
        return new Gson().fromJson(str, PluginAndCQHttpVersionInfo.class);
    }
}
