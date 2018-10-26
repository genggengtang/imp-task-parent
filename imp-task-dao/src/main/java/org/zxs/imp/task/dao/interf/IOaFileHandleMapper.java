package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.OaFileHandle;
import org.zxs.imp.task.dao.model.oa.OAFileHandleDetail;

import tk.mybatis.mapper.common.Mapper;

public interface IOaFileHandleMapper extends Mapper<OaFileHandle>{

	/**
	 * 增量更新处理信息
	 * @param fileGuid
	 * @param handleList
	 * @return
	 */
	int insertOrUpdateHandleList(@Param("fileGuid")String fileGuid, @Param("handleList")List<OAFileHandleDetail> handleList);
    
	/**
	 * 根据OA接口返回数据新增操作记录
	 * @param handle
	 * @return
	 */
	int insertBySourceOaData(@Param("handle")OAFileHandleDetail handle);
}