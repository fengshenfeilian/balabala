package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.UserGroup;
import com.how2java.util.Page;

public interface UserGroupMapper {


    public int add(UserGroup userGroup);


    public void delete(String id);


    public UserGroup get(String id);


    public int update(UserGroup userGroup);


    public List<UserGroup> list();

}