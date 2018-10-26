//package org.zxs.imp.task.dao.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.apache.ibatis.type.JdbcType;
//
//import com.alibaba.fastjson.annotation.JSONField;
//
//@Entity
//@Table(name="card_dairy")
//public class CardDairy {
//	public CardDairy() {
//		super();
//	}
//
//	public CardDairy(Long cardId, Long dairyId) {
//		super();
//		this.cardId = cardId;
//		this.dairyId = dairyId;
//	}
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@JSONField(ordinal=1)
//    private Long id;
//
//	@JSONField(ordinal=2)
//	@Column(name="card_id", nullable = false, unique = false, length = 15, columnDefinition = "卡片编号")
//    private Long cardId;
//
//	@JSONField(ordinal=3)
//	@Column(name="dairy_id", nullable = false, unique = false, length = 15, columnDefinition = "日志编号")
//    private Long dairyId;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getCardId() {
//        return cardId;
//    }
//
//    public void setCardId(Long cardId) {
//        this.cardId = cardId;
//    }
//
//    public Long getDairyId() {
//        return dairyId;
//    }
//
//    public void setDairyId(Long dairyId) {
//        this.dairyId = dairyId;
//    }
//
//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        CardDairy other = (CardDairy) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//            && (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
//            && (this.getDairyId() == null ? other.getDairyId() == null : this.getDairyId().equals(other.getDairyId()));
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
//        result = prime * result + ((getDairyId() == null) ? 0 : getDairyId().hashCode());
//        return result;
//    }
//}