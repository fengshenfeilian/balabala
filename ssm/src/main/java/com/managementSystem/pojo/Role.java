package com.managementSystem.pojo;

import java.util.List;

public class Role {
    private String roleId;

    private String name;

    private String description;

    private List<Privelege> pri;

    public List<Privelege> getPri() {
        return pri;
    }

    public void setPri(List<Privelege> pri) {
        this.pri = pri;
    }



    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}