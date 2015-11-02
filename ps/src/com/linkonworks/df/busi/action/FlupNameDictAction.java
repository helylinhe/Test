package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.DataImportRuleDaoService;
import com.linkonworks.df.busi.service.FlupNameDictService;
import com.linkonworks.df.busi.service.UserService;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FlupNameDictAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlupNameDictService flupNameDictService;	
	private Page<FlupNameDict> page=new Page<FlupNameDict>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private DataImportRuleDaoService dataImportRuleService;
	private Employee employee=new Employee();
	
	
	
	/**
	 * 修改状态
	 * @return
	 */
	public String updateState(){
		FlupNameDict f = new FlupNameDict();
		f.setUseState(map.get("useState"));
		f.setFlupNameId(map.get("flupNameId"));
		try {
			int result = flupNameDictService.updateState(f);
			if(result==1)
				ServletActionContext.getResponse().getWriter().print("修改成功");
			else
				ServletActionContext.getResponse().getWriter().print("修改失败");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 随访表维护查询
	 */
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Department> list = new ArrayList<Department>();
		if(map.get("deptCode")!=null && !map.get("deptCode").equals("")){
			Department department = new Department();
			department.setDeptCode(map.get("deptCode"));
			list.add(department);
			page.setList(list);
		}else{
			list = SessionData.getDepartmentCode();
		}
		page.setList(list);
		page.setParams(map);
		Map<String,Object> userMap=new HashMap<String,Object>();
		userMap.put("rows",flupNameDictService.getFlupNameDict(page));
		userMap.put("totalRecord",page.getTotalRecord());
		userMap.put("totalPage", page.getTotalPage());
		userMap.put("pageNo", page.getPageNo());
		JSON json=JSONArray.fromObject(userMap);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加随访记录
	 * @return
	 */
	public String addFlupNameDict(){
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		 Employee employee = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
		try {
			 FlupNameDict flupNameDict = new FlupNameDict();
			 flupNameDict.setFlupName(request.getParameter("flupName"));
			 flupNameDict.setFlupType(request.getParameter("flupType"));
			 flupNameDict.setDiagName(request.getParameter("diagName"));
			 flupNameDict.setDiagCode(request.getParameter("diagCode"));
			 flupNameDict.setDeptCode(request.getParameter("deptCode"));
			 flupNameDict.setEmployeeCode(SessionData.getEmployeeCode());
			 int result = flupNameDictService.savaFlupNameDict(flupNameDict);
			 if(result == 1)
				 response.getWriter().print("success"); 
			 else
				 response.getWriter().print("faild");
			 
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print("error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * 修改随访记录
	 */
	public String updateFlupNameDict(){
		 HttpServletResponse response = ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		try {
			 FlupNameDict flupNameDict = new FlupNameDict();
			 flupNameDict.setDeptCode(request.getParameter("deptCode"));
			 flupNameDict.setDiagCode(request.getParameter("diagCode"));
			 flupNameDict.setFlupName(request.getParameter("flupName")); 
			 flupNameDict.setFlupType(request.getParameter("flupType"));
			 flupNameDict.setDiagName(request.getParameter("diagName"));
			 flupNameDict.setEmployeeCode(SessionData.getEmployeeCode());
			 flupNameDict.setFlupNameId(request.getParameter("uflupNameId"));
			 int result = flupNameDictService.updateFlupNameDict(flupNameDict);
			 if(result == 1)
				 response.getWriter().print("success"); 
			 else
				 response.getWriter().print("faild");
			 
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().print("error");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
		
	}
	
	
	/**
	 * 加载combobox数据
	 */
	public String loadCombobox(){
		List<Department> department = SessionData.getDepartmentCode();
		List<Dict> flupType = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPTYPE);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		jsonMap.put("wdepartment", department);
		jsonMap.put("udepartment", department);
		jsonMap.put("flupType", flupType);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	
	/***
	 * 异步加载随访表名
	 * @return
	 */
	public String flupNamDict(){
		List<FlupNameDict> list=flupNameDictService.findList(map);
		Map map=new HashMap();
		map.put("rows",list);
		JsonUtil.jsonData(map);
		return null;
	}
	
	
	public Page<FlupNameDict> getPage() {
		return page;
	}
	public void setPage(Page<FlupNameDict> page) {
		this.page = page;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public void setFlupNameDictService(FlupNameDictService flupNameDictService) {
		this.flupNameDictService = flupNameDictService;
	}

	public void setDataImportRuleService(
			DataImportRuleDaoService dataImportRuleService) {
		this.dataImportRuleService = dataImportRuleService;
	}

	

	
	
	

}
