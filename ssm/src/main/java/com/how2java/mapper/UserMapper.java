package com.how2java.mapper;

import java.util.List;

import com.how2java.pojo.User;
import com.how2java.util.Page;

public interface UserMapper {


    public int add(User user);


    public void delete(String id);


    public User get(String id);


    public int update(User user);


    public List<User> list();

}