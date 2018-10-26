package org.zxs.imp.task.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="card_label_pr")
public class CardLabelPr {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JSONField(ordinal=1)
    private Long id;

	@JSONField(ordinal=2)
	@Column(name="label_id", nullable = false, unique = false, length = 12, columnDefinition = "标签编号")
    private Long labelId;

	@JSONField(ordinal=3)
	@Column(name="card_id", nullable = false, unique = false, length = 15, columnDefinition = "关联的卡片编号")
    private Long cardId;

	@JSONField(ordinal=4)
	@Column(name="create_id", nullable = false, unique = false, length = 8, columnDefinition = "关联者编号，0为系统用")
    private Integer createId;

	@JSONField(ordinal=5)
	@Column(name="visible_id", nullable = false, unique = false, length = 12, columnDefinition = "可以查看此关联的用户组编号")
    private Long visibleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Long getVisibleId() {
        return visibleId;
    }

    public void setVisibleId(Long visibleId) {
        this.visibleId = visibleId;
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
        CardLabelPr other = (CardLabelPr) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLabelId() == null ? other.getLabelId() == null : this.getLabelId().equals(other.getLabelId()))
            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getVisibleId() == null ? other.getVisibleId() == null : this.getVisibleId().equals(other.getVisibleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLabelId() == null) ? 0 : getLabelId().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getVisibleId() == null) ? 0 : getVisibleId().hashCode());
        return result;
    }
}