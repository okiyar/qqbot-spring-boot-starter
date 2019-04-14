package top.okiyar.qqbot.base;

import top.okiyar.qqbot.bean.base.Info;
import top.okiyar.qqbot.bean.info.*;
import top.okiyar.qqbot.enums.CQHttp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于 CQHttp Plugin 4.0.0 版本
 */
public class CQHttpBase {

//	public final String SEND_PRIVATE_MSG = "send_private_msg";					// 私聊消息
//	public final String SEND_GROUP_MSG = "send_group_msg";						// 群消息
//	public final String SEND_DISCUSS_MSG = "send_discuss_msg";					// 讨论组消息
//	public final String SEND_MSG = "send_msg";									// 自定义发送消息
//	public final String SET_GROUP_KICK = "set_group_kick";						// 踢人
//	public final String SET_GROUP_BAN = "set_group_ban";						// 禁言非匿名成员
//	public final String SET_GROUP_WHOLE_BAN = "set_group_whole_ban";			// 设置全员禁言
//	public final String SET_GROUP_ADMIN = "set_group_admin";					// 设置管理员
//	public final String SET_GROUP_CARD = "set_group_card";						// 设置群名片
//	public final String SET_GROUP_SPECIAL_TITLE = "set_group_special_title";	// 设置群组专属头衔
//	public final String SET_GROUP_LEAVE = "set_group_leave";					// 退群
//	public final String SET_DISCUSS_LEAVE = "set_discuss_leave";				// 退出讨论组
//
//	public final String SET_FRIEND_ADD_REQUEST = "set_friend_add_request";		// 设置添加好友请求
//	public final String SET_GROUP_ADD_REQUEST = "set_group_add_request";		// 设置加群请求
//
//	public final String DELETE_MSG = "delete_msg";								// 撤回消息
//	public final String SEND_LIKE = "send_like";								// 点赞
//	public final String GET_RECORD = "get_record";								// 获取语音
//	public final String SET_GROUP_ANONYMOUS = "set_group_anonymous";			// 设置匿名功能
//	public final String SET_GROUP_ANONYMOUS_BAN = "set_group_anonymous_ban";	// 禁言匿名成员
//
//	public final String _GET_FRIEND_LIST = "_get_friend_list";					// 获取好友列表
//
//	public final String GET_STRANGER_INFO = "get_stranger_info";				// 获取陌生人信息
//	public final String GET_GROUP_LIST = "get_group_list";						// 获取群列表
//	public final String GET_GROUP_MEMBER_INFO = "get_group_member_info";		// 获取群成员信息
//	public final String GET_GROUP_MEMBER_LIST = "get_group_member_list";		// 获取群成员列表
//
//	public final String GET_LOGIN_INFO = "get_login_info";						// 获取登录信息
//	public final String GET_COOKIES = "get_cookies";							// 获取 Cookies
//	public final String GET_VERSION_INFO = "get_version_info";					// 获取酷Q和HTTP API 插件版本信息
//	public final String GET_CSRF_TOKEN = "get_csrf_token";						// 获取 CSRF Token
//	public final String GET_STATUS = "get_status";								// 获取插件运行状态
//	public final String CLEAN_DATA_DIR = "clean_data_dir";						// 清理数据目录
//	public final String CLEAN_PLUGIN_LOG = "clean_plugin_log";					// 清理插件日志
//	public final String SET_RESTART_PLUGIN = "set_restart_plugin";				// 重启 HttpAPI 插件
//	public final String SET_RESTART = "set_restart";							// 重启酷Q和 HttpAPI 插件（并以当前账号自动登录，需要开启自动登录）
//
//	public final String _GET_GROUP_INFO = "_get_group_info ";					// 获取群信息
//	public final String GET_CREDENTIALS = "get_credentials";					// 获取 QQ 相关接口凭证

    /**
     * 发送私聊消息
     *
     * @param userId     对方QQ号
     * @param message    发送消息
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效  默认 false
     * @return coolq-http-api 插件返回内容对象
     */
    public Map sendPrivateMsg(long userId, String message, boolean autoEscape, Callback<Info> callback) {
        return sendMsg("private", userId, 0, 0, message, autoEscape, callback);
    }

