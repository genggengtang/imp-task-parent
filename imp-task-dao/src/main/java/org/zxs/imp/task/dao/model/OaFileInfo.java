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
@Table(name="oa_file_info"/*, indexes = {@Index(name = "file_guid_idx",  columnList="file_guid", unique = true)}*/)
public class OaFileInfo {
	public static final short FILE_REVIEW = 1;
	public static final short FILE_TODO = 2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;
	
	@JSONField(ordinal=2)
	@Column(name="file_type", nullable = false, unique = false, length = 3, columnDefinition = "OA文件类型，0为审阅件，1为交办件")
    private Short fileType;

	@JSONField(ordinal=3)
	@Column(name="file_guid", nullable = true, unique = true, length = 100, columnDefinition = "OA文件编号")
    private String fileGuid;

	@JSONField(ordinal=4)
	@Column(name="title", nullable = false, unique = false, length = 2000, columnDefinition = "标题")
    private String title;

	@JSONField(ordinal=5)
	@Column(name="file_code", nullable = true, unique = false, length = 100, columnDefinition = "文号")
    private String fileCode;

	@JSONField(ordinal=6)
	@Column(name="file_org", nullable = true, unique = false, length = 500, columnDefinition = "来文单位")
    private String fileOrg;

	@JSONField(ordinal=7)
	@Column(name="file_date", nullable = true, unique = false, columnDefinition = "文件日期")
    private Date fileDate;

	@JSONField(ordinal=8)
	@Column(name="receive_date", nullable = false, unique = false, columnDefinition = "收文日期")
    private Date receiveDate;

	@JSONField(ordinal=9)
	@Column(name="approval", nullable = true, unique = false, length = 500, columnDefinition = "领导批示")
    private String approval;

	@JSONField(ordinal=10)
	@Column(name="check_read", nullable = true, unique = false, length = 500, columnDefinition = "签阅情况")
    private String checkRead;
	
	@JSONField(ordinal=11)
	@Column(name="last_at", nullable = true, unique = false, columnDefinition = "最后更新时间")
    private Date lastAt;
	
	@JSONField(ordinal=12)
	@Column(name="txt_file_date", nullable = true, unique = false, columnDefinition = "限办日期")
    private Date txtFileDate;
	
	@JSONField(ordinal=13)
	@Column(name="old_xianban_date", nullable = true, unique = false, columnDefinition = "原限办日期")
    private Date oldXianbanDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getFileType() {
		return fileType;
	}

	public void setFileType(Short fileType) {
		this.fileType = fileType;
	}

	public String getFileGuid() {
        return fileGuid;
    }

    public void setFileGuid(String fileGuid) {
        this.fileGuid = fileGuid == null ? null : fileGuid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode == null ? null : fileCode.trim();
    }

    public String getFileOrg() {
        return fileOrg;
    }

    public void setFileOrg(String fileOrg) {
        this.fileOrg = fileOrg == null ? null : fileOrg.trim();
    }

    public Date getFileDate() {
        return fileDate;
    }

    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval == null ? null : approval.trim();
    }

    public String getCheckRead() {
        return checkRead;
    }

    public void setCheckRead(String checkRead) {
        this.checkRead = checkRead == null ? null : checkRead.trim();
    }

    public Date getLastAt() {
		return lastAt;
	}

	public void setLastAt(Date lastAt) {
		this.lastAt = lastAt;
	}

	public Date getTxtFileDate() {
		return txtFileDate;
	}

	public void setTxtFileDate(Date txtFileDate) {
		this.txtFileDate = txtFileDate;
	}

	public Date getOldXianbanDate() {
		return oldXianbanDate;
	}

	public void setOldXianbanDate(Date oldXianbanDate) {
		this.oldXianbanDate = oldXianbanDate;
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
        OaFileInfo other = (OaFileInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getFileType() == null ? other.getFileType() == null : this.getFileType().equals(other.getFileType()))	
            && (this.getFileGuid() == null ? other.getFileGuid() == null : this.getFileGuid().equals(other.getFileGuid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getFileCode() == null ? other.getFileCode() == null : this.getFileCode().equals(other.getFileCode()))
            && (this.getFileOrg() == null ? other.getFileOrg() == null : this.getFileOrg().equals(other.getFileOrg()))
            && (this.getFileDate() == null ? other.getFileDate() == null : this.getFileDate().equals(other.getFileDate()))
            && (this.getReceiveDate() == null ? other.getReceiveDate() == null : this.getReceiveDate().equals(other.getReceiveDate()))
            && (this.getApproval() == null ? other.getApproval() == null : this.getApproval().equals(other.getApproval()))
            && (this.getCheckRead() == null ? other.getCheckRead() == null : this.getCheckRead().equals(other.getCheckRead()))
            && (this.getLastAt() == null ? other.getLastAt() == null : this.getLastAt().equals(other.getLastAt()))
            && (this.getTxtFileDate() == null ? other.getTxtFileDate() == null : this.getTxtFileDate().equals(other.getTxtFileDate()))
            && (this.getOldXianbanDate() == null ? other.getOldXianbanDate() == null : this.getOldXianbanDate().equals(other.getOldXianbanDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFileType() == null) ? 0 : getFileType().hashCode());
        result = prime * result + ((getFileGuid() == null) ? 0 : getFileGuid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getFileCode() == null) ? 0 : getFileCode().hashCode());
        result = prime * result + ((getFileOrg() == null) ? 0 : getFileOrg().hashCode());
        result = prime * result + ((getFileDate() == null) ? 0 : getFileDate().hashCode());
        result = prime * result + ((getReceiveDate() == null) ? 0 : getReceiveDate().hashCode());
        result = prime * result + ((getApproval() == null) ? 0 : getApproval().hashCode());
        result = prime * result + ((getCheckRead() == null) ? 0 : getCheckRead().hashCode());
        result = prime * result + ((getLastAt() == null) ? 0 : getLastAt().hashCode());
        result = prime * result + ((getTxtFileDate() == null) ? 0 : getTxtFileDate().hashCode());
        result = prime * result + ((getOldXianbanDate() == null) ? 0 : getOldXianbanDate().hashCode());
        return result;
    }
}