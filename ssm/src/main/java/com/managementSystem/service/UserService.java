package com.managementSystem.service;

import com.managementSystem.dao.UserMapper;
import com.managementSystem.pojo.User;
import com.managementSystem.pojo.UserExample;
import com.managementSystem.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public List<User> getAllUsersWithRole() {

        //带角色的查询
        return userMapper.selectByExampleWithRole(null);
    }

    public void getUserWithRoleByExample() {
    }

    public void addUserByInput(User user) {
        userMapper.insertSelective(user);
    }

    public void addUserByFile(String name, MultipartFile file) {
        ReadExcel readExcel = new ReadExcel();
        List<User> users = readExcel.getExcelInfo(name, file);
        for(User user : users)
        {
            userMapper.insert(user);
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
