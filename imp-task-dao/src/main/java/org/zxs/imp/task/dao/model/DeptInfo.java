package org.zxs.imp.task.dao.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.ibatis.type.JdbcType;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="dept_info", uniqueConstraints = {@UniqueConstraint(columnNames="id")})
public class DeptInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
	@Column(nullable = false, length = 8, columnDefinition = "主键")
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="parent_id", nullable = true, unique = false, length = 8, columnDefinition = "关联的父科室编号")
    private Integer parentId;

	@JSONField(ordinal=3)
	@Column(name="full_name", nullable = false, unique = false, length = 50, columnDefinition = "全称")
    private String fullName;

	@JSONField(ordinal=4)
	@Column(name="short_name", nullable = false, unique = false, length = 20, columnDefinition = "简称")
    private String shortName;

	@JSONField(ordinal=5)
	@Column(name="level", nullable = false, unique = false, length = 3, columnDefinition = "机构层级，1为最高级，依次降低")
    private Byte level;

	@JSONField(ordinal=6)
	@Column(name="order_by", nullable = false, unique = false, length = 8, columnDefinition = "排序号，默认从小到大")
    private Integer orderBy;

	@JSONField(ordinal=7)
	@Column(name="status", nullable = false, unique = false, length = 3, columnDefinition = "状态，0为无效，1为有效")
    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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
        DeptInfo other = (DeptInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getShortName() == null ? other.getShortName() == null : this.getShortName().equals(other.getShortName()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getOrderBy() == null ? other.getOrderBy() == null : this.getOrderBy().equals(other.getOrderBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getShortName() == null) ? 0 : getShortName().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getOrderBy() == null) ? 0 : getOrderBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}