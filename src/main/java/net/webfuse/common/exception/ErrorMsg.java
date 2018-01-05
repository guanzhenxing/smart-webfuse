package net.webfuse.common.exception;

/**
 * 异常的枚举
 */
public enum ErrorMsg {

    BAD_REQUEST(400, "Bad Request", ""),
    UNAUTHORIZED(401, "Unauthorized", ""),
    FORBIDDEN(403, "Forbidden", ""),
    NOT_FOUND(404, "Not Found", ""),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed", ""),
    NOT_ACCEPTABLE(406, "Not Acceptable", ""),
    CONFLICT(409, "Conflict", ""),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type", ""),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", ""),
    NOT_IMPLEMENTED(501, "Not Implemented", ""),
    SERVICE_UNAVAILABLE(503, "Service Unavailable", ""),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported", "");

    ErrorMsg(int status, String code, String message) {
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
