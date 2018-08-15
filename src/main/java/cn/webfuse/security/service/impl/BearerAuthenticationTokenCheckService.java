package cn.webfuse.security.service.impl;

import cn.webfuse.framework.tool.AssertTools;
import cn.webfuse.security.AuthenticationTokenException;
import cn.webfuse.security.authentication.bearer.BearerAuthenticationToken;
import cn.webfuse.security.entity.uaa.AuthToken;
import cn.webfuse.security.service.AuthenticationTokenCheckService;
import cn.webfuse.security.service.UserService;
import com.vip.vjtools.vjkit.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class BearerAuthenticationTokenCheckService implements AuthenticationTokenCheckService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BearerAuthenticationTokenCheckService.class);

    @Autowired
    private UserService userService;

    @Override
    public AuthToken verifyToken(Authentication wafAuthenticationToken) {
        LOGGER.debug("verify bearer token begin.");
        AssertTools.assertNotNull(wafAuthenticationToken, "authenticationToken must not be null");
        BearerAuthenticationToken bearerPreAuthenticationToken = (BearerAuthenticationToken) wafAuthenticationToken;
        AuthToken authToken = checkAuthToken(bearerPreAuthenticationToken.getToken());
        LOGGER.debug("verify bearer token end.");
        return authToken;
    }

    private AuthToken checkAuthToken(String token) {
        AuthToken authToken = getAuthToken(token);
        if (authToken == null) {
            throw new AuthenticationTokenException(403, "AUTH_TOKEN_EXPIRED", "The token does not exist or has expired");
        }
        if (authToken.isExpire()) {
            throw new AuthenticationTokenException(403, "AUTH_TOKEN_EXPIRED", "The token has expired");
        }

        LOGGER.debug(JsonMapper.defaultMapper().toJson(authToken));

        return authToken;
    }

    private AuthToken getAuthToken(String token) {
        return userService.loadUaaAccessToken(token);
    }
}
