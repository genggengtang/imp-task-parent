package org.zxs.imp.task.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="label_info")
public class LabelInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="is_publish", nullable = false, unique = false, length = 3, columnDefinition = "是否公共标签，0为否，1为是")
    private Byte isPublish;
	
	@JSONField(ordinal=3)
	@Column(name="create_id", nullable = false, unique = false, length = 8, columnDefinition = "标签创建者，0为系统管理员")
    private Integer createId;
	
	@JSONField(ordinal=4)
	@Column(name="label_content", nullable = false, unique = false, length = 50, columnDefinition = "标签内容")
    private String labelContent;

	@JSONField(ordinal=5)
	@Column(name="label_star", nullable = false, unique = false, length = 3, columnDefinition = "标签星数")
    private Byte labelStar;
	
	
	@JSONField(ordinal=6)
	@Column(name="label_color", nullable = true, unique = false, length = 30, columnDefinition = "标签文字颜色")
    private String labelColor;
	
	@JSONField(ordinal=7)
	@Column(name="label_bgcolor", nullable = true, unique = false, length = 30, columnDefinition = "标签背景颜色")
    private String labelBgcolor;
	
	@JSONField(ordinal=8)
	@Column(name="remark", nullable = true, unique = false, length = 500, columnDefinition = "备注")
    private String remark;

	@JSONField(ordinal=9)
	@Column(name="is_delete", nullable = false, unique = false, length = 3, columnDefinition = "是否删除，0为否，1为是")
    private Byte isDelete;

	@JSONField(ordinal=10)
	@Column(name="create_at", nullable = false, unique = false, columnDefinition = "创建时间")
    private Date createAt;

	@JSONField(ordinal=11)
	@Column(name="end_at", nullable = true, unique = false, columnDefinition = "标签借宿时间")
	private Date endAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(String labelContent) {
        this.labelContent = labelContent == null ? null : labelContent.trim();
    }
    
	public Byte getLabelStar() {
		return labelStar;
	}

	public void setLabelStar(Byte labelStar) {
		this.labelStar = labelStar;
	}

	public String getLabelColor() {
		return labelColor;
	}

	public void setLabelColor(String labelColor) {
		this.labelColor = labelColor == null ? "" : labelColor.trim();
	}

	public String getLabelBgcolor() {
		return labelBgcolor;
	}

	public void setLabelBgcolor(String labelBgcolor) {
		this.labelBgcolor = labelBgcolor == null ? "" : labelBgcolor.trim();
	}

	public Byte getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Byte isPublish) {
		this.isPublish = isPublish;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
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
        LabelInfo other = (LabelInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLabelStar() == null ? other.getLabelStar() == null : this.getLabelStar().equals(other.getLabelStar()))
            && (this.getLabelContent() == null ? other.getLabelContent() == null : this.getLabelContent().equals(other.getLabelContent()))
            && (this.getIsPublish() == null ? other.getIsPublish() == null : this.getIsPublish().equals(other.getIsPublish()))
            && (this.getLabelColor() == null ? other.getLabelColor() == null : this.getLabelColor().equals(other.getLabelColor()))
            && (this.getLabelBgcolor() == null ? other.getLabelBgcolor() == null : this.getLabelBgcolor().equals(other.getLabelBgcolor()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getEndAt() == null ? other.getEndAt() == null : this.getEndAt().equals(other.getEndAt()))
            ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLabelStar() == null) ? 0 : getLabelStar().hashCode());
        result = prime * result + ((getLabelContent() == null) ? 0 : getLabelContent().hashCode());
        result = prime * result + ((getIsPublish() == null) ? 0 : getIsPublish().hashCode());
        result = prime * result + ((getLabelColor() == null) ? 0 : getLabelColor().hashCode());
        result = prime * result + ((getLabelBgcolor() == null) ? 0 : getLabelBgcolor().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getEndAt() == null) ? 0 : getEndAt().hashCode());
        return result;
    }
}