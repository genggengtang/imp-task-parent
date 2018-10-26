package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.ChatMsgStatus;
import org.zxs.imp.task.dao.model.vo.output.ChatGroupSimpleOut;

import tk.mybatis.mapper.common.Mapper;

public interface IChatMsgStatusMapper extends Mapper<ChatMsgStatus>{
	
	/**
	 * 根据群聊组编号和用户编号更新记录
	 * 
	 * @param id
	 * @param userId
	 * @return
	 */
	int updateByCgIdAndUserId(@Param("id")int id, @Param("userId")int userId);

	/**
	 * 根据用户编号,按群组获取未读消息
	 * @param userId
	 * @return
	 */
	List<ChatGroupSimpleOut> selectUnreadCountByRoom(@Param("userId")int userId);
}