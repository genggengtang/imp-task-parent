package org.zxs.imp.task.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.imp.task.dao.interf.IDeptInfoMapper;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;
import org.zxs.imp.task.service.interf.IDeptInfoService;


@Service
public class DeptInfoServiceImpl implements IDeptInfoService {

	@Resource
	private IDeptInfoMapper deptMapper;
	
	@Override
	public List<OptionsOut> getAllDeptSearchOpts() {
		return deptMapper.selectDeptOptions();
	}

	@Override
	public List<OptionsOut> getDeptOptsByUser(int userId) {
		return deptMapper.selectDeptOptionsByUser(userId);
	}

	
}
