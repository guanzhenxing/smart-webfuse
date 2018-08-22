package cn.webfuse.framework.security.service.impl;

import cn.webfuse.framework.tool.AssertTools;
import cn.webfuse.framework.security.AuthenticationTokenException;
import cn.webfuse.framework.security.authentication.mac.MacAuthenticationToken;
import cn.webfuse.framework.security.entity.uaa.AuthToken;
import cn.webfuse.framework.security.service.AuthenticationTokenCheckService;
import cn.webfuse.framework.security.service.UserService;
import cn.webfuse.framework.security.service.cache.NonceCache;
import cn.webfuse.framework.security.util.AuthTokenUtil;
import com.vip.vjtools.vjkit.mapper.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class MacAuthenticationTokenCheckService implements AuthenticationTokenCheckService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MacAuthenticationTokenCheckService.class);


    @Autowired
    private UserService userService;

    private NonceCache nonceCache;

    @Value("${webfuse.security.nonce-expire:300000}")
    private long nonceExpire;   //默认5分钟

    public MacAuthenticationTokenCheckService() {
        nonceCache = new NonceCache();
    }

    @Override
    public AuthToken verifyToken(Authentication wafAuthenticationToken) {
        LOGGER.debug("verify mac token begin.");
        AssertTools.assertNotNull(wafAuthenticationToken, "authenticationToken must not be null");
        MacAuthenticationToken macAuthenticationToken = (MacAuthenticationToken) wafAuthenticationToken;
        AuthToken authToken = this.checkAuthToken(macAuthenticationToken.getId());   //获得UaaAccessToken
        this.checkMac(macAuthenticationToken, authToken.getSecret());
        this.checkNonce(macAuthenticationToken.getNonce());

        LOGGER.debug("verify mac token end.");

        return authToken;
    }

    private AuthToken checkAuthToken(String token) {
        AuthToken authToken = getAuthToken(token);
        if (authToken.isExpire()) {
            throw new AuthenticationTokenException(403, "AUTH_TOKEN_EXPIRED", "The token has expired");
        }
        if (authToken == null) {
            throw new AuthenticationTokenException(403, "AUTH_TOKEN_EXPIRED", "The token does not exist or has expired");
        }

        LOGGER.debug(JsonMapper.defaultMapper().toJson(authToken));

        return authToken;
    }


    /**
     * 校验mac是否正确
     *
     * @param macAuthenticationToken 请求过来的参数
     * @param secret                 服务端的加密key
     */
    private void checkMac(MacAuthenticationToken macAuthenticationToken, String secret) {
        Map macRequestParam = toMacRequestParam(macAuthenticationToken);
        if (!AuthTokenUtil.checkMacToken(secret, macRequestParam)) {    //检查是否是正确的mac
            throw new AuthenticationTokenException(403, "MAC_SIGN_INVALID", "The mac sign is invalid");
        }
    }


    /**
     * 校验nonce，防止重放攻击(Replay Attacks)
     *
     * @param nonce
     */
    private void checkNonce(String nonce) {

        if (StringUtils.isEmpty(nonce)) {
            throw new AuthenticationTokenException(403, "NONCE_INVALID", "Nonce must not be null or empty.");
        }

        String[] strs = nonce.split(":");
        if (strs.length != 2 || StringUtils.isEmpty(strs[0]) || !Pattern.compile("[0-9]*").matcher(strs[0]).matches()) {
            throw new AuthenticationTokenException(403, "NONCE_INVALID", "The Nonce format is not correct.");
        }

        long diff = new Date().getTime() - Long.parseLong(strs[0]);
        if (diff > nonceExpire || diff < -nonceExpire) {
            throw new AuthenticationTokenException(403, "NONCE_INVALID",
                    "The Nonce string is invalid. The difference between the time and the system time is greater than 5 minutes");
        }

        boolean exist = nonceCache.existNonce(nonce);
        if (exist) {
            throw new AuthenticationTokenException(403, "NONCE_INVALID", "Nonce cannot be reused");//说明nonce串使用过了，抛出异常
        }

    }


    /**
     * 转换
     *
     * @param macAuthenticationToken
     * @return
     */
    private Map<String, Object> toMacRequestParam(MacAuthenticationToken macAuthenticationToken) {

        Map macRequestParam = new HashMap();
        macRequestParam.put("Host", macAuthenticationToken.getHost());
        macRequestParam.put("httpMethod", macAuthenticationToken.getHttpMethod());
        macRequestParam.put("id", macAuthenticationToken.getId());
        macRequestParam.put("mac", macAuthenticationToken.getMac());
        macRequestParam.put("nonce", macAuthenticationToken.getNonce());
        macRequestParam.put("requestUri", macAuthenticationToken.getRequestUri());

        return macRequestParam;
    }


    private AuthToken getAuthToken(String token) {
        return userService.loadUaaAccessToken(token);
    }
}