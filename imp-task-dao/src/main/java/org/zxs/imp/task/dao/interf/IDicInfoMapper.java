package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.DicInfo;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;

import tk.mybatis.mapper.common.Mapper;

public interface IDicInfoMapper extends Mapper<DicInfo>{
	/**
	 * 根据类型查询选项
	 * @param type
	 * @return
	 */
	List<OptionsOut> selectOptionsByType(@Param("type")int type, @Param("remark")String remark);
}