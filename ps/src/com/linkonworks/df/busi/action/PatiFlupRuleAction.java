package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.FlupTaskService;
import com.linkonworks.df.busi.service.PatiFlupRuleService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupTask;
import com.linkonworks.df.vo.PatiFlupRule;
import com.opensymphony.xwork2.ActionSupport;

public class PatiFlupRuleAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private PatiFlupRuleService patiFlupRuleService; 
	private FlupTaskService flupTaskService; 
	private Page<PatiFlupRule> page=new Page<PatiFlupRule>();
	private Map<String,String> map=new HashMap<String,String>();
	private FlupTask flupTask;
	
	public FlupTask getFlupTask() {
		return flupTask;
	}

	public void setFlupTask(FlupTask flupTask) {
		this.flupTask = flupTask;
	}
	
	public String pageList(){
		page.setParams(map);
		List<PatiFlupRule> list=patiFlupRuleService.findPageList(page);
		Map hashmap=new HashMap();
		hashmap.put("rows",list);
		hashmap.put("totalRecord", page.getTotalRecord());
		hashmap.put("totalPage", page.getTotalPage());
		hashmap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(hashmap);
		return null;
	}
	
	public String patiFlupRuleInfo(){
		PatiFlupRule p=patiFlupRuleService.flupRuleInfo(map);
		JSON json=JSONArray.fromObject(p);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String udpateFlupTask(){
		 int rows=0;
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 String message ="";
			 rows = flupTaskService.updateProperty(flupTask);
			 Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
			 flupTask.setEmployeeCode(e.getJobnum());
			 flupTaskService.updatePatiFlup(flupTask);
			 if(rows>0){
				jsonMap.put("success",true);
				message="修改病例信息成功！";
				}else{
				jsonMap.put("success",false);
				message="修改病例信息失败！";
				}
		 	jsonMap.put("message",message);
			JsonUtil.jsonData(jsonMap);	
			return null;
	}

	public PatiFlupRuleService getPatiFlupRuleService() {
		return patiFlupRuleService;
	}

	public void setPatiFlupRuleService(PatiFlupRuleService patiFlupRuleService) {
		this.patiFlupRuleService = patiFlupRuleService;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public FlupTaskService getFlupTaskService() {
		return flupTaskService;
	}

	public void setFlupTaskService(FlupTaskService flupTaskService) {
		this.flupTaskService = flupTaskService;
	}

	
	
	
}
