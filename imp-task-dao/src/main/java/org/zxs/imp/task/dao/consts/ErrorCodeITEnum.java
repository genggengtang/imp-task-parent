package org.zxs.imp.task.dao.consts;

import org.zxs.base.model.IErrorCode;

/**
 * 错误码枚举类
 * @author Administrator
 *
 */
public enum ErrorCodeITEnum implements IErrorCode{
	TASK_ABSENT(-301, "该任务不存在！"),
	CG_USER_NULL(-302, "请求的聊天用户参数为空！"),
	OA_FILE_LIST_FAIL(-303, "OA接口收文接口返回失败！"),
	LABEL_NAME_DUP(-501, "标签名称已存在！"),
	CARD_LABEL_EXIST(-502, "卡片已关联此标签！"),
	CARD_LABEL_ABSENT(-503, "卡片和标签无关联！"),
	CARD_NAME_DUP(-504, "卡片名称已存在！"),
	CARD_CREATE_FAIL(-505, "新增卡片失败！")
	;

	private ErrorCodeITEnum(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	private final int errorCode;
	private final String errorMsg;

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
