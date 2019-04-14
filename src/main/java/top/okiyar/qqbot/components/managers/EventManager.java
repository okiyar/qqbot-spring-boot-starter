package top.okiyar.qqbot.components.managers;

import lombok.extern.slf4j.Slf4j;
import top.okiyar.qqbot.QQBot;
import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.base.Info;
import top.okiyar.qqbot.components.Bot;
import top.okiyar.qqbot.components.Handler;
import top.okiyar.qqbot.exceptions.QQBotParseCQHttpJsonMsgException;
import top.okiyar.qqbot.utils.Executors;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class EventManager {

    QQBot qqBot;

    Bot bot;

    public EventManager(QQBot qqBot, Bot bot) {
        this.qqBot = qqBot;
        this.bot = bot;
    }

    /**
     * 暂时保存 CQHttp 上报消息集合
     * 避免多次处理 Http 和 WebSocket同时上报的重复消息
     */
    private Set<String> jsonMsgSet = new HashSet<>();

    private Handler handler = new Handler();

    public void addJsonMsgToSet(String jsonMsg) {
        // 目的过滤 Http 和 WebSocket 重复上报消息
        boolean ret = jsonMsgSet.add(jsonMsg);
        if (ret) {
            Executors.getCashedThreadPool().execute(() -> {
                this.parseEvent(jsonMsg);
            });
        }
    }

    private void parseEvent(String jsonMsg) {
        try {
            Object o = handler.parseJsonMsg(jsonMsg);
            if (o instanceof Info) {
                Info info = (Info) o;
                // 信息
                System.out.println("info...");
            } else if (o instanceof Event) {
                // 事件
                Event event = (Event) o;

                System.out.println("处理消息 bot信息:" + bot);
                qqBot.getListenerManager().matchesListener(event, bot);

                log.info("event..." + event.getMessage());
//                new QQApi().sendPrivateMsg(384758755,event.getMessage().toString());
            }
        } catch (QQBotParseCQHttpJsonMsgException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 移除消息
        jsonMsgSet.remove(jsonMsg);
    }
}
