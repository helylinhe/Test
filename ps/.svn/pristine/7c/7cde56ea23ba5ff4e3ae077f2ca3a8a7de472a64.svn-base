package com.linkonworks.df.busi.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.DataImportRuleDaoService;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.FlupNameDictVO;
import com.linkonworks.df.vo.ImpruleDetail;
import com.opensymphony.xwork2.ActionSupport;

public class DataImportRuleAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6193112719763015756L;
	private DataImportRuleDaoService dataImportRuleService;
	
	private Page<DataImportRule> page=new Page<DataImportRule>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private DataImportRule dataImportRule;
	private Department department;
	
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public DataImportRule getDataImportRule() {
		return dataImportRule;
	}

	public void setDataImportRule(DataImportRule dataImportRule) {
		this.dataImportRule = dataImportRule;
	}

	public Page<DataImportRule> getPage() {
		return page;
	}

	public void setPage(Page<DataImportRule> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public DataImportRuleDaoService getDataImportRuleService() {
		return dataImportRuleService;
	}

	public void setDataImportRuleService(
			DataImportRuleDaoService dataImportRuleService) {
		this.dataImportRuleService = dataImportRuleService;
	}
	
	public String loadFlupNameDict(){
		List<Dict> flupWay = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPWAY);
		List<Dict> flupCycle = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPCYCLE);
		List<Dict> flupType = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPTYPE);
		List<Dict> flupObject = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPOBJECT);
		List<Dict> flupStatus = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPSTATUS);

        //加载combobox所需要的数据(所有的科室)
	    List<Department> department = SessionData.getDepartmentCode();

		//加载datagrid数据(获取所有的随访表)
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list",  SessionData.getDepartmentCode());
		List<FlupNameDict> rows = dataImportRuleService.findAllFulpNameDicts(map);
		FlupNameDictVO flupNameDictVO =  new FlupNameDictVO();
		flupNameDictVO.setRows(rows);
		flupNameDictVO.setTotal(rows.size());
		//加载的时候获取改员工所属的部门的是有员工
		List<Employee> row = dataImportRuleService.getEmployeesByeDeptCode(SessionData.getDepartmentCode().get(0));
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("flupCycle", flupCycle);
		jsonMap.put("department", department);
		jsonMap.put("flupWay", flupWay);
		jsonMap.put("flupType", flupType);
		jsonMap.put("flupObject", flupObject);
		jsonMap.put("flupStatus", flupStatus);
		jsonMap.put("flupNameDictVO", flupNameDictVO);
		jsonMap.put("rows", rows);
		jsonMap.put("row", row);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	/**
	 * 加载科室随访的科室跟随访表
	 * @return
	 */
	public String loadComboboxCount(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",  SessionData.getDepartmentCode());
		List<FlupNameDict> rows = dataImportRuleService.findAllFulpNameDicts(map);
		FlupNameDictVO flupNameDictVO =  new FlupNameDictVO();
		flupNameDictVO.setRows(rows);
		flupNameDictVO.setTotal(rows.size());
	    List<Department> department = SessionData.getDepartmentCode();
	    Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		jsonMap.put("flupNameDictVO", flupNameDictVO);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	public String loadDG(){
		List<Department> list = new ArrayList<Department>();
		if(map.get("deptCode")!=null && !map.get("deptCode").equals("")){
			Department department = new Department();
			department.setDeptCode(map.get("deptCode"));
			list.add(department);
			page.setList(list);
		}else{
			list = SessionData.getDepartmentCode();
			page.setList(list);
		}
		
		page.setParams(map);
		List<DataImportRule> listData = dataImportRuleService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", listData);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	public String insertOrupdateDataImportRule(){
	 int rows=0;
	 Employee employee  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
	 dataImportRule.setOperateEmployeeCode(employee.getJobnum());
	 String type= ServletActionContext.getRequest().getParameter("type");
	 Map<String, Object> jsonMap = new HashMap<String, Object>();
	 String message ="";
	 if("update".equals(type)||"update"==type){
		 List<ImpruleDetail> list = new ArrayList<ImpruleDetail>();
		 rows = dataImportRuleService.update(dataImportRule);
		 String arr[] = dataImportRule.getFlupNumDate().split(",");
		 for (int i = 0; i < arr.length; i++) {
		   ImpruleDetail im = new ImpruleDetail();
		   im.setImpruleId(dataImportRule.getId());
		   im.setInpatiNumber(String.valueOf((i+1)));
		   im.setInpatiSerialNumber(arr[i]);
		   list.add(im);
		}
		 if(rows>0){
			    dataImportRuleService.deleteImpruleDetail(dataImportRule);
			    dataImportRuleService.insertImpruleDetailTow(list);
				jsonMap.put("success",true);
				message="修改规则成功！";
			}else{
				jsonMap.put("success",false);
				message = "修改失败,请仔细填写内容！";
			}
	 }else{
		 if(dataImportRule.getFlupType() =="1" ||dataImportRule.getFlupType().equals("1")){
			
				 List<DataImportRule> irow =dataImportRuleService.insertBoolean(dataImportRule);
				 if(irow.size()!=0){
					 message = "新增失败,专科只能有一条规则！";
					 jsonMap.put("message",message);
					 JsonUtil.jsonData(jsonMap);
					 return null;
				 }
			 
		 }
	 rows= dataImportRuleService.insert(dataImportRule);
	 List<ImpruleDetail> list = new ArrayList<ImpruleDetail>();
	 String arr[] = dataImportRule.getFlupNumDate().split(",");
	 for (int i = 0; i < arr.length; i++) {
	   ImpruleDetail im = new ImpruleDetail();
	   im.setInpatiNumber(String.valueOf((i+1)));
	   im.setInpatiSerialNumber(arr[i]);
	   list.add(im);
	}
		if(rows>0){
			dataImportRuleService.insertImpruleDetail(list);
			jsonMap.put("success",true);
			message="新增规则成功！";
		}else{
			jsonMap.put("success",false);
			message = "新增失败,请仔细填写内容！";
		}
	 }
	 	jsonMap.put("message",message);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	//修改规则的的方法
	public String updatedataImportRule(){
		int rows=0;
		String message ="";
		String info = ServletActionContext.getRequest().getParameter("dataImportRuleId");
		String[] dataImportRuleId = info.split(",");
		for (int i = 0; i < dataImportRuleId.length; i++) {
			dataImportRule.setId(dataImportRuleId[i]);
			rows = dataImportRuleService.updateDataImportRule(dataImportRule);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(rows>0){
			jsonMap.put("success",true);
			if("1".equals(dataImportRule.getDelState())||"1"==dataImportRule.getDelState()){
				message="删除成功！";
			}else{
				message="撤销成功！";
			}
			
		}else{
			jsonMap.put("success",false);
			if("1".equals(dataImportRule.getDelState())||"1"==dataImportRule.getDelState()){
				message="删除失败！";
			}else{
				message="撤销失败！";
			}
		}
		jsonMap.put("message", message);
		JsonUtil.jsonData(jsonMap);
		return null;		
	}
	
	public String getEmployeeByDeptCode(){
		List<Employee> rows = dataImportRuleService.getEmployeesByeDeptCode(department);
		String type = ServletActionContext.getRequest().getParameter("type");
		if(type!=null&&type!=""){
			if(type=="inEmployee"||type.equals("inEmployee")){
				Employee em = new Employee();
				em.setJobnum("住院医生");
				em.setName("住院医生");
				rows.add(0, em);
			}
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", rows);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	
	public String getDetailInfo(){
		List<ImpruleDetail> rows = dataImportRuleService.getDetailInfo(dataImportRule);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", rows);
		JsonUtil.jsonData(jsonMap);
		return null;
	}

	/******
	 * 加载诊断组
	 */
	public String loadDiagCode(){
		List<Map<String,String>> list = dataImportRuleService.loadDiagInfo(map);
		JsonUtil.jsonDataList(list);
		return null;
	}
	
}
