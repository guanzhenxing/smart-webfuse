package net.webfuse.uaa.permission.repository;

import java.util.List;
import net.webfuse.uaa.permission.domain.RolePermission;
import net.webfuse.uaa.permission.domain.RolePermissionCriteria;

public interface RolePermissionMapper {
    long countByExample(RolePermissionCriteria example);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionCriteria example);
}