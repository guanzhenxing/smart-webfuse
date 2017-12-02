package net.webfuse.uaa.user.repository;

import java.util.List;
import net.webfuse.uaa.user.domain.User;
import net.webfuse.uaa.user.domain.UserCriteria;

public interface UserMapper {
    long countByExample(UserCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}