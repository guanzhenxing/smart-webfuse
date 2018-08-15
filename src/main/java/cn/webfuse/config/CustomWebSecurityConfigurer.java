package cn.webfuse.config;

import cn.webfuse.framework.security.AuthenticationTokenVerifier;
import cn.webfuse.framework.security.config.AbstractBaseCustomWebSecurityConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurer extends AbstractBaseCustomWebSecurityConfigurer {

    @Bean
    public AuthenticationTokenVerifier authenticationTokenVerifier() throws Exception {
        return new AuthenticationTokenVerifier(authenticationManagerBean(), authenticationExtractorManager());
    }

}
