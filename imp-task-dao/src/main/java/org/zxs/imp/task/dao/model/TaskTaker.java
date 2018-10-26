package org.zxs.imp.task.dao.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="task_taker")
public class TaskTaker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="sub_task_id")
    private Long subTaskId;

	@JSONField(ordinal=3)
	@Column(name="dept_id")
    private Integer deptId;

	@JSONField(ordinal=4)
	@Column(name="user_id")
    private Integer userId;

	@JSONField(ordinal=5)
	@Column(name="dept_role")
    private Byte deptRole;

	@JSONField(ordinal=6)
	@Column(name="is_prover")
    private Byte isProver;

	@JSONField(ordinal=7)
	@Column(name="is_switch")
    private Byte isSwitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(Long subTaskId) {
        this.subTaskId = subTaskId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getDeptRole() {
        return deptRole;
    }

    public void setDeptRole(Byte deptRole) {
        this.deptRole = deptRole;
    }

    public Byte getIsProver() {
        return isProver;
    }

    public void setIsProver(Byte isProver) {
        this.isProver = isProver;
    }

    public Byte getIsSwitch() {
        return isSwitch;
    }

    public void setIsSwitch(Byte isSwitch) {
        this.isSwitch = isSwitch;
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
        TaskTaker other = (TaskTaker) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSubTaskId() == null ? other.getSubTaskId() == null : this.getSubTaskId().equals(other.getSubTaskId()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDeptRole() == null ? other.getDeptRole() == null : this.getDeptRole().equals(other.getDeptRole()))
            && (this.getIsProver() == null ? other.getIsProver() == null : this.getIsProver().equals(other.getIsProver()))
            && (this.getIsSwitch() == null ? other.getIsSwitch() == null : this.getIsSwitch().equals(other.getIsSwitch()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSubTaskId() == null) ? 0 : getSubTaskId().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDeptRole() == null) ? 0 : getDeptRole().hashCode());
        result = prime * result + ((getIsProver() == null) ? 0 : getIsProver().hashCode());
        result = prime * result + ((getIsSwitch() == null) ? 0 : getIsSwitch().hashCode());
        return result;
    }
}