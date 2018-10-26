package org.zxs.imp.task.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OaFileInfoDraftExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OaFileInfoDraftExample() {
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

        public Criteria andFileGuidIsNull() {
            addCriterion("file_guid is null");
            return (Criteria) this;
        }

        public Criteria andFileGuidIsNotNull() {
            addCriterion("file_guid is not null");
            return (Criteria) this;
        }

        public Criteria andFileGuidEqualTo(String value) {
            addCriterion("file_guid =", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidNotEqualTo(String value) {
            addCriterion("file_guid <>", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidGreaterThan(String value) {
            addCriterion("file_guid >", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidGreaterThanOrEqualTo(String value) {
            addCriterion("file_guid >=", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidLessThan(String value) {
            addCriterion("file_guid <", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidLessThanOrEqualTo(String value) {
            addCriterion("file_guid <=", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidLike(String value) {
            addCriterion("file_guid like", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidNotLike(String value) {
            addCriterion("file_guid not like", value, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidIn(List<String> values) {
            addCriterion("file_guid in", values, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidNotIn(List<String> values) {
            addCriterion("file_guid not in", values, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidBetween(String value1, String value2) {
            addCriterion("file_guid between", value1, value2, "fileGuid");
            return (Criteria) this;
        }

        public Criteria andFileGuidNotBetween(String value1, String value2) {
            addCriterion("file_guid not between", value1, value2, "fileGuid");
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

        public Criteria andFileCodeIsNull() {
            addCriterion("file_code is null");
            return (Criteria) this;
        }

        public Criteria andFileCodeIsNotNull() {
            addCriterion("file_code is not null");
            return (Criteria) this;
        }

        public Criteria andFileCodeEqualTo(String value) {
            addCriterion("file_code =", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotEqualTo(String value) {
            addCriterion("file_code <>", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeGreaterThan(String value) {
            addCriterion("file_code >", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeGreaterThanOrEqualTo(String value) {
            addCriterion("file_code >=", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeLessThan(String value) {
            addCriterion("file_code <", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeLessThanOrEqualTo(String value) {
            addCriterion("file_code <=", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeLike(String value) {
            addCriterion("file_code like", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotLike(String value) {
            addCriterion("file_code not like", value, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeIn(List<String> values) {
            addCriterion("file_code in", values, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotIn(List<String> values) {
            addCriterion("file_code not in", values, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeBetween(String value1, String value2) {
            addCriterion("file_code between", value1, value2, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileCodeNotBetween(String value1, String value2) {
            addCriterion("file_code not between", value1, value2, "fileCode");
            return (Criteria) this;
        }

        public Criteria andFileOrgIsNull() {
            addCriterion("file_org is null");
            return (Criteria) this;
        }

        public Criteria andFileOrgIsNotNull() {
            addCriterion("file_org is not null");
            return (Criteria) this;
        }

        public Criteria andFileOrgEqualTo(String value) {
            addCriterion("file_org =", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgNotEqualTo(String value) {
            addCriterion("file_org <>", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgGreaterThan(String value) {
            addCriterion("file_org >", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgGreaterThanOrEqualTo(String value) {
            addCriterion("file_org >=", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgLessThan(String value) {
            addCriterion("file_org <", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgLessThanOrEqualTo(String value) {
            addCriterion("file_org <=", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgLike(String value) {
            addCriterion("file_org like", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgNotLike(String value) {
            addCriterion("file_org not like", value, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgIn(List<String> values) {
            addCriterion("file_org in", values, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgNotIn(List<String> values) {
            addCriterion("file_org not in", values, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgBetween(String value1, String value2) {
            addCriterion("file_org between", value1, value2, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileOrgNotBetween(String value1, String value2) {
            addCriterion("file_org not between", value1, value2, "fileOrg");
            return (Criteria) this;
        }

        public Criteria andFileDateIsNull() {
            addCriterion("file_date is null");
            return (Criteria) this;
        }

        public Criteria andFileDateIsNotNull() {
            addCriterion("file_date is not null");
            return (Criteria) this;
        }

        public Criteria andFileDateEqualTo(Date value) {
            addCriterionForJDBCDate("file_date =", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("file_date <>", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateGreaterThan(Date value) {
            addCriterionForJDBCDate("file_date >", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("file_date >=", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateLessThan(Date value) {
            addCriterionForJDBCDate("file_date <", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("file_date <=", value, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateIn(List<Date> values) {
            addCriterionForJDBCDate("file_date in", values, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("file_date not in", values, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("file_date between", value1, value2, "fileDate");
            return (Criteria) this;
        }

        public Criteria andFileDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("file_date not between", value1, value2, "fileDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNull() {
            addCriterion("receive_date is null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNotNull() {
            addCriterion("receive_date is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateEqualTo(Date value) {
            addCriterionForJDBCDate("receive_date =", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("receive_date <>", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThan(Date value) {
            addCriterionForJDBCDate("receive_date >", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("receive_date >=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThan(Date value) {
            addCriterionForJDBCDate("receive_date <", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("receive_date <=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIn(List<Date> values) {
            addCriterionForJDBCDate("receive_date in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("receive_date not in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("receive_date between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("receive_date not between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andApprovalIsNull() {
            addCriterion("approval is null");
            return (Criteria) this;
        }

        public Criteria andApprovalIsNotNull() {
            addCriterion("approval is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalEqualTo(String value) {
            addCriterion("approval =", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotEqualTo(String value) {
            addCriterion("approval <>", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalGreaterThan(String value) {
            addCriterion("approval >", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalGreaterThanOrEqualTo(String value) {
            addCriterion("approval >=", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalLessThan(String value) {
            addCriterion("approval <", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalLessThanOrEqualTo(String value) {
            addCriterion("approval <=", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalLike(String value) {
            addCriterion("approval like", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotLike(String value) {
            addCriterion("approval not like", value, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalIn(List<String> values) {
            addCriterion("approval in", values, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotIn(List<String> values) {
            addCriterion("approval not in", values, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalBetween(String value1, String value2) {
            addCriterion("approval between", value1, value2, "approval");
            return (Criteria) this;
        }

        public Criteria andApprovalNotBetween(String value1, String value2) {
            addCriterion("approval not between", value1, value2, "approval");
            return (Criteria) this;
        }

        public Criteria andCheckReadIsNull() {
            addCriterion("check_read is null");
            return (Criteria) this;
        }

        public Criteria andCheckReadIsNotNull() {
            addCriterion("check_read is not null");
            return (Criteria) this;
        }

        public Criteria andCheckReadEqualTo(String value) {
            addCriterion("check_read =", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadNotEqualTo(String value) {
            addCriterion("check_read <>", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadGreaterThan(String value) {
            addCriterion("check_read >", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadGreaterThanOrEqualTo(String value) {
            addCriterion("check_read >=", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadLessThan(String value) {
            addCriterion("check_read <", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadLessThanOrEqualTo(String value) {
            addCriterion("check_read <=", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadLike(String value) {
            addCriterion("check_read like", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadNotLike(String value) {
            addCriterion("check_read not like", value, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadIn(List<String> values) {
            addCriterion("check_read in", values, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadNotIn(List<String> values) {
            addCriterion("check_read not in", values, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadBetween(String value1, String value2) {
            addCriterion("check_read between", value1, value2, "checkRead");
            return (Criteria) this;
        }

        public Criteria andCheckReadNotBetween(String value1, String value2) {
            addCriterion("check_read not between", value1, value2, "checkRead");
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