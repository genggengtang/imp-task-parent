package org.zxs.imp.task.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.imp.task.dao.interf.ISubTaskMapper;
import org.zxs.imp.task.dao.interf.ITaskFileMapper;
import org.zxs.imp.task.dao.model.vo.output.FileSimpleOut;
import org.zxs.imp.task.dao.model.vo.output.PeriodTaskOut;
import org.zxs.imp.task.service.interf.ISubTaskService;


@Service
public class SubTaskServiceImpl implements ISubTaskService {

	@Resource
	private ISubTaskMapper subMapper;
	
	@Resource
	private ITaskFileMapper taskFileMapper;

	@Override
	public List<PeriodTaskOut> getPeriodSubTaskInfoByTaskId(long id) {
		List<PeriodTaskOut> subList = subMapper.selectSubTaskByTaskId(id);
		if(null != subList && !subList.isEmpty()) {
			for(PeriodTaskOut subTaskOut : subList) {
				long subId = subTaskOut.getId();
				List<FileSimpleOut> fileList = taskFileMapper.selectFileSimpleInfoBySubIdAndType(subId, null);
				if(null != fileList && !fileList.isEmpty()) {
					subTaskOut.setAttachments(fileList);
				}
			}
		}
		return subList;
	}
	
}
