package com.managementSystem.pojo;

public class Pri_RoleKey {
    private String roleId;

    private String priId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPriId() {
        return priId;
    }

    public void setPriId(String priId) {
        this.priId = priId == null ? null : priId.trim();
    }
}