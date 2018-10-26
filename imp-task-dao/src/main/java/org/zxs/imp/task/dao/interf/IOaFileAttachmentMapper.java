package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.OaFileAttachment;

import tk.mybatis.mapper.common.Mapper;

public interface IOaFileAttachmentMapper extends Mapper<OaFileAttachment> {

	/**
	 * 增量更新收文附件信息
	 * @param fileGuid
	 * @param attachList
	 * @return
	 */
	int insertOrUpdateAttachment(@Param("oaFileId")Long oaFileId, @Param("attachList") List<OaFileAttachment> attachList);
}