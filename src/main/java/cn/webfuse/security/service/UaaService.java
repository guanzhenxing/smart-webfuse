package cn.webfuse.security.service;

import cn.webfuse.security.entity.uaa.AuthToken;
import cn.webfuse.security.entity.uaa.User;

/**
 * 从Uaa中获得数据的服务接口
 */
public interface UaaService {


    /**
     * 根据用户账号获得用户信息
     *
     * @param account
     * @return
     */
    User loadUserDetailsByAccount(String account);

    /**
     * 根据UaaAuthToken获得用户信息
     *
     * @param authToken
     * @return
     */
    User loadUserDetailsByAccessToken(AuthToken authToken);

    /**
     * 根据accessToken获得Token信息
     *
     * @param accessToken
     * @return
     */
    AuthToken loadUaaAccessToken(String accessToken);


}
