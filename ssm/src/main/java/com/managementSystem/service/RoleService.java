package com.managementSystem.service;

import com.managementSystem.dao.RoleMapper;
import com.managementSystem.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getRoles() {
        List<Role> list = roleMapper.selectByExample(null);
        return  list;
    }
}
