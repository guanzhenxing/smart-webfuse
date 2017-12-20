package net.webfuse.common.exception;

/**
 * 业务异常
 */
public class BizException extends AbstractBizException {

    private int status;
    private String bizCode;
    private String message;
    private Throwable cause;

    public BizException(String message) {
        this(500, "INTERNAL_SERVER_ERROR", message);
    }

    public BizException(String message, Throwable cause) {
        this(500, "INTERNAL_SERVER_ERROR", message, cause);
    }

    public BizException(int status, String bizCode, String message) {
        this(500, "INTERNAL_SERVER_ERROR", message, null);
    }

    public BizException(int status, String bizCode, String message, Throwable cause) {
        super(status + "||" + bizCode + "||" + message, cause);
        this.status = status;
        this.bizCode = bizCode;
        this.message = message;
        this.cause = cause;
    }

    public int getStatus() {
        return status;
    }

    public String getBizCode() {
        return bizCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
