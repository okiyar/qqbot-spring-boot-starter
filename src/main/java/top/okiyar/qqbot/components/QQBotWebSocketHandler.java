package top.okiyar.qqbot.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import top.okiyar.qqbot.QQBot;
import top.okiyar.qqbot.base.QQApi;
import top.okiyar.qqbot.bean.base.Message;
import top.okiyar.qqbot.bean.event.BotOfflineEvent;
import top.okiyar.qqbot.bean.event.BotOnlineEvent;
import top.okiyar.qqbot.components.Bot;
import top.okiyar.qqbot.components.Sender;
import top.okiyar.qqbot.components.managers.EventManager;
import top.okiyar.qqbot.utils.Executors;

import java.util.Map;

/**
 * QQBot Websocket处理器
 */
@Slf4j
public class QQBotWebSocketHandler extends TextWebSocketHandler {

    private QQBot qqBot;

    public QQBotWebSocketHandler(QQBot qqBot) {
        this.qqBot = qqBot;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        Map<String, Object> attributes = webSocketSession.getAttributes();
        long botId = Long.parseLong((String) attributes.get("self-id"));

        // 实例化 Bot
        // 判断是否断线重连
        Bot bot = qqBot.getBotManager().getBot(botId);
        if (bot != null) {
            if (bot.isLost()) {
                bot.getSender().setSession(webSocketSession);
                bot.setLost(false);
            }
        }

        if ("Api".equalsIgnoreCase((String) attributes.get("client-role"))) {
            bot = new Bot();
            bot.setBotId(botId);
            bot.setBotPluginVersion(((String) attributes.get("user-agent")).split("/")[1]);
            bot.setEventManager(new EventManager(qqBot, bot));
            Sender sender = new Sender(webSocketSession);
            QQApi qqApi = new QQApi(sender);
            bot.setQqApi(qqApi);
            bot.setSender(sender);
            qqBot.getBotManager().addBot(bot);

            if (!bot.isOffLine()) {
                Message message = new Message() {
                };
                message.setSelfId(bot.getBotId());
                message.setTime(System.currentTimeMillis());
                Bot finalBot = bot;
                Executors.getCashedThreadPool().execute(() -> qqBot.getListenerManager().
                        matchesListener(new BotOnlineEvent(message), finalBot));
            }
        }

        log.info("成功与 BotId[{}] {} 客户端建立连接，准备接收消息！", botId, webSocketSession.getAttributes().get("client-role"));
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        Map<String, Object> attributes = webSocketSession.getAttributes();

        String jsonMsg = (String) webSocketMessage.getPayload();

        // Bot 处理消息
        Bot bot = qqBot.getBotManager().getBot(Long.parseLong(((String) attributes.get("self-id"))));


        bot.getEventManager().addJsonMsgToSet(jsonMsg);

        log.info("收到 BotId[{}] {} 客户端一条长度 {} 的消息: {}",
                attributes.get("self-id"), attributes.get("client-role"),
                jsonMsg.length(), jsonMsg);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        Map<String, Object> attributes = webSocketSession.getAttributes();

        Bot bot = qqBot.getBotManager().getBot(Long.parseLong(((String) attributes.get("self-id"))));
        bot.setLost(true);

        webSocketSession.close();

        log.info("BotId[{}] {} 客户端底层传输信息异常，服务端断开与其链接!", attributes.get("self-id"), attributes.get("client-role"));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        Map<String, Object> attributes = webSocketSession.getAttributes();

        Bot bot = qqBot.getBotManager().getBot(Long.parseLong(((String) attributes.get("self-id"))));
        bot.setLost(true);

        if ("Api".equalsIgnoreCase((String) attributes.get("client-role")) && !bot.isOffLine()) {
            Message message = new Message() {
            };
            message.setSelfId(bot.getBotId());
            message.setTime(System.currentTimeMillis());
            Executors.getCashedThreadPool().execute(() -> qqBot.getListenerManager().
                    matchesListener(new BotOfflineEvent(message), bot));
        }

        log.info("BotId[{}] {} 客户端与服务端断开连接! 关闭码[{}] 原因[{}]",
                attributes.get("self-id"), attributes.get("client-role"),
                closeStatus.getCode(), closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
