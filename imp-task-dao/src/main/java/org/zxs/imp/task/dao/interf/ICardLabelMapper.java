package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.CardLabel;

import tk.mybatis.mapper.common.Mapper;

public interface ICardLabelMapper extends Mapper<CardLabel>{

	/**
	 * 批量插入卡片关联的标签
	 * @param labels
	 * @param cardId
	 * @param creatorId
	 * @return
	 */
	int batchInsertByLabelList(@Param("labels")List<Long> labels, @Param("cardId")Long cardId, @Param("creatorId")Integer creatorId);
}