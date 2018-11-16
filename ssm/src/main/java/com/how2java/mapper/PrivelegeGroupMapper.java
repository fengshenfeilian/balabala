package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.PrivelegeGroup;
import com.how2java.util.Page;

public interface PrivelegeGroupMapper {


    public int add(PrivelegeGroup privelegeGroup);


    public void delete(String id);


    public PrivelegeGroup get(String id);


    public int update(PrivelegeGroup privelegeGroup);


    public List<PrivelegeGroup> list();

}