package com.managementSystem.dao;

import com.managementSystem.pojo.Group_Assignment;
import com.managementSystem.pojo.Group_AssignmentExample;
import com.managementSystem.pojo.Group_AssignmentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Group_AssignmentMapper {
    long countByExample(Group_AssignmentExample example);

    int deleteByExample(Group_AssignmentExample example);

    int deleteByPrimaryKey(Group_AssignmentKey key);

    int insert(Group_Assignment record);

    int insertSelective(Group_Assignment record);

    List<Group_Assignment> selectByExample(Group_AssignmentExample example);

    Group_Assignment selectByPrimaryKey(Group_AssignmentKey key);

    int updateByExampleSelective(@Param("record") Group_Assignment record, @Param("example") Group_AssignmentExample example);

    int updateByExample(@Param("record") Group_Assignment record, @Param("example") Group_AssignmentExample example);

    int updateByPrimaryKeySelective(Group_Assignment record);

    int updateByPrimaryKey(Group_Assignment record);
}