package cn.webfuse.security.service;

import cn.webfuse.security.entity.uaa.AuthToken;
import org.springframework.security.core.Authentication;

/**
 * Uaa验证token的逻辑
 */
public interface AuthenticationTokenCheckService {
    /**
     * 校验Token
     *
     * @param wafAuthenticationToken
     * @return
     */
    AuthToken verifyToken(Authentication wafAuthenticationToken);
}
