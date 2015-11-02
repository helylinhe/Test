package com.linkonworks.df.busi.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xml.resolver.apps.resolver;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.ReturnTaskService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SendMessageUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.FlupModule;
import com.linkonworks.df.vo.ReturnMessage;
import com.linkonworks.df.vo.ReturnTask;
import com.opensymphony.xwork2.ActionSupport;

public class ReturnTaskAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7473297273635884359L;

	private ReturnTaskService returnTaskService;
	
	private Page<ReturnTask> page=new Page<ReturnTask>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private ReturnMessage returnMessage;
	
	

	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}

	public Page<ReturnTask> getPage() {
		return page;
	}

	public void setPage(Page<ReturnTask> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public ReturnTaskService getReturnTaskService() {
		return returnTaskService;
	}

	public void setReturnTaskService(ReturnTaskService returnTaskService) {
		this.returnTaskService = returnTaskService;
	}
	public String loadCombobox(){
	    List<Department> department=SessionData.getDepartmentCode();
	    Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	public String loadDataGird(){
		page.setParams(map);
		List<ReturnTask> list = returnTaskService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	public String getMessageInfo(){
		FlupModule f = new FlupModule();
		f.setOperateEmpolyeeCode(SessionData.getEmployeeCode());
		f.setDeptCode(SessionData.getDepartmentCode());
		List<FlupModule> rows = returnTaskService.findFlupModule(f);
//		for (FlupModule flupModule : rows) {
//			System.out.println(flupModule.getInfoContent());
//		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", rows);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	public String updateMessage(){
		int row = 0;
		String arrId[] = returnMessage.getId().split(",");
		String arrPhone[] = returnMessage.getPhone().split(",");
		//String arrDept[] = returnMessage.getDeptCode().split(",");
		String arrDate[] = returnMessage.getReturnDate().split(",");
		String arrDateName[]= returnMessage.getReturnType().split(",");
		returnMessage.setStrId(arrId);
		for (int i = 0; i < arrPhone.length; i++) {
			ReturnMessage re = new ReturnMessage();
			re.setId(arrId[i]);
			re.setDeptCode(returnMessage.getDeptCode());
			re.setConfirm(returnMessage.getConfirm());
			re.setMessage(returnMessage.getMessage());
			re.setPhone(arrPhone[i]);
			re.setReturnDate(arrDate[i]);
			re.setType(returnMessage.getType());
		    row = returnTaskService.updateMessage(re);
		   // System.out.println(re.getMessage().replace("YMD", re.getReturnDate()).replace("KS", arrDateName[i]));
		    SendMessageUtil.sendMessage("院后随访系统", re.getMessage().replace("YMD", re.getReturnDate()).replace("KS", arrDateName[i]), re.getPhone());
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(row>0){
			jsonMap.put("message", "发送成功！！");
		}else{
			jsonMap.put("message", "发送失败！！");
		}
		JsonUtil.jsonData(jsonMap);	
		return null;
	}

}
