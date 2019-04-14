package top.okiyar.qqbot.base;

import top.okiyar.qqbot.bean.base.Info;
import top.okiyar.qqbot.bean.info.*;
import top.okiyar.qqbot.components.Sender;

import java.util.List;
import java.util.Map;
import java.util.Observable;


public class QQApi extends Observable {

    public QQApi(Sender sender) {
        this.addObserver(sender);
    }

    private CQHttpBase cqhttp = new CQHttpBase();

    public void sendPrivateMsg(long userId, String message, boolean autoEscape, Callback<Info> callback) {
        Map map = cqhttp.sendPrivateMsg(userId, message, autoEscape, callback);
        this.setChanged();
        this.notifyObservers(map);
    }

    public void sendPrivateMsg(long userId, String message, Callback<Info> callback) {
        Map map = cqhttp.sendPrivateMsg(userId, message, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendPrivateMsg(long userId, String message, boolean autoEscape) {
        Map map = cqhttp.sendPrivateMsg(userId, message, autoEscape);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendPrivateMsg(long userId, String message) {
        Map map = cqhttp.sendPrivateMsg(userId, message);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendGroupMsg(long groupId, String message, boolean autoEscape, Callback<Info> callback) {
        Map map = cqhttp.sendGroupMsg(groupId, message, autoEscape, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendGroupMsg(long groupId, String message, Callback<Info> callback) {
        Map map = cqhttp.sendGroupMsg(groupId, message, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendGroupMsg(long groupId, String message, boolean autoEscape) {
        Map map = cqhttp.sendGroupMsg(groupId, message, autoEscape);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendGroupMsg(long groupId, String message) {
        Map map = cqhttp.sendGroupMsg(groupId, message);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendDiscussMsg(long discussId, String message, boolean autoEscape, Callback<Info> callback) {
        Map map = cqhttp.sendDiscussMsg(discussId, message, autoEscape, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendDiscussMsg(long discussId, String message, Callback<Info> callback) {
        Map map = cqhttp.sendDiscussMsg(discussId, message, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendDiscussMsg(long discussId, String message, boolean autoEscape) {
        Map map = cqhttp.sendDiscussMsg(discussId, message, autoEscape);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendDiscussMsg(long discussId, String message) {
        Map map = cqhttp.sendDiscussMsg(discussId, message);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendMsg(String messageType, long userId, long groupId, long discussId, String message, boolean autoEscape, Callback<Info> callback) {
        Map map = cqhttp.sendMsg(messageType, userId, groupId, discussId, message, autoEscape, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendMsg(String messageType, long userId, long groupId, long discussId, String message, boolean autoEscape) {
        Map map = cqhttp.sendMsg(messageType, userId, groupId, discussId, message, autoEscape);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void deleteMsg(long messageId, Callback<Info> callback) {
        Map map = cqhttp.deleteMsg(messageId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void deleteMsg(long messageId) {
        Map map = cqhttp.deleteMsg(messageId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupKick(long groupId, long userId, boolean autoReject, Callback<Info> callback) {
        Map map = cqhttp.setGroupKick(groupId, userId, autoReject, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupKick(long groupId, long userId, Callback<Info> callback) {
        Map map = cqhttp.setGroupKick(groupId, userId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupKick(long groupId, long userId, boolean autoReject) {
        Map map = cqhttp.setGroupKick(groupId, userId, autoReject);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberBan(long groupId, long userId, long duration, Callback<Info> callback) {
        Map map = cqhttp.setGroupMemberBan(groupId, userId, duration, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberBan(long groupId, long userId, Callback<Info> callback) {
        Map map = cqhttp.setGroupMemberBan(groupId, userId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberBan(long groupId, long userId, long duration) {
        Map map = cqhttp.setGroupMemberBan(groupId, userId, duration);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupWholeBan(long groupId, boolean enable, Callback<Info> callback) {
        Map map = cqhttp.setGroupWholeBan(groupId, enable, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupWholeBan(long groupId, boolean enable) {
        Map map = cqhttp.setGroupWholeBan(groupId, enable);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void openGroupWholeBan(long groupId, Callback callback) {
        Map map = cqhttp.openGroupWholeBan(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void closeGroupWholeBan(long groupId, Callback callback) {
        Map map = cqhttp.closeGroupWholeBan(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void openGroupWholeBan(long groupId) {
        Map map = cqhttp.openGroupWholeBan(groupId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void closeGroupWholeBan(long groupId) {
        Map map = cqhttp.closeGroupWholeBan(groupId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAdmin(long groupId, long userId, boolean enable, Callback<Info> callback) {
        Map map = cqhttp.setGroupAdmin(groupId, userId, enable, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAdmin(long groupId, long userId, boolean enable) {
        Map map = cqhttp.setGroupAdmin(groupId, userId, enable);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAdmin(long groupId, long userId, Callback<Info> callback) {
        Map map = cqhttp.setGroupAdmin(groupId, userId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void unsetGroupAdmin(long groupId, long userId, Callback<Info> callback) {
        Map map = cqhttp.unsetGroupAdmin(groupId, userId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAdmin(long groupId, long userId) {
        Map map = cqhttp.setGroupAdmin(groupId, userId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void unsetGroupAdmin(long groupId, long userId) {
        Map map = cqhttp.unsetGroupAdmin(groupId, userId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberCard(long groupId, long userId, String card, Callback<Info> callback) {
        Map map = cqhttp.setGroupMemberCard(groupId, userId, card, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberCard(long groupId, long userId, String card) {
        Map map = cqhttp.setGroupMemberCard(groupId, userId, card);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberTitle(long groupId, long userId, String title, int duration, Callback<Info> callback) {
        Map map = cqhttp.setGroupMemberTitle(groupId, userId, title, duration, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberTitle(long groupId, long userId, String title, int duration) {
        Map map = cqhttp.setGroupMemberTitle(groupId, userId, title, duration);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberTitle(long groupId, long userId, String title, Callback<Info> callback) {
        Map map = cqhttp.setGroupMemberTitle(groupId, userId, title, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupMemberTitle(long groupId, long userId, String title) {
        Map map = cqhttp.setGroupMemberTitle(groupId, userId, title);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAnonymous(long groupId, boolean enable, Callback<Info> callback) {
        Map map = cqhttp.setGroupAnonymous(groupId, enable, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAnonymous(long groupId, boolean enable) {
        Map map = cqhttp.setGroupAnonymous(groupId, enable);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void openGroupAnonymous(long groupId, Callback callback) {
        Map map = cqhttp.openGroupAnonymous(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void closeGroupAnonymous(long groupId, Callback callback) {
        Map map = cqhttp.closeGroupAnonymous(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void openGroupAnonymous(long groupId) {
        Map map = cqhttp.openGroupAnonymous(groupId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void closeGroupAnonymous(long groupId) {
        Map map = cqhttp.closeGroupAnonymous(groupId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAnonymousBan(String flag, long groupId, int duration, Callback<Info> callback) {
        Map map = cqhttp.setGroupAnonymousBan(flag, groupId, duration, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAnonymousBan(String flag, long groupId) {
        Map map = cqhttp.setGroupAnonymousBan(flag, groupId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAnonymousBan(String flag, long groupId, int duration) {
        Map map = cqhttp.setGroupAnonymousBan(flag, groupId, duration);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupLeave(long groupId, boolean dismiss, Callback<Info> callback) {
        Map map = cqhttp.setGroupLeave(groupId, dismiss, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void dismissGroup(long groupId, Callback callback) {
        Map map = cqhttp.dismissGroup(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void dismissGroup(long groupId) {
        Map map = cqhttp.dismissGroup(groupId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void leaveGroup(long groupId, Callback callback) {
        Map map = cqhttp.leaveGroup(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void leaveGroup(long groupId) {
        Map map = cqhttp.leaveGroup(groupId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupLeave(long groupId, boolean dismiss) {
        Map map = cqhttp.setGroupLeave(groupId, dismiss);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setDiscussLeave(long discussId, Callback<Info> callback) {
        Map map = cqhttp.setDiscussLeave(discussId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setDiscussLeave(long discussId) {
        Map map = cqhttp.setDiscussLeave(discussId);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setFriendAddRequest(String flag, boolean approve, String remark, Callback<Info> callback) {
        Map map = cqhttp.setFriendAddRequest(flag, approve, remark, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void agreeFriendAddRequest(String flag, String remark, Callback<Info> callback) {
        Map map = cqhttp.agreeFriendAddRequest(flag, remark, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void agreeFriendAddRequest(String flag, String remark) {
        Map map = cqhttp.agreeFriendAddRequest(flag, remark);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void agreeFriendAddRequest(String flag, Callback callback) {
        Map map = cqhttp.agreeFriendAddRequest(flag, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void agreeFriendAddRequest(String flag) {
        Map map = cqhttp.agreeFriendAddRequest(flag);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void rejectFriendAddRequest(String flag, Callback callback) {
        Map map = cqhttp.rejectFriendAddRequest(flag, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void rejectFriendAddRequest(String flag) {
        Map map = cqhttp.rejectFriendAddRequest(flag);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setGroupAddRequest(String flag, String type, boolean approve, String reason, Callback<Info> callback) {
        Map map = cqhttp.setGroupAddRequest(flag, type, approve, reason, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void agreeGroupAddRequest(String flag, String type, Callback<Info> callback) {
        Map map = cqhttp.agreeGroupAddRequest(flag, type, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void agreeGroupAddRequest(String flag, String type) {
        Map map = cqhttp.agreeGroupAddRequest(flag, type);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void rejectGroupAddRequest(String flag, String type, String reason, Callback<Info> callback) {
        Map map = cqhttp.rejectGroupAddRequest(flag, type, reason, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void rejectGroupAddRequest(String flag, String type, String reason) {
        Map map = cqhttp.rejectGroupAddRequest(flag, type, reason);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void rejectGroupAddRequest(String flag, String type, Callback<Info> callback) {
        Map map = cqhttp.rejectGroupAddRequest(flag, type, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void rejectGroupAddRequest(String flag, String type) {
        Map map = cqhttp.rejectGroupAddRequest(flag, type);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendLike(long userId, short times, Callback<Info> callback) {
        Map map = cqhttp.sendLike(userId, times, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void sendLike(long userId, short times) {
        Map map = cqhttp.sendLike(userId, times);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getCSRFToken(Callback<CSRFTokenInfo> callback) {
        Map map = cqhttp.getCSRFToken(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getStatus(Callback<PluginStatusInfo> callback) {
        Map map = cqhttp.getStatus(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void cleanDataDir() {
        Map map = cqhttp.cleanDataDir();
        this.setChanged();
        this.notifyObservers(map);
    }


    public void cleanPluginLog() {
        Map map = cqhttp.cleanPluginLog();
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setRestartPlugin() {
        Map map = cqhttp.setRestartPlugin();
        this.setChanged();
        this.notifyObservers(map);
    }


    public void setRestart() {
        Map map = cqhttp.setRestart();
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getStrangerInfo(long userId, boolean noCache, Callback<StrangerInfo> callback) {
        Map map = cqhttp.getStrangerInfo(userId, noCache, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getStrangerInfo(long userId, Callback<StrangerInfo> callback) {
        Map map = cqhttp.getStrangerInfo(userId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getGroupList(Callback<List<GroupInfo>> callback) {
        Map map = cqhttp.getGroupList(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getGroupMemberInfo(long groupId, long userId, boolean noCache, Callback<GroupMemberInfo> callback) {
        Map map = cqhttp.getGroupMemberInfo(groupId, userId, noCache, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getGroupMemberInfo(long groupId, long userId, Callback<GroupMemberInfo> callback) {
        Map map = cqhttp.getGroupMemberInfo(groupId, userId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getGroupMemberList(long groupId, Callback<GroupMemberInfo> callback) {
        Map map = cqhttp.getGroupMemberList(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getLoginInfo(Callback<LoginInfo> callback) {
        Map map = cqhttp.getLoginInfo(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getCookies(Callback<CookiesInfo> callback) {
        Map map = cqhttp.getCookies(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getVersionInfo(Callback<PluginAndCQHttpVersionInfo> callback) {
        Map map = cqhttp.getVersionInfo(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getRecord(String file, String outFormat, Callback<RecordInfo> callback) {
        Map map = cqhttp.getRecord(file, outFormat, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getFriendList(Callback<FriendInfo> callback) {
        Map map = cqhttp._getFriendList(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getGroupInfo(long groupId, Callback<GroupInfo> callback) {
        Map map = cqhttp._getGroupInfo(groupId, callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void getCredentials(Callback callback) {
        Map map = cqhttp.getCredentials(callback);
        this.setChanged();
        this.notifyObservers(map);
    }


    public void cleanPluginLog(Callback callback) {
        Map map = cqhttp.cleanPluginLog(callback);
        this.setChanged();
        this.notifyObservers(map);
    }
}
