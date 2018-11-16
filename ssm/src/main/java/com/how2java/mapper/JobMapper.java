package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Job;
import com.how2java.util.Page;

public interface JobMapper {


    public int add(Job job);


    public void delete(String id);


    public Job get(String id);


    public int update(Job job);


    public List<Job> list();

}