package cn.webfuse.framework.exception;

public class NotFoundBizException extends AbstractBizException {
    public NotFoundBizException(int status, String errorCode, String message, Throwable throwable, String developerMessage) {
        super(status, errorCode, message, throwable, developerMessage);
    }

    public NotFoundBizException(int status, String errorCode, String message, Throwable throwable) {
        super(status, errorCode, message, throwable);
    }

    public NotFoundBizException(int status, String errorCode, String message) {
        super(status, errorCode, message);
    }
}
