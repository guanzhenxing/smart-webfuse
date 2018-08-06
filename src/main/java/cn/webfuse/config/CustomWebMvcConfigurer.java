package cn.webfuse.config;

import cn.webfuse.framework.web.config.AbstractBaseCustomWebMvcConfigurer;
import cn.webfuse.security.AuthenticationTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.Map;

@Configuration
@EnableWebMvc
public class CustomWebMvcConfigurer extends AbstractBaseCustomWebMvcConfigurer {
    @Override
    public Map<String, String> getCustomExceptionMappingDefinitions() {
        return null;
    }

    @Override
    public void addCustomInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationTokenInterceptor());
    }

    @Bean
    public AuthenticationTokenInterceptor authenticationTokenInterceptor() {
        return new AuthenticationTokenInterceptor();
    }
}
