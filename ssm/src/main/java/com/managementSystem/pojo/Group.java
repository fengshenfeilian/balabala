package com.managementSystem.pojo;

public class Group {
    private String groupId;

    private Integer courseId;

    private String groupName;

    private Integer groupMemberNum;

    private String leaderId;


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getGroupMemberNum() {
        return groupMemberNum;
    }

    public void setGroupMemberNum(Integer groupMemberNum) {
        this.groupMemberNum = groupMemberNum;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId == null ? null : leaderId.trim();
    }
}