package org.zxs.imp.task.dao.model.vo.output;

import java.util.Date;

import org.zxs.imp.task.dao.model.CardInfo;

public class CardSimpleOut extends CardInfo {
	private Integer dayRest;
	private String cardTypeDis;
	private Date endDate;
	private Integer alertLevel;
	private String alertDes; // 预警文字描述
	private String alertColor; // 预警颜色
	private Long favoriteId;

	public Integer getDayRest() {
		return dayRest;
	}

	public void setDayRest(Integer dayRest) {
		this.dayRest = dayRest;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCardTypeDis() {
		return cardTypeDis;
	}

	public void setCardTypeDis(String cardTypeDis) {
		this.cardTypeDis = cardTypeDis;
	}

	public Integer getAlertLevel() {
		byte status = this.getCardStatus();
		if(status == CardInfo.STATUS_DONE) { // 已办
			alertLevel = 2; // 已办正常
//			if(null != dayRest && dayRest < 0) {
//				alertLevel = 5; // 已办超期
//			}
			// 判断办结时间是否大于限办日期
			Date endAt = this.getEndAt();
			if(null != endAt && null != endDate) {
				if(endAt.getTime() > endDate.getTime())
					alertLevel = 5; // 已办超期
			}
		}else if(status == CardInfo.STATUS_TODO) { // 待办
			alertLevel = 1; // 待办正常
			if(null != dayRest) {
				if(dayRest < 2 && dayRest >= 0) {
					alertLevel = 3; // 待办警告
				} else if(dayRest < 0){
					alertLevel = 4; // 待办滞后
				}
			}
		}else { // 缓办
			alertLevel = 1;
		}
		return alertLevel;
	}

	public void setAlertLevel(Integer alertLevel) {
		this.alertLevel = alertLevel;
	}

	public String getAlertDes() {
		if(null != alertLevel) {
			switch(alertLevel) {
				case 1:
					alertDes = "待办 还剩" + dayRest + "天";
					break;
				case 2:
					alertDes = "已按时办理";
					break;
				case 3:
					alertDes = "预警 还剩" + dayRest + "天";
					break;
				case 4:
					alertDes = "未办理 超出限办日期";
					break;
				case 5:
					alertDes = "已办理 超出限办日期";
					break;
				default:
					alertDes = "";	
			}
		}
		return alertDes;
	}

	public void setAlertDes(String alertDes) {
		this.alertDes = alertDes;
	}

	public String getAlertColor() {
		if(null != alertLevel) {
			switch(alertLevel) {
				case 1:
					alertColor = "green";
					break;
				case 2:
					alertColor = "blue";
					break;
				case 3:
					alertColor = "yellow";
					break;
				case 4:
					alertColor = "red";
					break;
				case 5:
					alertColor = "purple";
					break;
				default:
					alertColor = "";	
			}
		}
		return alertColor;
	}

	public void setAlertColor(String alertColor) {
		this.alertColor = alertColor;
	}

	public Long getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}
	
}
