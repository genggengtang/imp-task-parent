package org.zxs.imp.task.util;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.zxs.imp.task.dao.model.OaFileAttachment;
import org.zxs.imp.task.dao.model.oa.OAFileHandleDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlDetail;
import org.zxs.imp.task.dao.model.oa.OAFileXmlInfo;
import org.zxs.imp.task.dao.model.oa.OAReturnBase;
import org.zxs.imp.task.dao.model.oa.OAReturnFileDetailList;
import org.zxs.imp.task.dao.model.oa.OAReturnSingleList;

import com.alibaba.fastjson.JSON;


public class OAWebServiceTest {

	@Test
	public void testOAInterface() throws Exception {
		DynamicClientFactory clientFactory = DynamicClientFactory.newInstance();  
        Client client = clientFactory.createClient("http://10.18.101.81:8060/EpointOAWebservice_JXHDJ/OAWebService.asmx?WSDL");
//		Client client = clientFactory.createClient("http://202.103.199.209:8060/EpointOAWebservice_JXHDJ/OAWebService.asmx?WSDL");

//                String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
//	        					"<paras>" + 
//	        					"<Time>2014-02-01 00:00:00</Time>" +
//	        					"<LastTime>2015-01-01 00:00:00</LastTime>" +
//	        					"<KeyWord></KeyWord>" +
//				        		"<CurrentPageIndex>10</CurrentPageIndex>" + 
//				        		"<PageSize>250</PageSize>" + 
//				        		"</paras>";
        
        String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
				"<paras>" + 
				"<Time>2018-01-08 00:00:00</Time>" +
				"<LastTime>2018-01-09 00:00:00</LastTime>" +
				"<KeyWord></KeyWord>" +
        		"<CurrentPageIndex>1</CurrentPageIndex>" + 
        		"<PageSize>300</PageSize>" + 
        		"</paras>";
                
        Object[] result = client.invoke("Handle_GetShouWen_LiuZhuan", "Epoint_WebSerivce_**##0601", xmlInput);  
//        Object[] result = client.invoke("Handle_XingChengAnPai", "Epoint_WebSerivce_**##0601", xmlInput);  
        System.out.println(result[0]);
        
//		for(int i=1;i<100;i++) {
//			String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
//					"<paras>" + 
//					"<Time></Time>" +
//					"<CurrentPageIndex>" + i + "</CurrentPageIndex>" + 
//					"<PageSize>" + 320 + "</PageSize>" + 
//					"<KeyWord></KeyWord>" +
//					"</paras>";
//	        
//	        Object[] result = client.invoke("Handle_GetShouWen_LiuZhuan", "Epoint_WebSerivce_**##0601", xmlInput);  
//	        System.out.println(result[0]); 
//		}
        
	}
	
