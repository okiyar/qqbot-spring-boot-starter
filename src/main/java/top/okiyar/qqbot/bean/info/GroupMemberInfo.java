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
public class GroupMemberInfo extends Info {

    private int age;
    private String area;
    private String card;
    private String level;
    private String nickname;
    private String role;
    private String sex;
    private String title;
    private boolean unfriendly;
    @SerializedName("join_time")
    private int joinTime;
    @SerializedName("group_id")
    private long groupId;
    @SerializedName("user_id")
    private long userId;
    @SerializedName("last_sent_time")
    private int lastSentTime;
    @SerializedName("card_changeable")
    private boolean cardChangeable;
    @SerializedName("title_expire_time")
    private int titleExpireTime;

    public static GroupMemberInfo objectFromData(String str) {
        return new Gson().fromJson(str, GroupMemberInfo.class);
    }

    public static List<GroupMemberInfo> arrayGroupMemberInfoFromData(String str) {
        Type listType = new TypeToken<ArrayList<GroupMemberInfo>>() {
        }.getType();
        return new Gson().fromJson(str, listType);
    }
}
