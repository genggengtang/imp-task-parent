package org.zxs.imp.task.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zxs.imp.task.dao.consts.IDicInfoConst;
import org.zxs.imp.task.dao.interf.ICardAttachmentMapper;
import org.zxs.imp.task.dao.interf.ICardInfoMapper;
import org.zxs.imp.task.dao.interf.ICardTakerMapper;
import org.zxs.imp.task.dao.interf.IDairyNoteMapper;
import org.zxs.imp.task.dao.interf.IOaFileAttachmentMapper;
import org.zxs.imp.task.dao.interf.IOaFileHandleMapper;
import org.zxs.imp.task.dao.interf.IOaFileInfoDraftMapper;
import org.zxs.imp.task.dao.interf.IOaFileInfoMapper;
import org.zxs.imp.task.dao.interf.IUserInfoMapper;
import org.zxs.imp.task.dao.model.CardAttachment;
import org.zxs.imp.task.dao.model.CardInfo;
import org.zxs.imp.task.dao.model.CardTaker;
import org.zxs.imp.task.dao.model.DairyNote;
import org.zxs.imp.task.dao.model.OaFileAttachment;
import org.zxs.imp.task.dao.model.OaFileHandle;
import org.zxs.imp.task.dao.model.OaFileInfo;
import org.zxs.imp.task.dao.model.OaFileInfoDraft;
import org.zxs.imp.task.dao.model.OaFileInfoDraftExample;
import org.zxs.imp.task.dao.model.OaFileInfoExample;
import org.zxs.imp.task.dao.model.OaFileInfoExample.Criteria;
import org.zxs.imp.task.dao.model.UserInfo;
import org.zxs.imp.task.dao.model.UserInfoExample;
import org.zxs.imp.task.dao.model.oa.OAFileHandleDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlInfo;
import org.zxs.imp.task.service.interf.IOaFileInfoService;


@Service
public class OaFileInfoServiceImpl implements IOaFileInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OaFileInfoServiceImpl.class);
	
	@Resource
	private ICardInfoMapper cardInfoMapper;
	
	@Resource
	private IDairyNoteMapper dairyMapper;
	
//	@Resource
//	private ICardDairyMapper cardDairyMapper;

	@Resource
	private IOaFileInfoMapper oaFileInfoMapper;
	
	@Resource
	private IOaFileInfoDraftMapper oaFileDraftMapper;
	
	@Resource
	private IOaFileHandleMapper handleMapper;
	
	@Resource
	private IOaFileAttachmentMapper oaAttachMapper;
	
//	@Resource
//	private ICardAttachmentMapper attachMapper;
	
	@Resource
	private IUserInfoMapper userMapper;
	
	@Resource
	private ICardTakerMapper cardTakerMapper;

	@Override
	@Transactional
	public int batchSaveOaFileInfo2Draft(List<OAFileXmlInfo> oaFileXmlList) {
		return oaFileDraftMapper.batchInsertOAFile(oaFileXmlList);
	}

	@Override
	@Transactional
	public int saveOrUpdateFromDraft() {
//		int iUpdCnt = oaFileDraftMapper.batchUpdateCard();
//		LOGGER.info("从中间表更新{}条卡片数据！", iUpdCnt);
		
		int updNum = oaFileInfoMapper.updateFromDraft(null);
		LOGGER.info("从中间表更新{}条OA收文数据！", updNum);
		
//		int iSaveCnt = oaFileDraftMapper.batchInsertNewCard();
//		LOGGER.info("从中间表插入卡片信息表{}条数据！", iSaveCnt);
		
		int insOiNum = oaFileInfoMapper.insertFromDraft();
		LOGGER.info("从中间表插入oa办文信息表{}条数据！", insOiNum);
		
		return insOiNum + updNum;
	}

	@Override
	@Transactional
	public int clearDraft() {
		int delNum = oaFileDraftMapper.deleteByExample(new OaFileInfoDraftExample());
		LOGGER.info("清除中间表{}条数据！", delNum);
		return delNum;
	}

	@Override
	public List<String> getUpdFileIds() {
		return oaFileInfoMapper.selectUpdFromDraft();
	}

	@Override
	@Transactional
	public int saveOrUpdateHandleInfo(Long oaFileId, List<OAFileHandleDetail> handleList, Set<String> phoneSet) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("y/M/d H:m:s");
//		OaFileInfo oaFile = new OaFileInfo();
//		oaFile.setFileGuid(fileGuid);
//		OaFileInfo oaFileInfo = oaFileInfoMapper.selectOne(oaFile);
//		Long oaFileId = oaFileInfo.getId();
		int succ = 0;
