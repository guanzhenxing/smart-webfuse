package net.webfuse.common.exception.exhandler;

import net.webfuse.common.exception.BasicBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@ControllerAdvice
public class GlobalRestfulExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalRestfulExceptionHandler.class);

    @ExceptionHandler(value = {RuntimeException.class})
    ResponseEntity<Object> handleRuntimeException(HttpServletRequest request, RuntimeException ex) {
        RestfulError bodyOfResponse = getRestfulError(ex, request, HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(), "INTERNAL_SERVER_ERROR", ex.getCause().toString());
        return handleExceptionInternal(bodyOfResponse);
    }

    @ExceptionHandler(value = {BasicBizException.class})
    ResponseEntity<Object> handleBasicBizException(HttpServletRequest request, BasicBizException ex) {
        RestfulError bodyOfResponse = buildErrorResponseBody(ex, request);
        return handleExceptionInternal(bodyOfResponse);
    }

    private ResponseEntity<Object> handleExceptionInternal(RestfulError bodyOfResponse) {
        return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), bodyOfResponse.getStatus());
    }

    private RestfulError buildErrorResponseBody(BasicBizException ex, HttpServletRequest request) {

        HttpStatus httpStatus;
        try {
            httpStatus = HttpStatus.valueOf(ex.getStatus());
        } catch (Exception e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;  //默认使用 HttpStatus.INTERNAL_SERVER_ERROR
        }
        String message = ex.getMessage();
        String code = ex.getCode();
        String developerMessage = ex.getCause().toString();

        return getRestfulError(ex, request, httpStatus, message, code, developerMessage);
    }

    private RestfulError getRestfulError(RuntimeException ex, HttpServletRequest request,
                                         HttpStatus httpStatus, String message, String code, String developerMessage) {
        RestfulError.Builder builder = new RestfulError.Builder();
        builder.setDocument("");
        builder.setStatus(httpStatus);
        builder.setMessage(message);
        builder.setCode(code);
        builder.setDeveloperMessage(developerMessage);
        builder.setServerTime(new Date());
        builder.setThrowable(ex);
        builder.setHostId(request.getServerName());
        builder.setRequestId(request.getHeader("X-Request-ID"));    //自定义的X-Request-ID
        return builder.build();
    }


}
