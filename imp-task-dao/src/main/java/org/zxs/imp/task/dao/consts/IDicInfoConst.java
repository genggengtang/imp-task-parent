package org.zxs.imp.task.dao.consts;

/**
 * 字典表常量
 */
public interface IDicInfoConst {
	// 任务分类
	public static final int TASK_ALL = 100;
	public static final int TASK_CITY = 101;
	public static final int TASK_COMMITTEE = 102;
	public static final int TASK_KPI = 103;
	public static final int TASK_DAILY = 104;
	public static final int TASK_DEPT = 105;
	
	// 卡片分类
	public static final int CARD_ALL = 100;
	public static final int CARD_OA = 101;
	public static final int CARD_COMMITTEE = 102;
	public static final int CARD_KPI = 103;
	public static final int CARD_DAILY = 104;
	
	// 字典分类
    public static final int TYPE_TASK_STATUS = 113; // 任务状态
    public static final int TYPE_USER_LEVEL = 114; // 用户行政级别
    public static final int TYPE_FILE_TASK = 115; // 任务文件类型
    public static final int TYPE_USER_ROLE = 116; // 用户角色
    
    // 办理状态
    public static final int TASK_DOING = 11301; // 在办
    public static final int TASK_DONE = 11302; // 已办
    public static final int TASK_DELAY = 11303; // 缓办
    
    // 用户角色
    public static final int ROLE_ADMIN = 11600; // 系统管理员
    public static final int ROLE_LEADER_TOP = 11601; // 系统管理员
    public static final int ROLE_LEADER_ADMIN = 11602; // 分管领导
    public static final int ROLE_OFFICE = 11603; // 办公室工作人员
    public static final int ROLE_KPI = 11604; // 绩效办工作人员
    public static final int ROLE_DEPT_LEADER = 11605; // 科室负责人
    public static final int ROLE_DEPT_MEMBER = 11606; // 科室负责人
    
    // 文件类型
    public static final int FILE_BASIS = 11501; // 文件依据
    public static final int FILE_ATTACHMENT = 11502; // 附件
    
    public static final int AFFAIR_CREATE = 11701; // 文件依据
    public static final int AFFAIR_TRANS = 11702; // 转办
    public static final int AFFAIR_PRGR = 11703; // 进展
    public static final int AFFAIR_DONE = 11704; // 办结
    public static final int AFFAIR_LEADER_COMMENT = 11705; // 领导批示
    public static final int AFFAIR_PROVE = 11706; // 审核
}
