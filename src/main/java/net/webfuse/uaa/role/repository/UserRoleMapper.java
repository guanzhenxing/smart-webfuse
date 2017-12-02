package net.webfuse.uaa.role.repository;

import java.util.List;
import net.webfuse.uaa.role.domain.UserRole;
import net.webfuse.uaa.role.domain.UserRoleCriteria;

public interface UserRoleMapper {
    long countByExample(UserRoleCriteria example);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleCriteria example);
}