package net.webfuse.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.webfuse.common.exception.exhandler.DefaultRestfulErrorResolver;
import net.webfuse.common.exception.exhandler.HandlerRestfulExceptionResolver;
import net.webfuse.common.exception.exhandler.RestfulErrorResolver;
import net.webfuse.common.web.WafJsonMapper;
import net.webfuse.common.web.mvc.request.CustomServletModelAttributeMethodProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.Filter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于SpringMVC注解方式进行配置waf的spring配置。
 * Created by guanzhenxing on 2017/11/3.
 */
@Configuration
@EnableWebMvc
public class WafWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(stringHttpMessageConverter());
        converters.add(mappingJackson2HttpMessageConverter());
    }


    /**
     * 添加CORS映射
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true).maxAge(3600);
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }


    /**
     * HTTP方法转换（当浏览器不支持某些方法的时候，转换）
     *
     * @return
     */
    @Bean
    public Filter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        return filter;
    }

    /**
     * 添加请求参数解析器
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(customModelAttributeMethodProcessor());
    }

    @Bean
    protected CustomServletModelAttributeMethodProcessor customModelAttributeMethodProcessor() {
        return new CustomServletModelAttributeMethodProcessor(true);
    }

    /**
     * 定义Json的转换格式
     *
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = WafJsonMapper.getMapper();
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

    /**
     * 字符串类型编码
     *
     * @return
     */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }


    /**
     * 异常处理解析器
     *
     * @return
     */
    @Bean
    public HandlerRestfulExceptionResolver handlerRestfulExceptionResolver() {
        HandlerRestfulExceptionResolver handlerRestfulExceptionResolver = new HandlerRestfulExceptionResolver();
        handlerRestfulExceptionResolver.setOrder(-1);
        handlerRestfulExceptionResolver.setRestfulErrorResolver(defaultRestfulErrorResolver());
        return handlerRestfulExceptionResolver;
    }

    @Bean
    public DefaultRestfulErrorResolver defaultRestfulErrorResolver() {
        DefaultRestfulErrorResolver defaultRestfulErrorResolver = new DefaultRestfulErrorResolver();
        defaultRestfulErrorResolver.setLocaleResolver(localeResolver());
        defaultRestfulErrorResolver.setDefaultDocument("");
        defaultRestfulErrorResolver.setDefaultMessage("");
        defaultRestfulErrorResolver.setExceptionDefinitionMessageMappings(getExceptionDefinitionMessageMappings());
        return defaultRestfulErrorResolver;
    }

    private Map<String, String> getExceptionDefinitionMessageMappings() {
        Map<String, String> exceptionMappingDefinitions = new HashMap<>();
//        exceptionMappingDefinitions.put("net.webfuse.common.exception.BasicBizException",
//                "{\"code\":\"INTERNAL_SERVER_ERROR\",\"status\":\"500\",\"message\":\"\",\"document\":\"\"}");
        return exceptionMappingDefinitions;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }


}
