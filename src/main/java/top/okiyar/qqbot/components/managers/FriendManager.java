package top.okiyar.qqbot.components.managers;

import top.okiyar.qqbot.bean.info.FriendInfo;
import top.okiyar.qqbot.components.Bot;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例 Bot 好友管理器
 */
public class FriendManager {
    /**
     * 当前好友管理器所有者bot
     */
    private Bot bot;

    /**
     * 标识好友缓存是否处于刷新中
     */
    private boolean isRefreshing;

    /**
     * 缓存好友信息
     * Key: 好友QQ号
     * Value：好友信息封装类
     */
    private ConcurrentHashMap<Long, FriendInfo> friendInfoMap;

    public FriendManager(Bot bot) {
    }

    public FriendManager(Bot bot, ConcurrentHashMap<Long, FriendInfo> friendInfoMap) {
        this.bot = bot;
        this.friendInfoMap = friendInfoMap;
    }

    /**
     * 获取好友信息
     *
     * @param friendId 好友QQ
     */
    public FriendInfo getFriend(long friendId) {
        return isRefreshing ? null : friendInfoMap.get(friendId);
    }

    /**
     * 判断好友是否在好友集合中
     *
     * @param friendId 好友QQ
     */
    public Boolean isInFriendList(long friendId) {
        return isRefreshing ? null : friendInfoMap.containsKey(friendId);
    }

    /**
     * 刷新好友缓存信息
     */
    public void refresh() {
    }
}
