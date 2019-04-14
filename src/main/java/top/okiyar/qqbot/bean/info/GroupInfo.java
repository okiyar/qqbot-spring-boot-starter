package top.okiyar.qqbot.bean.info;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.bean.base.Info;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class GroupInfo extends Info {
    @SerializedName("group_id")
    private long groupId;
    @SerializedName("group_name")
    private String groupName;

    private String remark;

    public static List<GroupInfo> arrayGroupInfoFromData(String str) {
        Type listType = new TypeToken<ArrayList<GroupInfo>>() {
        }.getType();
        return new Gson().fromJson(str, listType);
    }
}
