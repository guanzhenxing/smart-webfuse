package net.webfuse.common.exception;

import net.webfuse.common.util.mapper.JsonMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础业务异常
 */
public class BasicBizException extends RuntimeException {

    private int status;
    private String code;
    private String message;
    private Throwable cause;

    public BasicBizException(int status, String code, String message, Throwable cause) {
        super(buildMsg(status, code, message), cause);
        this.status = status;
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

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

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    private static String buildMsg(int status, String code, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status == 0 ? 500 : status);
        map.put("code", StringUtils.isEmpty(code) ? "INTERNAL_SERVER_ERROR" : code);
        map.put("message", message);
        return JsonMapper.toJsonString(map);
    }
}
