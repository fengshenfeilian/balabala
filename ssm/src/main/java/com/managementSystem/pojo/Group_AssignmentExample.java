package com.managementSystem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group_AssignmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Group_AssignmentExample() {
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

        public Criteria andAssignmentIdIsNull() {
            addCriterion("ASSIGNMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdIsNotNull() {
            addCriterion("ASSIGNMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdEqualTo(String value) {
            addCriterion("ASSIGNMENT_ID =", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdNotEqualTo(String value) {
            addCriterion("ASSIGNMENT_ID <>", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdGreaterThan(String value) {
            addCriterion("ASSIGNMENT_ID >", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("ASSIGNMENT_ID >=", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdLessThan(String value) {
            addCriterion("ASSIGNMENT_ID <", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdLessThanOrEqualTo(String value) {
            addCriterion("ASSIGNMENT_ID <=", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdLike(String value) {
            addCriterion("ASSIGNMENT_ID like", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdNotLike(String value) {
            addCriterion("ASSIGNMENT_ID not like", value, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdIn(List<String> values) {
            addCriterion("ASSIGNMENT_ID in", values, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdNotIn(List<String> values) {
            addCriterion("ASSIGNMENT_ID not in", values, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdBetween(String value1, String value2) {
            addCriterion("ASSIGNMENT_ID between", value1, value2, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andAssignmentIdNotBetween(String value1, String value2) {
            addCriterion("ASSIGNMENT_ID not between", value1, value2, "assignmentId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("GROUP_ID like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("GROUP_ID not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("BODY is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("BODY is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("BODY =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("BODY <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("BODY >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("BODY >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("BODY <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("BODY <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("BODY like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("BODY not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("BODY in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("BODY not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("BODY between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("BODY not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeIsNull() {
            addCriterion("SUBMISSION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeIsNotNull() {
            addCriterion("SUBMISSION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeEqualTo(Date value) {
            addCriterion("SUBMISSION_TIME =", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeNotEqualTo(Date value) {
            addCriterion("SUBMISSION_TIME <>", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeGreaterThan(Date value) {
            addCriterion("SUBMISSION_TIME >", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SUBMISSION_TIME >=", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeLessThan(Date value) {
            addCriterion("SUBMISSION_TIME <", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeLessThanOrEqualTo(Date value) {
            addCriterion("SUBMISSION_TIME <=", value, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeIn(List<Date> values) {
            addCriterion("SUBMISSION_TIME in", values, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeNotIn(List<Date> values) {
            addCriterion("SUBMISSION_TIME not in", values, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeBetween(Date value1, Date value2) {
            addCriterion("SUBMISSION_TIME between", value1, value2, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andSubmissionTimeNotBetween(Date value1, Date value2) {
            addCriterion("SUBMISSION_TIME not between", value1, value2, "submissionTime");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("SCORE not between", value1, value2, "score");
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