package com.managementSystem.pojo;

import java.util.Date;

public class Course {
    private Integer courseId;

    private String courseName;

    private String courseDescription;

    private String teacherId;

    private Integer groupCapacityMin;

    private Integer groupCapacityMax;

    private Integer groupPrefix;

    private Date createTime;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription == null ? null : courseDescription.trim();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public Integer getGroupCapacityMin() {
        return groupCapacityMin;
    }

    public void setGroupCapacityMin(Integer groupCapacityMin) {
        this.groupCapacityMin = groupCapacityMin;
    }

    public Integer getGroupCapacityMax() {
        return groupCapacityMax;
    }

    public void setGroupCapacityMax(Integer groupCapacityMax) {
        this.groupCapacityMax = groupCapacityMax;
    }

    public Integer getGroupPrefix() {
        return groupPrefix;
    }

    public void setGroupPrefix(Integer groupPrefix) {
        this.groupPrefix = groupPrefix;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}