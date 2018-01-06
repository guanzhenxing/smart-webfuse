package net.webfuse.common.exception;

/**
 * 拒绝请求异常
 * Created by guanzhenxing on 2018/1/5.
 */
public class ForbiddenException extends BasicBizException {

    private static final ErrorMsg errorMsg = ErrorMsg.FORBIDDEN;

    public ForbiddenException(int status, String code, String message, Throwable cause) {
        super(status, code, message, cause);
    }

    public ForbiddenException(String message, Throwable cause) {
        this(errorMsg.getStatus(), errorMsg.getCode(), message, cause);
    }

    public ForbiddenException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    public ForbiddenException(String message) {
        this(message, null);
    }
}
