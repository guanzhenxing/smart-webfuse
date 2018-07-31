package cn.webfuse.framework.exception;


public class BizException extends BaseException {

    private int status;
    private String errorCode;
    private String message;
    private Throwable throwable;
    private String developerMessage;

    public BizException(int status, String errorCode, String message, Throwable throwable, String developerMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.throwable = throwable;
        this.developerMessage = developerMessage;
    }

    public BizException(int status, String errorCode, String message, Throwable throwable) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
        this.throwable = throwable;
    }

    public BizException(int status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