//		String logUserPhone = ""; 
		
		if(null != handleList && !handleList.isEmpty()) {
			for(OAFileHandleDetail handleDetail : handleList) {
				String hHuid = handleDetail.getHandleGuid();
				String handleDateTime = handleDetail.getHandleDateTime();
//				String operationName = handleDetail.getOperationName();
				String opUserPhone = handleDetail.getOperateUserPhone();
				String opUserName = handleDetail.getOperateUserName();
				String activity = handleDetail.getActivity();
				String content = handleDetail.getOpinion();
				String subUserPhone = handleDetail.getSubmitUserPhone();
				String subUserName = handleDetail.getSubmitUserName();
				
//				if(actity.equals("登记") || actity.equals("送传阅")) {
//					logUserPhone = handleDetail.getSubmitUserPhone(); // 登记者
//					CardInfo ci = new CardInfo();
//					ci.setOaFileId(oaFileId);
//					
//					UserInfo ui = new UserInfo();
//					ui.setLoginName(logUserPhone);
//					UserInfo logUser = userMapper.selectOne(ui);
//					if(null != logUser) { // 更新记录创建者
//						ci.setCreatorId(logUser.getId());
//						if(null != content && !content.isEmpty()) {
//							ci.setCardContent(content);
//						}
//						cardInfoMapper.updateByPrimaryKeySelective(ci);
//					}
//					
//				}else if(actity.equals("归档")) {
//					LOGGER.info("更新卡片{}完成状态为已办！", oaFileId);
//					// 更新卡片完成状态
//					CardInfo ci = new CardInfo();
//					ci.setOaFileId(oaFileId);
//					ci.setCardStatus(CardInfo.STATUS_DONE);
//					ci.setEndAt(sdf.parse(handleDetail.getReceiveDateTime()));
//					cardInfoMapper.updateByPrimaryKeySelective(ci);
//				}
				
//				UserInfoExample exam = new UserInfoExample();
//				org.zxs.imp.task.dao.model.UserInfoExample.Criteria criteriaLn = exam.createCriteria();
//				criteriaLn.andLoginNameEqualTo(opUserPhone);
//				
//				org.zxs.imp.task.dao.model.UserInfoExample.Criteria criteriaCpUser = exam.createCriteria();
//				criteriaCpUser.andMobilePhoneLike(opUserPhone);
//				exam.or(criteriaCpUser);
//				List<UserInfo> opUsers = userMapper.selectByExample(exam);
//				
//				UserInfo opUser = null;
				
//				if(null != opUsers && opUsers.size() == 1) {
//					opUser = opUsers.get(0);
//					Integer opUserId = opUser.getId();
					
					// 添加卡片关联用户
//					if(opUserPhone.equals(logUserPhone)) {
//						saveCardTaker(oaFileId, opUserId, CardTaker.USER_REGIS);
//					}else {
//						// 判断用户角色是否分管领导
//						if(opUser.getRole().equals(IDicInfoConst.ROLE_LEADER)) {
//							saveCardTaker(oaFileId, opUserId, CardTaker.USER_LEAD);
//						}else {
//							saveCardTaker(oaFileId, opUserId, CardTaker.DEPT_AHEAD); // 默认牵头科室
//						}
//					}
						
//				}else {
//					LOGGER.warn("手机号{}对应的用户{}不存在！", opUserPhone, hUserName);
//					if(null != opUserPhone && !opUserPhone.isEmpty()) {
//						phoneSet.add(hUserName + ":" + opUserPhone);
//					}
//				}
				
				OaFileHandle handleQuery = new OaFileHandle();
				handleQuery.setHandleGuid(hHuid);
				OaFileHandle handle = handleMapper.selectOne(handleQuery);
				
				if(null != handle) { // 操作记录已存在，则更新操作记录
					if(null != handleDateTime && !handleDateTime.isEmpty()) {
						handle.setOperateAt(sdf.parse(handleDateTime));
						handle.setOpinion(content);
					}
					handle.setActivity(activity);
					handle.setOperateUserName(opUserName);
					handle.setOperateUserPhone(opUserPhone);
					handle.setSubmitUserPhone(subUserPhone);
					handle.setSubmitUserName(subUserName);
					
					int updRet = handleMapper.updateByPrimaryKeySelective(handle);
					if(updRet == 1)
						succ++;
					
				} else {
					handleDetail.setOaFileId(oaFileId);
					int handleInsRet = handleMapper.insertBySourceOaData(handleDetail);
					
					if(handleInsRet == 1)
						succ++;
					
//					if(null != opUser) {
//						DairyNote dairyNote = new DairyNote();
//						
//						if(null != handleDateTime && !handleDateTime.isEmpty() && null != operationName && !operationName.isEmpty()) { 
//							dairyNote.setStatus(DairyNote.WORK_DONE);
//							dairyNote.setDate(sdf.parse(handleDateTime));
//							dairyNote.setContent(content);
//						}else {
//							dairyNote.setStatus(DairyNote.WORK_TODO);
//						}
//						
//						dairyNote.setUserId(opUser.getId());
//						dairyNote.setTitle(operationName);
//						dairyNote.setCardId(cardId);
//						
//						if(null != actity) {
//							if(actity.equals("登记") || actity.equals("送传阅")) {
//								dairyNote.setPhase(DairyNote.PHASE_START);
//							}else if(actity.equals("归档")) {
//								dairyNote.setPhase(DairyNote.PHASE_END);
//							}else {
//								dairyNote.setPhase(DairyNote.PHASE_MID);
//							}
//						}
//						
//						int dairyRet = dairyMapper.insert(dairyNote);
//						if(dairyRet == 1) { // 新增日志成功
//							CardDairy cd = new CardDairy(oaFileInfo.getId(), dairyNote.getId());
//							cardDairyMapper.insert(cd); // 新增卡片、操作记录关联
							
//							handleDetail.setFileGuid(fileGuid);
//							handleDetail.setDairyId(dairyNote.getId());
							
//						}
//					}
				}
			}
		}
		return succ;
	}

	@Transactional
	private int saveCardTaker(Long oaFileId, Integer userId, short role) {
		return cardTakerMapper.insertByUserPhone(oaFileId, userId, role);
	}

	@Override
	@Transactional
	public int saveOrUpdateAttachInfo(Long oaFileId, List<OaFileAttachment> attachList) {
		return oaAttachMapper.insertOrUpdateAttachment(oaFileId, attachList);
	}

	@Override
	@Transactional
	public int updateDetailByOne(OAFileXmlDetail fileDt) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("y/M/d H:m:s");
		OaFileInfo updFile = new OaFileInfo();
		updFile.setFileGuid(fileDt.getGuid());
		updFile.setApproval(fileDt.getApproval());
		updFile.setCheckRead(fileDt.getCheckRead());
		String oldXianBanDate = fileDt.getOldXianBanDate();
		if(null != oldXianBanDate && !oldXianBanDate.isEmpty())
			updFile.setOldXianbanDate(sdf.parse(oldXianBanDate));
		String txtFileDate = fileDt.getTxtFileDate();
		if(null != txtFileDate && !txtFileDate.isEmpty())
			updFile.setTxtFileDate(sdf.parse(txtFileDate));
		OaFileInfoExample ofiExam = new OaFileInfoExample();
		Criteria criteria = ofiExam.createCriteria();
		criteria.andFileGuidEqualTo(fileDt.getGuid());
		return oaFileInfoMapper.updateByExampleSelective(updFile, ofiExam);
	}

	@Override
	public List<OaFileInfoDraft> getNewInsertOAFiles() {
		return oaFileDraftMapper.selectNewOaFiles();
	}

	@Override
	@Transactional
	public int saveNewCardInfo(OaFileInfoDraft oaDraft, short fileType) {
		CardInfo card = new CardInfo();
		card.setCardName(oaDraft.getTitle());
		card.setCardLevel((byte) 3);
		card.setCardType(IDicInfoConst.CARD_OA);
		card.setCardStatus((byte) 0);
		card.setCreateAt(oaDraft.getReceiveDate());
		int cardInsertRet = cardInfoMapper.insert(card);
		String fileGuid = oaDraft.getFileGuid();
		if(cardInsertRet == 1) { // 新增卡片记录成功
			OaFileInfo oafile = new OaFileInfo();
			oafile.setId(card.getId());
			oafile.setFileType(fileType);
			oafile.setTitle(oaDraft.getTitle());
			oafile.setFileGuid(fileGuid);
			oafile.setFileCode(oaDraft.getFileCode());
			oafile.setFileOrg(oaDraft.getFileOrg());
			oafile.setFileDate(oaDraft.getFileDate());
			oafile.setReceiveDate(oaDraft.getReceiveDate());
			oafile.setLastAt(oaDraft.getLastAt());
			int oaFileSaveRet = oaFileInfoMapper.insert(oafile);
			if(oaFileSaveRet != 1) {
				LOGGER.error("新增OA收文记录{}失败！", fileGuid);
				return 0;
			}
			return 1;
		}else {
			LOGGER.error("新增卡片记录{}失败！", fileGuid);
		}
		return 0;
	}

	@Override
	@Transactional
	public int updateFromDraft(String guid) {
		return oaFileInfoMapper.updateFromDraft(guid);
	}

	@Override
	@Transactional
	public int batchSaveNewCardByDraft() {
		return oaFileDraftMapper.batchInsertNewCard();
	}

	@Override
	public int batchSaveOrUpdateCardByDraft() {
		int iUpdCnt = oaFileDraftMapper.batchUpdateCard();
		int iSaveCnt = oaFileDraftMapper.batchInsertNewCard();
		return iSaveCnt + iUpdCnt;
	}

	@Override
	public OaFileInfo getInfoByGuid(String fileGuid) {
		OaFileInfo oaFile = new OaFileInfo();
		oaFile.setFileGuid(fileGuid);
		return oaFileInfoMapper.selectOne(oaFile);
	}
	
}
