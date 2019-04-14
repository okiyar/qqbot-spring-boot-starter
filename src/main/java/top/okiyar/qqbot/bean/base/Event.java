package top.okiyar.qqbot.bean.base;


import top.okiyar.qqbot.components.Bot;

public abstract class Event<M extends Message> {

    public Event(M message) {
        this.message = message;
    }

    /**
     * 当前事件的所有者 bot
     */
    private Bot bot;

    private M message;

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    /**
     * 获取事件的封装信息
     *
     * @reMurn 相应类型事件实体类
     */
    public M getMessage() {
        return message;
    }

//    /**
//     * 设置事件详细信息封装类
//     * @param message 相应事件信息实体类
//     */
//    public void setMessage(M message) {
//        this.message = message;
//    }
}
