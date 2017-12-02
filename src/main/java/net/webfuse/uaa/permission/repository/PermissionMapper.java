package net.webfuse.uaa.permission.repository;

import java.util.List;
import net.webfuse.uaa.permission.domain.Permission;
import net.webfuse.uaa.permission.domain.PermissionCriteria;

public interface PermissionMapper {
    long countByExample(PermissionCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionCriteria example);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}