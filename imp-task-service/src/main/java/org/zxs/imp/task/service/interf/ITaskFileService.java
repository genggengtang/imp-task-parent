package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.vo.output.FileSimpleOut;

public interface ITaskFileService {
	/**
	 * 根据子项目编号、文件类型获取文件基本信息
	 * @param subId
	 * @param type
	 * @return
	 */
	List<FileSimpleOut> getFileSimpleInfoBySubIdAndType(long subId, Integer type);
}
