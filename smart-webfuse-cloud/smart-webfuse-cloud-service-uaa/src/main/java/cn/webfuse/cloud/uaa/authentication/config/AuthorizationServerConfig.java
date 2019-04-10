package cn.webfuse.cloud.uaa.authentication.config;

import cn.webfuse.cloud.uaa.authentication.service.CustomClientDetailsService;
import cn.webfuse.cloud.uaa.authentication.service.CustomTokenStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * token存储
     */
    @Autowired
    private CustomTokenStoreService customTokenStoreService;

    /**
     * clientDetails存储
     */
    @Autowired
    private CustomClientDetailsService customClientDetailsService;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    /**
     * 配置授权endpoint权限
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(customClientDetailsService);
    }

    /**
     * 配置授权端点
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(customTokenStoreService)
                .authenticationManager(authenticationManager)
        //                .approvalStore(approvalStore())/**/
        ;
    }

//    //TODO 需要确定这个的作用
//    @Bean
//    public ApprovalStore approvalStore() {
//        TokenApprovalStore tokenStore = new TokenApprovalStore();
//        tokenStore.setTokenStore(customTokenStoreService);
//        return tokenStore;
//    }

}
