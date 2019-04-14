package top.okiyar.qqbot.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "spring.qqbot")
@Data
public class QQBotProperties {

    private Http http;
    private WebSocket ws;
    private String accessToken = "";

    public QQBotProperties() {
        this.http = new Http();
        this.ws = new WebSocket();
    }

    @Data
    public static class Http {

        private Boolean enable = false;
        private String url = "/cqhttp";
        private Map<Long, String> postUrls;

    }

    @Data
    public static class WebSocket {

        private Boolean enable = true;
        private String apiUrl = "/cqhttp/api";
        private String eventUrl = "/cqhttp/event";

    }
}
