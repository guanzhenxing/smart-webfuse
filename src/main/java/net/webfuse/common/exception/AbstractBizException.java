package net.webfuse.common.exception;

public abstract class AbstractBizException extends RuntimeException {

    public AbstractBizException() {
    }

    public AbstractBizException(String message) {
        super(message);
    }

    public AbstractBizException(Throwable cause) {
        super(cause);
    }

    public AbstractBizException(String message, Throwable cause) {
        super(message, cause);
    }

}
