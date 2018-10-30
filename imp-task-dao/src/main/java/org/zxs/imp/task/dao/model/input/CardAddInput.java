package org.zxs.imp.task.dao.model.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CardAddInput {
	
	@NotNull(message = "是否公共卡片字段不能为空！")
	private Byte isPublic;
	
	@NotNull(message = "卡片层级不能为空！")
	private Byte level;
	
	@NotEmpty(message = "卡片名称不能为空！")
	private String name;
	
	@NotNull(message = "卡片星级不能为空！")
	private Byte starNum;
	
	@NotEmpty(message = "卡片内容不能为空！")
	private String content;
	
	private Integer userId;
	private Integer type;
	private Integer source;
	private String place;
	private String accurDateStr;
	private String endDateStr;
	private Integer submitUserDeptId;
	private Long oaFileId;
	private Long parentId;
	private List<Long> sonIdArray;
	private List<Integer> aheadArray;
	private List<Integer> parternArray;
	private List<Long> labelArray;
	private List<Long> attachArray;
	private List<Integer> leaderArray;
	
	public Byte getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Byte isPublic) {
		this.isPublic = isPublic;
	}
	public Byte getLevel() {
		return level;
	}
	public void setLevel(Byte level) {
		this.level = level;
	}
	public String getName() {
		return name == null ? "":name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getStarNum() {
		return starNum;
	}
	public void setStarNum(Byte starNum) {
		this.starNum = starNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAccurDateStr() {
		return accurDateStr;
	}
	public void setAccurDateStr(String accurDateStr) {
		this.accurDateStr = accurDateStr;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	public Integer getSubmitUserDeptId() {
		return submitUserDeptId;
	}
	public void setSubmitUserDeptId(Integer submitUserDeptId) {
		this.submitUserDeptId = submitUserDeptId;
	}
	public Long getOaFileId() {
		return oaFileId;
	}
	public void setOaFileId(Long oaFileId) {
		this.oaFileId = oaFileId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public List<Long> getSonIdArray() {
		return sonIdArray;
	}
	public void setSonIdArray(List<Long> sonIdArray) {
		this.sonIdArray = sonIdArray;
	}
	public List<Integer> getAheadArray() {
		return aheadArray;
	}
	public void setAheadArray(List<Integer> aheadArray) {
		this.aheadArray = aheadArray;
	}
	public List<Integer> getParternArray() {
		return parternArray;
	}
	public void setParternArray(List<Integer> parternArray) {
		this.parternArray = parternArray;
	}
	public List<Long> getLabelArray() {
		return labelArray;
	}
	public void setLabelArray(List<Long> labelArray) {
		this.labelArray = labelArray;
	}
	public List<Long> getAttachArray() {
		return attachArray;
	}
	public void setAttachArray(List<Long> attachArray) {
		this.attachArray = attachArray;
	}
	public List<Integer> getLeaderArray() {
		return leaderArray;
	}
	public void setLeaderArray(List<Integer> leaderArray) {
		this.leaderArray = leaderArray;
	}
}
