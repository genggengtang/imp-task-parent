package org.zxs.imp.task.service.impl;
//package org.zxs.leader.control.service.impl;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//import org.zxs.imp.task.dao.model.AppVersion;
//import org.zxs.imp.task.dao.model.AppVersionExample;
//import org.zxs.imp.task.dao.model.AppVersionExample.Criteria;
//import org.zxs.leader.control.service.interf.IAppVersionService;
//
//
//@Service
//public class AppVersionServiceImpl implements IAppVersionService {
//
////	@Resource
////	private IAppVersionMapper appVersionMapper;
//
//	@Override
//	public AppVersion getLatestVersion(byte os, String versionCode) {
////		AppVersion cond = new AppVersion();
////		cond.setOs(os);
////		cond.setvCode(versionCode);
////		AppVersion oldApp = appVersionMapper.selectOne(cond);
////		if(null != oldApp) {
////			AppVersionExample example = new AppVersionExample();
////			example.setOrderByClause(" id desc");
////			Criteria criteria = example.createCriteria();
////			criteria.andIdGreaterThan(oldApp.getId());
////			criteria.andOsEqualTo(os);
////			List<AppVersion> appList = appVersionMapper.selectByExample(example);
////			if(null != appList && !appList.isEmpty()) {
////				return appList.get(0);
////			}
////		}
//		return null;
//	}
//}
