package net.webfuse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security配置
 */
@Configuration
@EnableWebSecurity
public class WafWebSecurityConfig extends WebSecurityConfigurerAdapter {
//    https://spring.io/guides/gs/securing-web/
}
