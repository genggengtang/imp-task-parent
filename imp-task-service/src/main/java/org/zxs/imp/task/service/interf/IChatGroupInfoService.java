package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.ChatGroupInfo;
import org.zxs.imp.task.dao.model.vo.query.ChatGroupQuery;

import com.github.pagehelper.PageInfo;

public interface IChatGroupInfoService {

	/**
	 * 获取聊天群信息
	 * @return
	 */
	List<ChatGroupInfo> getAllChatGroup();
	
	/**
	 * 创建群聊
	 * @param query
	 * @return
	 */
	ChatGroupInfo createChatRoom(ChatGroupQuery query);
	
	
	/**
	 * 根据群聊组编号，删除群聊组及相关记录
	 * @param id
	 * @return
	 */
	int deleteChatGroupById(int id);
	
	/**
	 * 修改群聊组名称
	 * @param id
	 * @param name
	 * @return
	 */
	int updateCgName(int id, String name);

}
