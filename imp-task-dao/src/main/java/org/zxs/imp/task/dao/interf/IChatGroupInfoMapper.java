package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.ChatGroupInfo;
import org.zxs.imp.task.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.imp.task.dao.model.vo.query.PhoneListQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IChatGroupInfoMapper extends Mapper<ChatGroupInfo>{

	/**
	 * 获取用户相关群组信息
	 * @param query
	 * @return
	 */
	List<ChatGroupSimpleOut> selectChatGroupByUser(@Param("query")PhoneListQuery query);
	
	/**
	 * 根据群成员，判定聊天群组是否存在
	 * @param createId
	 * @param userListStr
	 * @return
	 */
	ChatGroupInfo selectIfGroupExist(@Param("createId")Integer createId, @Param("userListStr")String userListStr);
}