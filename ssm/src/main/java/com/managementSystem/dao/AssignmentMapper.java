package com.managementSystem.dao;

import com.managementSystem.pojo.Assignment;
import com.managementSystem.pojo.AssignmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssignmentMapper {
    long countByExample(AssignmentExample example);

    int deleteByExample(AssignmentExample example);

    int deleteByPrimaryKey(String assignmentId);

    int insert(Assignment record);

    int insertSelective(Assignment record);

    List<Assignment> selectByExample(AssignmentExample example);

    Assignment selectByPrimaryKey(String assignmentId);

    int updateByExampleSelective(@Param("record") Assignment record, @Param("example") AssignmentExample example);

    int updateByExample(@Param("record") Assignment record, @Param("example") AssignmentExample example);

    int updateByPrimaryKeySelective(Assignment record);

    int updateByPrimaryKey(Assignment record);

    int getPercent(String assignmentId);
}