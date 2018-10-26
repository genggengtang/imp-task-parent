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
@Table(name="chat_group_info")
public class ChatGroupInfo {
	public final static byte CHAT_DOUBLE_DIALOG = 1;
	public final static byte CHAT_MULTI_DIALOG = 2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Integer id;

	@JSONField(ordinal=2)
	@Column(name="type", nullable = false, unique = false, length = 3, columnDefinition = "群聊组类型，1为双人对话，2为多人群聊")
    private Byte type;

	@JSONField(ordinal=3)
	@Column(name="group_name", nullable = true, unique = false, length = 100, columnDefinition = "群名称")
    private String groupName;

	@JSONField(ordinal=4)
	@Column(name="enable_name_update", nullable = false, unique = false, length = 3, columnDefinition = "组名是否允许修改，0为否，1为是")
    private Byte enableNameUpdate;

	@JSONField(ordinal=5)
	@Column(name="enable_remove", nullable = false, unique = false, length = 3, columnDefinition = "是否允许解散，0为否，1为是")
    private Byte enableRemove;

	@JSONField(ordinal=6)
	@Column(name="is_deleted", nullable = false, unique = false, length = 3, columnDefinition = "是否已经软删除，0为否，1为是")
    private Boolean isDeleted;

	@JSONField(ordinal=7)
	@Column(name="create_at", nullable = false, unique = false, length = 3, columnDefinition = "创建时间")
    private Date createAt;

	@JSONField(ordinal=8)
	@Column(name="update_at", nullable = true, unique = false, length = 3, columnDefinition = "最后更新时间")
    private Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Byte getEnableNameUpdate() {
        return enableNameUpdate;
    }

    public void setEnableNameUpdate(Byte enableNameUpdate) {
        this.enableNameUpdate = enableNameUpdate;
    }

    public Byte getEnableRemove() {
        return enableRemove;
    }

    public void setEnableRemove(Byte enableRemove) {
        this.enableRemove = enableRemove;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
        ChatGroupInfo other = (ChatGroupInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getEnableNameUpdate() == null ? other.getEnableNameUpdate() == null : this.getEnableNameUpdate().equals(other.getEnableNameUpdate()))
            && (this.getEnableRemove() == null ? other.getEnableRemove() == null : this.getEnableRemove().equals(other.getEnableRemove()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getEnableNameUpdate() == null) ? 0 : getEnableNameUpdate().hashCode());
        result = prime * result + ((getEnableRemove() == null) ? 0 : getEnableRemove().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}