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
public class FriendInfo extends Info {

    private List<FriendGroupInfo> friendGroupInfoList;

    public static FriendInfo objectFromData(String str) {
        List<FriendGroupInfo> friendGroupInfoList = FriendGroupInfo.arrayFriendsBeanFromData(str);
        return new FriendInfo(friendGroupInfoList);
    }

    public FriendInfo(List<FriendGroupInfo> friendGroupInfoList) {
        this.friendGroupInfoList = friendGroupInfoList;
    }

    public List<FriendGroupInfo> getFriendGroupInfoList() {
        return friendGroupInfoList;
    }

    public int getFriendGroupSize() {
        return friendGroupInfoList == null ? 0 : friendGroupInfoList.size();
    }

    @Getter
    @Setter
    @ToString
    public static class FriendGroupInfo {
        @SerializedName("friend_group_id")
        private int friendGroupNumber;
        @SerializedName("friend_group_name")
        private String friendGroupName;
        private List<FriendsBean> friends;

        public static List<FriendGroupInfo> arrayFriendsBeanFromData(String str) {
            Type listType = new TypeToken<ArrayList<FriendGroupInfo>>() {
            }.getType();
            return new Gson().fromJson(str, listType);
        }

        public int getFriendSize() {
            return friends == null ? 0 : friends.size();
        }

        @Getter
        @Setter
        @ToString
        public static class FriendsBean {
            private String nickname;
            private String remark;
            @SerializedName("user_id")
            private long userId;

            public static FriendsBean objectFromData(String str) {
                return new Gson().fromJson(str, FriendsBean.class);
            }

            public static List<FriendsBean> arrayFriendsBeanFromData(String str) {
                Type listType = new TypeToken<ArrayList<FriendsBean>>() {
                }.getType();
                return new Gson().fromJson(str, listType);
            }

        }
    }
}
