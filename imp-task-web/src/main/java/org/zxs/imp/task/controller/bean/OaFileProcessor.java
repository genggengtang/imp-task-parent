package org.zxs.imp.task.controller.bean;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.digester.Digester;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.zxs.base.model.CommonReturnBean;
import org.zxs.base.model.ErrorCodeBaseEnum;
import org.zxs.imp.task.dao.consts.ErrorCodeITEnum;
import org.zxs.imp.task.dao.model.CardAttachment;
import org.zxs.imp.task.dao.model.OaFileAttachment;
import org.zxs.imp.task.dao.model.OaFileInfo;
import org.zxs.imp.task.dao.model.OaFileInfoDraft;
import org.zxs.imp.task.dao.model.oa.OAFileHandleDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlInfo;
import org.zxs.imp.task.dao.model.oa.OAReturnFileDetailList;
import org.zxs.imp.task.dao.model.oa.OAReturnSingleList;
import org.zxs.imp.task.service.interf.ICardInfoService;
import org.zxs.imp.task.service.interf.IOaFileInfoService;
import org.zxs.imp.task.service.interf.ITaskInfoService;
import org.zxs.utils.CommonUtil;

import com.alibaba.fastjson.JSON;

/**
 * 处理OA接口
 * @author Administrator
 *
 */
@Component("oaFileProcessor")
public class OaFileProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(OaFileProcessor.class);
	private final static String OA_WSDL_PATH = "http://10.18.101.81:8060/EpointOAWebservice_JXHDJ/OAWebService.asmx?WSDL";
