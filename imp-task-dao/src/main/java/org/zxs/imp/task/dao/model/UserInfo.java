package org.zxs.imp.task.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="user_info"/*, indexes = {@Index(name = "uname_idx",  columnList="login_name", unique = true)}*/)
public class UserInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="login_name", nullable = false, unique = true, length = 20, columnDefinition = "登录名，默认手机号")
    private String loginName;

	@JSONField(ordinal=3)
	@Column(name="real_name", nullable = false, unique = false, length = 20, columnDefinition = "真实姓名")
    private String realName;

	@JSONField(ordinal=4)
	@Column(name="password", nullable = false, unique = false, length = 32, columnDefinition = "密码")
    private String password;

	@JSONField(ordinal=5)
	@Column(name="position", nullable = true, unique = false, length = 500, columnDefinition = "职位")
    private String position;
	
	@JSONField(ordinal=6)
	@Column(name="avatar", nullable = true, unique = false, length = 200, columnDefinition = "头像URL")
    private String avatar;
	
	@JSONField(ordinal=7)
	@Column(name="dept_id", nullable = true, unique = false, length = 8, columnDefinition = "关联的部门编号")
    private Integer deptId;

	@JSONField(ordinal=8)
	@Column(name="office_phone", nullable = true, unique = false, length = 11, columnDefinition = "办公室电话")
    private String officePhone;

	@JSONField(ordinal=9)
	@Column(name="mobile_phone", nullable = true, unique = false, length = 11, columnDefinition = "手机号")
    private String mobilePhone;

	@JSONField(ordinal=10)
	@Column(name="user_level", nullable = false, unique = false, length = 6, columnDefinition = "用户行政级别，对应字典表104字段")
    private Integer userLevel;

	@JSONField(ordinal=11)
	@Column(name="role", nullable = false, unique = false, length = 6, columnDefinition = "用户角色，对应字典表116字段")
    private Integer role;

	@JSONField(ordinal=12)
	@Column(name="order_by", nullable = false, unique = false, length = 8, columnDefinition = "成员排序")
    private Integer orderBy;

	@JSONField(ordinal=13)
	@Column(name="status", nullable = false, unique = false, length = 3, columnDefinition = "状态，0为异常，1为正常")
    private Byte status;
	
	@JSONField(ordinal=14)
	@Column(name="dept_user_name", nullable = true, unique = false, length = 50, columnDefinition = "含部门的用户全名")
    private String deptUserName;

	@JSONField(ordinal=15)
	@Column(name="create_at", nullable = false, unique = false, columnDefinition = "创建时间")
    private Date createAt;

	@JSONField(ordinal=16)
	@Column(name="update_at", nullable = false, unique = false, columnDefinition = "最后更新时间")
    private Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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

    public String getDeptUserName() {
		return deptUserName;
	}

	public void setDeptUserName(String deptUserName) {
		this.deptUserName = deptUserName == null ? null : deptUserName.trim();
	}

	public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
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
        UserInfo other = (UserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getOfficePhone() == null ? other.getOfficePhone() == null : this.getOfficePhone().equals(other.getOfficePhone()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.getUserLevel() == null ? other.getUserLevel() == null : this.getUserLevel().equals(other.getUserLevel()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getOrderBy() == null ? other.getOrderBy() == null : this.getOrderBy().equals(other.getOrderBy()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeptUserName() == null ? other.getDeptUserName() == null : this.getDeptUserName().equals(other.getDeptUserName()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getOfficePhone() == null) ? 0 : getOfficePhone().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((getUserLevel() == null) ? 0 : getUserLevel().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getOrderBy() == null) ? 0 : getOrderBy().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeptUserName() == null) ? 0 : getDeptUserName().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}