package top.okiyar.qqbot.exceptions;

public class QQBotRequestMappingSetFailedException extends Exception {
    public QQBotRequestMappingSetFailedException() {
    }

    public QQBotRequestMappingSetFailedException(String message) {
        super(message);
    }

    public QQBotRequestMappingSetFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public QQBotRequestMappingSetFailedException(Throwable cause) {
        super(cause);
    }

    public QQBotRequestMappingSetFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
