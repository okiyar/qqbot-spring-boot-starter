package top.okiyar.qqbot.exceptions;

public class QQBotParseCQHttpJsonMsgException extends Exception {
    private String parseErrorJsonMsg;

    public QQBotParseCQHttpJsonMsgException(String parseErrorJsonMsg) {
        this.parseErrorJsonMsg = parseErrorJsonMsg;
    }

    public QQBotParseCQHttpJsonMsgException(String message, String parseErrorJsonMsg) {
        super(message);
        this.parseErrorJsonMsg = parseErrorJsonMsg;
    }

    public QQBotParseCQHttpJsonMsgException(String message, Throwable cause, String parseErrorJsonMsg) {
        super(message, cause);
        this.parseErrorJsonMsg = parseErrorJsonMsg;
    }

    public QQBotParseCQHttpJsonMsgException(Throwable cause, String parseErrorJsonMsg) {
        super(cause);
        this.parseErrorJsonMsg = parseErrorJsonMsg;
    }

    public QQBotParseCQHttpJsonMsgException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String parseErrorJsonMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.parseErrorJsonMsg = parseErrorJsonMsg;
    }

    public String getParseErrorJsonMsg() {
        return parseErrorJsonMsg;
    }

    public void setParseErrorJsonMsg(String parseErrorJsonMsg) {
        this.parseErrorJsonMsg = parseErrorJsonMsg;
    }
}
