package cn.webfuse.cloud.uaa.uc.user.service;

import cn.webfuse.cloud.uaa.uc.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获得用户数据的Service
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


}
