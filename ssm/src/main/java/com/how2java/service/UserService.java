package com.how2java.service;

import java.util.List;

import com.how2java.pojo.User;
import com.how2java.util.Page;

public interface UserService {

    User login(String name, String password);

    void createStudents(List<User> users);

    void createTeachers(List<User> users);

    void updateUserInfo(User user);

    void deleteUser(String id);
}
