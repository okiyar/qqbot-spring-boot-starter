package top.okiyar.qqbot.autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import top.okiyar.qqbot.QQBot;
import top.okiyar.qqbot.components.QQBotHttpHandlerInterceptor;
import top.okiyar.qqbot.components.QQBotWebSocketHandler;
import top.okiyar.qqbot.components.QQBotWebSocketHandshakeInterceptor;
import top.okiyar.qqbot.components.managers.Admin;
import top.okiyar.qqbot.components.managers.BotManager;
import top.okiyar.qqbot.components.managers.ListenerManager;
import top.okiyar.qqbot.properties.QQBotProperties;

@Configuration
@EnableWebSocket
@ConditionalOnProperty(prefix = "spring.qqbot", value = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(QQBotProperties.class)
public class QQBotAutoConfiguration {

    /**
     * 注意：若使用独立的servlet容器，而不是直接使用springboot的内置容器，
     * 就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理。
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    @ConditionalOnMissingBean
    public ListenerManager listenerManager() {
        return new ListenerManager();
    }

    @Bean
    @ConditionalOnMissingBean
    public BotManager botManager() {
        return new BotManager();
    }

    @Bean
    @ConditionalOnMissingBean
    public Admin getAdmin() {
        return new Admin();
    }

    @Bean
    @ConditionalOnMissingBean
    public QQBot qqBot(BotManager botManager, Admin admin, ListenerManager listenerManager) {
        return new QQBot(botManager, admin, listenerManager);
    }

    @Configuration
    public static class WebSocketAndHttpConfiguration  implements WebSocketConfigurer, WebMvcConfigurer {

        @Autowired
        private QQBot qqBot;

        @Autowired
        private QQBotProperties properties;

        /**
         * 注册QQBot WebSocket处理器
         */
        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
            webSocketHandlerRegistry
                    .addHandler(new QQBotWebSocketHandler(qqBot),
                            properties.getWs().getApiUrl(),
                            properties.getWs().getEventUrl())
                    // 添加拦截器
                    .addInterceptors(new QQBotWebSocketHandshakeInterceptor(qqBot))
                    .setAllowedOrigins("*");

            System.out.println(properties);
        }

        /**
         * 注册QQBot Http拦截器
         */
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new QQBotHttpHandlerInterceptor())
                    .addPathPatterns(properties.getHttp().getUrl());
        }
    }
}
