package org.zxs.imp.task.dao.model.oa;

public class OAReturnBase<D>{
	protected Boolean returnStatus;
	protected String description;
	protected Integer totalNumCount;
	protected D dataBasic;

	public Boolean getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(Boolean returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTotalNumCount() {
		return totalNumCount;
	}

	public void setTotalNumCount(Integer totalNumCount) {
		this.totalNumCount = totalNumCount;
	}

	public D getDataBasic() {
		return dataBasic;
	}

	public void setDataBasic(D dataBasic) {
		this.dataBasic = dataBasic;
	}

}
