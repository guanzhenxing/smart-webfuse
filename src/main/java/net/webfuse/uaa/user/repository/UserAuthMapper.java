package net.webfuse.uaa.user.repository;

import java.util.List;
import net.webfuse.uaa.user.domain.UserAuth;
import net.webfuse.uaa.user.domain.UserAuthCriteria;

public interface UserAuthMapper {
    long countByExample(UserAuthCriteria example);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    List<UserAuth> selectByExample(UserAuthCriteria example);
}