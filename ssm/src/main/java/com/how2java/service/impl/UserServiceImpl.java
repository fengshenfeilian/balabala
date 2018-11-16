package com.how2java.service.impl;

import com.how2java.mapper.RoleMapper;
import com.how2java.mapper.UserMapper;
import com.how2java.pojo.Role;
import com.how2java.pojo.User;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    private RoleMapper roleMapper;

    @Override
    public User login(String name, String password)
    {
        User user = userMapper.get(name);
        if (user != null && user.getPwd().equals(password))
        {
            return user;
        }
        return null;
    }

    @Override
    public void createStudents(List<User> users)
    {
        for (User user : users)
        {
            userMapper.add(user);
            Role role = new Role();
            role.setId(user.getId());
            role.setName("student");
            roleMapper.add(role);
        }
    }

    @Override
    public void createTeachers(List<User> users)
    {
        for( User user : users)
        {
            userMapper.add(user);
            Role role = new Role();
            role.setId(user.getId());
            role.setName("teacher");
            roleMapper.add(role);
        }
    }

    @Override
    public void updateUserInfo(User user)
    {
        userMapper.update(user);
    }

    @Override
    public void deleteUser(String id)
    {
        userMapper.delete(id);
    }

}
