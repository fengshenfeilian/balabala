package com.managementSystem.service;

import com.managementSystem.dao.*;
import com.managementSystem.pojo.*;
import com.managementSystem.util.MD5Utils;
import com.managementSystem.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    Pri_RoleMapper pri_roleMapper;


    //根据当前用户角色id与相应的权限id鉴权
    public boolean Authenticate(String roleId, String priId){

        Pri_RoleExample pri_roleExample = new Pri_RoleExample();
        Pri_RoleExample.Criteria criteria = pri_roleExample.createCriteria();
        criteria.andPriIdEqualTo(priId);
        criteria.andRoleIdEqualTo(roleId);
        return  pri_roleMapper.selectByExample(pri_roleExample).size()>0;

    }

    public List<User> getAllUsersWithRole() {

        //带角色的查询
        return userMapper.selectByExampleWithRole(null);
    }



    public User getUserWithRoleById(String userId){
        if(userId.equals("")||userId==null)return null;
        return userMapper.selectByPrimaryKeyWithRole(userId);
    }

    //提供五个可选条件的查询，检索用不到的条件应为""
    public List<User> getUsersWithRoleByExample(String roleName,String userName,String gender,String department,String classes) {
        //==比较地址,equals比较值
        if(roleName.equals("") && userName.equals("") && gender.equals("") && department.equals("") && classes.equals(""))
            return userMapper.selectByExampleWithRole(null);

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(!roleName.equals(""))criteria.andNameEqualToWithRole(roleName);
        if(!userName.equals(""))criteria.andUserNameEqualTo(userName);
        if(!gender.equals(""))criteria.andGenderEqualTo(gender);
        if(!department.equals(""))criteria.andDepartmentEqualTo(department);
        if(!classes.equals("")) criteria.andClassesEqualTo(classes);

        return userMapper.selectByExampleWithRole(userExample);
    }

    public void addUserByInput(User user) {
        userMapper.insertSelective(user);
    }

    public void addUserByFile(String name, MultipartFile file) {
        ReadExcel readExcel = new ReadExcel();
        List<User> users = readExcel.getExcelInfo(name, file);


        for(User user : users)
        {
            //默认用户密码为学号，并对其进行md5加密
            user.setPassword(MD5Utils.getPwd(user.getUserId()));
            if(userMapper.selectByPrimaryKey(user.getUserId())==null)
                userMapper.insertSelective(user);
        }
    }

    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void deleteUsers(List<String> del_ids) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdIn(del_ids);
        userMapper.deleteByExample(userExample);
    }

    public User checkLogin(String userId, String password) {
        User result = userMapper.selectByPrimaryKeyWithRole(userId);
        if (result != null && result.getPassword().equals(password)) {
            return result;
        }
        return null;
    }
}