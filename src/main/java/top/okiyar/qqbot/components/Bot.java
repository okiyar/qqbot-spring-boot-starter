package top.okiyar.qqbot.components;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.okiyar.qqbot.base.QQApi;
import top.okiyar.qqbot.components.managers.EventManager;
import top.okiyar.qqbot.components.managers.FriendManager;
import top.okiyar.qqbot.components.managers.GroupManager;

@Getter
@Setter
@ToString
public class Bot {

    /**
     * 标识 QQ Bot 在线状态
     */
    private boolean isOffLine;

    /**
     * 标识 Bot 是否与 CQHttp 连接中
     */
    private boolean isLost;

    /**
     * Bot 插件版本
     */
    private String botPluginVersion;

    /**
     * Bot QQ号
     */
    private Long botId;

    /**
     * Bot 昵称
     */
    private String botName;

    /**
     * Bot 别名
     */
    private String botAlias;

    /**
     * 事件管理器
     */
    private EventManager eventManager;

    /**
     * 好友管理器
     */
    private final FriendManager friendManager = new FriendManager(this);

    /**
     * 群管理器
     */
    private GroupManager groupManager = new GroupManager(this);

    /**
     * 消息发送器
     */
    private Sender sender;

    /**
     * CQHttp 支持的 QQ Api 封装
     */
    private QQApi qqApi;
}
