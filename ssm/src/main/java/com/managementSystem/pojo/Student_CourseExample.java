package com.managementSystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class Student_CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Student_CourseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStudentIdIsNull() {
            addCriterion("STUDENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("STUDENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("STUDENT_ID =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("STUDENT_ID <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("STUDENT_ID >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("STUDENT_ID <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("STUDENT_ID like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("STUDENT_ID not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("STUDENT_ID in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("STUDENT_ID not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("STUDENT_ID between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("STUDENT_ID not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("COURSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("COURSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("COURSE_ID =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("COURSE_ID <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("COURSE_ID >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COURSE_ID >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("COURSE_ID <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("COURSE_ID <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("COURSE_ID in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("COURSE_ID not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_ID between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COURSE_ID not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeIsNull() {
            addCriterion("ASSIGNMENT_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeIsNotNull() {
            addCriterion("ASSIGNMENT_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeEqualTo(Integer value) {
            addCriterion("ASSIGNMENT_GRADE =", value, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeNotEqualTo(Integer value) {
            addCriterion("ASSIGNMENT_GRADE <>", value, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeGreaterThan(Integer value) {
            addCriterion("ASSIGNMENT_GRADE >", value, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ASSIGNMENT_GRADE >=", value, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeLessThan(Integer value) {
            addCriterion("ASSIGNMENT_GRADE <", value, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeLessThanOrEqualTo(Integer value) {
            addCriterion("ASSIGNMENT_GRADE <=", value, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeIn(List<Integer> values) {
            addCriterion("ASSIGNMENT_GRADE in", values, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeNotIn(List<Integer> values) {
            addCriterion("ASSIGNMENT_GRADE not in", values, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeBetween(Integer value1, Integer value2) {
            addCriterion("ASSIGNMENT_GRADE between", value1, value2, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andAssignmentGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("ASSIGNMENT_GRADE not between", value1, value2, "assignmentGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeIsNull() {
            addCriterion("DAILY_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andDailyGradeIsNotNull() {
            addCriterion("DAILY_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andDailyGradeEqualTo(Integer value) {
            addCriterion("DAILY_GRADE =", value, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeNotEqualTo(Integer value) {
            addCriterion("DAILY_GRADE <>", value, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeGreaterThan(Integer value) {
            addCriterion("DAILY_GRADE >", value, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DAILY_GRADE >=", value, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeLessThan(Integer value) {
            addCriterion("DAILY_GRADE <", value, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeLessThanOrEqualTo(Integer value) {
            addCriterion("DAILY_GRADE <=", value, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeIn(List<Integer> values) {
            addCriterion("DAILY_GRADE in", values, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeNotIn(List<Integer> values) {
            addCriterion("DAILY_GRADE not in", values, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeBetween(Integer value1, Integer value2) {
            addCriterion("DAILY_GRADE between", value1, value2, "dailyGrade");
            return (Criteria) this;
        }

        public Criteria andDailyGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("DAILY_GRADE not between", value1, value2, "dailyGrade");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}