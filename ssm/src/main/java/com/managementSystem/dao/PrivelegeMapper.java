package com.managementSystem.dao;

import com.managementSystem.pojo.Privelege;
import com.managementSystem.pojo.PrivelegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivelegeMapper {
    long countByExample(PrivelegeExample example);

    int deleteByExample(PrivelegeExample example);

    int deleteByPrimaryKey(String priId);

    int insert(Privelege record);

    int insertSelective(Privelege record);

    List<Privelege> selectByExample(PrivelegeExample example);

    Privelege selectByPrimaryKey(String priId);

    int updateByExampleSelective(@Param("record") Privelege record, @Param("example") PrivelegeExample example);

    int updateByExample(@Param("record") Privelege record, @Param("example") PrivelegeExample example);

    int updateByPrimaryKeySelective(Privelege record);

    int updateByPrimaryKey(Privelege record);
}