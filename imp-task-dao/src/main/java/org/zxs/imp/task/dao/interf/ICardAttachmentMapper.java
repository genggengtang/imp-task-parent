package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.CardAttachment;

import tk.mybatis.mapper.common.Mapper;

public interface ICardAttachmentMapper extends Mapper<CardAttachment> {

	/**
	 * 增量更新收文附件信息
	 * @param cardId
	 * @param attachList
	 * @return
	 */
	int insertOrUpdateAttachment(@Param("cardId")Long cardId, @Param("attachList") List<CardAttachment> attachList);
}