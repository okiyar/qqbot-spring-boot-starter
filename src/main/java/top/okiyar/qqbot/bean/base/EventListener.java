package top.okiyar.qqbot.bean.base;

import top.okiyar.qqbot.components.Bot;

public abstract class EventListener<E extends Event> {

    /**
     * 处理上报事件
     *
     * @param event 上报事件
     */
    public abstract void dealEvent(E event, Bot bot);

    /**
     * 获取监听事件类型
     */
    public abstract Class getEventType();
}
