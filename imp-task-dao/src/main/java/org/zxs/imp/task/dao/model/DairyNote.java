package org.zxs.imp.task.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="dairy_note")
public class DairyNote {
	public static final short PHASE_START = 1;
	public static final short PHASE_END = 2;
	public static final short PHASE_MID = 3;
	
	public static final short WORK_TODO = 0;
	public static final short WORK_DONE = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;
	
	@JSONField(ordinal=2)
	@Column(name="card_id", nullable = false, unique = false, columnDefinition = "关联的卡片编号")
    private Long cardId;

	@JSONField(ordinal=3)
	@Column(name="date", nullable = false, unique = false, columnDefinition = "记录日期")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

	@JSONField(ordinal=4)
	@Column(name="title", nullable = false, unique = false, length = 200, columnDefinition = "事件标题")
    private String title;

	@JSONField(ordinal=5)
	@Column(name="user_id", nullable = true, unique = false, length = 8, columnDefinition = "操作人员编号")
    private Integer userId;

	@JSONField(ordinal=6)
	@Column(name="content", nullable = true, unique = false, length = 5000, columnDefinition = "事件内容")
    private String content;
	
	@JSONField(ordinal=7)
	@Column(name="phase", nullable = true, unique = false, length = 3, columnDefinition = "阶段，1为开始，2为结束，3为中间过程")
	private Short phase;
	
	@JSONField(ordinal=8)
	@Column(name="status", nullable = false, unique = false, length = 3, columnDefinition = "是否完成，0为否，1为是")
	private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Short getPhase() {
		return phase;
	}

	public void setPhase(Short phase) {
		this.phase = phase;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
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
        DairyNote other = (DairyNote) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getPhase() == null ? other.getPhase() == null : this.getPhase().equals(other.getPhase()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getPhase() == null) ? 0 : getPhase().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}