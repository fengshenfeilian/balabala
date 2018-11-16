package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.UserRole;
import com.how2java.util.Page;

public interface UserRoleMapper {


    public int add(UserRole userRole);


    public void delete(String id);


    public UserRole get(String id);


    public int update(UserRole userRole);


    public List<UserRole> list();

}