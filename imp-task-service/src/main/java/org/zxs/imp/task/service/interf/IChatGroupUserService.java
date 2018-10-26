package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.base.model.CommonReturnBean;

import com.github.pagehelper.PageInfo;

public interface IChatGroupUserService {
	/**
	 * 判断用户是否在群组中
	 * @param userId
	 * @param cgId
	 * @return
	 */
	boolean isUserInGroup(int userId, int cgId);
	
	/**
	 * 判断用户是否群主
	 * @param userId
	 * @param cgId
	 * @return
	 */
	boolean isUserGroupOwner(int userId, int cgId);
	
	/**
	 * 是否群管理员，能否加、减成员
	 * @param userId
	 * @param cgId
	 * @return
	 */
	boolean isGroupAdmin(int userId, int cgId);
	
	/**
	 * 根据聊天群组编号，获取群组成员编号集合
	 * @return
	 */
	List<Integer> getUserByCgId(int cgId, Integer selfId);

}
