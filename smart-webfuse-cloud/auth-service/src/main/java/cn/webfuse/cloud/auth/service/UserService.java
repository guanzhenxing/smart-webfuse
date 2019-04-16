package cn.webfuse.cloud.auth.service;

import cn.webfuse.cloud.auth.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    public void create(User user) {

    }

    public List<User> getUserList() {
        return Collections.EMPTY_LIST;
    }
}
