package top.okiyar.qqbot.components.managers;

import lombok.ToString;
import top.okiyar.qqbot.components.Bot;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多实例QQBot管理器
 */
@ToString
public class BotManager {
    /**
     * 多实例Bot集合
     * Key: Bot QQ号
     * Value: Bot对象
     */
    private ConcurrentHashMap<Long, Bot> bots = new ConcurrentHashMap<>();

    public Bot createBotAndSave(Map<String, Object> headers) {
        Long botId = (Long) headers.get("self-id");
        String userAgen = (String) headers.get("user-agent");
        String clientRole = (String) headers.get("client-role");
        String accessToken = (String) headers.get("accessToken");



        Bot bot = new Bot();

        return  bot;
    }

    /**
     * 获取Bot
     *
     * @param botId bot QQ号
     */
    public Bot getBot(long botId) {
        return bots.get(botId);
    }

    /**
     * 添加Bot
     * 注：只添加 API WS 客户端 Bot
     *
     * @param bot Bot对象
     */
    public void addBot(Bot bot) {
        if (!bots.containsKey(bot.getBotId())) {
            bots.put(bot.getBotId(), bot);
        }
    }

    /**
     * 移除Bot对象
     *
     * @param botId bot QQ号
     */
    public void removeBot(long botId) {
        bots.remove(botId);
    }

    public int getBotSize() {
        return bots.size();
    }

    public boolean isInBotList(long botId) {
        return bots.containsKey(botId);
    }

    /**
     * 获取所有Bot
     */
    public List<Bot> getBots() {
        List<Bot> list = new ArrayList<>();
        Enumeration<Bot> elements = bots.elements();
        while (elements.hasMoreElements()) {
            list.add(elements.nextElement());
        }
        return list;
    }
}
