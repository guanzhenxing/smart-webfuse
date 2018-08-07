package cn.webfuse.security.authentication.debug;

import cn.webfuse.security.entity.UserAuthenticationToken;
import cn.webfuse.security.entity.uaa.AuthToken;
import cn.webfuse.security.entity.uaa.User;
import cn.webfuse.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Order(10)
public class DebugTokenAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugTokenAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        LOGGER.debug("Debug token authenticate begin.");

        Assert.notNull(authentication, "authentication cannot be null.");
        DebugAuthenticationToken debugAuthenticationToken = (DebugAuthenticationToken) authentication;

        AuthToken authToken = buildUaaAccessToken(debugAuthenticationToken);
        User user = buildUaaUserDetails(debugAuthenticationToken);
        user.setAuthToken(authToken);
        UserAuthenticationToken userAuthenticationToken = new UserAuthenticationToken(user, "Debug");

        LOGGER.debug("Debug token authenticate end.");

        return userAuthenticationToken;
    }

    /**
     * 获得用户信息
     *
     * @param debugAuthenticationToken
     * @return
     */
    private User buildUaaUserDetails(DebugAuthenticationToken debugAuthenticationToken) {
        return userService.loadUserDetailsByAccount(debugAuthenticationToken.getAccount());
    }

    /**
     * 获得认证信息
     *
     * @param debugAuthenticationToken
     * @return
     */
    private AuthToken buildUaaAccessToken(DebugAuthenticationToken debugAuthenticationToken) {
        AuthToken authToken = new AuthToken();
        authToken.setAccount(debugAuthenticationToken.getAccount());
        return authToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == DebugAuthenticationToken.class;
    }
}
