package com.managementSystem.pojo;

public class User {
    private String userId;

    private String roleId;

    private String password;

    private String userName;

    private String gender;

    private String email;

    private Integer firstLogin;

    private String department;

    private String major;

    private String classNum;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Integer firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }

    public String getMajor() { return major; }

    public void setMajor(String major) { this.major = major; }

    public String getClassNum() { return classNum; }

    public void setClassNum(String classNum) { this.classNum = classNum; }
}