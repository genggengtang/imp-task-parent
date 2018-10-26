package org.zxs.imp.task.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="user_comment")
public class UserComment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="user_id")
    private Integer userId;

	@JSONField(ordinal=3)
	@Column(name="sub_task_id")
    private Long subTaskId;

	@JSONField(ordinal=4)
	@Column(name="content")
    private String content;

	@JSONField(ordinal=5)
	@Column(name="is_conclusion")
    private Byte isConclusion;

	@JSONField(ordinal=6)
	@Column(name="create_at")
    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(Long subTaskId) {
        this.subTaskId = subTaskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getIsConclusion() {
        return isConclusion;
    }

    public void setIsConclusion(Byte isConclusion) {
        this.isConclusion = isConclusion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserComment other = (UserComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSubTaskId() == null ? other.getSubTaskId() == null : this.getSubTaskId().equals(other.getSubTaskId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getIsConclusion() == null ? other.getIsConclusion() == null : this.getIsConclusion().equals(other.getIsConclusion()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSubTaskId() == null) ? 0 : getSubTaskId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getIsConclusion() == null) ? 0 : getIsConclusion().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        return result;
    }
}