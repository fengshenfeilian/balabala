package com.managementSystem.dao;

import com.managementSystem.pojo.Group_Student;
import com.managementSystem.pojo.Group_StudentExample;
import com.managementSystem.pojo.Group_StudentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Group_StudentMapper {
    long countByExample(Group_StudentExample example);

    int deleteByExample(Group_StudentExample example);

    int deleteByPrimaryKey(Group_StudentKey key);

    int insert(Group_Student record);

    int insertSelective(Group_Student record);

    List<Group_Student> selectByExample(Group_StudentExample example);

    Group_Student selectByPrimaryKey(Group_StudentKey key);

    int updateByExampleSelective(@Param("record") Group_Student record, @Param("example") Group_StudentExample example);

    int updateByExample(@Param("record") Group_Student record, @Param("example") Group_StudentExample example);

    int updateByPrimaryKeySelective(Group_Student record);

    int updateByPrimaryKey(Group_Student record);

/*  marco  */
    Integer selectGroupIdByStudentId(String studentId);
    Boolean existStudent(String studentId);
    Integer getStudentCountByGroupId(Integer groupId);
/*   */
}