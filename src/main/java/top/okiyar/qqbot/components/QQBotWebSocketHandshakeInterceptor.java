package top.okiyar.qqbot.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import top.okiyar.qqbot.QQBot;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

/**
 * QQBot Websocket 链接拦截器
 */
@Slf4j
public class QQBotWebSocketHandshakeInterceptor implements HandshakeInterceptor {

    QQBot qqBot;

    public QQBotWebSocketHandshakeInterceptor(QQBot qqBot) {
        this.qqBot = qqBot;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        InetSocketAddress remoteAddress = serverHttpRequest.getRemoteAddress();
        HttpHeaders headers = serverHttpRequest.getHeaders();
        log.info("收到 {} WebSocket 三次握手 {} 请求", remoteAddress, serverHttpRequest.getMethodValue());

        log.info("{} 请求头信息 {}", remoteAddress, headers);
        String accessToken = "", userAgent = "", botId = "", clientRole = "";
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String k = entry.getKey();
            List<String> v = entry.getValue();
            String value = v.get(0);
            switch (k.toLowerCase()) {
                case "user-agent":
                    userAgent = value;
                    break;
                case "x-self-id":
                    botId = value;
                    break;
                case "x-client-role":
                    clientRole = value;
                    break;
                case "authorization":
                    accessToken = value.split(" ")[1];
                    break;
            }
        }

        log.info("开始验证 {} 请求头信息.....", remoteAddress);
        // 验证CQHttp WebSocket链接参数
        if (userAgent.startsWith("CQHttp")
                && botId.matches("[1-9]\\d{4,9}")
                && clientRole.matches("API|Event")) {
            // 若设置 access_token 则比较 token
            if (accessToken != null) {

            }

            map.put("self-id",botId);
            map.put("user-agent",userAgent);
            map.put("client-role",clientRole);

            log.info("检查到 {} 是一次合法的 CQHttp WebSocket 请求，验证通过，即将放行！", remoteAddress);
            return true;
        }
        log.info("检查到 {} 是一次非法的 WebSocket 请求，验证不通过，即将关闭连接！", remoteAddress);
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
    }
}
