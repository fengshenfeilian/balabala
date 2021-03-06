package com.managementSystem.pojo;

import java.util.Date;

public class Course {
    private Integer courseId;

    private String courseName;

    private String courseDescription;

    private String teacherId;

    private Integer groupCapacityMin;

    private Integer groupCapacityMax;

    private String groupPrefix;

    private Date createTime;

    private Integer isEnd;

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

    public String getGroupPrefix() {
        return groupPrefix;
    }

    public void setGroupPrefix(String groupPrefix) {
        this.groupPrefix = groupPrefix == null ? null : groupPrefix.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }
}