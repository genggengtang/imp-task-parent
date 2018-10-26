package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.ChatGroupMsg;
import org.zxs.imp.task.dao.model.vo.output.ChatMsgOut;
import org.zxs.imp.task.dao.model.vo.query.MsgHisQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IChatGroupMsgMapper extends Mapper<ChatGroupMsg>{

	/**
	 * 获取最新聊天记录
	 * @param query
	 * @return
	 */
	List<ChatMsgOut> selectLatestMsgHis(@Param("query")MsgHisQuery query);
}