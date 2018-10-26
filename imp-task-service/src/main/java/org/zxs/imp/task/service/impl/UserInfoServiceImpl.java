package org.zxs.imp.task.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.interf.IChatGroupInfoMapper;
import org.zxs.imp.task.dao.interf.IDeptInfoMapper;
import org.zxs.imp.task.dao.interf.IUserDeptMapper;
import org.zxs.imp.task.dao.interf.IUserInfoMapper;
import org.zxs.imp.task.dao.model.vo.output.AppUser;
import org.zxs.imp.task.dao.model.vo.output.ChatGroupSimpleOut;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;
import org.zxs.imp.task.dao.model.vo.output.PhoneCardOut;
import org.zxs.imp.task.dao.model.vo.output.PhoneListOut;
import org.zxs.imp.task.dao.model.vo.query.PhoneListQuery;
import org.zxs.imp.task.service.interf.IUserInfoService;


@Service
public class UserInfoServiceImpl implements IUserInfoService {

	@Resource
	private IUserInfoMapper userMapper;
	
	@Resource
	private IDeptInfoMapper deptMapper;
	
	@Resource
	private IUserDeptMapper userDeptMapper;
	
	@Resource
	private IChatGroupInfoMapper cgMapper;
	
	@Override
	public AppUser getAppLoginInfo(String username, String password){
		AppUser user = userMapper.selectAppLoginInfoByNameAndPsw(username, password);
		
		if(null != user) {
			List<Integer> deptList = userDeptMapper.selectDeptListByUser(user.getUserId());
			user.setDeptList(deptList);
		}
		
		return user;
	}

	@Override
	@Transactional
	public int updatePassword(int userId, String pswdNew){
		return userMapper.updatePasswordById(userId, pswdNew);
	}

	@Override
	public List<OptionsOut> getLeaderOpts() {
		return userMapper.selectLeaderOpts();
	}

	@Override
	public PhoneListOut getPhoneList(PhoneListQuery query) {
		// 查询所有委内用户
		List<PhoneCardOut> userPhoneList = userMapper.selectPhoneList(query);
		
		// 查询用户相关所有群组
		List<ChatGroupSimpleOut> cgGroupList = cgMapper.selectChatGroupByUser(query);
		return new PhoneListOut(userPhoneList, cgGroupList);
	}

	@Override
	public List<OptionsOut> getUserOptsByDept(int deptId) {
//		return userMapper.selectUserByDept(deptId);
		return userDeptMapper.selectUserOptsByDept(deptId);
	}

	@Override
	public Map<String, List<OptionsOut>> getDeptUserOpts() {
		Map<String, List<OptionsOut>> retMap = new LinkedHashMap<>();
		List<OptionsOut> deptList = deptMapper.selectDeptOptions();
		for(OptionsOut dept : deptList) {
			retMap.put(dept.getOptText(), userDeptMapper.selectUserOptsByDept(Integer.parseInt(dept.getOptValue())));
		}
		return retMap;
	}

	@Override
	public List<OptionsOut> getLeaderList() {
		return userMapper.selectLeaderList();
	}
	
}
