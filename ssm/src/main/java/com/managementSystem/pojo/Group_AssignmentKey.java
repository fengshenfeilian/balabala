package com.managementSystem.pojo;

public class Group_AssignmentKey {
    private String assignmentId;

    private String groupId;

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId == null ? null : assignmentId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }
}