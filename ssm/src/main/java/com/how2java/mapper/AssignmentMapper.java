package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Assignment;
import com.how2java.util.Page;

public interface AssignmentMapper {


    public int add(Assignment assignment);


    public void delete(String id);


    public Assignment get(String id);


    public int update(Assignment assignment);


    public List<Assignment> list();

}