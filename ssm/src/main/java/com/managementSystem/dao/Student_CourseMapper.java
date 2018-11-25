package com.managementSystem.dao;

import com.managementSystem.pojo.Student_Course;
import com.managementSystem.pojo.Student_CourseExample;
import com.managementSystem.pojo.Student_CourseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Student_CourseMapper {
    long countByExample(Student_CourseExample example);

    int deleteByExample(Student_CourseExample example);

    int deleteByPrimaryKey(Student_CourseKey key);

    int insert(Student_Course record);

    int insertSelective(Student_Course record);

    List<Student_Course> selectByExample(Student_CourseExample example);

    Student_Course selectByPrimaryKey(Student_CourseKey key);

    int updateByExampleSelective(@Param("record") Student_Course record, @Param("example") Student_CourseExample example);

    int updateByExample(@Param("record") Student_Course record, @Param("example") Student_CourseExample example);

    int updateByPrimaryKeySelective(Student_Course record);

    int updateByPrimaryKey(Student_Course record);
}