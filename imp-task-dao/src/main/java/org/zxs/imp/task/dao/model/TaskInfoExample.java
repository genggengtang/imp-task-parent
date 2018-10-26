package org.zxs.imp.task.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskInfoExample() {
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Byte value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Byte value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Byte value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Byte value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Byte value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Byte> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Byte> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Byte value1, Byte value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTaskLabelIsNull() {
            addCriterion("task_label is null");
            return (Criteria) this;
        }

        public Criteria andTaskLabelIsNotNull() {
            addCriterion("task_label is not null");
            return (Criteria) this;
        }

        public Criteria andTaskLabelEqualTo(String value) {
            addCriterion("task_label =", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotEqualTo(String value) {
            addCriterion("task_label <>", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelGreaterThan(String value) {
            addCriterion("task_label >", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelGreaterThanOrEqualTo(String value) {
            addCriterion("task_label >=", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelLessThan(String value) {
            addCriterion("task_label <", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelLessThanOrEqualTo(String value) {
            addCriterion("task_label <=", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelLike(String value) {
            addCriterion("task_label like", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotLike(String value) {
            addCriterion("task_label not like", value, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelIn(List<String> values) {
            addCriterion("task_label in", values, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotIn(List<String> values) {
            addCriterion("task_label not in", values, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelBetween(String value1, String value2) {
            addCriterion("task_label between", value1, value2, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andTaskLabelNotBetween(String value1, String value2) {
            addCriterion("task_label not between", value1, value2, "taskLabel");
            return (Criteria) this;
        }

        public Criteria andIsPeriodIsNull() {
            addCriterion("is_period is null");
            return (Criteria) this;
        }

        public Criteria andIsPeriodIsNotNull() {
            addCriterion("is_period is not null");
            return (Criteria) this;
        }

        public Criteria andIsPeriodEqualTo(Byte value) {
            addCriterion("is_period =", value, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodNotEqualTo(Byte value) {
            addCriterion("is_period <>", value, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodGreaterThan(Byte value) {
            addCriterion("is_period >", value, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_period >=", value, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodLessThan(Byte value) {
            addCriterion("is_period <", value, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodLessThanOrEqualTo(Byte value) {
            addCriterion("is_period <=", value, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodIn(List<Byte> values) {
            addCriterion("is_period in", values, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodNotIn(List<Byte> values) {
            addCriterion("is_period not in", values, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodBetween(Byte value1, Byte value2) {
            addCriterion("is_period between", value1, value2, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andIsPeriodNotBetween(Byte value1, Byte value2) {
            addCriterion("is_period not between", value1, value2, "isPeriod");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeIsNull() {
            addCriterion("period_type is null");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeIsNotNull() {
            addCriterion("period_type is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeEqualTo(Integer value) {
            addCriterion("period_type =", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeNotEqualTo(Integer value) {
            addCriterion("period_type <>", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeGreaterThan(Integer value) {
            addCriterion("period_type >", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("period_type >=", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeLessThan(Integer value) {
            addCriterion("period_type <", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeLessThanOrEqualTo(Integer value) {
            addCriterion("period_type <=", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeIn(List<Integer> values) {
            addCriterion("period_type in", values, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeNotIn(List<Integer> values) {
            addCriterion("period_type not in", values, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeBetween(Integer value1, Integer value2) {
            addCriterion("period_type between", value1, value2, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("period_type not between", value1, value2, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysIsNull() {
            addCriterion("period_days is null");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysIsNotNull() {
            addCriterion("period_days is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysEqualTo(Short value) {
            addCriterion("period_days =", value, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysNotEqualTo(Short value) {
            addCriterion("period_days <>", value, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysGreaterThan(Short value) {
            addCriterion("period_days >", value, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysGreaterThanOrEqualTo(Short value) {
            addCriterion("period_days >=", value, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysLessThan(Short value) {
            addCriterion("period_days <", value, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysLessThanOrEqualTo(Short value) {
            addCriterion("period_days <=", value, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysIn(List<Short> values) {
            addCriterion("period_days in", values, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysNotIn(List<Short> values) {
            addCriterion("period_days not in", values, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysBetween(Short value1, Short value2) {
            addCriterion("period_days between", value1, value2, "periodDays");
            return (Criteria) this;
        }

        public Criteria andPeriodDaysNotBetween(Short value1, Short value2) {
            addCriterion("period_days not between", value1, value2, "periodDays");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelIsNull() {
            addCriterion("urgent_level is null");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelIsNotNull() {
            addCriterion("urgent_level is not null");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelEqualTo(Byte value) {
            addCriterion("urgent_level =", value, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelNotEqualTo(Byte value) {
            addCriterion("urgent_level <>", value, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelGreaterThan(Byte value) {
            addCriterion("urgent_level >", value, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("urgent_level >=", value, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelLessThan(Byte value) {
            addCriterion("urgent_level <", value, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelLessThanOrEqualTo(Byte value) {
            addCriterion("urgent_level <=", value, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelIn(List<Byte> values) {
            addCriterion("urgent_level in", values, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelNotIn(List<Byte> values) {
            addCriterion("urgent_level not in", values, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelBetween(Byte value1, Byte value2) {
            addCriterion("urgent_level between", value1, value2, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andUrgentLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("urgent_level not between", value1, value2, "urgentLevel");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andEndDateDesIsNull() {
            addCriterion("end_date_des is null");
            return (Criteria) this;
        }

        public Criteria andEndDateDesIsNotNull() {
            addCriterion("end_date_des is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateDesEqualTo(String value) {
            addCriterion("end_date_des =", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesNotEqualTo(String value) {
            addCriterion("end_date_des <>", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesGreaterThan(String value) {
            addCriterion("end_date_des >", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesGreaterThanOrEqualTo(String value) {
            addCriterion("end_date_des >=", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesLessThan(String value) {
            addCriterion("end_date_des <", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesLessThanOrEqualTo(String value) {
            addCriterion("end_date_des <=", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesLike(String value) {
            addCriterion("end_date_des like", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesNotLike(String value) {
            addCriterion("end_date_des not like", value, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesIn(List<String> values) {
            addCriterion("end_date_des in", values, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesNotIn(List<String> values) {
            addCriterion("end_date_des not in", values, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesBetween(String value1, String value2) {
            addCriterion("end_date_des between", value1, value2, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andEndDateDesNotBetween(String value1, String value2) {
            addCriterion("end_date_des not between", value1, value2, "endDateDes");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdIsNull() {
            addCriterion("current_sub_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdIsNotNull() {
            addCriterion("current_sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdEqualTo(Long value) {
            addCriterion("current_sub_id =", value, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdNotEqualTo(Long value) {
            addCriterion("current_sub_id <>", value, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdGreaterThan(Long value) {
            addCriterion("current_sub_id >", value, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdGreaterThanOrEqualTo(Long value) {
            addCriterion("current_sub_id >=", value, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdLessThan(Long value) {
            addCriterion("current_sub_id <", value, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdLessThanOrEqualTo(Long value) {
            addCriterion("current_sub_id <=", value, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdIn(List<Long> values) {
            addCriterion("current_sub_id in", values, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdNotIn(List<Long> values) {
            addCriterion("current_sub_id not in", values, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdBetween(Long value1, Long value2) {
            addCriterion("current_sub_id between", value1, value2, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andCurrentSubIdNotBetween(Long value1, Long value2) {
            addCriterion("current_sub_id not between", value1, value2, "currentSubId");
            return (Criteria) this;
        }

        public Criteria andOaGuidIsNull() {
            addCriterion("oa_guid is null");
            return (Criteria) this;
        }

        public Criteria andOaGuidIsNotNull() {
            addCriterion("oa_guid is not null");
            return (Criteria) this;
        }

        public Criteria andOaGuidEqualTo(String value) {
            addCriterion("oa_guid =", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidNotEqualTo(String value) {
            addCriterion("oa_guid <>", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidGreaterThan(String value) {
            addCriterion("oa_guid >", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidGreaterThanOrEqualTo(String value) {
            addCriterion("oa_guid >=", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidLessThan(String value) {
            addCriterion("oa_guid <", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidLessThanOrEqualTo(String value) {
            addCriterion("oa_guid <=", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidLike(String value) {
            addCriterion("oa_guid like", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidNotLike(String value) {
            addCriterion("oa_guid not like", value, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidIn(List<String> values) {
            addCriterion("oa_guid in", values, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidNotIn(List<String> values) {
            addCriterion("oa_guid not in", values, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidBetween(String value1, String value2) {
            addCriterion("oa_guid between", value1, value2, "oaGuid");
            return (Criteria) this;
        }

        public Criteria andOaGuidNotBetween(String value1, String value2) {
            addCriterion("oa_guid not between", value1, value2, "oaGuid");
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