    public Map sendPrivateMsg(long userId, String message, Callback<Info> callback) {
        return sendPrivateMsg(userId, message, false, callback);
    }

    public Map sendPrivateMsg(long userId, String message, boolean autoEscape) {
        return sendPrivateMsg(userId, message, autoEscape, null);
    }

    public Map sendPrivateMsg(long userId, String message) {
        return sendPrivateMsg(userId, message, false, null);
    }

    /**
     * 发送群聊消息
     *
     * @param groupId    群ID
     * @param message    消息
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效  默认 false
     * @return coolq-http-api 插件返回内容对象
     */
    public Map sendGroupMsg(long groupId, String message, boolean autoEscape, Callback<Info> callback) {
        return sendMsg("group", 0, groupId, 0, message, autoEscape, callback);
    }

    public Map sendGroupMsg(long groupId, String message, Callback<Info> callback) {
        return sendGroupMsg(groupId, message, false, callback);
    }

    public Map sendGroupMsg(long groupId, String message, boolean autoEscape) {
        return sendGroupMsg(groupId, message, autoEscape, null);
    }

    public Map sendGroupMsg(long groupId, String message) {
        return sendGroupMsg(groupId, message, false, null);
    }

    /**
     * 发送讨论组消息
     *
     * @param discussId  讨论组ID
     * @param message    消息
     * @param autoEscape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效  默认 false
     * @return coolq-http-api 插件返回内容对象
     */
    public Map sendDiscussMsg(long discussId, String message, boolean autoEscape, Callback<Info> callback) {
        return sendMsg("discuss", 0, 0, discussId, message, autoEscape, callback);
    }

    public Map sendDiscussMsg(long discussId, String message, Callback<Info> callback) {
        return sendDiscussMsg(discussId, message, false, callback);
    }

    public Map sendDiscussMsg(long discussId, String message, boolean autoEscape) {
        return sendDiscussMsg(discussId, message, autoEscape, null);
    }

    public Map sendDiscussMsg(long discussId, String message) {
        return sendDiscussMsg(discussId, message, false, null);
    }

    /**
     * 发送消息
     *
     * @param messageType 消息类型
     * @param userId      对方 QQ 号
     * @param groupId     群号
     * @param discussId   讨论组ID
     * @param message     消息
     * @param autoEscape  消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效  默认 false
     * @return coolq-http-api 插件返回内容对象
     */
    public Map sendMsg(String messageType, long userId, long groupId, long discussId, String message,
                       boolean autoEscape, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SendMsg.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("message_type", messageType);

        if ("private".equals(messageType)) {
            param.put("user_id", userId);
        } else if ("group".equals(messageType)) {
            param.put("group_id", groupId);
        } else if ("discuss".equals(messageType)) {
            param.put("discuss_id", discussId);
        }

        param.put("message", message);
        param.put("auto_escape", autoEscape);

        map.put("params", param);
        return map;
    }

    public Map sendMsg(String messageType, long userId, long groupId, long discussId, String message, boolean autoEscape) {
        return sendMsg(messageType, userId, groupId, discussId, message, autoEscape, null);
    }

    /**
     * 撤回消息
     *
     * @param messageId 消息ID
     * @return
     */
    public Map deleteMsg(long messageId, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.DeleteMsg.getValue());

