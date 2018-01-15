package net.webfuse.uaa.user.repository;

import java.util.List;
import net.webfuse.uaa.user.domain.UserExtra;
import net.webfuse.uaa.user.domain.UserExtraCriteria;

public interface UserExtraMapper {
    long countByExample(UserExtraCriteria example);

    int deleteByPrimaryKey(String userId);

    int insert(UserExtra record);

    int insertSelective(UserExtra record);

    List<UserExtra> selectByExample(UserExtraCriteria example);

    UserExtra selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserExtra record);

    int updateByPrimaryKey(UserExtra record);
}