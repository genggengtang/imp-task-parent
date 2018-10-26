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
@Table(name="chat_group_msg")
public class ChatGroupMsg {
	public static final int TYPE_MSSAGE = 21101;
	public static final int TYPE_ADD_MEMBER = 21102;
	public static final int TYPE_REMOVE_MEMBER = 21103;
	public static final int TYPE_DISSOLUTION = 21104;
	public static final int TYPE_PIC = 21105;
	public static final int TYPE_DOC = 21106;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="chat_group_id", nullable = false, unique = false, length = 10, columnDefinition = "群聊组编号")
    private Integer chatGroupId;

	@JSONField(ordinal=3)
	@Column(name="chat_type", nullable = false, unique = false, length = 6, columnDefinition = "聊天类型，参见字典表220")
    private Integer chatType;

	@JSONField(ordinal=4)
	@Column(name="from_id", nullable = false, unique = false, length = 10, columnDefinition = "发送者编号")
    private Integer fromId;

	@JSONField(ordinal=5)
	@Column(name="from_name", nullable = true, unique = false, length = 30, columnDefinition = "发送者名称")
    private String fromName;

	@JSONField(ordinal=6)
	@Column(name="content", nullable = true, unique = false, length = 500, columnDefinition = "消息内容")
    private String content;

	@JSONField(ordinal=7)
	@Column(name="user_ids", nullable = true, unique = false, length = 500, columnDefinition = "返回的用户编号，多个编号以逗号分隔")
    private String userIds;

	@JSONField(ordinal=8)
	@Column(name="user_names", nullable = true, unique = false, length = 500, columnDefinition = "返回的用户名，多个名称以逗号分隔")
    private String userNames;

	@JSONField(ordinal=9)
	@Column(name="user_cnt", nullable = true, unique = false, length = 5, columnDefinition = "用户数")
    private Short userCnt;

	@JSONField(ordinal=10)
	@Column(name="file_name", nullable = true, unique = false, length = 200, columnDefinition = "文件名")
    private String fileName;

	@JSONField(ordinal=11)
	@Column(name="file_url", nullable = true, unique = false, length = 500, columnDefinition = "文件URL")
    private String fileUrl;

	@JSONField(ordinal=12)
	@Column(name="create_at", nullable = true, unique = false, columnDefinition = "发送时间")
    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(Integer chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    public Integer getChatType() {
        return chatType;
    }

    public void setChatType(Integer chatType) {
        this.chatType = chatType;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName == null ? null : fromName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds == null ? null : userIds.trim();
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames == null ? null : userNames.trim();
    }

    public Short getUserCnt() {
        return userCnt;
    }

    public void setUserCnt(Short userCnt) {
        this.userCnt = userCnt;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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
        ChatGroupMsg other = (ChatGroupMsg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChatGroupId() == null ? other.getChatGroupId() == null : this.getChatGroupId().equals(other.getChatGroupId()))
            && (this.getChatType() == null ? other.getChatType() == null : this.getChatType().equals(other.getChatType()))
            && (this.getFromId() == null ? other.getFromId() == null : this.getFromId().equals(other.getFromId()))
            && (this.getFromName() == null ? other.getFromName() == null : this.getFromName().equals(other.getFromName()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getUserIds() == null ? other.getUserIds() == null : this.getUserIds().equals(other.getUserIds()))
            && (this.getUserNames() == null ? other.getUserNames() == null : this.getUserNames().equals(other.getUserNames()))
            && (this.getUserCnt() == null ? other.getUserCnt() == null : this.getUserCnt().equals(other.getUserCnt()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChatGroupId() == null) ? 0 : getChatGroupId().hashCode());
        result = prime * result + ((getChatType() == null) ? 0 : getChatType().hashCode());
        result = prime * result + ((getFromId() == null) ? 0 : getFromId().hashCode());
        result = prime * result + ((getFromName() == null) ? 0 : getFromName().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getUserIds() == null) ? 0 : getUserIds().hashCode());
        result = prime * result + ((getUserNames() == null) ? 0 : getUserNames().hashCode());
        result = prime * result + ((getUserCnt() == null) ? 0 : getUserCnt().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        return result;
    }
}