package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.vo.output.OptionsOut;

public interface IDeptInfoService {
	/**
	 * 获取所有科室选项
	 * @return
	 */
	List<OptionsOut> getAllDeptSearchOpts();
	
	/**
	 * 根据用户获取相关科室信息
	 * @param userId
	 * @return
	 */
	List<OptionsOut> getDeptOptsByUser(int userId);
}
