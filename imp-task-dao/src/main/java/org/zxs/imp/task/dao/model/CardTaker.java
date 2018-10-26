package org.zxs.imp.task.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="card_taker")
public class CardTaker {
	public static final short USER_AHEAD = 1;
	public static final short USER_PARTERN = 2;
	public static final short USER_REGIS = 3;
	public static final short USER_RSP = 4;
	public static final short USER_LEAD = 5;
	public static final short USER_OTHER = 6;
	
	public static final short AFFAIR_TODO = 0;
	public static final short AFFAIR_DONE = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="card_id", nullable = false, unique = false, length = 15, columnDefinition = "卡片编号")
    private Long cardId;
	
	@JSONField(ordinal=3)
	@Column(name="user_dept_id", nullable = false, unique = false, length = 8, columnDefinition = "关联的用户部门编号")
    private Integer userDeptId;

//	@JSONField(ordinal=4)
//	@Column(name="dept_id", nullable = false, unique = false, length = 8, columnDefinition = "关联部门编号")
//    private Integer deptId;
//
//	@JSONField(ordinal=5)
//	@Column(name="user_id", nullable = false, unique = false, length = 8, columnDefinition = "关联的用户编号")
//    private Integer userId;
	
	@JSONField(ordinal=4)
	@Column(name="affair_id", nullable = true, unique = false, length = 15, columnDefinition = "来源事项编号")
    private Long affairId;

	@JSONField(ordinal=5)
	@Column(name="role", nullable = false, unique = false, length = 1, columnDefinition = "角色，1为牵头，2为配合，3为登记者，4为归档者，5为分管领导，6为其他参与者")
    private Short role;
	
	@JSONField(ordinal=6)
	@Column(name="status", nullable = false, unique = false, length = 1, columnDefinition = "事项办理状态，0为待办，1为已办")
    private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
    
    public Integer getUserDeptId() {
		return userDeptId;
	}

	public void setUserDeptId(Integer userDeptId) {
		this.userDeptId = userDeptId;
	}

	public Long getAffairId() {
		return affairId;
	}

	public void setAffairId(Long affairId) {
		this.affairId = affairId;
	}

	public Short getRole() {
		return role;
	}

	public void setRole(Short role) {
		this.role = role;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
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
        CardTaker other = (CardTaker) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getUserDeptId() == null ? other.getUserDeptId() == null : this.getUserDeptId().equals(other.getUserDeptId()))
            && (this.getAffairId() == null ? other.getAffairId() == null : this.getAffairId().equals(other.getAffairId()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getUserDeptId() == null) ? 0 : getUserDeptId().hashCode());
        result = prime * result + ((getAffairId() == null) ? 0 : getAffairId().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}