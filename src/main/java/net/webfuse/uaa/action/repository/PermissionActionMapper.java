package net.webfuse.uaa.action.repository;

import java.util.List;
import net.webfuse.uaa.action.domain.PermissionAction;
import net.webfuse.uaa.action.domain.PermissionActionCriteria;

public interface PermissionActionMapper {
    long countByExample(PermissionActionCriteria example);

    int insert(PermissionAction record);

    int insertSelective(PermissionAction record);

    List<PermissionAction> selectByExample(PermissionActionCriteria example);
}