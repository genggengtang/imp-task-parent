package org.zxs.imp.task.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.zxs.imp.task.dao.interf.ITaskFileMapper;
import org.zxs.imp.task.dao.model.vo.output.FileSimpleOut;
import org.zxs.imp.task.service.interf.ITaskFileService;


@Service
public class TaskFileServiceImpl implements ITaskFileService {

	@Resource
	private ITaskFileMapper taskFileMapper;

	@Override
	public List<FileSimpleOut> getFileSimpleInfoBySubIdAndType(long subId, Integer type) {
		return taskFileMapper.selectFileSimpleInfoBySubIdAndType(subId, type);
	}
	
	
}
