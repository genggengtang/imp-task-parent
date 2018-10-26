package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.DeptInfo;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;

import tk.mybatis.mapper.common.Mapper;

public interface IDeptInfoMapper extends Mapper<DeptInfo>{
	/**
	 * 查询所有科室选项
	 * @return
	 */
	List<OptionsOut> selectDeptOptions();
	
	/**
	 * 查询用户相关所有部门条件选项
	 * @return
	 */
	List<OptionsOut> selectDeptOptionsByUser(int userId);
}