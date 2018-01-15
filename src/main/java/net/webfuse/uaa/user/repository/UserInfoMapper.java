package net.webfuse.uaa.user.repository;

import java.util.List;
import net.webfuse.uaa.user.domain.UserInfo;
import net.webfuse.uaa.user.domain.UserInfoCriteria;

public interface UserInfoMapper {
    long countByExample(UserInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoCriteria example);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}