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
@Table(name="chat_msg_status")
public class ChatMsgStatus {
	public static final byte STATUS_UNREAD = 0;
	public static final byte STATUS_READ = 1;
	
	public static final byte STATUS_UNPUSH = 0;
	public static final byte STATUS_PUSH = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="chat_msg_id", nullable = false, unique = false, length = 12, columnDefinition = "聊天消息编号")
    private Long chatMsgId;

	@JSONField(ordinal=3)
	@Column(name="user_id", nullable = false, unique = false, length = 10, columnDefinition = "消息接收者编号")
    private Integer userId;

	@JSONField(ordinal=4)
	@Column(name="read_status", nullable = false, unique = false, length = 3, columnDefinition = "消息阅读状态，0为未读，1为已读")
    private Byte readStatus = STATUS_UNREAD;

	@JSONField(ordinal=5)
	@Column(name="push_status", nullable = false, unique = false, length = 3, columnDefinition = "是否推送成功，0为否，1为是")
    private Byte pushStatus = STATUS_UNPUSH;

	@JSONField(ordinal=6)
	@Column(name="create_at", nullable = false, unique = false, columnDefinition = "创建时间")
    private Date createAt;

	@JSONField(ordinal=7)
	@Column(name="update_at", nullable = false, unique = false, columnDefinition = "最后更新时间")
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatMsgId() {
        return chatMsgId;
    }

    public void setChatMsgId(Long chatMsgId) {
        this.chatMsgId = chatMsgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Byte readStatus) {
        this.readStatus = readStatus;
    }

    public Byte getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Byte pushStatus) {
        this.pushStatus = pushStatus;
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
        ChatMsgStatus other = (ChatMsgStatus) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChatMsgId() == null ? other.getChatMsgId() == null : this.getChatMsgId().equals(other.getChatMsgId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getReadStatus() == null ? other.getReadStatus() == null : this.getReadStatus().equals(other.getReadStatus()))
            && (this.getPushStatus() == null ? other.getPushStatus() == null : this.getPushStatus().equals(other.getPushStatus()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChatMsgId() == null) ? 0 : getChatMsgId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getReadStatus() == null) ? 0 : getReadStatus().hashCode());
        result = prime * result + ((getPushStatus() == null) ? 0 : getPushStatus().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}