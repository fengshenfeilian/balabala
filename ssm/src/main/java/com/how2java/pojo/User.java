package com.how2java.pojo;

public class User {
    private String id;
    private String name;
    private String pwd;
    private String birthday;
    private String gender;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }
    public String getBirthday() {return birthday; }
    public void setBrithday(String birth) { this.birthday = birth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

}
