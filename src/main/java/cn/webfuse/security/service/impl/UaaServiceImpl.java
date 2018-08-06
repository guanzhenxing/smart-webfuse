package cn.webfuse.security.service.impl;

import cn.webfuse.security.entity.uaa.AuthToken;
import cn.webfuse.security.entity.uaa.User;
import cn.webfuse.security.service.UaaService;
import org.springframework.stereotype.Service;

@Service
public class UaaServiceImpl implements UaaService {
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
