package com.managementSystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class GroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupExample() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
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

        public Criteria andCapacityMinIsNull() {
            addCriterion("CAPACITY_MIN is null");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIsNotNull() {
            addCriterion("CAPACITY_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityMinEqualTo(Integer value) {
            addCriterion("CAPACITY_MIN =", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinNotEqualTo(Integer value) {
            addCriterion("CAPACITY_MIN <>", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinGreaterThan(Integer value) {
            addCriterion("CAPACITY_MIN >", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY_MIN >=", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinLessThan(Integer value) {
            addCriterion("CAPACITY_MIN <", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinLessThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY_MIN <=", value, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinIn(List<Integer> values) {
            addCriterion("CAPACITY_MIN in", values, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinNotIn(List<Integer> values) {
            addCriterion("CAPACITY_MIN not in", values, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY_MIN between", value1, value2, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMinNotBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY_MIN not between", value1, value2, "capacityMin");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIsNull() {
            addCriterion("CAPACITY_MAX is null");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIsNotNull() {
            addCriterion("CAPACITY_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxEqualTo(Integer value) {
            addCriterion("CAPACITY_MAX =", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxNotEqualTo(Integer value) {
            addCriterion("CAPACITY_MAX <>", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxGreaterThan(Integer value) {
            addCriterion("CAPACITY_MAX >", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY_MAX >=", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxLessThan(Integer value) {
            addCriterion("CAPACITY_MAX <", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxLessThanOrEqualTo(Integer value) {
            addCriterion("CAPACITY_MAX <=", value, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxIn(List<Integer> values) {
            addCriterion("CAPACITY_MAX in", values, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxNotIn(List<Integer> values) {
            addCriterion("CAPACITY_MAX not in", values, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY_MAX between", value1, value2, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andCapacityMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("CAPACITY_MAX not between", value1, value2, "capacityMax");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLeaderIdIsNull() {
            addCriterion("LEADER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIdIsNotNull() {
            addCriterion("LEADER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderIdEqualTo(String value) {
            addCriterion("LEADER_ID =", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdNotEqualTo(String value) {
            addCriterion("LEADER_ID <>", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdGreaterThan(String value) {
            addCriterion("LEADER_ID >", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdGreaterThanOrEqualTo(String value) {
            addCriterion("LEADER_ID >=", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdLessThan(String value) {
            addCriterion("LEADER_ID <", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdLessThanOrEqualTo(String value) {
            addCriterion("LEADER_ID <=", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdLike(String value) {
            addCriterion("LEADER_ID like", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdNotLike(String value) {
            addCriterion("LEADER_ID not like", value, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdIn(List<String> values) {
            addCriterion("LEADER_ID in", values, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdNotIn(List<String> values) {
            addCriterion("LEADER_ID not in", values, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdBetween(String value1, String value2) {
            addCriterion("LEADER_ID between", value1, value2, "leaderId");
            return (Criteria) this;
        }

        public Criteria andLeaderIdNotBetween(String value1, String value2) {
            addCriterion("LEADER_ID not between", value1, value2, "leaderId");
            return (Criteria) this;
        }

        public Criteria andIsCreatedIsNull() {
            addCriterion("IS_CREATED is null");
            return (Criteria) this;
        }

        public Criteria andIsCreatedIsNotNull() {
            addCriterion("IS_CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andIsCreatedEqualTo(Boolean value) {
            addCriterion("IS_CREATED =", value, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedNotEqualTo(Boolean value) {
            addCriterion("IS_CREATED <>", value, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedGreaterThan(Boolean value) {
            addCriterion("IS_CREATED >", value, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_CREATED >=", value, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedLessThan(Boolean value) {
            addCriterion("IS_CREATED <", value, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_CREATED <=", value, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedIn(List<Boolean> values) {
            addCriterion("IS_CREATED in", values, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedNotIn(List<Boolean> values) {
            addCriterion("IS_CREATED not in", values, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CREATED between", value1, value2, "isCreated");
            return (Criteria) this;
        }

        public Criteria andIsCreatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CREATED not between", value1, value2, "isCreated");
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