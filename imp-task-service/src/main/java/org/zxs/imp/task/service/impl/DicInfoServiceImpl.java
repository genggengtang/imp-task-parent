package org.zxs.imp.task.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.imp.task.dao.interf.IDicInfoMapper;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;
import org.zxs.imp.task.service.interf.IDicInfoService;


@Service
public class DicInfoServiceImpl implements IDicInfoService {

	@Resource
	private IDicInfoMapper dicMapper;
	
	@Override
	public List<OptionsOut> getOptionsByType(int type, String remark) {
		return dicMapper.selectOptionsByType(type, remark);
	}

	
	
}