        Map param = new HashMap();
        param.put("message_id", messageId);
        map.put("callback", callback);
        map.put("params", param);
        return map;
    }

    public Map deleteMsg(long messageId) {
        return deleteMsg(messageId, null);
    }

    /**
     * 群组踢人
     *
     * @param userId     QQ
     * @param groupId    群号
     * @param autoReject 拒绝此人的加群请求 默认值 false
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupKick(long groupId, long userId, boolean autoReject, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupKick.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("user_id", userId);
        param.put("reject_add_request", autoReject);
        map.put("params", param);
        return map;
    }

    public Map setGroupKick(long groupId, long userId, Callback<Info> callback) {
        return setGroupKick(groupId, userId, false, callback);
    }

    public Map setGroupKick(long groupId, long userId, boolean autoReject) {
        return setGroupKick(groupId, userId, autoReject, null);
    }

    /**
     * 群组单人禁言
     *
     * @param groupId  群号
     * @param userId   QQ
     * @param duration 禁言时长，单位秒，0 表示取消禁言 默认值 30 * 60
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupMemberBan(long groupId, long userId, long duration, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupBan.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("user_id", userId);
        param.put("duration", duration);
        map.put("params", param);
        return map;
    }

    public Map setGroupMemberBan(long groupId, long userId, Callback<Info> callback) {
        return setGroupMemberBan(groupId, userId, 30 * 60, callback);
    }

    public Map setGroupMemberBan(long groupId, long userId, long duration) {
        return setGroupMemberBan(groupId, userId, duration, null);
    }


    /**
     * 群组全员禁言
     *
     * @param groupId 群号
     * @param enable  true 为开启，false 为关闭
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupWholeBan(long groupId, boolean enable, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupWholeBan.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("enable", enable);
        map.put("params", param);
        return map;
    }

    public Map setGroupWholeBan(long groupId, boolean enable) {
        return setGroupWholeBan(groupId, enable, null);
    }

    public Map openGroupWholeBan(long groupId, Callback callback) {
        return setGroupWholeBan(groupId, true, callback);
    }

    public Map closeGroupWholeBan(long groupId, Callback callback) {
        return setGroupWholeBan(groupId, false, callback);
    }

    public Map openGroupWholeBan(long groupId) {
        return setGroupWholeBan(groupId, true, null);
    }

    public Map closeGroupWholeBan(long groupId) {
        return setGroupWholeBan(groupId, false, null);
    }

    /**
     * 群组设置管理员
     *
     * @param groupId 群号
     * @param userId  要设置管理员的 QQ 号
     * @param enable  true 为设置，false 为取消
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupAdmin(long groupId, long userId, boolean enable, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupAdmin.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("user_id", userId);
        param.put("enable", enable);
        map.put("params", param);
        return map;
    }

    public Map setGroupAdmin(long groupId, long userId, boolean enable) {
        return setGroupAdmin(groupId, userId, enable, null);
    }

    public Map setGroupAdmin(long groupId, long userId, Callback<Info> callback) {
        return setGroupAdmin(groupId, userId, true, callback);
    }

    public Map unsetGroupAdmin(long groupId, long userId, Callback<Info> callback) {
        return setGroupAdmin(groupId, userId, false, callback);
    }

    public Map setGroupAdmin(long groupId, long userId) {
        return setGroupAdmin(groupId, userId, true, null);
    }

    public Map unsetGroupAdmin(long groupId, long userId) {
        return setGroupAdmin(groupId, userId, false, null);
    }

    /**
     * 设置群成员群名片
     *
     * @param groupId 群号
     * @param userId  群成员 QQ 号
     * @param card    群名片内容，不填或空字符串表示删除群名片 默认为空
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupMemberCard(long groupId, long userId, String card, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupCard.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("user_id", userId);
        param.put("card", card);
        map.put("params", param);
        return map;
    }

    public Map setGroupMemberCard(long groupId, long userId, String card) {
        return setGroupMemberCard(groupId, userId, card, null);
    }

    /**
     * 设置群成员群专属头衔
     *
     * @param groupId  群号
     * @param userId   群成员 QQ 号
     * @param title    专属头衔 不填或空字符串表示删除专属头衔 默认为空
     * @param duration 头衔有效期 -1代表永久 单位秒
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupMemberTitle(long groupId, long userId, String title, int duration, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupSpecialTitle.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("user_id", userId);
        param.put("special_title", title);
        param.put("duration", duration);
        map.put("params", param);
        return map;
    }

    public Map setGroupMemberTitle(long groupId, long userId, String title, int duration) {
        return setGroupMemberTitle(groupId, userId, title, duration, null);
    }

    public Map setGroupMemberTitle(long groupId, long userId, String title, Callback<Info> callback) {
        return setGroupMemberTitle(groupId, userId, title, -1, callback);
    }

    public Map setGroupMemberTitle(long groupId, long userId, String title) {
        return setGroupMemberTitle(groupId, userId, title, -1, null);
    }

    /**
     * 设置群组匿名功能
     *
     * @param groupId 群号
     * @param enable  true 为开启，false 为关闭
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupAnonymous(long groupId, boolean enable, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupAnonymous.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("enable", enable);
        map.put("params", param);
        return map;
    }

    public Map setGroupAnonymous(long groupId, boolean enable) {
        return setGroupAnonymous(groupId, enable, null);
    }

    public Map openGroupAnonymous(long groupId, Callback callback) {
        return setGroupAnonymous(groupId, true, callback);
    }

    public Map closeGroupAnonymous(long groupId, Callback callback) {
        return setGroupAnonymous(groupId, false, callback);
    }

    public Map openGroupAnonymous(long groupId) {
        return setGroupAnonymous(groupId, true, null);
    }

    public Map closeGroupAnonymous(long groupId) {
        return setGroupAnonymous(groupId, false, null);
    }

    /**
     * 群组匿名用户禁言
     *
     * @param flag     要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
     * @param groupId  群号
     * @param duration 禁言时长，单位秒，无法取消匿名用户禁言
     * @return
     */
    public Map setGroupAnonymousBan(String flag, long groupId, int duration, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupAnonymousBan.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("flag", flag);
        param.put("group_id", groupId);
        param.put("duration", duration);
        map.put("params", param);
        return map;
    }

    public Map setGroupAnonymousBan(String flag, long groupId) {
        return setGroupAnonymousBan(flag, groupId, 3 * 60, null);
    }

    public Map setGroupAnonymousBan(String flag, long groupId, int duration) {
        return setGroupAnonymousBan(flag, groupId, duration, null);
    }

    /**
     * 退群
     *
     * @param groupId 群号
     * @param dismiss 是否解散，如果登录号是群主，则仅在此项为 true 时能够解散 默认 false
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupLeave(long groupId, boolean dismiss, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupLeave.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("dismiss", dismiss);
        map.put("params", param);
        return map;
    }

    public Map dismissGroup(long groupId, Callback callback) {
        return setGroupLeave(groupId, true, callback);
    }

    public Map dismissGroup(long groupId) {
        return setGroupLeave(groupId, true, null);
    }

    public Map leaveGroup(long groupId, Callback callback) {
        return setGroupLeave(groupId, false, callback);
    }

    public Map leaveGroup(long groupId) {
        return setGroupLeave(groupId, false, null);
    }

    public Map setGroupLeave(long groupId, boolean dismiss) {
        return setGroupLeave(groupId, dismiss, null);
    }

    /**
     * 退出讨论组
     *
     * @param discussId 讨论组ID
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setDiscussLeave(long discussId, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetDiscussLeave.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("discuss_id", discussId);
        map.put("params", param);
        return map;
    }

    public Map setDiscussLeave(long discussId) {
        return setDiscussLeave(discussId, null);
    }

    /**
     * 添加好友请求
     *
     * @param flag    请求标志，数据上报时可获得
     * @param approve true 添加 false 拒绝添加
     * @param remark  添加后的好友备注（仅在同意时有效）
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setFriendAddRequest(String flag, boolean approve, String remark, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetFriendAddRequest.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("flag", flag);
        param.put("approve", approve);
        param.put("remark", remark);
        map.put("params", param);
        return map;
    }

    public Map agreeFriendAddRequest(String flag, String remark, Callback<Info> callback) {
        return setFriendAddRequest(flag, true, remark, callback);
    }

    public Map agreeFriendAddRequest(String flag, String remark) {
        return setFriendAddRequest(flag, true, remark, null);
    }

    public Map agreeFriendAddRequest(String flag, Callback callback) {
        return agreeFriendAddRequest(flag, "", callback);
    }

    public Map agreeFriendAddRequest(String flag) {
        return agreeFriendAddRequest(flag, "", null);
    }

    public Map rejectFriendAddRequest(String flag, Callback callback) {
        return setFriendAddRequest(flag, false, "", callback);
    }

    public Map rejectFriendAddRequest(String flag) {
        return setFriendAddRequest(flag, false, "", null);
    }

    /**
     * 群添加请求
     *
     * @param flag    请求标志，数据上报时可获得
     * @param type    add或invite，请求类型需和上报消息中sub_type相符
     * @param approve true 同意 false 拒绝
     * @param reason  拒绝理由，仅在拒绝时有效
     * @return coolq-http-api 插件返回内容对象
     */
    public Map setGroupAddRequest(String flag, String type, boolean approve, String reason, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetGroupAddRequest.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("flag", flag);
        param.put("type", type);
        param.put("approve", approve);
        param.put("reason", reason);
        map.put("params", param);
        return map;
    }

    public Map agreeGroupAddRequest(String flag, String type, Callback<Info> callback) {
        return setGroupAddRequest(flag, type, true, "", callback);
    }

    public Map agreeGroupAddRequest(String flag, String type) {
        return setGroupAddRequest(flag, type, true, "", null);
    }

    public Map rejectGroupAddRequest(String flag, String type, String reason, Callback<Info> callback) {
        return setGroupAddRequest(flag, type, false, reason, callback);
    }

    public Map rejectGroupAddRequest(String flag, String type, String reason) {
        return setGroupAddRequest(flag, type, false, reason, null);
    }

    public Map rejectGroupAddRequest(String flag, String type, Callback<Info> callback) {
        return rejectGroupAddRequest(flag, type, "", callback);
    }

    public Map rejectGroupAddRequest(String flag, String type) {
        return rejectGroupAddRequest(flag, type, "", null);
    }

    /**
     * 发送好友赞
     *
     * @param userId QQ号
     * @param times  赞的次数，每个好友每天最多 10 次
     * @return
     */
    public Map sendLike(long userId, short times, Callback<Info> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SendLike.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("user_id", userId);
        param.put("times", times);
        map.put("params", param);
        return map;
    }

    public Map sendLike(long userId, short times) {
        return sendLike(userId, times);
    }

    /**
     * 获取 CSRF Token 信息
     *
     * @return
     */
    public Map getCSRFToken(Callback<CSRFTokenInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetCSRFToken.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        map.put("params", param);
        return map;
    }

    /**
     * 获取插件运行状态信息
     *
     * @return
     */
    public Map getStatus(Callback<PluginStatusInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetStatus.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        map.put("params", param);
        return map;
    }

    /**
     * 清理数据目录
     *
     * @return
     */
    public Map cleanDataDir() {
        Map map = new HashMap<>();
        map.put("action", CQHttp.CleanDataDir.getValue());

//		SendQueue.put(new QQInfo(param,null));
        return map;
    }

    /**
     * 清理插件日志
     *
     * @return
     */
    public Map cleanPluginLog() {
        Map map = new HashMap<>();
        map.put("action", CQHttp.CleanPluginLog.getValue());
        return map;
    }

    /**
     * 重启 HTTP API 插件
     */
    public Map setRestartPlugin() {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetRestartPlugin.getValue());
        return map;
    }

    /**
     * 重启酷 Q，并以当前登录号自动登录（需勾选快速登录）
     */
    public Map setRestart() {
        Map map = new HashMap<>();
        map.put("action", CQHttp.SetRestart.getValue());
        return map;
    }

    /**
     * 获取陌生人信息
     *
     * @param userId  陌生人 QQ 号
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     * @return 陌生人信息实例对象
     */
    public Map getStrangerInfo(long userId, boolean noCache, Callback<StrangerInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetStrangerInfo.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("user_id", userId);
        param.put("no_cache", noCache);
        map.put("params", param);
        return map;
    }

    public Map getStrangerInfo(long userId, Callback<StrangerInfo> callback) {
        return getStrangerInfo(userId, true, callback);
    }

    /**
     * 获取群列表
     *
     * @return 群列表实例对象
     */
    public Map getGroupList(Callback<List<GroupInfo>> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetGroupList.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        map.put("params", param);
        return map;
    }

    /**
     * 获取群成员信息
     *
     * @param groupId 群号
     * @param userId  QQ 号（不可以是登录号）
     * @param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快） 默认 false
     * @return 群成员实例对象
     */
    public Map getGroupMemberInfo(long groupId, long userId, boolean noCache, Callback<GroupMemberInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetGroupMemberInfo.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        param.put("user_id", userId);
        param.put("no_cache", noCache);
        map.put("params", param);
        return map;
    }

    public Map getGroupMemberInfo(long groupId, long userId, Callback<GroupMemberInfo> callback) {
        return getGroupMemberInfo(groupId, userId, true, callback);
    }

    /**
     * 获取群成员列表
     *
     * @param groupId 群号
     * @return 群成员列表实例对象
     */
    public Map getGroupMemberList(long groupId, Callback<GroupMemberInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetGroupMemberList.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        map.put("params", param);
        return map;
    }

    /**
     * 获取登录信息
     *
     * @return 登录信息实例对象
     */
    public Map getLoginInfo(Callback<LoginInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetLoginInfo.getValue());
        map.put("callback", callback);
        return map;
    }

    /**
     * 获取登录Cookies信息
     *
     * @return Cookies信息实例对象
     */
    public Map getCookies(Callback<CookiesInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetCookies.getValue());
        map.put("callback", callback);
        return map;
    }

    /**
     * 获取酷 Q 及 HTTP API 插件的版本信息
     *
     * @return 酷 Q 及 HTTP API 插件的版本信息实例对象
     */
    public Map getVersionInfo(Callback<PluginAndCQHttpVersionInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetVersionInfo.getValue());
        map.put("callback", callback);
        return map;
    }

    /**
     * 获取语音信息
     *
     * @param file      收到的语音文件名，如 0B38145AA44505000B38145AA4450500.silk
     * @param outFormat 要转换到的格式，目前支持 mp3、amr、wma、m4a、spx、ogg、wav、flac
     * @return 语音信息实例对象
     */
    public Map getRecord(String file, String outFormat, Callback<RecordInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetRecord.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("file", file);
        param.put("out_format", outFormat);
        map.put("params", param);
        return map;
    }

    /**
     * 获取好友列表
     *
     * @param callback 回调函数
     */
    public Map _getFriendList(Callback<FriendInfo> callback) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetFriendList.getValue());
        map.put("callback", callback);
        return map;
    }


    /**
     * 获取群信息
     *
     * @param groupId  群号
     * @param callback 回调函数
     */
    public Map _getGroupInfo(long groupId, Callback<GroupInfo> callback) {
//		if (CQHttp.GetGroupInfo.isValidVersion(cqhttp.getCurVersion())) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetGroupInfo.getValue());
        map.put("callback", callback);

        Map param = new HashMap();
        param.put("group_id", groupId);
        map.put("params", param);
        return map;
//		} else {
        // 抛异常
//			throw new QQBotApiExecuteFailedException("当前 cqhttp 版本: v" + cqhttp.getCurVersion()
//					+ " 获取群信息 API 生效版本是"
//					+ CQHttp.GetGroupInfo.getEffectiveVersion()
//			);
//			return null;
//		}
    }

    /**
     * 获取 CSRF Token 和 Cookies 信息
     *
     * @return
     */
    public Map getCredentials(Callback callback) {
//		if (CQHttp.GetGroupInfo.isValidVersion(cqhttp.getCurVersion())) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.GetCredentials.getValue());
        map.put("callback", callback);
        return map;
//		} else {
        // 抛异常
//			throw new QQBotApiExecuteFailedException("当前 cqhttp 版本: v" + cqhttp.getCurVersion()
//					+ " 获取 CSRF Token 和 Cookies 信息 API 生效版本是"
//					+ CQHttp.GetCredentials.getEffectiveVersion()
//			);
//			return null;
//		}
    }

    public Map cleanPluginLog(Callback callback) {
//		if (CQHttp.GetGroupInfo.isValidVersion(cqhttp.getCurVersion())) {
        Map map = new HashMap<>();
        map.put("action", CQHttp.CleanPluginLog.getValue());
        map.put("callback", callback);
        return map;
//		} else {
        // 抛异常
//			throw new QQBotApiExecuteFailedException("当前 cqhttp 版本: v" + cqhttp.getCurVersion()
//					+ " 清空 CQHttp Plugin 日志 API 生效版本是"
//					+ CQHttp.CleanDataDir.getEffectiveVersion()
//			);
//			return null;
//		}
    }
}
