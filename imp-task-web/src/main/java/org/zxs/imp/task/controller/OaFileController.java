package org.zxs.imp.task.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.imp.task.controller.bean.OaFileProcessor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="006.请求OA接口")
public class OaFileController {
	@Resource
	private OaFileProcessor oaFileProcessor;

	@RequestMapping(value = "syn-oa-file", method = RequestMethod.POST)
	@ApiOperation(httpMethod = "POST", value = "同步OA收文数据", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonReturnBean<Integer> getOAFileList(@RequestParam(value="startTime", required=false) String startTime,
			@RequestParam(value="endTime", required=false) String endTime, 
			@RequestParam(value="pageSize", required=false, defaultValue="320") Integer pageSize) {
		return oaFileProcessor.persistOaFiles(startTime, endTime, pageSize);
	}
}
