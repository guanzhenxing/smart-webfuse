package net.webfuse.common.exception;

/**
 * 异常的枚举
 */
public enum ErrorMsg {

    BAD_REQUEST(400, "Bad Request", "语义有误，当前请求无法被服务器理解"),
    UNAUTHORIZED(401, "Unauthorized", "当前请求需要用户验证"),
    FORBIDDEN(403, "Forbidden", "服务器拒绝了该请求"),
    NOT_FOUND(404, "Not Found", "请求失败，请求所希望得到的资源未被在服务器上发现"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed", "请求行中指定的请求方法不能被用于请求相应的资源"),
    NOT_ACCEPTABLE(406, "Not Acceptable", "请求的资源的内容特性无法满足请求头中的条件"),
    CONFLICT(409, "Conflict", "由于和被请求的资源的当前状态之间存在冲突，请求无法完成"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type", "请求中提交的实体并不是服务器中所支持的格式，因此请求被拒绝"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "服务器错误"),
    NOT_IMPLEMENTED(501, "Not Implemented", "当服务器无法识别请求的方法，并且无法支持其对任何资源的请求"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable", "由于临时的服务器维护或者过载，服务器当前无法处理请求"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported", "服务器不支持在请求中使用的 HTTP 版本");

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
