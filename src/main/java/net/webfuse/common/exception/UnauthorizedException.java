package net.webfuse.common.exception;

/**
 * 未授权异常
 *  Created by guanzhenxing on 2018/1/5.
 */
public class UnauthorizedException extends BasicBizException {

    private static final ErrorMsg errorMsg = ErrorMsg.UNAUTHORIZED;

    public UnauthorizedException(int status, String code, String message, Throwable cause) {
        super(status, code, message, cause);
    }

    public UnauthorizedException(String message, Throwable cause) {
        this(errorMsg.getStatus(), errorMsg.getCode(), message, cause);
    }

    public UnauthorizedException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

}
