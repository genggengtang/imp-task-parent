package org.zxs.imp.task.service.interf;

import java.text.ParseException;

import org.zxs.imp.task.dao.model.input.CardAddInput;
import org.zxs.imp.task.dao.model.vo.output.CardSimpleOut;
import org.zxs.imp.task.dao.model.vo.output.CardTaskPageOut;
import org.zxs.imp.task.dao.model.vo.query.CardTaskQuery;

import com.github.pagehelper.PageInfo;

public interface ICardInfoService {

	/**
	 * 从中间表批量插入卡片信息
	 * @return
	 */
	int batchInsertCardInfoByOaDraft();

	/**
	 * 获取卡片任务分页数据
	 * @param query
	 * @return
	 */
	PageInfo<CardTaskPageOut> getCardTaskInfoByPage(CardTaskQuery query);

	/**
	 * 根据卡片编号、用户编号获取详情
	 * @param id
	 * @param userId
	 * @return
	 */
	CardSimpleOut getSimpleDetail(long id, int userId);
	
	/**
	 * 根据卡片级别和条件获取数量
	 * @param cLevel 卡片级别
	 * @param query 查询对象
	 * @return
	 */
	long getCountByCardLevel(int cLevel, CardTaskQuery query);

	/**
	 * 检查卡片名称是否已存在
	 * @param name
	 * @param userId
	 * @return
	 */
	boolean isCardNameExist(String name, int userId);

	/**
	 * 新增卡片
	 * @param cardInput
	 * @param content 
	 * @param starNum 
	 * @param name 
	 * @param level 
	 * @param isPublic 
	 * @return
	 */
	int saveNewCard(CardAddInput cardInput, Byte isPublic, Byte level, String name, Byte starNum, String content) throws ParseException;
}
