package org.zxs.imp.task.dao.model;

public class TaskStaticsView {
	public static final int STS_ALL_TYPE = 1000;
	public static final int STS_ALL_DEPT = 1001;
	public static final int STS_ALL_STATUS = 1002;
	
	public static final int STS_CITY_TYPE = 1010;
	public static final int STS_CITY_DEPT = 1011;
	public static final int STS_CITY_STATUS = 1012;
	
	public static final int STS_COMMITEE_TYPE = 1020;
	public static final int STS_COMMITEE_DEPT = 1021;
	public static final int STS_COMMITEE_STATUS = 1022;
	
	public static final int STS_KPI_TYPE = 1030;
	public static final int STS_KPI_DEPT = 1031;
	public static final int STS_KPI_STATUS = 1032;
	
	public static final int STS_DAILY_TYPE = 1040;
	public static final int STS_DAILY_DEPT = 1041;
	public static final int STS_DAILY_STATUS = 1042;
	
	public static final int STS_DEPT_TYPE = 1050;
	
	private Integer stsType;
	private String stsName;
	private Integer stsNum;
	
	public Integer getStsType() {
		return stsType;
	}
	public void setStsType(Integer stsType) {
		this.stsType = stsType;
	}
	public String getStsName() {
		return stsName;
	}
	public void setStsName(String stsName) {
		this.stsName = stsName;
	}
	public Integer getStsNum() {
		return stsNum;
	}
	public void setStsNum(Integer stsNum) {
		this.stsNum = stsNum;
	}
	
}
