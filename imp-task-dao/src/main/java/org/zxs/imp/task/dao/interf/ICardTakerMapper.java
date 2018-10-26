package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.CardTaker;

import tk.mybatis.mapper.common.Mapper;

public interface ICardTakerMapper extends Mapper<CardTaker>{

	/**
	 * 根据用户手机号，新增数据
	 * @param cardId 
	 * @param userId
	 * @param role
	 * @return
	 */
	int insertByUserPhone(@Param("cardId")Long cardId, @Param("userId")Integer userId, @Param("role")short role);

	/**
	 * 批量插入数据
	 * @param aheadList
	 * @param cardId
	 * @param affairId
	 * @param role
	 * @return
	 */
	int batchInsertByUserList(@Param("aheadList")List<Integer> aheadList, 
				@Param("cardId")Long cardId, @Param("affairId")Long affairId, @Param("role")short role);
}