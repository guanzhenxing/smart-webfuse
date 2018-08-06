package cn.webfuse.config;

import cn.webfuse.security.AuthenticationTokenVerifier;
import cn.webfuse.security.config.AbstractBaseCustomWebSecurityConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@Configuration
//@EnableWebSecurity
//@Order(1)
public class CustomWebSecurityConfigurer extends AbstractBaseCustomWebSecurityConfigurer {

//    @Bean
//    public AuthenticationTokenVerifier authenticationTokenVerifier() throws Exception {
//        return new AuthenticationTokenVerifier(authenticationManagerBean(), authenticationExtractorManager());
//    }

}
