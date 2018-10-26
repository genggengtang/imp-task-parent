package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.vo.output.OptionsOut;

public interface IDicInfoService {
	/**
	 * 根据类型获取选项信息
	 * @param type
	 * @param remark 返回对象添加属性值
	 * @return
	 */
	List<OptionsOut> getOptionsByType(int type, String remark);
}
