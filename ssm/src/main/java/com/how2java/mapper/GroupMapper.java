package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Group;
import com.how2java.util.Page;

public interface GroupMapper {


    public int add(Group group);


    public void delete(String id);


    public Group get(String id);


    public int update(Group group);


    public List<Group> list();

}