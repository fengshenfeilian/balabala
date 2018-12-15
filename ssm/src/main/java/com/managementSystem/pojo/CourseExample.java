package com.managementSystem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseNameIsNull() {
            addCriterion("COURSE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("COURSE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("COURSE_NAME =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("COURSE_NAME <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("COURSE_NAME >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("COURSE_NAME <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("COURSE_NAME <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("COURSE_NAME like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("COURSE_NAME not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("COURSE_NAME in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("COURSE_NAME not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("COURSE_NAME between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("COURSE_NAME not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionIsNull() {
            addCriterion("COURSE_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionIsNotNull() {
            addCriterion("COURSE_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionEqualTo(String value) {
            addCriterion("COURSE_DESCRIPTION =", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotEqualTo(String value) {
            addCriterion("COURSE_DESCRIPTION <>", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionGreaterThan(String value) {
            addCriterion("COURSE_DESCRIPTION >", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("COURSE_DESCRIPTION >=", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionLessThan(String value) {
            addCriterion("COURSE_DESCRIPTION <", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionLessThanOrEqualTo(String value) {
            addCriterion("COURSE_DESCRIPTION <=", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionLike(String value) {
            addCriterion("COURSE_DESCRIPTION like", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotLike(String value) {
            addCriterion("COURSE_DESCRIPTION not like", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionIn(List<String> values) {
            addCriterion("COURSE_DESCRIPTION in", values, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotIn(List<String> values) {
            addCriterion("COURSE_DESCRIPTION not in", values, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionBetween(String value1, String value2) {
            addCriterion("COURSE_DESCRIPTION between", value1, value2, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotBetween(String value1, String value2) {
            addCriterion("COURSE_DESCRIPTION not between", value1, value2, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("TEACHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("TEACHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("TEACHER_ID =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("TEACHER_ID <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("TEACHER_ID >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("TEACHER_ID <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("TEACHER_ID like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("TEACHER_ID not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("TEACHER_ID in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("TEACHER_ID not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("TEACHER_ID between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("TEACHER_ID not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinIsNull() {
            addCriterion("GROUP_CAPACITY_MIN is null");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinIsNotNull() {
            addCriterion("GROUP_CAPACITY_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MIN =", value, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinNotEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MIN <>", value, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinGreaterThan(Integer value) {
            addCriterion("GROUP_CAPACITY_MIN >", value, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MIN >=", value, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinLessThan(Integer value) {
            addCriterion("GROUP_CAPACITY_MIN <", value, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinLessThanOrEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MIN <=", value, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinIn(List<Integer> values) {
            addCriterion("GROUP_CAPACITY_MIN in", values, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinNotIn(List<Integer> values) {
            addCriterion("GROUP_CAPACITY_MIN not in", values, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_CAPACITY_MIN between", value1, value2, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMinNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_CAPACITY_MIN not between", value1, value2, "groupCapacityMin");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxIsNull() {
            addCriterion("GROUP_CAPACITY_MAX is null");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxIsNotNull() {
            addCriterion("GROUP_CAPACITY_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MAX =", value, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxNotEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MAX <>", value, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxGreaterThan(Integer value) {
            addCriterion("GROUP_CAPACITY_MAX >", value, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MAX >=", value, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxLessThan(Integer value) {
            addCriterion("GROUP_CAPACITY_MAX <", value, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxLessThanOrEqualTo(Integer value) {
            addCriterion("GROUP_CAPACITY_MAX <=", value, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxIn(List<Integer> values) {
            addCriterion("GROUP_CAPACITY_MAX in", values, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxNotIn(List<Integer> values) {
            addCriterion("GROUP_CAPACITY_MAX not in", values, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_CAPACITY_MAX between", value1, value2, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupCapacityMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_CAPACITY_MAX not between", value1, value2, "groupCapacityMax");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixIsNull() {
            addCriterion("GROUP_PREFIX is null");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixIsNotNull() {
            addCriterion("GROUP_PREFIX is not null");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixEqualTo(String value) {
            addCriterion("GROUP_PREFIX =", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixNotEqualTo(String value) {
            addCriterion("GROUP_PREFIX <>", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixGreaterThan(String value) {
            addCriterion("GROUP_PREFIX >", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_PREFIX >=", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixLessThan(String value) {
            addCriterion("GROUP_PREFIX <", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixLessThanOrEqualTo(String value) {
            addCriterion("GROUP_PREFIX <=", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixLike(String value) {
            addCriterion("GROUP_PREFIX like", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixNotLike(String value) {
            addCriterion("GROUP_PREFIX not like", value, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixIn(List<String> values) {
            addCriterion("GROUP_PREFIX in", values, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixNotIn(List<String> values) {
            addCriterion("GROUP_PREFIX not in", values, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixBetween(String value1, String value2) {
            addCriterion("GROUP_PREFIX between", value1, value2, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andGroupPrefixNotBetween(String value1, String value2) {
            addCriterion("GROUP_PREFIX not between", value1, value2, "groupPrefix");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andIsEndIsNull() {
            addCriterion("IS_END is null");
            return (Criteria) this;
        }

        public Criteria andIsEndIsNotNull() {
            addCriterion("IS_END is not null");
            return (Criteria) this;
        }

        public Criteria andIsEndEqualTo(Integer value) {
            addCriterion("IS_END =", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotEqualTo(Integer value) {
            addCriterion("IS_END <>", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndGreaterThan(Integer value) {
            addCriterion("IS_END >", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_END >=", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndLessThan(Integer value) {
            addCriterion("IS_END <", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndLessThanOrEqualTo(Integer value) {
            addCriterion("IS_END <=", value, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndIn(List<Integer> values) {
            addCriterion("IS_END in", values, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotIn(List<Integer> values) {
            addCriterion("IS_END not in", values, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndBetween(Integer value1, Integer value2) {
            addCriterion("IS_END between", value1, value2, "isEnd");
            return (Criteria) this;
        }

        public Criteria andIsEndNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_END not between", value1, value2, "isEnd");
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