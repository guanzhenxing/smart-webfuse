package cn.webfuse.framework.security.service.impl;

import cn.webfuse.framework.security.entity.uaa.AuthToken;
import cn.webfuse.framework.security.entity.uaa.User;
import cn.webfuse.framework.security.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User loadUserDetailsByAccount(String account) {
        return null;
    }

    @Override
    public User loadUserDetailsByAccessToken(AuthToken authToken) {
        return null;
    }

    @Override
    public AuthToken loadUaaAccessToken(String accessToken) {
        return null;
    }
}