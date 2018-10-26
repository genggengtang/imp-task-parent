package org.zxs.imp.task.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SubTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubTaskExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andAlertDateIsNull() {
            addCriterion("alert_date is null");
            return (Criteria) this;
        }

        public Criteria andAlertDateIsNotNull() {
            addCriterion("alert_date is not null");
            return (Criteria) this;
        }

        public Criteria andAlertDateEqualTo(Date value) {
            addCriterionForJDBCDate("alert_date =", value, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("alert_date <>", value, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateGreaterThan(Date value) {
            addCriterionForJDBCDate("alert_date >", value, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("alert_date >=", value, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateLessThan(Date value) {
            addCriterionForJDBCDate("alert_date <", value, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("alert_date <=", value, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateIn(List<Date> values) {
            addCriterionForJDBCDate("alert_date in", values, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("alert_date not in", values, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("alert_date between", value1, value2, "alertDate");
            return (Criteria) this;
        }

        public Criteria andAlertDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("alert_date not between", value1, value2, "alertDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andDraftCommentIsNull() {
            addCriterion("draft_comment is null");
            return (Criteria) this;
        }

        public Criteria andDraftCommentIsNotNull() {
            addCriterion("draft_comment is not null");
            return (Criteria) this;
        }

        public Criteria andDraftCommentEqualTo(String value) {
            addCriterion("draft_comment =", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentNotEqualTo(String value) {
            addCriterion("draft_comment <>", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentGreaterThan(String value) {
            addCriterion("draft_comment >", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentGreaterThanOrEqualTo(String value) {
            addCriterion("draft_comment >=", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentLessThan(String value) {
            addCriterion("draft_comment <", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentLessThanOrEqualTo(String value) {
            addCriterion("draft_comment <=", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentLike(String value) {
            addCriterion("draft_comment like", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentNotLike(String value) {
            addCriterion("draft_comment not like", value, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentIn(List<String> values) {
            addCriterion("draft_comment in", values, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentNotIn(List<String> values) {
            addCriterion("draft_comment not in", values, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentBetween(String value1, String value2) {
            addCriterion("draft_comment between", value1, value2, "draftComment");
            return (Criteria) this;
        }

        public Criteria andDraftCommentNotBetween(String value1, String value2) {
            addCriterion("draft_comment not between", value1, value2, "draftComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentIsNull() {
            addCriterion("prc_comment is null");
            return (Criteria) this;
        }

        public Criteria andPrcCommentIsNotNull() {
            addCriterion("prc_comment is not null");
            return (Criteria) this;
        }

        public Criteria andPrcCommentEqualTo(String value) {
            addCriterion("prc_comment =", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentNotEqualTo(String value) {
            addCriterion("prc_comment <>", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentGreaterThan(String value) {
            addCriterion("prc_comment >", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentGreaterThanOrEqualTo(String value) {
            addCriterion("prc_comment >=", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentLessThan(String value) {
            addCriterion("prc_comment <", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentLessThanOrEqualTo(String value) {
            addCriterion("prc_comment <=", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentLike(String value) {
            addCriterion("prc_comment like", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentNotLike(String value) {
            addCriterion("prc_comment not like", value, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentIn(List<String> values) {
            addCriterion("prc_comment in", values, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentNotIn(List<String> values) {
            addCriterion("prc_comment not in", values, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentBetween(String value1, String value2) {
            addCriterion("prc_comment between", value1, value2, "prcComment");
            return (Criteria) this;
        }

        public Criteria andPrcCommentNotBetween(String value1, String value2) {
            addCriterion("prc_comment not between", value1, value2, "prcComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentIsNull() {
            addCriterion("final_comment is null");
            return (Criteria) this;
        }

        public Criteria andFinalCommentIsNotNull() {
            addCriterion("final_comment is not null");
            return (Criteria) this;
        }

        public Criteria andFinalCommentEqualTo(String value) {
            addCriterion("final_comment =", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentNotEqualTo(String value) {
            addCriterion("final_comment <>", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentGreaterThan(String value) {
            addCriterion("final_comment >", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentGreaterThanOrEqualTo(String value) {
            addCriterion("final_comment >=", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentLessThan(String value) {
            addCriterion("final_comment <", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentLessThanOrEqualTo(String value) {
            addCriterion("final_comment <=", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentLike(String value) {
            addCriterion("final_comment like", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentNotLike(String value) {
            addCriterion("final_comment not like", value, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentIn(List<String> values) {
            addCriterion("final_comment in", values, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentNotIn(List<String> values) {
            addCriterion("final_comment not in", values, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentBetween(String value1, String value2) {
            addCriterion("final_comment between", value1, value2, "finalComment");
            return (Criteria) this;
        }

        public Criteria andFinalCommentNotBetween(String value1, String value2) {
            addCriterion("final_comment not between", value1, value2, "finalComment");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNull() {
            addCriterion("finish_date is null");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNotNull() {
            addCriterion("finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinishDateEqualTo(Date value) {
            addCriterionForJDBCDate("finish_date =", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("finish_date <>", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThan(Date value) {
            addCriterionForJDBCDate("finish_date >", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("finish_date >=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThan(Date value) {
            addCriterionForJDBCDate("finish_date <", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("finish_date <=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateIn(List<Date> values) {
            addCriterionForJDBCDate("finish_date in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("finish_date not in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("finish_date between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("finish_date not between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
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