package com.managementSystem.service;

import com.managementSystem.dao.RoleMapper;
import com.managementSystem.pojo.Role;
import com.managementSystem.pojo.RoleExample;
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

    public Role getRoleById(String roleId){
        return roleMapper.selectByPrimaryKey(roleId);
    }

    public List<Role> getRoleByName(String roleName){
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andNameEqualTo(roleName);
        return roleMapper.selectByExample(roleExample);
    }
}
