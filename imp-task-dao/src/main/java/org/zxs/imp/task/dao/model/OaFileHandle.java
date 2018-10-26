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
@Table(name="oa_file_handle"/*, indexes = {@Index(name = "hd_guid_idx",  columnList="handle_guid", unique = true)}*/)
public class OaFileHandle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

//	@JSONField(ordinal=2)
//	@Column(name="file_guid", nullable = false, unique = false, length = 100, columnDefinition = "关联的OA文件编号")
//    private String fileGuid;
	
	@JSONField(ordinal=2)
	@Column(name="oa_file_id", nullable = false, unique = false, length = 15, columnDefinition = "关联的OA文件记录编号")
    private Long oaFileId;
	
	@JSONField(ordinal=3)
	@Column(name="handle_guid", nullable = false, unique = true, length = 100, columnDefinition = "对应的OA操作记录编号")
    private String handleGuid;
	
	@JSONField(ordinal=4)
	@Column(name="activity", nullable = false, unique = false, length = 20, columnDefinition = "步骤")
    private String activity;

	@JSONField(ordinal=5)
	@Column(name="submit_user_phone", nullable = true, unique = false, length = 11, columnDefinition = "提交人员手机号")
    private String submitUserPhone;
	
	@JSONField(ordinal=6)
	@Column(name="submit_user_name", nullable = true, unique = false, length = 30, columnDefinition = "提交人员姓名")
    private String submitUserName;

	@JSONField(ordinal=7)
	@Column(name="receive_at", nullable = true, unique = false, columnDefinition = "收到时间")
    private Date receiveAt;

	@JSONField(ordinal=8)
	@Column(name="operate_user_phone", nullable = true, unique = false, length = 11, columnDefinition = "操作人员手机")
    private String operateUserPhone;
	
	@JSONField(ordinal=9)
	@Column(name="operate_user_name", nullable = true, unique = false, length = 30, columnDefinition = "操作人员姓名")
    private String operateUserName;

	@JSONField(ordinal=10)
	@Column(name="opinion", nullable = true, unique = false, length = 2000, columnDefinition = "办理意见")
    private String opinion;

	@JSONField(ordinal=11)
	@Column(name="operate_at", nullable = true, unique = false, columnDefinition = "办理时间")
    private Date operateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getFileGuid() {
//		return fileGuid;
//	}
//
//	public void setFileGuid(String fileGuid) {
//		this.fileGuid = fileGuid == null ? null : fileGuid.trim();
//	}

	public Long getOaFileId() {
		return oaFileId;
	}

	public void setOaFileId(Long oaFileId) {
		this.oaFileId = oaFileId;
	}

	public String getHandleGuid() {
		return handleGuid;
	}
	
	public void setHandleGuid(String handleGuid) {
		this.handleGuid = handleGuid == null ? null : handleGuid.trim();
	}

	public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }

    public String getSubmitUserPhone() {
        return submitUserPhone;
    }

    public void setSubmitUserPhone(String submitUserPhone) {
        this.submitUserPhone = submitUserPhone;
    }

    public Date getReceiveAt() {
        return receiveAt;
    }

    public void setReceiveAt(Date receiveAt) {
        this.receiveAt = receiveAt;
    }

    public String getOperateUserPhone() {
        return operateUserPhone;
    }

    public void setOperateUserPhone(String operateUserPhone) {
        this.operateUserPhone = operateUserPhone;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public Date getOperateAt() {
        return operateAt;
    }

    public void setOperateAt(Date operateAt) {
        this.operateAt = operateAt;
    }

    public String getSubmitUserName() {
		return submitUserName;
	}

	public void setSubmitUserName(String submitUserName) {
		this.submitUserName = submitUserName;
	}

	public String getOperateUserName() {
		return operateUserName;
	}

	public void setOperateUserName(String operateUserName) {
		this.operateUserName = operateUserName;
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
        OaFileHandle other = (OaFileHandle) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOaFileId() == null ? other.getOaFileId() == null : this.getOaFileId().equals(other.getOaFileId()))
            && (this.getHandleGuid() == null ? other.getHandleGuid() == null : this.getHandleGuid().equals(other.getHandleGuid()))
            && (this.getActivity() == null ? other.getActivity() == null : this.getActivity().equals(other.getActivity()))
            && (this.getSubmitUserPhone() == null ? other.getSubmitUserPhone() == null : this.getSubmitUserPhone().equals(other.getSubmitUserPhone()))
            && (this.getSubmitUserName() == null ? other.getSubmitUserName() == null : this.getSubmitUserName().equals(other.getSubmitUserName()))
            && (this.getReceiveAt() == null ? other.getReceiveAt() == null : this.getReceiveAt().equals(other.getReceiveAt()))
            && (this.getOperateUserPhone() == null ? other.getOperateUserPhone() == null : this.getOperateUserPhone().equals(other.getOperateUserPhone()))
            && (this.getOperateUserName() == null ? other.getOperateUserName() == null : this.getOperateUserName().equals(other.getOperateUserName()))
            && (this.getOpinion() == null ? other.getOpinion() == null : this.getOpinion().equals(other.getOpinion()))
            && (this.getOperateAt() == null ? other.getOperateAt() == null : this.getOperateAt().equals(other.getOperateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOaFileId() == null) ? 0 : getOaFileId().hashCode());
        result = prime * result + ((getHandleGuid() == null) ? 0 : getHandleGuid().hashCode());
        result = prime * result + ((getActivity() == null) ? 0 : getActivity().hashCode());
        result = prime * result + ((getSubmitUserPhone() == null) ? 0 : getSubmitUserPhone().hashCode());
        result = prime * result + ((getSubmitUserName() == null) ? 0 : getSubmitUserName().hashCode());
        result = prime * result + ((getReceiveAt() == null) ? 0 : getReceiveAt().hashCode());
        result = prime * result + ((getOperateUserPhone() == null) ? 0 : getOperateUserPhone().hashCode());
        result = prime * result + ((getOperateUserName() == null) ? 0 : getOperateUserName().hashCode());
        result = prime * result + ((getOpinion() == null) ? 0 : getOpinion().hashCode());
        result = prime * result + ((getOperateAt() == null) ? 0 : getOperateAt().hashCode());
        return result;
    }
}