package cn.webfuse.framework.security;

import cn.webfuse.framework.exception.AbstractBizException;

public class AuthenticationTokenException extends AbstractBizException {
    public AuthenticationTokenException(int status, String code, String message, Throwable throwable, String developerMessage) {
        super(status, code, message, throwable, developerMessage);
    }

    public AuthenticationTokenException(int status, String code, String message, Throwable throwable) {
        super(status, code, message, throwable);
    }

    public AuthenticationTokenException(int status, String code, String message) {
        super(status, code, message);
    }
}
