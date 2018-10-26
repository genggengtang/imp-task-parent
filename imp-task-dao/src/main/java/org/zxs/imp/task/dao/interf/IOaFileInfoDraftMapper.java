package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.OaFileInfoDraft;
import org.zxs.imp.task.dao.model.oa.OAFileXmlInfo;

import tk.mybatis.mapper.common.Mapper;

public interface IOaFileInfoDraftMapper extends Mapper<OaFileInfoDraft> {

	/**
	 * 批量保存
	 * @param oaFileXmlList
	 * @return
	 */
	int batchInsertOAFile(@Param("list")List<OAFileXmlInfo> oaFileXmlList);

	/**
	 * 查询新OA收文记录
	 * @return
	 */
	List<OaFileInfoDraft> selectNewOaFiles();

	/**
	 * 从中间表批量插入新卡片信息
	 * @return
	 */
	int batchInsertNewCard();

	/**
	 * 从中间表批量更新新卡片信息
	 * @return
	 */
	int batchUpdateCard();
}