package cn.webfuse.framework.web.config;


import cn.webfuse.framework.exception.handler.DefaultRestfulErrorResolver;
import cn.webfuse.framework.exception.handler.HandlerRestfulExceptionResolver;
import cn.webfuse.framework.web.support.WebFuseJsonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于SpringMVC注解方式进行配置waf的spring配置。
 */
@Configuration
@EnableWebMvc
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
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
     * 配置HiddenHttpMethodFilter过滤器
     *
     * @return
     */
    @Bean
    public Filter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        return filter;
    }


    /**
     * 定义Json的转换格式
     *
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = WebFuseJsonMapper.getMapper();
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(customModelAttributeMethodProcessor());
//    }
//
//    /**
//     * 自定义请求参数模型处理
//     *
//     * @return
//     */
//    @Bean
//    protected CustomServletModelAttributeMethodProcessor customModelAttributeMethodProcessor() {
//        return new CustomServletModelAttributeMethodProcessor(true);
//    }
//

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

        defaultRestfulErrorResolver.setExceptionMappingDefinitions(getExceptionMappingDefinitions());

        return defaultRestfulErrorResolver;
    }

    public Map<String, String> getExceptionMappingDefinitions() {
        Map<String, String> exceptionMappingDefinitions = new HashMap<>();
        exceptionMappingDefinitions.put("Throwable", "{\"status\":500}");
        exceptionMappingDefinitions.put("RuntimeException", "{\"status\":500}");
        exceptionMappingDefinitions.put("cn.webfuse.framework.exception.AbstractBizException", "{\"status\":500,\"code\":\"INTERNAL SERVER ERROR\",\"message\":\"\",\"developerMessage\":\"\"}");

        return exceptionMappingDefinitions;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }


    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

}
