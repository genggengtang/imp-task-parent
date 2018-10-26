package org.zxs.imp.task.dao.interf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zxs.imp.task.dao.model.CardInfo;
import org.zxs.imp.task.dao.model.input.CardAddInput;
import org.zxs.imp.task.dao.model.vo.output.CardSimpleOut;
import org.zxs.imp.task.dao.model.vo.output.CardTaskPageOut;
import org.zxs.imp.task.dao.model.vo.query.CardTaskQuery;

import tk.mybatis.mapper.common.Mapper;

public interface ICardInfoMapper extends Mapper<CardInfo>{

	/**
	 * 从OA中间表插入新记录
	 * @return
	 */
	int insertFromOaDraft();

	/**
	 * 查询小卡片列表
	 * @param query
	 * @return
	 */
	List<CardTaskPageOut> selectCardTaskList(@Param("query")CardTaskQuery query);

	/**
	 * 根据卡片编号和用户编号，获取卡片详情信息
	 * @param id
	 * @param userId
	 * @return
	 */
	CardSimpleOut selectDetailByIdAndUser(@Param("id")long id, @Param("userId")int userId);

	/**
	 * 查询某种级别卡片数量
	 * @param cLevel 
	 * @param query
	 * @return
	 */
	long selectCountByCardLevel(@Param("cLevel")int cLevel, @Param("query")CardTaskQuery query);

	/**
	 * 根据创建者、卡片名称获取记录数
	 * @param name
	 * @param userId
	 * @return
	 */
	int selectCountByNameAndCreator(@Param("name")String name, @Param("userId")int userId);

}