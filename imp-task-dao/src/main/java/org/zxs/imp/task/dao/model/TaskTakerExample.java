package org.zxs.imp.task.dao.model;

import java.util.ArrayList;
import java.util.List;

public class TaskTakerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskTakerExample() {
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

        public Criteria andSubTaskIdIsNull() {
            addCriterion("sub_task_id is null");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdIsNotNull() {
            addCriterion("sub_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdEqualTo(Long value) {
            addCriterion("sub_task_id =", value, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdNotEqualTo(Long value) {
            addCriterion("sub_task_id <>", value, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdGreaterThan(Long value) {
            addCriterion("sub_task_id >", value, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_task_id >=", value, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdLessThan(Long value) {
            addCriterion("sub_task_id <", value, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("sub_task_id <=", value, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdIn(List<Long> values) {
            addCriterion("sub_task_id in", values, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdNotIn(List<Long> values) {
            addCriterion("sub_task_id not in", values, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdBetween(Long value1, Long value2) {
            addCriterion("sub_task_id between", value1, value2, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andSubTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("sub_task_id not between", value1, value2, "subTaskId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDeptRoleIsNull() {
            addCriterion("dept_role is null");
            return (Criteria) this;
        }

        public Criteria andDeptRoleIsNotNull() {
            addCriterion("dept_role is not null");
            return (Criteria) this;
        }

        public Criteria andDeptRoleEqualTo(Byte value) {
            addCriterion("dept_role =", value, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleNotEqualTo(Byte value) {
            addCriterion("dept_role <>", value, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleGreaterThan(Byte value) {
            addCriterion("dept_role >", value, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("dept_role >=", value, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleLessThan(Byte value) {
            addCriterion("dept_role <", value, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleLessThanOrEqualTo(Byte value) {
            addCriterion("dept_role <=", value, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleIn(List<Byte> values) {
            addCriterion("dept_role in", values, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleNotIn(List<Byte> values) {
            addCriterion("dept_role not in", values, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleBetween(Byte value1, Byte value2) {
            addCriterion("dept_role between", value1, value2, "deptRole");
            return (Criteria) this;
        }

        public Criteria andDeptRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("dept_role not between", value1, value2, "deptRole");
            return (Criteria) this;
        }

        public Criteria andIsProverIsNull() {
            addCriterion("is_prover is null");
            return (Criteria) this;
        }

        public Criteria andIsProverIsNotNull() {
            addCriterion("is_prover is not null");
            return (Criteria) this;
        }

        public Criteria andIsProverEqualTo(Byte value) {
            addCriterion("is_prover =", value, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverNotEqualTo(Byte value) {
            addCriterion("is_prover <>", value, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverGreaterThan(Byte value) {
            addCriterion("is_prover >", value, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_prover >=", value, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverLessThan(Byte value) {
            addCriterion("is_prover <", value, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverLessThanOrEqualTo(Byte value) {
            addCriterion("is_prover <=", value, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverIn(List<Byte> values) {
            addCriterion("is_prover in", values, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverNotIn(List<Byte> values) {
            addCriterion("is_prover not in", values, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverBetween(Byte value1, Byte value2) {
            addCriterion("is_prover between", value1, value2, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsProverNotBetween(Byte value1, Byte value2) {
            addCriterion("is_prover not between", value1, value2, "isProver");
            return (Criteria) this;
        }

        public Criteria andIsSwitchIsNull() {
            addCriterion("is_switch is null");
            return (Criteria) this;
        }

        public Criteria andIsSwitchIsNotNull() {
            addCriterion("is_switch is not null");
            return (Criteria) this;
        }

        public Criteria andIsSwitchEqualTo(Byte value) {
            addCriterion("is_switch =", value, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchNotEqualTo(Byte value) {
            addCriterion("is_switch <>", value, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchGreaterThan(Byte value) {
            addCriterion("is_switch >", value, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_switch >=", value, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchLessThan(Byte value) {
            addCriterion("is_switch <", value, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchLessThanOrEqualTo(Byte value) {
            addCriterion("is_switch <=", value, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchIn(List<Byte> values) {
            addCriterion("is_switch in", values, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchNotIn(List<Byte> values) {
            addCriterion("is_switch not in", values, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchBetween(Byte value1, Byte value2) {
            addCriterion("is_switch between", value1, value2, "isSwitch");
            return (Criteria) this;
        }

        public Criteria andIsSwitchNotBetween(Byte value1, Byte value2) {
            addCriterion("is_switch not between", value1, value2, "isSwitch");
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