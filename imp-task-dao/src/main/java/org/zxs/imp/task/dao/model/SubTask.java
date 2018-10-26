package org.zxs.imp.task.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="sub_task")
public class SubTask {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="task_id")
    private Long taskId;

	@JSONField(ordinal=3)
	@Column(name="alert_date")
    private Date alertDate;

	@JSONField(ordinal=4)
	@Column(name="end_date")
    private Date endDate;

	@JSONField(ordinal=5)
	@Column(name="draft_comment")
    private String draftComment;

	@JSONField(ordinal=6)
	@Column(name="prc_comment")
    private String prcComment;

	@JSONField(ordinal=7)
	@Column(name="final_comment")
    private String finalComment;

	@JSONField(ordinal=8)
	@Column(name="status")
    private Integer status;

	@JSONField(ordinal=9)
	@Column(name="finish_date")
    private Date finishDate;
	
	@JSONField(ordinal=10)
	@Column(name="period_title")
    private String periodTitle;
	
	@JSONField(ordinal=11)
	@Column(name="period_content")
    private String periodContent;

	@JSONField(ordinal=12)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=13)
	@Column(name="update_at")
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDraftComment() {
        return draftComment;
    }

    public void setDraftComment(String draftComment) {
        this.draftComment = draftComment == null ? null : draftComment.trim();
    }

    public String getPrcComment() {
        return prcComment;
    }

    public void setPrcComment(String prcComment) {
        this.prcComment = prcComment == null ? null : prcComment.trim();
    }

    public String getFinalComment() {
        return finalComment;
    }

    public void setFinalComment(String finalComment) {
        this.finalComment = finalComment == null ? null : finalComment.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getPeriodTitle() {
		return periodTitle;
	}

	public void setPeriodTitle(String periodTitle) {
		this.periodTitle = periodTitle == null ? null : periodTitle.trim();
	}

	public String getPeriodContent() {
		return periodContent;
	}

	public void setPeriodContent(String periodContent) {
		this.periodContent = periodContent == null ? null : periodContent.trim();
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
        SubTask other = (SubTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getAlertDate() == null ? other.getAlertDate() == null : this.getAlertDate().equals(other.getAlertDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getDraftComment() == null ? other.getDraftComment() == null : this.getDraftComment().equals(other.getDraftComment()))
            && (this.getPrcComment() == null ? other.getPrcComment() == null : this.getPrcComment().equals(other.getPrcComment()))
            && (this.getFinalComment() == null ? other.getFinalComment() == null : this.getFinalComment().equals(other.getFinalComment()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFinishDate() == null ? other.getFinishDate() == null : this.getFinishDate().equals(other.getFinishDate()))
            && (this.getPeriodTitle() == null ? other.getPeriodTitle() == null : this.getPeriodTitle().equals(other.getPeriodTitle()))
            && (this.getPeriodContent() == null ? other.getPeriodContent() == null : this.getPeriodContent().equals(other.getPeriodContent()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getAlertDate() == null) ? 0 : getAlertDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getDraftComment() == null) ? 0 : getDraftComment().hashCode());
        result = prime * result + ((getPrcComment() == null) ? 0 : getPrcComment().hashCode());
        result = prime * result + ((getFinalComment() == null) ? 0 : getFinalComment().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFinishDate() == null) ? 0 : getFinishDate().hashCode());
        result = prime * result + ((getPeriodTitle() == null) ? 0 : getPeriodTitle().hashCode());
        result = prime * result + ((getPeriodContent() == null) ? 0 : getPeriodContent().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}