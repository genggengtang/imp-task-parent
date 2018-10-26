package org.zxs.imp.task.service.interf;

import java.util.List;
import java.util.Map;

import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;
import org.zxs.imp.task.dao.model.vo.output.PhoneListOut;
import org.zxs.imp.task.dao.model.vo.query.PhoneListQuery;

public interface IUserInfoService {
	
	/**
	 * 根据用户名和密码查找用户，返回用户基本信息
	 * @param username
	 * @param password
	 * @return
	 */
	AppUser getAppLoginInfo(String username, String password);

	/**
	 * 在APP上更新密码
	 * @param userId
	 * @param pswdNew
	 * @return
	 */
	int updatePassword(int userId, String pswdNew);
	
	/**
	 * 获取所有分管领导编号选择
	 * @return
	 */
	List<OptionsOut> getLeaderList();
	
	/**
	 * 获取所有分管领导，返回领导主管科室用户表编号作为值，主要用于卡片选择领导接口
	 * @return
	 */
	List<OptionsOut> getLeaderOpts();

	/**
	 * 获取聊天通讯录
	 * @param query
	 * @return
	 */
	PhoneListOut getPhoneList(PhoneListQuery query);
	
	/**
	 * 根据科室编号获取人员列表
	 * @return
	 */
	List<OptionsOut> getUserOptsByDept(int deptId);

	/**
	 * 获取科室人员选项列表
	 * @return
	 */
	Map<String, List<OptionsOut>> getDeptUserOpts();
}
