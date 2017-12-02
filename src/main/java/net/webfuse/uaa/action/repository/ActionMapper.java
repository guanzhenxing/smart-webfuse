package net.webfuse.uaa.action.repository;

import java.util.List;
import net.webfuse.uaa.action.domain.Action;
import net.webfuse.uaa.action.domain.ActionCriteria;

public interface ActionMapper {
    long countByExample(ActionCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(Action record);

    int insertSelective(Action record);

    List<Action> selectByExample(ActionCriteria example);

    Action selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
}