package top.okiyar.qqbot.base;


public abstract  class Callback<T> {
    /**
     * 成功回调
     * @param info 查询结果
     */
    public abstract void onMessage(T info);

    /**
     * 失败回调
     */
    public void onError(String errorReason) {};
}
