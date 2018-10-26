package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.OaFileInfo;

import tk.mybatis.mapper.common.Mapper;

public interface IOaFileInfoMapper extends Mapper<OaFileInfo>{

	/**
	 * 根据guid从中间表插入数据
	 * @return
	 */
	int insertFromDraft();

	/**
	 * 根据guid从中间表更新数据
	 * @return
	 */
	int updateFromDraft(String guid);

	/**
	 * 从中间表获取需要更新的公文记录的guid
	 * @return
	 */
	List<String> selectUpdFromDraft();
}