package net.webfuse.uaa.role.repository;

import java.util.List;
import net.webfuse.uaa.role.domain.Role;
import net.webfuse.uaa.role.domain.RoleCriteria;

public interface RoleMapper {
    long countByExample(RoleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleCriteria example);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}