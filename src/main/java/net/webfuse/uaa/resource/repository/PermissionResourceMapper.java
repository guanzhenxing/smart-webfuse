package net.webfuse.uaa.resource.repository;

import java.util.List;
import net.webfuse.uaa.resource.domain.PermissionResource;
import net.webfuse.uaa.resource.domain.PermissionResourceCriteria;

public interface PermissionResourceMapper {
    long countByExample(PermissionResourceCriteria example);

    int insert(PermissionResource record);

    int insertSelective(PermissionResource record);

    List<PermissionResource> selectByExample(PermissionResourceCriteria example);
}