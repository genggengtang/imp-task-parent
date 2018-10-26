package org.zxs.imp.task.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.interf.ICardLabelMapper;
import org.zxs.imp.task.dao.interf.ILabelInfoMapper;
import org.zxs.imp.task.dao.model.CardLabel;
import org.zxs.imp.task.dao.model.LabelInfo;
import org.zxs.imp.task.dao.model.LabelInfoExample;
import org.zxs.imp.task.dao.model.LabelInfoExample.Criteria;
import org.zxs.imp.task.dao.model.vo.output.LabelOut;
import org.zxs.imp.task.dao.model.vo.query.MyLabelQuery;
import org.zxs.imp.task.service.interf.ILabelInfoService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class LabelInfoServiceImpl implements ILabelInfoService {

	@Resource
	private ILabelInfoMapper labelMapper;
	
	@Resource
	private ICardLabelMapper cLabelMapper;
	
	@Override
	public List<LabelInfo> getPubLabelsByIds(String ids) {
		LabelInfoExample exam = new LabelInfoExample();
		Criteria crtr = exam.createCriteria();
		if(null != ids) {
			String[] idsArray = ids.split(",");
			Long[] lIds = (Long[])ConvertUtils.convert(idsArray, Long.class);
			crtr.andIdIn(Arrays.asList(lIds));
			crtr.andIsDeleteEqualTo((byte) 0);
			crtr.andIsPublishEqualTo((byte) 1);
			return labelMapper.selectByExample(exam);
		}
		return Collections.emptyList();
	}

	@Override
	public PageInfo<LabelOut> getMyLabels(MyLabelQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize());
		List<LabelOut> outsList = labelMapper.selectMyLabelList(query);
		return new PageInfo<>(outsList);
	}

	@Override
	public boolean checkLabelContent(String content, int userId) {
		List<Integer> userList = new ArrayList<>();
		userList.add(0);
		userList.add(userId);
		LabelInfoExample exam = new LabelInfoExample();
		Criteria criteria = exam.createCriteria();
		criteria.andIsDeleteEqualTo((byte) 0);
		criteria.andLabelContentEqualTo(content);
		criteria.andCreateIdIn(userList);
		return labelMapper.selectCountByExample(exam) > 0;
	}

	@Override
	@Transactional
	public int createLabel(LabelInfo label) {
		return labelMapper.insertSelective(label);
	}

	@Override
	public boolean checkCardLabel(Long labelId, Long cardId) {
		CardLabel cl = new CardLabel();
		cl.setCardId(cardId);
		cl.setLabelId(labelId);
		return cLabelMapper.selectCount(cl) > 0;
	}

	@Override
	@Transactional
	public int addCardLabel(CardLabel cl) {
		return cLabelMapper.insert(cl);
	}

	@Override
	@Transactional
	public int delCardLabel(CardLabel cl) {
		return cLabelMapper.delete(cl);
	}
	
	
	
}
