package com.managementSystem.pojo;

public class Student_Course extends Student_CourseKey {
    private Integer assignmentGrade;

    private Integer dailyGrade;

    public Integer getAssignmentGrade() {
        return assignmentGrade;
    }

    public void setAssignmentGrade(Integer assignmentGrade) {
        this.assignmentGrade = assignmentGrade;
    }

    public Integer getDailyGrade() {
        return dailyGrade;
    }

    public void setDailyGrade(Integer dailyGrade) {
        this.dailyGrade = dailyGrade;
    }
}