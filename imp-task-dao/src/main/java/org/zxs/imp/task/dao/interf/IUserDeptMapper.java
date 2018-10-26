package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.UserDept;
import org.zxs.imp.task.dao.model.vo.output.OptionsOut;

import tk.mybatis.mapper.common.Mapper;

public interface IUserDeptMapper extends Mapper<UserDept>{
	public final static byte ROLE_LEADER = 0;
	public final static byte ROLE_HEADER = 1;
	public final static byte ROLE_MEMBER = 2;
	
	/**
	 * 根据用户查询关联科室
	 * @param userId
	 * @return
	 */
	public List<Integer> selectDeptListByUser(int userId);
	
	/**
	 * 根据用户编号获取主键
	 * @param userId
	 * @return
	 */
	public Integer selectIdByUserId(int userId);

	/**
	 * 根据科室编号获取用户选项集合
	 * @param deptId
	 * @return
	 */
	public List<OptionsOut> selectUserOptsByDept(int deptId);
}