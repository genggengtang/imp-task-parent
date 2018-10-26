package org.zxs.imp.task.service.interf;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.zxs.imp.task.dao.model.OaFileAttachment;
import org.zxs.imp.task.dao.model.OaFileInfo;
import org.zxs.imp.task.dao.model.OaFileInfoDraft;
import org.zxs.imp.task.dao.model.oa.OAFileHandleDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlInfo;

public interface IOaFileInfoService {

	/**
	 * 批量保存OA数据到中间表
	 * @param oaFileXmlList
	 * @return
	 */
	int batchSaveOaFileInfo2Draft(List<OAFileXmlInfo> oaFileXmlList);

	/**
	 * 将收文数据从中间表更新到主表
	 * @return
	 */
	int saveOrUpdateFromDraft();
	
	/**
	 * 清空中间表记录
	 * @return
	 */
	int clearDraft();

	/**
	 * 获取需要更新的文件GUID
	 * @return
	 */
	List<String> getUpdFileIds();

	/**
	 * 增量更新处理信息表
	 * @param oaFileId
	 * @param handleList
	 * @param phoneSet 
	 * @return
	 * @throws ParseException 
	 */
	int saveOrUpdateHandleInfo(Long oaFileId, List<OAFileHandleDetail> handleList, Set<String> phoneSet) throws ParseException;

	/**
	 * 增量更新附件表
	 * @param oaFileId
	 * @param attachList
	 * @return
	 */
	int saveOrUpdateAttachInfo(Long oaFileId, List<OaFileAttachment> attachList);

	/**
	 * 更新收文信息
	 * @param fileDt
	 * @return
	 */
	int updateDetailByOne(OAFileXmlDetail fileDt) throws ParseException;

	/**
	 * 获取新的OA收文记录
	 * @return
	 */
	List<OaFileInfoDraft> getNewInsertOAFiles();

	/**
	 * 根据中间表新增卡片记录
	 * @param oaDraft
	 * @param fileType 文件类型
	 * @return
	 */
	int saveNewCardInfo(OaFileInfoDraft oaDraft, short fileType);
	
	/**
	 * 将收文数据从中间表更新到主表
	 * @return
	 */
	int updateFromDraft(String guid);

	/**
	 * 根据中间表新增卡片信息
	 * @param fileType 文件类型
	 * @return
	 */
	int batchSaveNewCardByDraft();
	
	/**
	 * 根据中间表增量更新卡片信息
	 * @param fileType 文件类型
	 * @return
	 */
	int batchSaveOrUpdateCardByDraft();

	/**
	 * 根据OA收文编号获取收文信息
	 * @param fileGuid
	 * @return
	 */
	OaFileInfo getInfoByGuid(String fileGuid);
}
