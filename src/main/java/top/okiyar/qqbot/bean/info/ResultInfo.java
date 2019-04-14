package top.okiyar.qqbot.bean.info;

public class ResultInfo {
//    private FriendInfo friendInfo;
//    private List<GroupInfo> groupInfoList;
//    private GroupMemberInfo groupMemberInfo;
//    private List<GroupMemberInfo> groupMemberInfoList;
//    private StrangerInfo strangerInfo;
//    private CookiesInfo cookiesInfo;
//    private LoginInfo loginInfo;
//    private top.okiyar.bean.info.CSRFTokenInfo CSRFTokenInfo;
//    private PluginStatusInfo pluginStatusInfo;
//    private PluginAndCQHttpVersionInfo pluginAndCQHttpVersionInfo;
//    private RecordInfo recordInfo;
//
//    private long messageId = -1;
//    private String echo;
//
//
//    private String dataJson;
//
//    public long getMessageId() {
//        if (messageId == -1) {
//            try {
//                messageId = GsonUtil.getJsonObject(dataJson).get("message_id").getAsLong();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return messageId;
//    }
//
//    public ResultInfo(String dataJson) {
//        JsonObject json = GsonUtil.getJsonObject(dataJson);
//        this.echo = json.get("echo").getAsString();
//        this.retcode = json.get("retcode").getAsInt();
//        this.status = json.get("status").getAsString();
//        this.dataJson = json.get("data").isJsonNull()? null : json.get("data").toString();
//    }
//
//    public FriendInfo getFriendInfo() {
//        if (friendInfo == null) {
//            try {
//                friendInfo = FriendInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return friendInfo;
//    }
//
//    public List<GroupInfo> getGroupInfoList() {
//        if (groupInfoList == null) {
//            try {
//                groupInfoList = GroupInfo.arrayGroupInfoFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return groupInfoList;
//    }
//
//    public GroupMemberInfo getGroupMemberInfo() {
//        if (groupMemberInfo == null) {
//            try {
//                groupMemberInfo = GroupMemberInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return groupMemberInfo;
//    }
//
//    public top.okiyar.bean.info.CSRFTokenInfo getCSRFTokenInfo() {
//        if (CSRFTokenInfo == null) {
//            try {
//                CSRFTokenInfo = CSRFTokenInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return CSRFTokenInfo;
//    }
//
//    public List<GroupMemberInfo> getGroupMemberInfoList() {
//        if (groupMemberInfoList == null) {
//            try {
//                groupMemberInfoList = GroupMemberInfo.arrayGroupMemberInfoFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return groupMemberInfoList;
//    }
//
//    public StrangerInfo getStrangerInfo() {
//        if (strangerInfo == null) {
//            try {
//                strangerInfo = StrangerInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return strangerInfo;
//    }
//
//    public CookiesInfo getCookiesInfo() {
//        if (cookiesInfo == null) {
//            try {
//                cookiesInfo = CookiesInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return cookiesInfo;
//    }
//
//    public LoginInfo getLoginInfo() {
//        if (loginInfo == null) {
//            try {
//                loginInfo = LoginInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return loginInfo;
//    }
//
//    public PluginStatusInfo getPluginStatusInfo() {
//        if (pluginStatusInfo == null) {
//            try {
//                pluginStatusInfo = PluginStatusInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return pluginStatusInfo;
//    }
//
//    public PluginAndCQHttpVersionInfo getPluginAndCQHttpVersionInfo() {
//        if (pluginAndCQHttpVersionInfo == null) {
//            try {
//                pluginAndCQHttpVersionInfo = PluginAndCQHttpVersionInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return pluginAndCQHttpVersionInfo;
//    }
//
//    public RecordInfo getRecordInfo() {
//        if (recordInfo == null) {
//            try {
//                recordInfo = RecordInfo.objectFromData(dataJson);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return recordInfo;
//    }
//
//    public String getEcho() {
//        return echo;
//    }
//
//    public int getRetcode() {
//        return retcode;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    @Override
//    public String toString() {
//        return "ResultInfo{" +
//                "friendInfo=" + friendInfo +
//                ", groupInfoList=" + groupInfoList +
//                ", groupMemberInfo=" + groupMemberInfo +
//                ", groupMemberInfoList=" + groupMemberInfoList +
//                ", strangerInfo=" + strangerInfo +
//                ", cookiesInfo=" + cookiesInfo +
//                ", loginInfo=" + loginInfo +
//                ", CSRFTokenInfo=" + CSRFTokenInfo +
//                ", pluginStatusInfo=" + pluginStatusInfo +
//                ", pluginAndCQHttpVersionInfo=" + pluginAndCQHttpVersionInfo +
//                ", recordInfo=" + recordInfo +
//                ", echo='" + echo + '\'' +
//                ", retcode=" + retcode +
//                ", status='" + status + '\'' +
//                ", dataJson='" + dataJson + '\'' +
//                '}';
//    }
}
