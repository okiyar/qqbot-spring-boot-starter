package top.okiyar.qqbot.components;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import top.okiyar.qqbot.bean.base.Info;
import top.okiyar.qqbot.base.Callback;

import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Sender implements Observer {
    /**
     * 当前 Bot WebSocket Session
     */
    private WebSocketSession session;

    /**
     * 保存回调函数集合
     */
    private Map<String, Callback> callbackMap = new ConcurrentHashMap<>();

    public Sender(WebSocketSession session) {
        this.session = session;
    }

    public void send(String jsonMsg) throws IOException {
        System.out.println(jsonMsg);
        session.sendMessage(new TextMessage(jsonMsg));
    }

    public void callback(Info info) {
        // 多线程
        callbackMap.get(info.getEcho()).onMessage(info);
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    @Override
    public void update(Observable o, Object arg) {
        Map map = (Map) arg;
        // 生成 echo
        UUID echo = UUID.randomUUID();
        Callback callback = (Callback) map.remove("callback");
        if (callback != null) {
            callbackMap.put(echo.toString(), callback);
        }

        try {
            String jsonMsg = new ObjectMapper().writeValueAsString(map);
            this.send(jsonMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
