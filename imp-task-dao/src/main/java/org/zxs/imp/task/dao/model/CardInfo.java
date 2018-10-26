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
@Table(name="card_info")
public class CardInfo {
	public static final byte STATUS_TODO = 0;
	public static final byte STATUS_DONE = 1;
	public static final byte STATUS_DELAY = 2;
	
	public static final int LEVEL_TOP = 1;
	public static final int LEVEL_SEC = 2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;
	
	@JSONField(ordinal=2)
	@Column(name="card_type", nullable = false, unique = false, length = 6, columnDefinition = "卡片类型，对应字典表10字段")
    private Integer cardType;
	
	@JSONField(ordinal=3)
	@Column(name="oa_file_id", nullable = true, unique = false, length = 3, columnDefinition = "关联的OA文件编号")
    private Long oaFileId;
	
	@JSONField(ordinal=4)
	@Column(name="card_name", nullable = false, unique = true, length = 500, columnDefinition = "卡片标题")
    private String cardName;

	@JSONField(ordinal=5)
	@Column(name="card_level", nullable = false, unique = false, length = 3, columnDefinition = "卡片级别")
    private Byte cardLevel;
	
	@JSONField(ordinal=6)
	@Column(name="card_star", nullable = false, unique = false, length = 3, columnDefinition = "卡片星级")
    private Byte cardStar;
	
	@JSONField(ordinal=7)
	@Column(name="card_content", nullable = true, unique = false, length = 3, columnDefinition = "卡片内容")
    private String cardContent;

	@JSONField(ordinal=8)
	@Column(name="card_status", nullable = false, unique = false, length = 3, columnDefinition = "卡片状态，0为待办，1为已办，2为缓办")
    private Byte cardStatus;
	
	@JSONField(ordinal=9)
	@Column(name="create_id", nullable = false, unique = false, length = 8, columnDefinition = "创建者编号")
    private Integer createId;
	
	@JSONField(ordinal=10)
	@Column(name="place", nullable = true, unique = false, length = 3, columnDefinition = "发生地点")
    private String place;
	
	@JSONField(ordinal=11)
	@Column(name="accur_date", nullable = true, unique = false, columnDefinition = "发生时间")
    private Date accurDate;
	
	@JSONField(ordinal=12)
	@Column(name="prove_status", nullable = false, unique = false, length = 3, columnDefinition = "卡片审核状态，0为未审核，1为已审核")
    private Byte proveStatus;
	
	@JSONField(ordinal=13)
	@Column(name="is_public", nullable = false, unique = false, length = 1, columnDefinition = "是否公开卡片，0为否，1为是")
    private Byte isPublic;
	
	@JSONField(ordinal=14)
	@Column(name="end_date", nullable = true, unique = false, columnDefinition = "限办日期")
    private Date endDate;

	@JSONField(ordinal=15)
	@Column(name="create_at", nullable = false, unique = false, columnDefinition = "记录创建时间")
    private Date createAt;
	
	@JSONField(ordinal=16)
	@Column(name="update_at", nullable = true, unique = false, columnDefinition = "最后更新时间")
    private Date updateAt;

	@JSONField(ordinal=17)
	@Column(name="end_at", nullable = true, unique = false, columnDefinition = "卡片终止时间")
    private Date endAt;
	
	@JSONField(ordinal=18)
	@Column(name="is_delete", nullable = false, unique = false, columnDefinition = "卡片终止时间")
    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Long getOaFileId() {
		return oaFileId;
	}

	public void setOaFileId(Long oaFileId) {
		this.oaFileId = oaFileId;
	}

	public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public Byte getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(Byte cardLevel) {
        this.cardLevel = cardLevel;
    }

    public Byte getCardStar() {
		return cardStar;
	}

	public void setCardStar(Byte cardStar) {
		this.cardStar = cardStar;
	}

	public String getCardContent() {
		return cardContent;
	}

	public void setCardContent(String cardContent) {
		this.cardContent = cardContent == null ? "" : cardContent.trim();
	}

	public Byte getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Byte cardStatus) {
        this.cardStatus = cardStatus;
    }

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place == null ? "" : place;
	}

	public Date getAccurDate() {
		return accurDate;
	}

	public void setAccurDate(Date accurDate) {
		this.accurDate = accurDate;
	}

	public Byte getProveStatus() {
		return proveStatus;
	}

	public void setProveStatus(Byte proveStatus) {
		this.proveStatus = proveStatus;
	}

	public Byte getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Byte isPublic) {
		this.isPublic = isPublic;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
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
        CardInfo other = (CardInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getOaFileId() == null ? other.getOaFileId() == null : this.getOaFileId().equals(other.getOaFileId()))
            && (this.getCardName() == null ? other.getCardName() == null : this.getCardName().equals(other.getCardName()))
            && (this.getCardLevel() == null ? other.getCardLevel() == null : this.getCardLevel().equals(other.getCardLevel()))
            && (this.getCardStar() == null ? other.getCardStar() == null : this.getCardStar().equals(other.getCardStar()))
            && (this.getCardContent() == null ? other.getCardContent() == null : this.getCardContent().equals(other.getCardContent()))
            && (this.getCardStatus() == null ? other.getCardStatus() == null : this.getCardStatus().equals(other.getCardStatus()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getPlace() == null ? other.getPlace() == null : this.getPlace().equals(other.getPlace()))
            && (this.getAccurDate() == null ? other.getAccurDate() == null : this.getAccurDate().equals(other.getAccurDate()))
            && (this.getProveStatus() == null ? other.getProveStatus() == null : this.getProveStatus().equals(other.getProveStatus()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()))
            && (this.getEndAt() == null ? other.getEndAt() == null : this.getEndAt().equals(other.getEndAt()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getOaFileId() == null) ? 0 : getOaFileId().hashCode());
        result = prime * result + ((getCardName() == null) ? 0 : getCardName().hashCode());
        result = prime * result + ((getCardLevel() == null) ? 0 : getCardLevel().hashCode());
        result = prime * result + ((getCardStar() == null) ? 0 : getCardStar().hashCode());
        result = prime * result + ((getCardContent() == null) ? 0 : getCardContent().hashCode());
        result = prime * result + ((getCardStatus() == null) ? 0 : getCardStatus().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getPlace() == null) ? 0 : getPlace().hashCode());
        result = prime * result + ((getAccurDate() == null) ? 0 : getAccurDate().hashCode());
        result = prime * result + ((getProveStatus() == null) ? 0 : getProveStatus().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        result = prime * result + ((getEndAt() == null) ? 0 : getEndAt().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}