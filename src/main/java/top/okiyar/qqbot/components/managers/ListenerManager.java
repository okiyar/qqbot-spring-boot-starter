package top.okiyar.qqbot.components.managers;

import top.okiyar.qqbot.bean.base.Event;
import top.okiyar.qqbot.bean.base.EventListener;
import top.okiyar.qqbot.components.Bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListenerManager {
    /**
     * key：监听器类名用于归类多个同种监听器
     * value：监听器集合
     */
    private Map<String, List<EventListener>> listenerMap = new HashMap<>();

    public synchronized ListenerManager addListener(EventListener l) {
        List<EventListener> ll = listenerMap.get(l.getEventType().getSimpleName());
        if (ll == null) {
            ll = new ArrayList<>();
            ll.add(l);
            listenerMap.put(l.getEventType().getSimpleName(), ll);
        } else {
            ll.add(l);
        }
        return this;
    }

    public void matchesListener(Event event, Bot bot) {
        List<EventListener> eventListeners = listenerMap.get(event.getClass().getSimpleName());
        if (eventListeners != null) {
            // 是只允许相同监听器仅有一个 还是多个 用于后面的扩展注解
            eventListeners.forEach(listener -> listener.dealEvent(event, bot));
        }
    }
}
