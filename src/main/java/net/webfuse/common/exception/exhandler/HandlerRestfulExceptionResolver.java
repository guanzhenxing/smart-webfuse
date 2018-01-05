package net.webfuse.common.exception.exhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Restful异常处理分析器
 * Created by guanzhenxing on 2018/1/5.
 */
public class HandlerRestfulExceptionResolver extends AbstractHandlerExceptionResolver implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerRestfulExceptionResolver.class);

    private List<HttpMessageConverter<?>> allMessageConverters = null;

    private HttpMessageConverter<?>[] messageConverters = null;
    private RestfulErrorConverter<?> restfulErrorConverter;
    private RestfulErrorResolver restfulErrorResolver;

    public HandlerRestfulExceptionResolver() {
        this.restfulErrorConverter = new DefaultRestfulErrorConverter();
        this.restfulErrorResolver = new DefaultRestfulErrorResolver();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ensureMessageConverters();
    }

    /**
     * 获得所有的MessageConverters
     */
    private void ensureMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        if (this.messageConverters != null && this.messageConverters.length > 0) {
            converters.addAll(CollectionUtils.arrayToList(this.messageConverters));
        }
        new HttpMessageConverterHelper().addDefaultMessageConverters(converters);
        this.allMessageConverters = converters;
    }

    /**
     * 继承自WebMvcConfigurationSupport，在SpringMVC默认的MessageConverters基础上添加自定义的MessageConverters
     */
    private static final class HttpMessageConverterHelper extends WebMvcConfigurationSupport {
        public void addDefaultMessageConverters(List<HttpMessageConverter<?>> converters) {
            addDefaultHttpMessageConverters(converters);
        }
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        RestfulErrorResolver resolver = getRestfulErrorResolver();
        RestfulError restfulError = resolver.resolveError(request, response, handler, e);  //获得RestfulError实例
        if (restfulError == null) {
            return null;
        }
        try {
            return getModelAndView(request, response, restfulError);
        } catch (Exception invocationEx) {
            LOGGER.error("Acquiring ModelAndView for Exception [" + e + "] resulted in an exception.", invocationEx);
        }
        return null;
    }

    private ModelAndView getModelAndView(HttpServletRequest request, HttpServletResponse response, RestfulError restfulError) throws IOException {
        response.setStatus(restfulError.getStatus().value());
        Object body = restfulError;
        RestfulErrorConverter converter = getRestfulErrorConverter();
        if (converter != null) {
            body = converter.convert(restfulError);
        }
        return handleResponseBody(body, request, response);
    }

    private ModelAndView handleResponseBody(Object body, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
        List<MediaType> acceptedMediaTypes = inputMessage.getHeaders().getAccept();
        if (acceptedMediaTypes.isEmpty()) {
            acceptedMediaTypes = Collections.singletonList(MediaType.ALL);
        }
        MediaType.sortByQualityValue(acceptedMediaTypes);

        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        Class<?> bodyType = body.getClass();
        List<HttpMessageConverter<?>> converters = this.allMessageConverters;

        if (converters != null) {
            for (MediaType acceptedMediaType : acceptedMediaTypes) {
                for (HttpMessageConverter messageConverter : converters) {
                    if (messageConverter.canWrite(bodyType, acceptedMediaType)) {   //如果能够使用对应的格式输出的话
                        messageConverter.write(body, acceptedMediaType, outputMessage);
                        return new ModelAndView();
                    }
                }
            }
        }
        if (LOGGER.isWarnEnabled()) {
            LOGGER.warn("Could not find HttpMessageConverter that supports return type [" + bodyType + "] and " + acceptedMediaTypes);
        }
        return null;
    }


    public HttpMessageConverter<?>[] getMessageConverters() {
        return messageConverters;
    }

    public void setMessageConverters(HttpMessageConverter<?>[] messageConverters) {
        this.messageConverters = messageConverters;
    }

    public RestfulErrorConverter<?> getRestfulErrorConverter() {
        return restfulErrorConverter;
    }

    public void setRestfulErrorConverter(RestfulErrorConverter<?> restfulErrorConverter) {
        this.restfulErrorConverter = restfulErrorConverter;
    }

    public RestfulErrorResolver getRestfulErrorResolver() {
        return restfulErrorResolver;
    }

    public void setRestfulErrorResolver(RestfulErrorResolver restfulErrorResolver) {
        this.restfulErrorResolver = restfulErrorResolver;
    }


}
