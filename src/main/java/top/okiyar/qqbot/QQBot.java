package top.okiyar.qqbot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.okiyar.qqbot.components.managers.Admin;
import top.okiyar.qqbot.components.managers.BotManager;
import top.okiyar.qqbot.components.managers.ListenerManager;

@AllArgsConstructor
@Getter
public class QQBot {

    /**
     * 多账号QQ实例管理器
     */
    private BotManager botManager;

    /**
     * 管理员
     */
    private Admin admin;

    private ListenerManager listenerManager;
}
