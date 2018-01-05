package net.webfuse.common.exception.exhandler;

import net.webfuse.common.exception.BasicBizException;
import net.webfuse.common.util.mapper.JsonMapper;
import org.apache.commons.lang3.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的RestfulError解析器
 * Created by guanzhenxing on 2018/1/5.
 */
public class DefaultRestfulErrorResolver implements RestfulErrorResolver, MessageSourceAware, InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRestfulErrorResolver.class);

    private Map<String, RestfulError> exceptionMappings = Collections.emptyMap();   //异常类与解析信息对应关系
    private Map<String, String> exceptionDefinitionMessageMappings = Collections.emptyMap();   //异常类与自定义的处理方式对应关系


    private String defaultDocument;
    private String defaultMessage;

    private MessageSource messageSource;
    private LocaleResolver localeResolver;

    /**
     * 解析异常信息
     *
     * @param request  request请求对象
     * @param response response返回对象
     * @param handler  处理器
     * @param ex       待处理的异常
     * @return
     */
    @Override
    public RestfulError resolveError(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        RestfulError template = buildRuntimeError(handler, ex);
        RestfulError.Builder builder = new RestfulError.Builder();

        builder.setDocument(template.getDocument());
        builder.setStatus(template.getStatus());
        builder.setMessage(getMessage(template.getMessage(), request));
        builder.setCode(template.getCode());
        builder.setDeveloperMessage(template.getDeveloperMessage());
        builder.setServerTime(template.getServerTime());
        builder.setThrowable(ex);
        builder.setHostId(request.getServerName());
        builder.setRequestId(request.getHeader("X-Request-ID"));    //自定义的X-Request-ID

        return builder.build();
    }

    private RestfulError buildRuntimeError(Object handler, Exception ex) {
        Map<String, RestfulError> mappings = this.exceptionMappings;

        Class clazz = ex.getClass();
        RestfulError restfulError = mappings.get(clazz.getName());  //从配置中获得解析信息

        if (restfulError == null) { //没有获得自定义的情况下，逐级去找父级的
            List<Class<?>> superClasses = ClassUtils.getAllSuperclasses(clazz);
            for (Class superClass : superClasses) {
                LOGGER.debug("The super class name is " + superClass.getName());
                restfulError = mappings.get(superClass.getName());
                if (restfulError != null) {
                    break;
                }
            }
        }

        if (ex instanceof BasicBizException) {  //如果是自定义的业务异常，则使用自定义的业务异常解析
            restfulError = buildBasicBizExceptionError(ex, handler, restfulError);
        }

        RestfulError.Builder builder = new RestfulError.Builder();
        builder.setServerTime(new Date());
        builder.setThrowable(ex);
        builder.setStatus(restfulError.getStatus());
        builder.setMessage(restfulError.getMessage());
        builder.setCode(restfulError.getCode());
        builder.setDocument(buildDocument(restfulError));
        builder.setDeveloperMessage(buildDeveloperMessage(restfulError, handler, ex));

        return builder.build();
    }

    /**
     * 构造BasicBizException的错误消息
     *
     * @param ex
     * @param handler
     * @param restfulError
     * @return
     */
    private RestfulError buildBasicBizExceptionError(Exception ex, Object handler, RestfulError restfulError) {
        Map<String, String> exMsg = JsonMapper.getInstance().fromJson(ex.getMessage(), Map.class);

        HttpStatus httpStatus;
        try {
            String status = exMsg.get("status");
            httpStatus = HttpStatus.valueOf(Integer.valueOf(status));
        } catch (Exception e) {
            LOGGER.debug("Error to HttpStatus,the error value is " + exMsg.get("status"));
            httpStatus = restfulError.getStatus();  //默认使用 HttpStatus.INTERNAL_SERVER_ERROR
        }

        String message = exMsg.get("message");
        if (message.equalsIgnoreCase("null") || StringUtils.isEmpty(message)) {
            message = restfulError.getMessage();
        }
        String code = Optional.ofNullable(exMsg.get("code")).orElse(restfulError.getCode());

        RestfulError.Builder builder = new RestfulError.Builder();
        builder.setDocument(buildDocument(restfulError));
        builder.setStatus(httpStatus);
        builder.setMessage(message);
        builder.setCode(code);
        builder.setDeveloperMessage(buildDeveloperMessage(restfulError, handler, ex));

        return builder.build();
    }


    private String buildDeveloperMessage(RestfulError restfulError, Object handler, Exception ex) {
        String developerMessage = restfulError.getDeveloperMessage();
        if (StringUtils.isEmpty(developerMessage)) {
            String exMessage = ex.getMessage();
            developerMessage = exMessage;
        }
        return developerMessage;
    }

    private String buildDocument(RestfulError template) {
        String document = template.getDocument();
        //如果该RestfulError的文档定义和默认的一样，就在其父类中查看，如果找到，就其父类的文档，这样做可以用来做文档归类
        if (defaultDocument.equalsIgnoreCase(document)) {
            List<Class<?>> superClasses = ClassUtils.getAllSuperclasses(template.getThrowable().getClass());
            for (Class superClass : superClasses) {
                LOGGER.debug("In buildDocument, the super class name is " + superClass.getName());
                RestfulError restfulError = this.exceptionMappings.get(superClass.getName());
                if (restfulError != null) {
                    document = restfulError.getDocument();
                    break;
                }
            }
        }
        return Optional.ofNullable(document).orElse(defaultDocument);
    }

    private String getMessage(String message, HttpServletRequest request) {
        if (message != null) {  //国际化处理
            if (message.equalsIgnoreCase("null") || message.equalsIgnoreCase("off")) {
                return "";
            }
            if (messageSource != null) {
                Locale locale = null;
                if (localeResolver != null) {
                    locale = localeResolver.resolveLocale(request);
                }
                message = messageSource.getMessage(message, null, message, locale);
            }
        }
        return Optional.ofNullable(message).orElse(defaultMessage);
    }


    //以下的方法是定义各种的异常处理信息
    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, String> definitionMessageMappings = createDefaultExceptionDefinitionMessageMappings();
        if (this.exceptionDefinitionMessageMappings != null && !this.exceptionDefinitionMessageMappings.isEmpty()) {
            definitionMessageMappings.putAll(this.exceptionDefinitionMessageMappings);
        }
        this.exceptionMappings = definitionRestErrors(definitionMessageMappings);
    }


    private Map<String, String> createDefaultExceptionDefinitionMessageMappings() {
        Map<String, String> map = new LinkedHashMap<>();
        // 400
        applyDef(map, HttpMessageNotReadableException.class, HttpStatus.BAD_REQUEST);
        applyDef(map, MissingServletRequestParameterException.class, HttpStatus.BAD_REQUEST);
        applyDef(map, TypeMismatchException.class, HttpStatus.BAD_REQUEST);
        applyDef(map, "javax.validation.ValidationException", HttpStatus.BAD_REQUEST);
        applyDef(map, BindException.class, HttpStatus.BAD_REQUEST);
        applyDef(map, ServletRequestBindingException.class, HttpStatus.BAD_REQUEST);
        applyDef(map, MethodArgumentNotValidException.class, HttpStatus.BAD_REQUEST);
        applyDef(map, MissingServletRequestPartException.class, HttpStatus.BAD_REQUEST);

        // 404
        applyDef(map, NoHandlerFoundException.class, HttpStatus.NOT_FOUND);
        applyDef(map, NoSuchRequestHandlingMethodException.class, HttpStatus.NOT_FOUND);
        applyDef(map, "org.hibernate.ObjectNotFoundException", HttpStatus.NOT_FOUND);
        // 405
        applyDef(map, HttpRequestMethodNotSupportedException.class, HttpStatus.METHOD_NOT_ALLOWED);
        // 406
        applyDef(map, HttpMediaTypeNotAcceptableException.class, HttpStatus.NOT_ACCEPTABLE);
        // 409
        //can't use the class directly here as it may not be an available dependency:
        applyDef(map, "org.springframework.dao.DataIntegrityViolationException", HttpStatus.CONFLICT);
        // 415
        applyDef(map, HttpMediaTypeNotSupportedException.class, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        // 500
        applyDef(map, Throwable.class, HttpStatus.INTERNAL_SERVER_ERROR);
        applyDef(map, RuntimeException.class, HttpStatus.INTERNAL_SERVER_ERROR);
        applyDef(map, MissingPathVariableException.class, HttpStatus.INTERNAL_SERVER_ERROR);
        applyDef(map, ConversionNotSupportedException.class, HttpStatus.INTERNAL_SERVER_ERROR);
        applyDef(map, HttpMessageNotWritableException.class, HttpStatus.INTERNAL_SERVER_ERROR);
        //503
        applyDef(map, AsyncRequestTimeoutException.class, HttpStatus.SERVICE_UNAVAILABLE);

        applyDef(map, BasicBizException.class, HttpStatus.INTERNAL_SERVER_ERROR);

        return map;
    }

    private void applyDef(Map<String, String> map, Class clazz, HttpStatus status) {
        applyDef(map, clazz.getName(), status);
    }

    private void applyDef(Map<String, String> map, String name, HttpStatus status) {
        map.put(name, getDefaultDefinition(status));
    }

    /**
     * 将status转换成定义的字符串格式
     *
     * @param status
     * @return
     */
    private String getDefaultDefinition(HttpStatus status) {
        Map<String, String> map = new ConcurrentHashMap<>();
        String code = status.getReasonPhrase().toUpperCase().replaceAll(" ", "_");
        map.put("code", code);
        map.put("status", status.toString());
        return JsonMapper.getInstance().toJson(map);
    }

    /**
     * 转换成为：异常类-RestfulError格式的对应map
     *
     * @param definitionMessageMappings
     * @return
     */
    private Map<String, RestfulError> definitionRestErrors(Map<String, String> definitionMessageMappings) {

        Map<String, RestfulError> map = new LinkedHashMap<>(definitionMessageMappings.size());

        definitionMessageMappings.entrySet().stream().forEach(entry -> {
            String key = entry.getKey();    //异常类名
            String value = entry.getValue();    //配置的异常处理信息
            RestfulError template = convertToRestError(value);
            map.put(key, template);
        });

        return map;
    }

    /**
     * 构造一个RestfulError
     *
     * @param value
     * @return
     */
    private RestfulError convertToRestError(String value) {

        Map<String, String> error = JsonMapper.getInstance().fromJson(value, Map.class);

        String code = error.get("code");
        if (StringUtils.isEmpty(code)) {    //如果没有定义code，那么默认就是INTERNAL_SERVER_ERROR
            code = "INTERNAL_SERVER_ERROR";
        }

        String message = error.get("message");
        if (StringUtils.isEmpty(message)) {
            message = this.defaultMessage;    //如果没有定义message,默认为 ""
        }

        String status = String.valueOf(error.get("status"));
        HttpStatus httpStatus;
        try {
            httpStatus = HttpStatus.valueOf(Integer.valueOf(status));
        } catch (Exception e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;  //默认使用 HttpStatus.INTERNAL_SERVER_ERROR
        }

        String document = error.get("document");
        if (StringUtils.isEmpty(document)) {    //如果没有定义文档信息，那么就是要默认的文档
            document = this.defaultDocument;
        }

        RestfulError.Builder builder = new RestfulError.Builder();
        builder.setCode(code);
        builder.setMessage(message);
        builder.setStatus(httpStatus);
        builder.setDocument(document);

        return builder.build();
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void setExceptionMappings(Map<String, RestfulError> exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }

    public void setExceptionDefinitionMessageMappings(Map<String, String> exceptionDefinitionMessageMappings) {
        this.exceptionDefinitionMessageMappings = exceptionDefinitionMessageMappings;
    }

    public void setLocaleResolver(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    public void setDefaultDocument(String defaultDocument) {
        this.defaultDocument = defaultDocument;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
