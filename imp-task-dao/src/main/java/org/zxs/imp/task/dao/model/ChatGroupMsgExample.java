package org.zxs.imp.task.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatGroupMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatGroupMsgExample() {
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

        public Criteria andChatGroupIdIsNull() {
            addCriterion("chat_group_id is null");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdIsNotNull() {
            addCriterion("chat_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdEqualTo(Integer value) {
            addCriterion("chat_group_id =", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdNotEqualTo(Integer value) {
            addCriterion("chat_group_id <>", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdGreaterThan(Integer value) {
            addCriterion("chat_group_id >", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_group_id >=", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdLessThan(Integer value) {
            addCriterion("chat_group_id <", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("chat_group_id <=", value, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdIn(List<Integer> values) {
            addCriterion("chat_group_id in", values, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdNotIn(List<Integer> values) {
            addCriterion("chat_group_id not in", values, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("chat_group_id between", value1, value2, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_group_id not between", value1, value2, "chatGroupId");
            return (Criteria) this;
        }

        public Criteria andChatTypeIsNull() {
            addCriterion("chat_type is null");
            return (Criteria) this;
        }

        public Criteria andChatTypeIsNotNull() {
            addCriterion("chat_type is not null");
            return (Criteria) this;
        }

        public Criteria andChatTypeEqualTo(Integer value) {
            addCriterion("chat_type =", value, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeNotEqualTo(Integer value) {
            addCriterion("chat_type <>", value, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeGreaterThan(Integer value) {
            addCriterion("chat_type >", value, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("chat_type >=", value, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeLessThan(Integer value) {
            addCriterion("chat_type <", value, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeLessThanOrEqualTo(Integer value) {
            addCriterion("chat_type <=", value, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeIn(List<Integer> values) {
            addCriterion("chat_type in", values, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeNotIn(List<Integer> values) {
            addCriterion("chat_type not in", values, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeBetween(Integer value1, Integer value2) {
            addCriterion("chat_type between", value1, value2, "chatType");
            return (Criteria) this;
        }

        public Criteria andChatTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("chat_type not between", value1, value2, "chatType");
            return (Criteria) this;
        }

        public Criteria andFromIdIsNull() {
            addCriterion("from_id is null");
            return (Criteria) this;
        }

        public Criteria andFromIdIsNotNull() {
            addCriterion("from_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromIdEqualTo(Integer value) {
            addCriterion("from_id =", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotEqualTo(Integer value) {
            addCriterion("from_id <>", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdGreaterThan(Integer value) {
            addCriterion("from_id >", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_id >=", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLessThan(Integer value) {
            addCriterion("from_id <", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_id <=", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdIn(List<Integer> values) {
            addCriterion("from_id in", values, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotIn(List<Integer> values) {
            addCriterion("from_id not in", values, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdBetween(Integer value1, Integer value2) {
            addCriterion("from_id between", value1, value2, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_id not between", value1, value2, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromNameIsNull() {
            addCriterion("from_name is null");
            return (Criteria) this;
        }

        public Criteria andFromNameIsNotNull() {
            addCriterion("from_name is not null");
            return (Criteria) this;
        }

        public Criteria andFromNameEqualTo(String value) {
            addCriterion("from_name =", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotEqualTo(String value) {
            addCriterion("from_name <>", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameGreaterThan(String value) {
            addCriterion("from_name >", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameGreaterThanOrEqualTo(String value) {
            addCriterion("from_name >=", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameLessThan(String value) {
            addCriterion("from_name <", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameLessThanOrEqualTo(String value) {
            addCriterion("from_name <=", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameLike(String value) {
            addCriterion("from_name like", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotLike(String value) {
            addCriterion("from_name not like", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameIn(List<String> values) {
            addCriterion("from_name in", values, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotIn(List<String> values) {
            addCriterion("from_name not in", values, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameBetween(String value1, String value2) {
            addCriterion("from_name between", value1, value2, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotBetween(String value1, String value2) {
            addCriterion("from_name not between", value1, value2, "fromName");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andUserIdsIsNull() {
            addCriterion("user_ids is null");
            return (Criteria) this;
        }

        public Criteria andUserIdsIsNotNull() {
            addCriterion("user_ids is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdsEqualTo(String value) {
            addCriterion("user_ids =", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotEqualTo(String value) {
            addCriterion("user_ids <>", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsGreaterThan(String value) {
            addCriterion("user_ids >", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsGreaterThanOrEqualTo(String value) {
            addCriterion("user_ids >=", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLessThan(String value) {
            addCriterion("user_ids <", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLessThanOrEqualTo(String value) {
            addCriterion("user_ids <=", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLike(String value) {
            addCriterion("user_ids like", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotLike(String value) {
            addCriterion("user_ids not like", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsIn(List<String> values) {
            addCriterion("user_ids in", values, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotIn(List<String> values) {
            addCriterion("user_ids not in", values, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsBetween(String value1, String value2) {
            addCriterion("user_ids between", value1, value2, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotBetween(String value1, String value2) {
            addCriterion("user_ids not between", value1, value2, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserNamesIsNull() {
            addCriterion("user_names is null");
            return (Criteria) this;
        }

        public Criteria andUserNamesIsNotNull() {
            addCriterion("user_names is not null");
            return (Criteria) this;
        }

        public Criteria andUserNamesEqualTo(String value) {
            addCriterion("user_names =", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesNotEqualTo(String value) {
            addCriterion("user_names <>", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesGreaterThan(String value) {
            addCriterion("user_names >", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesGreaterThanOrEqualTo(String value) {
            addCriterion("user_names >=", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesLessThan(String value) {
            addCriterion("user_names <", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesLessThanOrEqualTo(String value) {
            addCriterion("user_names <=", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesLike(String value) {
            addCriterion("user_names like", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesNotLike(String value) {
            addCriterion("user_names not like", value, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesIn(List<String> values) {
            addCriterion("user_names in", values, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesNotIn(List<String> values) {
            addCriterion("user_names not in", values, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesBetween(String value1, String value2) {
            addCriterion("user_names between", value1, value2, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserNamesNotBetween(String value1, String value2) {
            addCriterion("user_names not between", value1, value2, "userNames");
            return (Criteria) this;
        }

        public Criteria andUserCntIsNull() {
            addCriterion("user_cnt is null");
            return (Criteria) this;
        }

        public Criteria andUserCntIsNotNull() {
            addCriterion("user_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andUserCntEqualTo(Short value) {
            addCriterion("user_cnt =", value, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntNotEqualTo(Short value) {
            addCriterion("user_cnt <>", value, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntGreaterThan(Short value) {
            addCriterion("user_cnt >", value, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntGreaterThanOrEqualTo(Short value) {
            addCriterion("user_cnt >=", value, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntLessThan(Short value) {
            addCriterion("user_cnt <", value, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntLessThanOrEqualTo(Short value) {
            addCriterion("user_cnt <=", value, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntIn(List<Short> values) {
            addCriterion("user_cnt in", values, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntNotIn(List<Short> values) {
            addCriterion("user_cnt not in", values, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntBetween(Short value1, Short value2) {
            addCriterion("user_cnt between", value1, value2, "userCnt");
            return (Criteria) this;
        }

        public Criteria andUserCntNotBetween(Short value1, Short value2) {
            addCriterion("user_cnt not between", value1, value2, "userCnt");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
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