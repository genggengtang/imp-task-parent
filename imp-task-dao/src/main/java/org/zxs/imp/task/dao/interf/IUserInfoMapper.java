package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.UserInfo;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;
import org.zxs.imp.task.dao.model.vo.output.PhoneCardOut;
import org.zxs.imp.task.dao.model.vo.output.PhoneListOut;
import org.zxs.imp.task.dao.model.vo.query.PhoneListQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IUserInfoMapper extends Mapper<UserInfo>{
	/**
	 * 根据用户名密码，获取APP用户登录信息
	 * @return
	 */
	AppUser selectAppLoginInfoByNameAndPsw(@Param("username")String username, @Param("psw")String psw);

	/**
	 * 根据用户编号更新密码
	 * @param userId
	 * @param pswdNew
	 * @return
	 */
	int updatePasswordById(@Param("id")int id, @Param("pswdNew")String pswdNew);
	
	/**
	 * 查询所有分管领导编号选项
	 * @return
	 */
	List<OptionsOut> selectLeaderList();

	/**
	 * 获取通讯录信息
	 * @param query
	 * @return
	 */
	List<PhoneCardOut> selectPhoneList(@Param("query")PhoneListQuery query);

	/**
	 * 根据传入的用户编号集合，获取用户姓名串
	 * @param userList
	 * @return
	 */
	String selectNameInRow(List<Integer> userList);

	/**
	 * 获取本科室用户编号列表
	 * @param deptId
	 * @return
	 */
	List<OptionsOut> selectUserByDept(int deptId);

	/**
	 * 获取所有分管领导，返回领导主管科室用户表编号作为值，主要用于卡片选择领导接口
	 * @return
	 */
	List<OptionsOut> selectLeaderOpts();
}