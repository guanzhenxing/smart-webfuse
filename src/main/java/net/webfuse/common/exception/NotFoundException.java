package net.webfuse.common.exception;

/**
 * 资源未发现异常
 * Created by guanzhenxing on 2018/1/5.
 */
public class NotFoundException extends BasicBizException {

    private static final ErrorMsg errorMsg = ErrorMsg.NOT_FOUND;

    public NotFoundException(int status, String code, String message, Throwable cause) {
        super(status, code, message, cause);
    }

    public NotFoundException(String message, Throwable cause) {
        this(errorMsg.getStatus(), errorMsg.getCode(), message, cause);
    }

    public NotFoundException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public NotFoundException(String message) {
        this(message, null);
    }
}
