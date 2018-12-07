package com.managementSystem.pojo;

import javax.validation.constraints.Pattern;

public class User {
    @Pattern(regexp = "^[a-zA-Z0-9_-]{3,16}$",
            message ="用户id格式错误，应为3到16位的字母数字组合" )
    private String userId;

    private String roleId;

    private String password;

    @Pattern(regexp = "(^[a-zA-Z_-]{1,10}$)|(^[\\u2E80-\\u9FFF]{2,5})",
            message = "用户名格式错误，应为1到10位的字母或2到5位的中文")
    private String userName;

    private String gender;

    @Pattern(regexp = "(^[a-z\\d]+(\\.[a-z\\d]+)*@([\\da-z](-[\\da-z])?)+(\\.{1,2}[a-z]+)+$)|(^$)",
            message ="Email格式错误" )
    private String email;

    private String department;

    private String major;

    private String classes;

    private Integer pwdDefault;

    //联表查询用
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public Integer getPwdDefault() {
        return pwdDefault;
    }

    public void setPwdDefault(Integer pwdDefault) {
        this.pwdDefault = pwdDefault;
    }
}