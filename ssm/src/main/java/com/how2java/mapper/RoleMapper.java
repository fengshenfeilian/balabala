package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Role;
import com.how2java.util.Page;

public interface RoleMapper {


    public int add(Role role);


    public void delete(String id);


    public Role get(String id);


    public int update(Role role);


    public List<Role> list();

}