package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.LabelInfo;
import org.zxs.imp.task.dao.model.vo.output.LabelOut;
import org.zxs.imp.task.dao.model.vo.query.MyLabelQuery;

import tk.mybatis.mapper.common.Mapper;

public interface ILabelInfoMapper extends Mapper<LabelInfo>{
	
	/**
	 * 获取我的标签列表，包括公共和私人
	 * @param query
	 * @return
	 */
	List<LabelOut> selectMyLabelList(@Param("query")MyLabelQuery query);
}