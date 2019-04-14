package top.okiyar.qqbot.enums;

import lombok.Getter;

/**
 * 鉴于 CqHttp 稳定性和从 3.0 版本才引入 WebSocket 通信方式考虑
 * 只做兼容 3.0.0 以上的版本处理
 */
@Getter
public enum CQHttp {
    /*
            解析思路：第一步：判断 retcode，若存在所列值则进入相应子判断是否含有 data 数据判断是否是数据查询。否则进入第二步
                     第二步：判断 post_type:message|request|notice
                           1.判断message_type:private|group
                           2.判断notice_type:group_upload|group_admin|group_decrease|group_increase
                           3.判断sub_type:set|unset
    */

    /**
     * CQHttp 接口字段属性
     */
    SendPrivateMsg("send_private_msg"),                    // 私聊消息
    SendGroupMsg("send_group_msg"),                        // 群消息
    SendDiscussMsg("send_discuss_msg"),                    // 讨论组消息
    SendMsg("send_msg"),                                // 自定义发送消息

    SetGroupKick("set_group_kick"),                        // 踢人
    SetGroupBan("set_group_ban"),                        // 禁言非匿名成员
    SetGroupWholeBan("set_group_whole_ban"),            // 设置全员禁言
    SetGroupAdmin("set_group_admin"),                    // 设置管理员
    SetGroupCard("set_group_card"),                        // 设置群名片
    SetGroupSpecialTitle("set_group_special_title"),    // 设置群组专属头衔
    SetGroupLeave("set_group_leave"),                    // 退群
    SetDiscussLeave("set_discuss_leave"),                // 退出讨论组

    SetFriendAddRequest("set_friend_add_request"),        // 设置添加好友请求
    SetGroupAddRequest("set_group_add_request"),        // 设置加群请求

    SendLike("send_like"),                                // 点赞
    SetGroupAnonymous("set_group_anonymous"),            // 设置匿名功能
    SetGroupAnonymousBan("set_group_anonymous_ban"),    // 禁言匿名成员

    GetStrangerInfo("get_stranger_info"),                // 获取陌生人信息
    GetGroupList("get_group_list"),                        // 获取群列表
    GetGroupMemberInfo("get_group_member_info"),        // 获取群成员信息
    GetGroupMemberList("get_group_member_list"),        // 获取群成员列表
    GetLoginInfo("get_login_info"),                        // 获取登录信息
    GetCookies("get_cookies"),                            // 获取 cookies
    GetVersionInfo("get_version_info"),                    // 获取酷q和http api 插件版本信息
    GetCSRFToken("get_csrf_token"),                        // 获取 csrf token
    GetStatus("get_status"),                            // 获取插件运行状态

    SetRestart("set_restart", "3.0.2"),                            // 获取好友列表
    SetRestartPlugin("set_restart_plugin", "3.2.0"),                // 重启酷Q和 HttpAPI 插件（并以当前账号自动登录，需要开启自动登录）
    GetFriendList("_get_friend_list", "3.0.2"),                    // 重启 httpapi 插件
    DeleteMsg("delete_msg", "3.3.0"),                            // 撤回消息
    GetRecord("get_record", "3.3.0"),                            // 获取语音
    CleanDataDir("clean_data_dir", "3.3.4"),                        // 清理数据目录

    GetGroupInfo("_get_group_info ", "4.0.1"),                    // 获取群信息
    CleanPluginLog("clean_plugin_log", "4.1.0"),                    // 清理插件日志
    GetCredentials("get_credentials", "4.3.0"),                    // 获取 qq 相关接口凭证

    // ------ 自定义字段字段属性区 ------
    AccountVerification("account-verification", "4.0.0"),

    /**
     * CQHttp 上报事件字段属性
     */

    // ------ 返回结果字段属性区 ------
    Data("data"),

    // get_group_list
    GroupId("group_id"),
    GroupName("group_name"),

    // get_stranger_info

    RetCode("retcode"),
    Status("status"),

    PostType("post_type"),
    Message("message"),
    Request("request"),
    Notice("notice"),
    MessageType("message_type"),
    Private("private"),
    Group("group"),
    NoticeType("notice_type"),
    GroupUpload("group_upload"),
    GroupAdmin("group_admin"),
    GroupDecrease("group_decrease"),
    GroupIncrease("group_increase"),
    SubType("sub_type"),
    Set("set"),
    Unset("uset");


    /**
     * 字段属性值
     */
    private String value;

    /**
     * 字段属性开始生效版本
     * 默认3.0.0版本开始生效
     */
    private String effectiveVersion = "3.0.0";

    /**
     * 字段属性失效版本
     */
    private String invalidVersion;

    private String description;

    CQHttp(String value) {
        this.value = value;
    }

    CQHttp(String value, String effectiveVersion) {
        this.value = value;
        this.effectiveVersion = effectiveVersion;
    }

    CQHttp(String value, String effectiveVersion, String invalidVersion) {
        this.value = value;
        this.effectiveVersion = effectiveVersion;
        this.invalidVersion = invalidVersion;
    }

    /**
     * 匹配当前字段属性当前 CQHttp 是否有效
     *
     * @param currentCQHttpVersion 当前 CQHttp 版本
     */
    public boolean isValidVersion(String currentCQHttpVersion) {
        String cv = currentCQHttpVersion.replaceAll("\\.", "");
        String ev = effectiveVersion.replaceAll("\\.", "");

        int r1 = Integer.compare(Integer.parseInt(cv), Integer.parseInt(ev));
        if (invalidVersion != null) {
            String iv = invalidVersion.replaceAll("\\.", "");
            int r2 = Integer.compare(Integer.parseInt(cv), Integer.parseInt(iv));
            System.out.println(iv);
            return r1 >= 0 && r2 <= 0;
        }

        return r1 >= 0;
    }
}
