package com.managementSystem.dao;

import com.managementSystem.pojo.Pri_RoleExample;
import com.managementSystem.pojo.Pri_RoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Pri_RoleMapper {
    long countByExample(Pri_RoleExample example);

    int deleteByExample(Pri_RoleExample example);

    int deleteByPrimaryKey(Pri_RoleKey key);

    int insert(Pri_RoleKey record);

    int insertSelective(Pri_RoleKey record);

    List<Pri_RoleKey> selectByExample(Pri_RoleExample example);

    int updateByExampleSelective(@Param("record") Pri_RoleKey record, @Param("example") Pri_RoleExample example);

    int updateByExample(@Param("record") Pri_RoleKey record, @Param("example") Pri_RoleExample example);
}