package net.webfuse.common.exception;

/**
 * 异常的枚举
 */
public enum ExceptionMsg {

    NOT_FOUND(404, "NOT_FOUND", "没有找到对应的资源"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR", "服务器内部错误");

    ExceptionMsg(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    private int status;
    private String code;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
