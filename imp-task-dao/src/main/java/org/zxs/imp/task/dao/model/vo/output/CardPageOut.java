package org.zxs.imp.task.dao.model.vo.output;

import com.github.pagehelper.PageInfo;

public class CardPageOut {
	private Long bCardNum;
	private Long sCardNum;
	private PageInfo<CardTaskPageOut> cardPageData;
	
	public Long getbCardNum() {
		return bCardNum;
	}
	public void setbCardNum(Long bCardNum) {
		this.bCardNum = bCardNum == null ? 0 : bCardNum;
	}
	public Long getsCardNum() {
		return sCardNum;
	}
	public void setsCardNum(Long sCardNum) {
		this.sCardNum = sCardNum == null ? 0 : sCardNum;
	}
	public PageInfo<CardTaskPageOut> getCardPageData() {
		return cardPageData;
	}
	public void setCardPageData(PageInfo<CardTaskPageOut> cardPageData) {
		this.cardPageData = cardPageData;
	}
	
}
