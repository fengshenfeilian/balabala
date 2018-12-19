package com.managementSystem.dao;

import com.managementSystem.pojo.Group;
import com.managementSystem.pojo.GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);

    String selectByUseridCourseid(@Param("courseId")Integer courseId,@Param("studentId") String studentId);

    int selectGrade(@Param("courseId")Integer courseId,@Param("studentId") String studentId);

    //groupId
    String selectId(String groupName);
    /*Add by Marco*/
    String selectCourseNameByCourseId(int courseId);
    /* ********** */

}