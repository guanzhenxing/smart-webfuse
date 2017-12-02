package net.webfuse.uaa.resource.repository;

import java.util.List;
import net.webfuse.uaa.resource.domain.Resource;
import net.webfuse.uaa.resource.domain.ResourceCriteria;

public interface ResourceMapper {
    long countByExample(ResourceCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceCriteria example);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}