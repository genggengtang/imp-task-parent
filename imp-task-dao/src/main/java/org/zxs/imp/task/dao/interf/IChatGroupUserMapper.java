package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.ChatGroupInfo;
import org.zxs.imp.task.dao.model.ChatGroupUser;
import org.zxs.imp.task.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.imp.task.dao.model.vo.query.PhoneListQuery;

import tk.mybatis.mapper.common.Mapper;

public interface IChatGroupUserMapper extends Mapper<ChatGroupUser>{

	/**
	 * 获取群聊组里所有成员信息
	 * @param cgId
	 * @param selfId
	 * @return
	 */
	List<Integer> selectUserIdByCgId(int cgId, Integer selfId);
}