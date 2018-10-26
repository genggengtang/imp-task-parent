package org.zxs.imp.task.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Table(name="task_info")
public class TaskInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="task_type")
    private Integer taskType;

	@JSONField(ordinal=3)
	@Column(name="title")
    private String title;

	@JSONField(ordinal=4)
	@Column(name="task_label")
    private String taskLabel;

	@JSONField(ordinal=5)
	@Column(name="is_period")
    private Byte isPeriod;

	@JSONField(ordinal=6)
	@Column(name="period_type")
    private Integer periodType;

	@JSONField(ordinal=7)
	@Column(name="period_days")
    private Short periodDays;

	@JSONField(ordinal=8)
	@Column(name="urgent_level")
    private Byte urgentLevel;

	@JSONField(ordinal=9)
	@Column(name="create_user_id")
    private Integer createUserId;

	@JSONField(ordinal=10)
	@Column(name="end_date_des")
    private String endDateDes;

	@JSONField(ordinal=11)
	@Column(name="current_sub_id")
    private Long currentSubId;

	@JSONField(ordinal=12)
	@Column(name="oa_guid")
    private String oaGuid;
	
	@JSONField(ordinal=13)
	@Column(name="kpi_1st_id")
    private Integer kpi1stId;
	
	@JSONField(ordinal=14)
	@Column(name="kpi_2nd_id")
    private Integer kpi2ndId;
	
	@JSONField(ordinal=15)
	@Column(name="kpi_3rd_id")
    private Integer kpi3rdId;
	
	@JSONField(ordinal=16)
	@Column(name="kpi_point")
    private Integer kpiPoint;
	
	@JSONField(ordinal=17)
	@Column(name="kpi_target")
    private String kpiTarget;

	@JSONField(ordinal=18)
	@Column(name="create_at")
    private Date createAt;

	@JSONField(ordinal=19)
	@Column(name="update_at")
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTaskLabel() {
        return taskLabel;
    }

    public void setTaskLabel(String taskLabel) {
        this.taskLabel = taskLabel == null ? null : taskLabel.trim();
    }

    public Byte getIsPeriod() {
        return isPeriod;
    }

    public void setIsPeriod(Byte isPeriod) {
        this.isPeriod = isPeriod;
    }

    public Integer getPeriodType() {
        return periodType;
    }

    public void setPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    public Short getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(Short periodDays) {
        this.periodDays = periodDays;
    }

    public Byte getUrgentLevel() {
        return urgentLevel;
    }

    public void setUrgentLevel(Byte urgentLevel) {
        this.urgentLevel = urgentLevel;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getEndDateDes() {
        return endDateDes;
    }

    public void setEndDateDes(String endDateDes) {
        this.endDateDes = endDateDes == null ? null : endDateDes.trim();
    }

    public Long getCurrentSubId() {
        return currentSubId;
    }

    public void setCurrentSubId(Long currentSubId) {
        this.currentSubId = currentSubId;
    }

    public String getOaGuid() {
		return oaGuid;
	}

	public void setOaGuid(String oaGuid) {
		this.oaGuid = oaGuid == null ? null : oaGuid.trim();
	}

	public Integer getKpi1stId() {
		return kpi1stId;
	}

	public void setKpi1stId(Integer kpi1stId) {
		this.kpi1stId = kpi1stId;
	}

	public Integer getKpi2ndId() {
		return kpi2ndId;
	}

	public void setKpi2ndId(Integer kpi2ndId) {
		this.kpi2ndId = kpi2ndId;
	}

	public Integer getKpi3rdId() {
		return kpi3rdId;
	}

	public void setKpi3rdId(Integer kpi3rdId) {
		this.kpi3rdId = kpi3rdId;
	}

	public Integer getKpiPoint() {
		return kpiPoint;
	}

	public void setKpiPoint(Integer kpiPoint) {
		this.kpiPoint = kpiPoint;
	}

	public String getKpiTarget() {
		return kpiTarget;
	}

	public void setKpiTarget(String kpiTarget) {
		this.kpiTarget = kpiTarget == null ? "" : kpiTarget;
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
        TaskInfo other = (TaskInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTaskLabel() == null ? other.getTaskLabel() == null : this.getTaskLabel().equals(other.getTaskLabel()))
            && (this.getIsPeriod() == null ? other.getIsPeriod() == null : this.getIsPeriod().equals(other.getIsPeriod()))
            && (this.getPeriodType() == null ? other.getPeriodType() == null : this.getPeriodType().equals(other.getPeriodType()))
            && (this.getPeriodDays() == null ? other.getPeriodDays() == null : this.getPeriodDays().equals(other.getPeriodDays()))
            && (this.getUrgentLevel() == null ? other.getUrgentLevel() == null : this.getUrgentLevel().equals(other.getUrgentLevel()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getEndDateDes() == null ? other.getEndDateDes() == null : this.getEndDateDes().equals(other.getEndDateDes()))
            && (this.getCurrentSubId() == null ? other.getCurrentSubId() == null : this.getCurrentSubId().equals(other.getCurrentSubId()))
            && (this.getOaGuid() == null ? other.getOaGuid() == null : this.getOaGuid().equals(other.getOaGuid()))
            && (this.getKpi1stId() == null ? other.getKpi1stId() == null : this.getKpi1stId().equals(other.getKpi1stId()))
            && (this.getKpi2ndId() == null ? other.getKpi2ndId() == null : this.getKpi2ndId().equals(other.getKpi2ndId()))
            && (this.getKpi3rdId() == null ? other.getKpi3rdId() == null : this.getKpi3rdId().equals(other.getKpi3rdId()))
            && (this.getKpiPoint() == null ? other.getKpiPoint() == null : this.getKpiPoint().equals(other.getKpiPoint()))
            && (this.getKpiTarget() == null ? other.getKpiTarget() == null : this.getKpiTarget().equals(other.getKpiTarget()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTaskLabel() == null) ? 0 : getTaskLabel().hashCode());
        result = prime * result + ((getIsPeriod() == null) ? 0 : getIsPeriod().hashCode());
        result = prime * result + ((getPeriodType() == null) ? 0 : getPeriodType().hashCode());
        result = prime * result + ((getPeriodDays() == null) ? 0 : getPeriodDays().hashCode());
        result = prime * result + ((getUrgentLevel() == null) ? 0 : getUrgentLevel().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getEndDateDes() == null) ? 0 : getEndDateDes().hashCode());
        result = prime * result + ((getCurrentSubId() == null) ? 0 : getCurrentSubId().hashCode());
        result = prime * result + ((getOaGuid() == null) ? 0 : getOaGuid().hashCode());
        result = prime * result + ((getKpi1stId() == null) ? 0 : getKpi1stId().hashCode());
        result = prime * result + ((getKpi2ndId() == null) ? 0 : getKpi2ndId().hashCode());
        result = prime * result + ((getKpi3rdId() == null) ? 0 : getKpi3rdId().hashCode());
        result = prime * result + ((getKpiPoint() == null) ? 0 : getKpiPoint().hashCode());
        result = prime * result + ((getKpiTarget() == null) ? 0 : getKpiTarget().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }
}