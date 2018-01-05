package net.webfuse.common.exception;

/**
 * 错误的请求异常
 * Created by guanzhenxing on 2018/1/5.
 */
public class BadRequestException extends BasicBizException {

    private static final ErrorMsg errorMsg = ErrorMsg.BAD_REQUEST;

    public BadRequestException(int status, String code, String message, Throwable cause) {
        super(status, code, message, cause);
    }

    public BadRequestException(String message, Throwable cause) {
        this(errorMsg.getStatus(), errorMsg.getCode(), message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(errorMsg.getStatus(), errorMsg.getCode(), cause.getMessage(), cause);
    }


}
