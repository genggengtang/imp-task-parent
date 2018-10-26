package org.zxs.imp.task.service.interf;

import java.util.List;

import org.zxs.imp.task.dao.model.CardLabel;
import org.zxs.imp.task.dao.model.LabelInfo;
import org.zxs.imp.task.dao.model.vo.output.LabelOut;
import org.zxs.imp.task.dao.model.vo.query.MyLabelQuery;

import com.github.pagehelper.PageInfo;

public interface ILabelInfoService {
	
	/**
	 * 根据ID字符串，获取公共标签列表
	 * @param ids
	 * @return
	 */
	List<LabelInfo> getPubLabelsByIds(String ids);
	
	/**
	 * 根据关键字获取我的标签列表
	 * @param pageQuery
	 * @return
	 */
	PageInfo<LabelOut> getMyLabels(MyLabelQuery query);

	/**
	 * 根据标签是否存在
	 * @param content
	 * @param userId 
	 * @return
	 */
	boolean checkLabelContent(String content, int userId);

	/**
	 * 新增标签
	 * @param label
	 * @return
	 */
	int createLabel(LabelInfo label);

	/**
	 * 检查卡片标签关系是否已存在
	 * @param labelId
	 * @param cardId
	 * @return
	 */
	boolean checkCardLabel(Long labelId, Long cardId);

	/**
	 * 添加卡片标签关联关系
	 * @param cl
	 * @return
	 */
	int addCardLabel(CardLabel cl);
	
	/**
	 * 移除卡片标签关联关系
	 * @param cl
	 * @return
	 */
	int delCardLabel(CardLabel cl);
	
}
