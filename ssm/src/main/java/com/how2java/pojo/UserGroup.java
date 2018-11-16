package com.how2java.pojo;

public class UserGroup {
    private String id;
    private String user_id;
    private String group_id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getRole_id() { return group_id; }
    public void setRole_id(String group_id) { this.group_id = group_id; }

}
