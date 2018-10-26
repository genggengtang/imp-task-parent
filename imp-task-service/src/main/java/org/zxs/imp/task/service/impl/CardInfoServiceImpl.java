package org.zxs.imp.task.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.interf.ICardAffairMapper;
import org.zxs.imp.task.dao.interf.ICardInfoMapper;
import org.zxs.imp.task.dao.interf.ICardLabelMapper;
import org.zxs.imp.task.dao.interf.ICardTakerMapper;
import org.zxs.imp.task.dao.interf.IUserDeptMapper;
import org.zxs.imp.task.dao.model.CardAffair;
import org.zxs.imp.task.dao.model.CardInfo;
import org.zxs.imp.task.dao.model.CardTaker;
import org.zxs.imp.task.dao.model.UserDept;
import org.zxs.imp.task.dao.model.UserDeptExample;
import org.zxs.imp.task.dao.model.UserDeptExample.Criteria;
import org.zxs.imp.task.dao.model.input.CardAddInput;
import org.zxs.imp.task.dao.model.vo.output.CardSimpleOut;
import org.zxs.imp.task.dao.model.vo.output.CardTaskPageOut;
import org.zxs.imp.task.dao.model.vo.query.CardTaskQuery;
import org.zxs.imp.task.service.interf.ICardInfoService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class CardInfoServiceImpl implements ICardInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CardInfoServiceImpl.class);
	@Resource
	private ICardInfoMapper cardInfoMapper;
	
	@Resource
	private IUserDeptMapper userDeptMapper;
	
	@Resource
	private ICardAffairMapper affairMapper;
	
	@Resource
	private ICardTakerMapper cardTakerMapper;
	
	@Resource
	private ICardLabelMapper cLabelMapper;

	@Override
	@Transactional
	public int batchInsertCardInfoByOaDraft() {
		return cardInfoMapper.insertFromOaDraft();
	}

	@Override
	public PageInfo<CardTaskPageOut> getCardTaskInfoByPage(CardTaskQuery query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize());
		
		List<Integer> leaderArray = query.getLeaderArray();
		if(null != leaderArray && !leaderArray.isEmpty()) { // 分管领导条件转换为部门
			UserDeptExample example = new UserDeptExample();
			Criteria leaderCriteria = example.createCriteria();
			leaderCriteria.andUserIdIn(leaderArray);
			leaderCriteria.andRoleEqualTo(IUserDeptMapper.ROLE_LEADER);
			List<UserDept> userDeptList = userDeptMapper.selectByExample(example);
			
			if(null != userDeptList && !userDeptList.isEmpty()) {
				List<Integer> deptArray = query.getDeptArray();
				Set<Integer> leaderSet = new HashSet<>();
				if(null != deptArray && !deptArray.isEmpty()) {
					leaderSet = new HashSet<>(deptArray);
				}else {
					deptArray = new ArrayList<>();
				}
				
				for(UserDept ud : userDeptList) {
					Integer deptId = ud.getDeptId();
					if(leaderSet.isEmpty()) {
						deptArray.add(deptId);
						leaderSet.add(deptId);
					}else {
						if(!leaderSet.contains(deptId)) {
							deptArray.add(deptId);
							leaderSet.add(deptId);
						}
					}
				}
				query.setDeptArray(deptArray);
			}
			
		}
		
		List<CardTaskPageOut> outsList = cardInfoMapper.selectCardTaskList(query);
		return new PageInfo<>(outsList);
	}

	@Override
	public CardSimpleOut getSimpleDetail(long id, int userId) {
		return cardInfoMapper.selectDetailByIdAndUser(id, userId);
	}

	@Override
	public long getCountByCardLevel(int cLevel, CardTaskQuery query) {
		return cardInfoMapper.selectCountByCardLevel(cLevel, query);
	}

	@Override
	public boolean isCardNameExist(String name, int userId) {
		return cardInfoMapper.selectCountByNameAndCreator(name, userId) > 0;
	}

	@Override
	@Transactional
	public int saveNewCard(CardAddInput cardInput, Byte isPublic, Byte level, String name, Byte starNum, String content) throws ParseException {
		Integer creatorId = cardInput.getUserId();
		Date nowTime = new Date();
		CardInfo ci = new CardInfo();
		ci.setCardLevel(level);
		ci.setCardName(name);
		ci.setCardContent(content);
		ci.setCardStar(starNum);
		ci.setIsPublic(isPublic);
		ci.setCreateId(creatorId);
		
		ci.setCardType(cardInput.getType());
		ci.setIsDelete((byte) 0);
		ci.setOaFileId(cardInput.getOaFileId());
		ci.setPlace(cardInput.getPlace());
		ci.setProveStatus((byte) 0);
		if(level > 1) // 对于小卡片，设置待办状态
			ci.setCardStatus(CardInfo.STATUS_TODO);
		ci.setCreateAt(nowTime);
		ci.setUpdateAt(nowTime);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		String accurDateStr = cardInput.getAccurDateStr();
		if(null != accurDateStr && !accurDateStr.isEmpty()) {
			ci.setAccurDate(sdf.parse(accurDateStr));
		}
		
		String endDateStr = cardInput.getEndDateStr();
		if(null != endDateStr && !endDateStr.isEmpty()) {
			ci.setEndDate(sdf.parse(endDateStr));
		}
		
		int cardInsertCnt = cardInfoMapper.insertSelective(ci);
		if(cardInsertCnt == 1) {
			Long cardId = ci.getId();
			LOGGER.info("创建卡片记录{}成功！", cardId);
			
			// 添加卡片创建人员
			CardTaker ctCreator = new CardTaker();
			ctCreator.setCardId(cardId);
			ctCreator.setRole(CardTaker.USER_REGIS);
			ctCreator.setStatus(CardTaker.AFFAIR_DONE);
			// 获取创建者默认用户科室编号
			Integer userDeptId = userDeptMapper.selectIdByUserId(creatorId);
			ctCreator.setUserDeptId(userDeptId);
			int ctCnt = cardTakerMapper.insertSelective(ctCreator);
			if(ctCnt == 1) {
				LOGGER.info("添加卡片创建人记录成功！");
			}
			
			// 添加分管领导
			List<Integer> leaderList = cardInput.getLeaderArray();
			if(null != leaderList && !leaderList.isEmpty()) {
				int ldCnt = cardTakerMapper.batchInsertByUserList(leaderList, cardId, null, CardTaker.USER_LEAD);
				LOGGER.info("添加卡片分管领导结束，结果为{}！", ldCnt);
			}
			
			// 添加卡片创建事项
			CardAffair ca = new CardAffair();
			ca.setCardId(cardId);
			ca.setCreatorId(creatorId);
			ca.setType(IDicInfoConst.AFFAIR_CREATE);
			ca.setCreateAt(nowTime);
			ca.setTitle("卡片创建！");
			ca.setContent("卡片创建！");
			
			int affairCnt = affairMapper.insert(ca);
			if(affairCnt == 1) {
				Long affairId = ca.getId();
				LOGGER.info("创建卡片{}事项{}结束！", cardId, affairId);
				
				// 添加总负责人
				Integer rspUdId = cardInput.getSubmitUserDeptId();
				if(null != rspUdId) {
					CardTaker ctRsp = new CardTaker();
					ctRsp.setCardId(cardId);
					ctRsp.setRole(CardTaker.USER_RSP);
					ctRsp.setStatus(CardTaker.AFFAIR_TODO);
					ctRsp.setAffairId(affairId);
					ctRsp.setUserDeptId(rspUdId);
					int rspCtCnt = cardTakerMapper.insertSelective(ctRsp);
					LOGGER.info("添加卡片负责人记录结束，结果为{}！", rspCtCnt);
				}
				
				// 添加牵头人员关联
				List<Integer> aheadList = cardInput.getAheadArray();
				if(null != aheadList && !aheadList.isEmpty()) {
					int aheadCnt = cardTakerMapper.batchInsertByUserList(aheadList, cardId, affairId, CardTaker.USER_AHEAD);
					LOGGER.info("添加卡片牵头人员结束，结果为{}！", aheadCnt);
				}
				
				// 添加配合人员关联
				List<Integer> ptList = cardInput.getParternArray();
				if(null != ptList && !ptList.isEmpty()) {
					int ptCnt = cardTakerMapper.batchInsertByUserList(ptList, cardId, affairId, CardTaker.USER_PARTERN);
					LOGGER.info("添加卡片配合人员记录结束，结果为{}！", ptCnt);
				}
			}
			
			// 添加关联标签
			List<Long> labels = cardInput.getLabelArray();
			if(null != labels && !labels.isEmpty()) {
				int lbCnt = cLabelMapper.batchInsertByLabelList(labels, cardId, creatorId);
				LOGGER.info("添加卡片关联标签记录结束，结果为{}！", lbCnt);
			}
			
		}else {
			LOGGER.info("创建卡片记录'{}'失败！", name);
		}
		
		return cardInsertCnt;
	}
	
	
}