//	private final static String OA_WSDL_PATH = "http://202.103.199.209:8060/EpointOAWebservice_JXHDJ/OAWebService.asmx?WSDL";
	private final static String OA_KEY = "Epoint_WebSerivce_**##0601";
	private final static int PAGE_SIZE = 320;
	
	@Resource
	private ICardInfoService cardInfoService;
	
	@Resource
	private IOaFileInfoService oaInfoService;
	
	@Resource
	private ITaskInfoService taskService;
	
	/**
	 * 更新过去一天内OA收文新数据
	 */
	public void updateOaFilesByDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date nowtime = new Date();
		String nowtimeStr = sdf.format(nowtime);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,-1);
		String yesterdayStr = sdf.format(nowtime);
		persistOaFiles(yesterdayStr, nowtimeStr, PAGE_SIZE);
	}
	
	/**
	 * 更新过去1个月内OA收文新数据
	 */
	public void updateOaFilesByMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date nowtime = new Date();
		String nowtimeStr = sdf.format(nowtime);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH,-1);
		String lastMonthStr = sdf.format(nowtime);
		persistOaFiles(lastMonthStr, nowtimeStr, PAGE_SIZE);
	}
	
	/**
	 * 请求OA接口，并保存数据
	 */
	public CommonReturnBean<Integer> persistOaFiles(String startTimeStr, String endTimeStr, int pageSize) {
		int pageIdx = 1;
		int saveTotal = 0;
		try {
			do {
				LOGGER.info("开始第{}批OA收文数据更新！", pageIdx);
				OAReturnSingleList<OAFileXmlInfo> oaReturnInfo = null;
				oaReturnInfo = callOaFileList(startTimeStr, endTimeStr, pageIdx, pageSize);
				
				if(null == oaReturnInfo) {
					LOGGER.warn("OA收文列表接口返回空数据!");
					return new CommonReturnBean<>(ErrorCodeBaseEnum.RETURN_ERROR);
				}
				boolean status = oaReturnInfo.getReturnStatus();
				if(!status) {
					LOGGER.warn("请求OA收文列表接口返回失败，信息：{}", oaReturnInfo.getDescription());
					return new CommonReturnBean<>(ErrorCodeITEnum.OA_FILE_LIST_FAIL);
				}
				List<OAFileXmlInfo> oaFileXmlList = oaReturnInfo.getDataList();
				if(null == oaFileXmlList || oaFileXmlList.isEmpty())
					break;
				
				LOGGER.info("获取第{}批OA收文接口数据结束！", pageIdx);
				int batchSaveNum = oaInfoService.batchSaveOaFileInfo2Draft(oaFileXmlList);
				saveTotal += batchSaveNum;
				
				int totalCnt = oaReturnInfo.getTotalNumCount();
				if(totalCnt <= pageSize * pageIdx) {
					break;
				} 
				pageIdx++;
			} while(true);
			
			LOGGER.info("批量插入OA收文中间表数据结束，成功总数{}", saveTotal);
			
//			List<OaFileInfoDraft> oaInsertList = oaInfoService.getNewInsertOAFiles();
//			if(null != oaInsertList && !oaInsertList.isEmpty()) {
//				int insertSuccNum = 0;
//				LOGGER.info("开始新增OA收文卡片信息！");
//				for(OaFileInfoDraft oaDraft : oaInsertList) {
//					int oaSaveNewNum = oaInfoService.saveNewCardInfo(oaDraft, OaFileInfo.FILE_REVIEW);
//					if(oaSaveNewNum == 1) {
//						insertSuccNum++;
//					}
//				}
//			}
			
			List<String> fileGuidList = oaInfoService.getUpdFileIds();
			
//			int newCardNum = oaInfoService.batchSaveOrUpdateCardByDraft();
//			LOGGER.info("成功处理{}条卡片信息记录！", newCardNum);
			
			int dualOaNum = oaInfoService.saveOrUpdateFromDraft();
			LOGGER.info("成功处理{}条卡片记录！", dualOaNum);
			
			Set<String> phoneSet = new HashSet<>();
			
			if(null != fileGuidList && !fileGuidList.isEmpty()) {
				LOGGER.info("开始更新收文详情信息，数量为{}", fileGuidList.size());
				for(String fileGuid : fileGuidList) {
					LOGGER.info("开始更新文件{}的详情信息", fileGuid);
					OAReturnFileDetailList fileDetail = callOaFileDetail(fileGuid);
					
					// 更新OA收文信息表
//					OAFileXmlDetail fileDt = fileDetail.getDataBasic();
//					fileDt.setGuid(fileGuid);
//					int detailRet = oaInfoService.updateDetailByOne(fileDt);
					
					OaFileInfo oaFileInfo = oaInfoService.getInfoByGuid(fileGuid);
					
					if(null != oaFileInfo) {
						Long oaFileId = oaFileInfo.getId();
						// 更新操作表
						List<OAFileHandleDetail> handleList = fileDetail.getHandleList();
						int handleRet = oaInfoService.saveOrUpdateHandleInfo(oaFileId, handleList, phoneSet);
						
						// 更新附件表
						List<OaFileAttachment> attachList = fileDetail.getAttachList();
						if(null != attachList && !attachList.isEmpty()) {
							int attachRet = oaInfoService.saveOrUpdateAttachInfo(oaFileId, attachList);
							LOGGER.info("文件{}详情信息更新结束！", oaFileId);
						}
					}
					
				}
			}
			
//			int oaFileUpdRet = oaInfoService.updateFromDraft(null);
//			LOGGER.info("成功更新{}条OA收文信息！", oaFileUpdRet);
			
			if(!phoneSet.isEmpty()) {
				LOGGER.info("找不到用户的手机号：{}", JSON.toJSONString(phoneSet));
			}
			
			CommonReturnBean<Integer> ret = new CommonReturnBean<>(ErrorCodeBaseEnum.SUCC);
			ret.setData(fileGuidList.size());
			return ret;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new CommonReturnBean<>(ErrorCodeBaseEnum.RETURN_ERROR);
		} finally {
			oaInfoService.clearDraft();
		}
	}

	/**
	 * 分页查询OA收文列表接口
	 * @param idx
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private OAReturnSingleList<OAFileXmlInfo> callOaFileList(String startTime, String endTime, int idx, int pageSize) throws Exception {
		DynamicClientFactory clientFactory = DynamicClientFactory.newInstance();  
        Client client = clientFactory.createClient(OA_WSDL_PATH);
        startTime = startTime == null ? "" : startTime;
        endTime = endTime == null ? "" : endTime;
        String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
							"<paras>" + 
							"<Time>" + startTime + "</Time>" +
							"<LastTime>" + endTime + "</LastTime>" +
							"<CurrentPageIndex>" + idx + "</CurrentPageIndex>" + 
							"<PageSize>" + pageSize + "</PageSize>" + 
							"<KeyWord></KeyWord>" +
							"</paras>";
		
		Object[] result = client.invoke("Handle_GetShouWen_LiuZhuan", OA_KEY, xmlInput);
		String basePath = "EpointDataBody/DATA";
		String returnPath = basePath + "/ReturnInfo";
		String userPath = basePath + "/UserArea";
		
		Digester digester = new Digester();
		digester.setValidating(false);  
		
		digester.addObjectCreate(basePath, OAReturnSingleList.class);
		digester.addBeanPropertySetter(returnPath + "/Status", "returnStatus");
		digester.addBeanPropertySetter(returnPath + "/Description", "description");
        digester.addBeanPropertySetter(userPath + "/PageInfo/TotalNumCount", "totalNumCount"); 
        // 指明匹配模式和要创建的类   
        digester.addObjectCreate(userPath + "/HandleList/Handle", OAFileXmlInfo.class);  
        // 设置对象属性,与xml文件对应,不设置则是默认  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtTitle", "txtTitle");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/isTodo", "fileType");
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtLaiWenHao", "txtLaiWenHao");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtLaiWenDept", "txtLaiWenDept");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtFileDate", "txtFileDate");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtShouWenDate", "txtShouWenDate");
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/handelDateTimeMax", "lastAt");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/ProcessVersionInstanceGuid", "processVersionInstanceGuid");
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/xianbanDate", "xianbanDate");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/OldXianBanDate", "oldXianbanDate");
        // 当移动到下一个标签中时的动作  
        digester.addSetNext(userPath + "/HandleList/Handle", "addData");
        
        return (OAReturnSingleList<OAFileXmlInfo>) digester.parse(new ByteArrayInputStream(result[0].toString().getBytes("gbk")));
	}
	
	/**
	 * 分页查询OA收文列表接口
	 * @param idx
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private OAReturnFileDetailList callOaFileDetail(String guid) throws Exception {
		DynamicClientFactory clientFactory = DynamicClientFactory.newInstance();  
        Client client = clientFactory.createClient(OA_WSDL_PATH);
		String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
							"<paras>" + 
							"<ProcessVersionInstanceGuid>" + guid + "</ProcessVersionInstanceGuid>" + 
							"</paras>";
		
		Object[] result = client.invoke("Handle_GetShouWengDetail", OA_KEY, xmlInput);
		String basePath = "EpointDataBody/DATA";
		String returnPath = basePath + "/ReturnInfo";
		String userPath = returnPath + "/UserArea";
		
		Digester digester = new Digester();
		digester.setValidating(false);  
		
		digester.addObjectCreate(basePath, OAReturnFileDetailList.class);
		digester.addBeanPropertySetter(returnPath + "/Status", "returnStatus");
		digester.addBeanPropertySetter(returnPath + "/Description", "description");
        
//        digester.addObjectCreate(userPath + "/Worklowinfo/ShouWengInfo", OAFileXmlDetail.class);
//        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/Approval", "approval");  
//        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/CheckRead", "checkRead");  
//        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/txtFileDate", "txtFileDate");  
//        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/OldXianBanDate", "oldXianBanDate");
//        
//        digester.addSetNext(userPath + "/Worklowinfo/ShouWengInfo", "setDataBasic");
        
        // 指明匹配模式和要创建的类   
        digester.addObjectCreate(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo", OAFileHandleDetail.class);  
        // 设置对象属性,与xml文件对应,不设置则是默认  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/WorkItemGuid", "handleGuid");
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/ActivityName", "activity");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/TransactorMobile", "submitUserPhone");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/ReceiveDateTime", "receiveDateTime");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/HandleUserMobile", "operateUserPhone");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/OperationName", "operationName");
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/HandleDateTime", "handleDateTime");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/Opinion", "opinion");
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/HandleUserName", "operateUserName");
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo/TransactorName", "submitUserName");
        
        // 当移动到下一个标签中时的动作  
        digester.addSetNext(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo", "addHandleDetail");
        
        // 指明匹配模式和要创建的类   
        digester.addObjectCreate(userPath + "/Worklowinfo/MaterialList/MaterialInfo", OaFileAttachment.class);  
//        digester.addObjectCreate(userPath + "/Worklowinfo/MaterialList/MaterialInfo", CardAttachment.class);  
        // 设置对象属性,与xml文件对应,不设置则是默认  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/MaterialInstanceGuid", "oaGuid");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/MaterialInstanceName", "name");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/MaterialType", "type");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/DownLoadUrl", "url");  
        // 当移动到下一个标签中时的动作  
        digester.addSetNext(userPath + "/Worklowinfo/MaterialList/MaterialInfo", "addAttachDetail");
        
        OAReturnFileDetailList retList = (OAReturnFileDetailList) digester.parse(new ByteArrayInputStream(result[0].toString().getBytes("gbk")));
        return retList;
	}
}
