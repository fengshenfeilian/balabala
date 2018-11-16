package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.PrivelegeRole;
import com.how2java.util.Page;

public interface PrivelegeRoleMapper {


    public int add(PrivelegeRole privelegeRole);


    public void delete(String id);


    public PrivelegeRole get(String id);


    public int update(PrivelegeRole privelegeRole);


    public List<PrivelegeRole> list();

}