package net.webfuse.common.exception;

/**
 * Created by guanzhenxing on 2018/1/5.
 */
public class BadRequestException extends BasicBizException {

    private static final ErrorMsg errorMsg = ErrorMsg.BAD_REQUEST;

    public BadRequestException(String message, Throwable cause) {
        super(errorMsg.getStatus(), errorMsg.getCode(), message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(errorMsg.getStatus(), errorMsg.getCode(), cause.getMessage(), cause);
    }


}
