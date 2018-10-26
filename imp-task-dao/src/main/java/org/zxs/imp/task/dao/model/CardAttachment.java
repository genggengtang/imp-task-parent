package org.zxs.imp.task.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="card_attachment"/*, indexes = {@Index(name = "attach_guid_idx",  columnList="oa_guid", unique = true)}*/)
public class CardAttachment {
//	public static final String URL_PRE = "http://202.103.199.209:8091/EpointOAWebservice_JXHDJ/";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;
	
	@JSONField(ordinal=2)
	@Column(name="card_id", nullable = false, unique = false, length = 15, columnDefinition = "关联的卡片编号")
    private Long cardId;

	@JSONField(ordinal=3)
	@Column(name="oa_guid", nullable = true, unique = true, length = 100, columnDefinition = "OA系统编号")
    private String oaGuid;

	@JSONField(ordinal=4)
	@Column(name="name", nullable = false, unique = false, length = 500, columnDefinition = "文件名")
    private String name;

	@JSONField(ordinal=5)
	@Column(name="oa_type", nullable = true, unique = false, length = 10, columnDefinition = "文件类型")
    private String oaType;

	@JSONField(ordinal=6)
	@Column(name="url", nullable = false, unique = false, length = 500, columnDefinition = "下载地址")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getOaGuid() {
        return oaGuid;
    }

    public void setOaGuid(String oaGuid) {
        this.oaGuid = oaGuid == null ? null : oaGuid.trim();
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOaType() {
		return oaType;
	}

	public void setOaType(String oaType) {
		this.oaType = oaType == null ? null : oaType.trim();
	}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
        CardAttachment other = (CardAttachment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getOaGuid() == null ? other.getOaGuid() == null : this.getOaGuid().equals(other.getOaGuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getOaType() == null ? other.getOaType() == null : this.getOaType().equals(other.getOaType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getOaGuid() == null) ? 0 : getOaGuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getOaType() == null) ? 0 : getOaType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        return result;
    }
}