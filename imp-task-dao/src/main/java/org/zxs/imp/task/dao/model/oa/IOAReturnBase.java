package org.zxs.imp.task.dao.model.oa;

public interface IOAReturnBase<D> {

	Boolean getReturnStatus();

	void setReturnStatus(Boolean returnStatus);

	String getDescription();

	void setDescription(String description);

	Integer getTotalNumCount();

	void setTotalNumCount(Integer totalNumCount);

	D getDataBase();

	void setDataBase(D dataBase);

}