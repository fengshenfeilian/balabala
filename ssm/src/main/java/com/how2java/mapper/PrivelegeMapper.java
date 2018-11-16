package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.Privelege;
import com.how2java.util.Page;

public interface PrivelegeMapper {


    public int add(Privelege privelege);


    public void delete(String id);


    public Privelege get(String id);


    public int update(Privelege privelege);


    public List<Privelege> list();

}