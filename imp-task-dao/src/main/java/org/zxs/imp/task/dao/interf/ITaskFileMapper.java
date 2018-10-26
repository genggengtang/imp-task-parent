package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.TaskFile;
import org.zxs.imp.task.dao.model.vo.output.FileSimpleOut;

import tk.mybatis.mapper.common.Mapper;

public interface ITaskFileMapper extends Mapper<TaskFile>{
	/**
	 * 根据子任务编号、文件类型获取文件基本信息集合
	 * @param subId
	 * @param type
	 * @return
	 */
	List<FileSimpleOut> selectFileSimpleInfoBySubIdAndType(@Param("subId")long subId, @Param("type")Integer type);
}