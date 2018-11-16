package com.how2java.pojo;

public class Job {
    private String id;
    private String title;
    private String body;
    private String assign_id;
    private String group_id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public String getAssign_id() {return assign_id; }
    public void setAssign_id(String assign_id) { this.assign_id = assign_id; }
    public String getGroup_id() {return group_id; }
    public void setGroup_id(String group_id) { this.group_id = group_id; }

}