	@Test
	public void testOAFileDetailInterface() throws Exception {
		DynamicClientFactory clientFactory = DynamicClientFactory.newInstance();  
        Client client = clientFactory.createClient("http://10.18.101.81:8060/EpointOAWebservice_JXHDJ/OAWebService.asmx?WSDL");
        /*String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
        					"<paras>" + 
        					"<KeyWord></KeyWord>" + 
			        		"<CurrentPageIndex>1</CurrentPageIndex>" + 
			        		"<PageSize>10</PageSize>" + 
			        		"</paras>";
        
        Object[] result = client.invoke("Handle_GetShouWen_LiuZhuan", "Epoint_WebSerivce_**##0601", xmlInput); */ 
        String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
						"<paras>" + 
						"<ProcessVersionInstanceGuid>0e0b4195-859d-4c71-afdd-6b4de5964428</ProcessVersionInstanceGuid>" +
		        		"</paras>";

        Object[] result = client.invoke("Handle_GetShouWengDetail", "Epoint_WebSerivce_**##0601", xmlInput); 
        
        System.out.println(result[0]); 
        
        String basePath = "EpointDataBody/DATA";
		String returnPath = basePath + "/ReturnInfo";
		String userPath = returnPath + "/UserArea";
		
		Digester digester = new Digester();
		digester.setValidating(false);  
		
		digester.addObjectCreate(basePath, OAReturnFileDetailList.class);
		digester.addBeanPropertySetter(returnPath + "/Status", "returnStatus");
		digester.addBeanPropertySetter(returnPath + "/Description", "description");
        
        digester.addObjectCreate(userPath + "/Worklowinfo/ShouWengInfo", OAFileXmlDetail.class);
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/Approval", "approval");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/CheckRead", "checkRead");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/txtFileDate", "txtFileDate");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/ShouWengInfo/OldXianBanDate", "oldXianBanDate");
        
        digester.addSetNext(userPath + "/Worklowinfo/ShouWengInfo", "setDataBasic");
        
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
        
        // 当移动到下一个标签中时的动作  
        digester.addSetNext(userPath + "/Worklowinfo/FlowInfoLst/FlowInfo", "addHandleDetail");
        
        // 指明匹配模式和要创建的类   
        digester.addObjectCreate(userPath + "/Worklowinfo/MaterialList/MaterialInfo", OaFileAttachment.class);  
        // 设置对象属性,与xml文件对应,不设置则是默认  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/MaterialInstanceGuid", "oaGuid");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/MaterialInstanceName", "name");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/MaterialType", "type");  
        digester.addBeanPropertySetter(userPath + "/Worklowinfo/MaterialList/MaterialInfo/DownLoadUrl", "url");  
        // 当移动到下一个标签中时的动作  
        digester.addSetNext(userPath + "/Worklowinfo/MaterialList/MaterialInfo", "addAttachDetail");
        
        OAReturnFileDetailList list = (OAReturnFileDetailList) digester.parse(new ByteArrayInputStream(result[0].toString().getBytes("gbk")));
        System.out.println(JSON.toJSONString(list));
        
        assertNotNull(list.getDataBasic());
	}
	
	@Test
	public void testParseXml() throws Exception {
		DynamicClientFactory clientFactory = DynamicClientFactory.newInstance();  
        Client client = clientFactory.createClient("http://10.18.101.81:8060/EpointOAWebservice_JXHDJ/OAWebService.asmx?WSDL");
		String xmlInput = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
							"<paras>" + 
							"<Time>2018-08-01 10:00:00</Time>" +
							"<KeyWord></KeyWord>" + 
							"<CurrentPageIndex>1</CurrentPageIndex>" + 
							"<PageSize>30</PageSize>" + 
							"</paras>";

		Object[] result = client.invoke("Handle_GetShouWen_LiuZhuan", "Epoint_WebSerivce_**##0601", xmlInput);
		System.out.println(result[0]); 
        
		String basePath = "EpointDataBody/DATA";
		String returnPath = basePath + "/ReturnInfo";
		String userPath = basePath + "/UserArea";
		Digester digester = new Digester();
		digester.setValidating(false);  
		
		digester.addObjectCreate(basePath, OAReturnSingleList.class);
		digester.addBeanPropertySetter(returnPath + "/Status", "returnStatus");
		digester.addBeanPropertySetter(returnPath + "/Description", "description");
        digester.addBeanPropertySetter(userPath +"/PageInfo/TotalNumCount", "totalNumCount"); 
        
        // 指明匹配模式和要创建的类   
        digester.addObjectCreate(userPath + "/HandleList/Handle", OAFileXmlInfo.class);  
        // 设置对象属性,与xml文件对应,不设置则是默认  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtTitle", "txtTitle");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtLaiWenHao", "txtLaiWenHao");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtLaiWenDept", "txtLaiWenDept");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtFileDate", "txtFileDate");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/txtShouWenDate", "txtShouWenDate");  
        digester.addBeanPropertySetter(userPath + "/HandleList/Handle/ProcessVersionInstanceGuid", "processVersionInstanceGuid");
        // 当移动到下一个标签中时的动作  
        digester.addSetNext(userPath + "/HandleList/Handle", "addData");  
        
        InputStream ist = new ByteArrayInputStream(result[0].toString().getBytes("gb2312"));
        
        OAReturnSingleList list = (OAReturnSingleList) digester.parse(ist); 
        System.out.println(JSON.toJSONString(list));
        
	}

}
