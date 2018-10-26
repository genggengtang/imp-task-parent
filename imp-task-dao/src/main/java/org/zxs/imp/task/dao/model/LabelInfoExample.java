package org.zxs.imp.task.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LabelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LabelInfoExample() {
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

        public Criteria andLabelSourceIsNull() {
            addCriterion("label_source is null");
            return (Criteria) this;
        }

        public Criteria andLabelSourceIsNotNull() {
            addCriterion("label_source is not null");
            return (Criteria) this;
        }

        public Criteria andLabelSourceEqualTo(Byte value) {
            addCriterion("label_source =", value, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceNotEqualTo(Byte value) {
            addCriterion("label_source <>", value, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceGreaterThan(Byte value) {
            addCriterion("label_source >", value, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("label_source >=", value, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceLessThan(Byte value) {
            addCriterion("label_source <", value, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceLessThanOrEqualTo(Byte value) {
            addCriterion("label_source <=", value, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceIn(List<Byte> values) {
            addCriterion("label_source in", values, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceNotIn(List<Byte> values) {
            addCriterion("label_source not in", values, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceBetween(Byte value1, Byte value2) {
            addCriterion("label_source between", value1, value2, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("label_source not between", value1, value2, "labelSource");
            return (Criteria) this;
        }

        public Criteria andLabelLevelIsNull() {
            addCriterion("label_level is null");
            return (Criteria) this;
        }

        public Criteria andLabelLevelIsNotNull() {
            addCriterion("label_level is not null");
            return (Criteria) this;
        }

        public Criteria andLabelLevelEqualTo(Byte value) {
            addCriterion("label_level =", value, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelNotEqualTo(Byte value) {
            addCriterion("label_level <>", value, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelGreaterThan(Byte value) {
            addCriterion("label_level >", value, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("label_level >=", value, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelLessThan(Byte value) {
            addCriterion("label_level <", value, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelLessThanOrEqualTo(Byte value) {
            addCriterion("label_level <=", value, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelIn(List<Byte> values) {
            addCriterion("label_level in", values, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelNotIn(List<Byte> values) {
            addCriterion("label_level not in", values, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelBetween(Byte value1, Byte value2) {
            addCriterion("label_level between", value1, value2, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("label_level not between", value1, value2, "labelLevel");
            return (Criteria) this;
        }

        public Criteria andLabelContentIsNull() {
            addCriterion("label_content is null");
            return (Criteria) this;
        }

        public Criteria andLabelContentIsNotNull() {
            addCriterion("label_content is not null");
            return (Criteria) this;
        }

        public Criteria andLabelContentEqualTo(String value) {
            addCriterion("label_content =", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotEqualTo(String value) {
            addCriterion("label_content <>", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentGreaterThan(String value) {
            addCriterion("label_content >", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentGreaterThanOrEqualTo(String value) {
            addCriterion("label_content >=", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentLessThan(String value) {
            addCriterion("label_content <", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentLessThanOrEqualTo(String value) {
            addCriterion("label_content <=", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentLike(String value) {
            addCriterion("label_content like", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotLike(String value) {
            addCriterion("label_content not like", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentIn(List<String> values) {
            addCriterion("label_content in", values, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotIn(List<String> values) {
            addCriterion("label_content not in", values, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentBetween(String value1, String value2) {
            addCriterion("label_content between", value1, value2, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotBetween(String value1, String value2) {
            addCriterion("label_content not between", value1, value2, "labelContent");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Integer value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Integer value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Integer value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Integer value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Integer> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Integer> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Integer value1, Integer value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_id not between", value1, value2, "createId");
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
        
        public Criteria andIsPublishIsNull() {
            addCriterion("is_publish is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNotNull() {
            addCriterion("is_publish is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishEqualTo(Byte value) {
            addCriterion("is_publish =", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotEqualTo(Byte value) {
            addCriterion("is_publish <>", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThan(Byte value) {
            addCriterion("is_publish >", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_publish >=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThan(Byte value) {
            addCriterion("is_publish <", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThanOrEqualTo(Byte value) {
            addCriterion("is_publish <=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishIn(List<Byte> values) {
            addCriterion("is_publish in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotIn(List<Byte> values) {
            addCriterion("is_publish not in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishBetween(Byte value1, Byte value2) {
            addCriterion("is_publish between", value1, value2, "isPublish");
            return (Criteria) this;
        }
        
        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("label_source not between", value1, value2, "labelSource");
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