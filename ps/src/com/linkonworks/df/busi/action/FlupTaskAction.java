package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSON;
import net.sf.json.JSONArray;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.tempuri.HospitalSMS;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.BlackListService;
import com.linkonworks.df.busi.service.DataImportRuleDaoService;
import com.linkonworks.df.busi.service.DepartmentService;
import com.linkonworks.df.busi.service.FlupTaskService;
import com.linkonworks.df.busi.utils.CollectionUtil;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SendMessageUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.BlackList;
import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupDetail;
import com.linkonworks.df.vo.FlupModule;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.FlupNameDictVO;
import com.linkonworks.df.vo.FlupTask;
import com.linkonworks.df.vo.TeletePhone;
import com.opensymphony.xwork2.ActionSupport;

public class FlupTaskAction extends ActionSupport {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8513488319976372312L;
	
	private FlupTaskService flupTaskService;
	private BlackListService blackListService;	

	

	public BlackListService getBlackListService() {
		return blackListService;
	}

	public void setBlackListService(BlackListService blackListService) {
		this.blackListService = blackListService;
	}



	private Page<DataImportRule> page=new Page<DataImportRule>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private DataImportRuleDaoService dataImportRuleService;
	private FlupTask flupTask;
	private TeletePhone phone;
	
	public TeletePhone getPhone() {
		return phone;
	}

	public void setPhone(TeletePhone phone) {
		this.phone = phone;
	}

	public FlupTask getFlupTask() {
		return flupTask;
	}

	public void setFlupTask(FlupTask flupTask) {
		this.flupTask = flupTask;
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

	public FlupTaskService getFlupTaskService() {
		return flupTaskService;
	}

	public void setFlupTaskService(FlupTaskService flupTaskService) {
		this.flupTaskService = flupTaskService;
	}
	


	public String loadDoctorCombobox(){
		//加载combobox所需要的数据(随访方式)
		List<Dict> flupWay = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPWAY);
		List<Dict> flupStatus = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPSTATUS);
		List<Dict> flupWaysDocutor=new ArrayList<Dict>();
		for(int i=0;i<flupWay.size();i++){
			if(flupWay.get(i).getName()!=null && (flupWay.get(i).getName().equals("电话") || flupWay.get(i).getName().equals("上门") || flupWay.get(i).getName().equals("门诊") || flupWay.get(i).getName().equals("不限") )){
				flupWaysDocutor.add(flupWay.get(i));
			}
		}
		//加载combobox所需要的数据(所有的科室)
		List<Department> department = SessionData.getDepartmentCode();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list",  SessionData.getDepartmentCode());
	    //加载datagrid数据(获取所有的随访表)
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		jsonMap.put("flupWay", flupWaysDocutor);
		jsonMap.put("flupStatus", flupStatus);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	/*******
	 * 获取随访方式（服务中心随访工作台）
	 * @return
	 */
	public String loadServiceCombobox(){
		List<Dict> flupWay = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPWAY);
		List<Dict> flupStatus = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPSTATUS);
		//加载combobox所需要的数据(所有的科室)
		List<Department> department = SessionData.getDepartmentCode();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list",  SessionData.getDepartmentCode());
	    //加载datagrid数据(获取所有的随访表)
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		jsonMap.put("flupWay", flupWay);
		jsonMap.put("flupStatus", flupStatus);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	public String loadInfoCombobox(){
		//加载combobox所需要的数据(随访方式)
		List<Dict> flupWay = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPWAY);
		List<Dict> flupStatus = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPSTATUS);
		List<Dict> flupWays=new ArrayList<Dict>();
		for(int i=0;i<flupWay.size();i++){
			if(flupWay.get(i).getName()!=null && (flupWay.get(i).getName().equals("短信") || flupWay.get(i).getName().equals("微信") || flupWay.get(i).getName().equals("不限") )){
				flupWays.add(flupWay.get(i));
			}
		}
		//加载combobox所需要的数据(所有的科室)
		List<Department> department = SessionData.getDepartmentCode();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list",  SessionData.getDepartmentCode());
	    
	    //加载datagrid数据(获取所有的随访表)
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		jsonMap.put("flupWay", flupWays);
		jsonMap.put("flupStatus", flupStatus);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	
	//suifang.jsp加载combobox的数据
	public String loadCombobox(){
		//加载combobox所需要的数据(随访方式)
		List<Dict> flupWay = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPWAY);
		//加载combobox所需要的数据(所有的科室)
		List<Department> department = SessionData.getDepartmentCode();
//		department.add(0, d);
		//加载combobox所需要的数据(随访类别)
		List<Dict> flupType = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPTYPE);
	    //加载combobox所需要的数据(随访状态)
	    List<Dict> flupStatus = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPSTATUS);
	    //加载combobox所需要都数据(付款方式)
	    //加载combobox所需要都数据(随访周期)
	    List<Dict> flupPeriod = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPPERIOD);
	    //加载combobox所需要数据(随访对象)
	    List<Dict> flupObject = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPOBJECT);
	    //加载所有都员工
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list",  SessionData.getDepartmentCode());
	    List<Employee> flupDoctorCode =flupTaskService.findALlEmployees(map);
	    //加载datagrid数据(获取所有的随访表)
	  	List<FlupNameDict> rows = dataImportRuleService.findAllFulpNameDicts(map);
	  	FlupNameDictVO flupNameDictVO =  new FlupNameDictVO();
		flupNameDictVO.setRows(rows);
		flupNameDictVO.setTotal(rows.size());
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		jsonMap.put("flupWay", flupWay);
		jsonMap.put("wflupWay", flupWay);
		jsonMap.put("flupStatus", flupStatus);
		jsonMap.put("wflupStatus", flupStatus);
//	    jsonMap.put("billingCode", billingCode);
		jsonMap.put("flupPeriod", flupPeriod);
		//去掉随访对象的
		jsonMap.put("flupObject", flupObject);
		jsonMap.put("flupType", flupType);
		jsonMap.put("flupDoctorCode", flupDoctorCode);
		jsonMap.put("rows", rows);
		jsonMap.put("flupNameDictVO", flupNameDictVO);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	
	public String loadDG(){
		List<Department> listDeparts = new ArrayList<Department>();
		if(map.get("inDept")!=null && !map.get("inDept").equals("")){
			Department d = new Department();
			d.setDeptCode(map.get("inDept"));
			listDeparts.add(d);
		}else{
			listDeparts = SessionData.getDepartmentCode();
		}
		page.setParams(map);
		page.setList(listDeparts);
		List<FlupTask> list = flupTaskService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	
	
	
	public String updatePlanRuleTask(){
		 TeletePhone tp = new TeletePhone();
		 tp.setPatiSerial(flupTask.getPatiSerial());
		  tp.setInpatiNumber(flupTask.getInpatiNumber());
		 if(flupTask.getFlupObject().equals("1")){
			  if(flupTask.getFlupMobile().length()==11){
				  tp.setMobileNumber(flupTask.getFlupMobile());
			  }else{
				  tp.setFamilyNumber(flupTask.getFlupMobile());
			  }
		 }else{
			     tp.setRelationMobileNumber(flupTask.getFlupMobile());
		 }
			 flupTaskService.updateFTask(flupTask);
			 flupTaskService.updatePFTask(flupTask);
			 flupTaskService.updatePati(tp);
		     flupTaskService.updateRuleGz(flupTask);
		     //flupTaskService.updateTaskRw(flupTask);
		     
		     Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("message", "修改任务成功!");
			JsonUtil.jsonData(jsonMap);	
		     
		
		return null;
	}
	
	//suifang.jsp修改功能
	public String updateFlupTask(){
		 int rows=0;
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 String message ="";
			 rows = flupTaskService.update(flupTask);
			 TeletePhone tp = new TeletePhone();
			 tp.setPatiSerial(flupTask.getPatiSerial());
			  tp.setInpatiNumber(flupTask.getInpatiNumber());
			 if(flupTask.getFlupObject().equals("1")){
				  if(flupTask.getFlupMobile().length()==11){
					  tp.setMobileNumber(flupTask.getFlupMobile());
				  }else{
					  tp.setFamilyNumber(flupTask.getFlupMobile());
				  }
			 }else{
				     tp.setRelationMobileNumber(flupTask.getFlupMobile());
			 }
				 flupTaskService.updateFTask(flupTask);
				 flupTaskService.updatePFTask(flupTask);
				 flupTaskService.updatePati(tp);
			 Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
			 flupTask.setEmployeeCode(e.getJobnum());
			 flupTaskService.updatePatiFlup(flupTask);
			 if(flupTask.getFlupStatus()==5||flupTask.getFlupStatus().equals("5")){
				 flupTaskService.updateflupPlan(flupTask);
			 }
			 else if(flupTask.getFlupStatus()==4||flupTask.getFlupStatus().equals("4")){
				 	BlackList  b = new BlackList();
					b.setAddReasons(flupTask.getAddReasons());
					b.setInpatiNumber(flupTask.getInpatiNumber());
					b.setPatiSerial(flupTask.getPatiSerial());
					List<BlackList> list =blackListService.selectBlack(b);
					BlackList  b1 =null;
					for (BlackList blackList : list) {
						if(blackList.getState()=="1"||blackList.getState().equals("1")){
							b1 = blackList;
							b1.setAddReasons(flupTask.getAddReasons());
						}
					}
					if(list.size()==0){
						blackListService.updatePati(b);
						blackListService.addBlack(b);	
					}else  if(b1!=null){
						blackListService.updataBlackTwo(b1);
						blackListService.updatePati(b1);
					}else {
						blackListService.updatePati(b);
						blackListService.addBlack(b);
					}
			 }else{
				 BlackList  b = new BlackList();
				 b = new BlackList();
				 b.setInpatiNumber(flupTask.getInpatiNumber());
				 b.setPatiSerial(flupTask.getPatiSerial());
				 blackListService.updataBlack(b);
				 blackListService.updatePatiTwo(b);
			 }
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
	
	//suifang.jsp修改功能
	public String updateFlupTask2(){
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 String message ="";
		 //修改电话
		 TeletePhone tp = new TeletePhone();
		 tp.setPatiSerial(flupTask.getPatiSerial());
		  tp.setInpatiNumber(flupTask.getInpatiNumber());
		 if(flupTask.getFlupObject().equals("1")){
			  if(flupTask.getFlupMobile().length()==11){
				  tp.setMobileNumber(flupTask.getFlupMobile());
			  }else{
				  tp.setFamilyNumber(flupTask.getFlupMobile());
			  }
		 }else{
			     tp.setRelationMobileNumber(flupTask.getFlupMobile());
		 }
			 flupTaskService.updateFTask(flupTask);
			 flupTaskService.updatePFTask(flupTask);
			 flupTaskService.updatePati(tp);
		     flupTaskService.updateRuleGz(flupTask);
		     flupTaskService.updateTaskRw(flupTask);
			 Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
			 flupTask.setEmployeeCode(e.getJobnum());
		//	 flupTaskService.updatePatiFlup(flupTask);
			 if(flupTask.getFlupStatus()==5||flupTask.getFlupStatus().equals("5")){
				 flupTaskService.updateflupPlan(flupTask);
			 }
			 else if(flupTask.getFlupStatus()==4||flupTask.getFlupStatus().equals("4")){
				 	BlackList  b = new BlackList();
					b.setAddReasons(flupTask.getAddReasons());
					b.setInpatiNumber(flupTask.getInpatiNumber());
					b.setPatiSerial(flupTask.getPatiSerial());
					List<BlackList> list =blackListService.selectBlack(b);
					BlackList  b1 =null;
					for (BlackList blackList : list) {
						if(blackList.getState()=="1"||blackList.getState().equals("1")){
							b1 = blackList;
							b1.setAddReasons(flupTask.getAddReasons());
						}
					}
					if(list.size()==0){
						blackListService.updatePati(b);
						blackListService.addBlack(b);	
					}else  if(b1!=null){
						blackListService.updataBlackTwo(b1);
						blackListService.updatePati(b1);
					}else {
						blackListService.updatePati(b);
						blackListService.addBlack(b);
					}
			 }else{
				 BlackList  b = new BlackList();
				 b = new BlackList();
				 b.setInpatiNumber(flupTask.getInpatiNumber());
				 b.setPatiSerial(flupTask.getPatiSerial());
				 blackListService.updataBlack(b);
				 blackListService.updatePatiTwo(b);
			 }
			jsonMap.put("success",true);
			message="修改信息成功！";
		 	jsonMap.put("message",message);
			JsonUtil.jsonData(jsonMap);	
			return null;	
	}
	
	//suifangList.jsp加载datagrid
	public String loadDGList(){
		page.setParams(map);
		List<FlupTask> list = flupTaskService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	//suifangList.jsp加载combobox数据
	public String loadComboboxList(){
		Department d= new Department();
		d.setDeptCode("");
		d.setDeptName("不限");
		List<Department> department = dataImportRuleService.findAllDepartments();
		department.add(0, d);
		List<Dict> flupWay = SessionData.getSessionDict(ServletActionContext.getRequest().getSession(), FinalUtil.FLUPWAY);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		jsonMap.put("flupWay", flupWay);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	//suifang.jsp加载详细datagrid数据（无分页）
	public String findFlupTaskInfo(){
		List<FlupTask> rows = flupTaskService.findflFlupTasksInfo(flupTask);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", rows);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}

	
	
	
	/***
	 * 
	 * 加载随访信息
	 */
	public String findSuifangInfo(){
		flupTask=flupTaskService.findInfoById(map.get("id"));
		JSON json = JSONArray.fromObject(flupTask);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  null;
	}

	/**
	 * 查询数据
	 */
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Dict> dict = SessionData.getSessionDict(session, "信息类别");
		page.setParams(map);
		Map userMap = new HashMap();
		userMap.put("rows",flupTaskService.getFlupTask(page));
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
	 * 加载信息内容
	 */
	public String loadInfoContent(){
			String smsstyle = ServletActionContext.getRequest().getParameter("smsstyle");
			List<FlupModule> list = flupTaskService.getFlupModule(smsstyle);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("rows", list);
			JsonUtil.jsonData(jsonMap);	
			return null;
	}
	/**
	 * 发送消息
	 * @return
	 */
	public String sendMessger(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse  response = ServletActionContext.getResponse();
			String[] patiSerial = request.getParameter("patiSerial").split(",");
			String[] inpatiNumber = request.getParameter("inpatiNumber").split(",");
			String[] inpatiSerialNumber = request.getParameter("inpatiSerialNumber").split(",");
			String[] flupWay = request.getParameter("flupWay").split(",");
			String[] id = request.getParameter("id").split(",");
			String smscontent = request.getParameter("smscontent");
			String deptName=request.getParameter("deptName");
			String infoType = request.getParameter("infoType");
			String sendDate = request.getParameter("sendDate");
			String diagName = request.getParameter("diagName");
			Employee e = (Employee) request.getSession().getAttribute("employee");
			String mobilePhone=request.getParameter("mobilephone");
			FlupDetail flupDetail = null;
			if(patiSerial.length==inpatiNumber.length && patiSerial.length==inpatiSerialNumber.length){
				for (int i = 0; i < patiSerial.length; i++) {
					flupDetail = new FlupDetail();
					flupDetail.setSendContent(CollectionUtil.checkNull(sendDate) ? smscontent+"复诊时间:"+sendDate : smscontent);
					flupDetail.setId(inpatiSerialNumber[i]); //流水号
					flupDetail.setPatiSerial(patiSerial[i]);
					flupDetail.setInpatiNumber(inpatiNumber[i]);
					flupDetail.setSendWay(flupWay[i]);
					flupDetail.setName(e.getName());
					flupDetail.setInfoType(infoType);
					flupTaskService.addFlupDetail(flupDetail);//记录已经发送的用户数据
					flupTaskService.updateFlupTask(new FlupTask(patiSerial[i],inpatiNumber[i],inpatiSerialNumber[i],"1",String.valueOf(System.currentTimeMillis()),SessionData.getEmployeeCode().toString(),id[i],sendDate,diagName));

				}
				String str=(CollectionUtil.checkNull(sendDate) ? smscontent.replace("YMD", sendDate).replace("KS", deptName) : smscontent);
				String success=SendMessageUtil.sendMessage("院后随访系统",str,mobilePhone);
				response.getWriter().print("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 查询交互历史信息记录
	 * @return
	 */
	public String getByIdQuery(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String id = request.getParameter("id");
			List<FlupDetail> list = flupTaskService.getByIdQuery(id);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("rows", list);
			JsonUtil.jsonData(jsonMap);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	/**
	 * 查询手机号码
	 * @return
	 */
	public String getPhoneByType(){
		
		TeletePhone t=flupTaskService.getPhoneByType(phone);
		List<TeletePhone> list = new ArrayList<TeletePhone>();
		if(t!=null){
		if(phone.getType().equals("1")||phone.getType()=="1"){
			TeletePhone t1 = new TeletePhone();
			t1.setType(t.getMobileNumber());
			t1.setMobileNumber(t.getMobileNumber());
			TeletePhone t2 = new TeletePhone();
			t2.setType(t.getFamilyNumber());
			t2.setMobileNumber(t.getFamilyNumber());
			list.add(t1);
			list.add(t2);
		}else if(phone.getType().equals("2")||phone.getType()=="2"){
			TeletePhone t1 = new TeletePhone();
			t1.setType(t.getRelationMobileNumber());
			t1.setMobileNumber(t.getRelationMobileNumber());
			list.add(t1);
		}else{
			TeletePhone t3 = new TeletePhone();
			t3.setType(t.getRelationMobileNumber());
			t3.setMobileNumber(t.getRelationMobileNumber());
			TeletePhone t1 = new TeletePhone();
			t1.setType(t.getMobileNumber());
			t1.setMobileNumber(t.getMobileNumber());
			TeletePhone t2 = new TeletePhone();
			t2.setType(t.getFamilyNumber());
			t2.setMobileNumber(t.getFamilyNumber());
			list.add(t1);
			list.add(t2);
			list.add(t3);
			
		}
		}else{
			TeletePhone t1 = new TeletePhone();
			list.add(t1);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("phone", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	/**
	 * 加载复诊科室
	 * @return
	 */
	public String loadCodeName(){
		synchronized(map){
				List<Department> list = SessionData.getDepartment(map.get("diagCode"),map.get("diagName"));
				Map<String, Object> jsonMap = new HashMap<String, Object>();
				jsonMap.put("rows", list);
				JsonUtil.jsonData(jsonMap);	
				return null;
		}
	}
	
	
	//suifang.jsp 加载datagrid
	public String loadPlanDatagrid(){
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
		List<FlupTask> listdata = flupTaskService.findPageListPlan(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("rows", listdata);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	

	public String findPlan(){
		List<FlupTask> list = flupTaskService.findPlan(flupTask);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("plan", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	
	public String updatePlan(){
		String date[] = flupTask.getFlupPlanDate().split(",");
		String num[] = flupTask.getFlupTimes().split(",");
		for (int i = 0; i < date.length; i++) {
			FlupTask fk = new FlupTask();
			fk.setInpatiNumber(flupTask.getInpatiNumber());
			fk.setInpatiSerialNumber(flupTask.getInpatiSerialNumber());
			fk.setFlupTimes(num[i]);
			fk.setFlupPlanDate(date[i]);
			flupTaskService.updatePlan(fk);
			flupTaskService.updatePlan2(fk);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("message", "计划调整成功!");
		JsonUtil.jsonData(jsonMap);	
		
		return null;
	}
	
	public String stopPlan(){
		flupTask.setFlupComplete("1");
	flupTaskService.stopPlan(flupTask);
		flupTaskService.delteTask(flupTask);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("message", "计划终止成功!");
		JsonUtil.jsonData(jsonMap);	
		return null;
	}

	
	public String findPlan2(){
		List<FlupTask> list = flupTaskService.findPlan2(flupTask);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("plan", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	public String SavePlan(){
		String date[] = flupTask.getReturnDate().split(",");
		List<FlupTask> list = flupTaskService.findPlan2(flupTask);
		List<FlupTask> list2 = new ArrayList<FlupTask>();
		for (int i = 0; i < date.length; i++) {
			FlupTask fk = new FlupTask();
			fk.setInpatiNumber(flupTask.getInpatiNumber());
			fk.setInpatiSerialNumber(flupTask.getInpatiSerialNumber());
			fk.setPatiSerial(flupTask.getPatiSerial());
			fk.setName(flupTask.getName());
			fk.setDeptCode(flupTask.getDeptCode());
			fk.setUnitCode(flupTask.getUnitCode());
			fk.setFlupPlanDate(date[i]);
			fk.setFlupTimes(String.valueOf(list.size()+i+1));
			fk.setActualDoctorCode(SessionData.getEmployeeCode());
			list2.add(fk);
		}
		flupTaskService.addPlanJh(list2);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("message", "添加计划成功!");
		JsonUtil.jsonData(jsonMap);	
		

		
		return null;
	}
	
	public String stopTask(){
		flupTask.setFlupComplete("2");
		flupTask.setActualDoctorCode(SessionData.getEmployeeCode());
	    int row = flupTaskService.stoptask(flupTask);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(row>0){
			jsonMap.put("message", "停止随访成功!");
		}else{
			jsonMap.put("message", "停止随访失败!");
		}
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	 //根据院区统计随访率
	 public void findHospital(){
		 	page.setParams(map);
			List<FlupTask> list = flupTaskService.findHospital(page);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("totalRecord",page.getTotalRecord());
			jsonMap.put("totalPage", page.getTotalPage());
			jsonMap.put("rows", list);
			JsonUtil.jsonData(jsonMap);
	 }
	 //根据院区和计划随访日期查询科室随访率
	 public void findDepat(){
		 	map.put("flupDate1",map.get("flupDate").replace("-",""));
			page.setParams(map);
			List<FlupTask> list = flupTaskService.findDepatByUnit(page);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("totalRecord",page.getTotalRecord());
			jsonMap.put("totalPage", page.getTotalPage());
			jsonMap.put("rows", list);
			JsonUtil.jsonData(jsonMap);
	 }
	 //根据院区编码、科室编码、计划随访日期查询随访详细信息
	 public void findInfo(){
		 	page.setParams(map);
		 	List<Map<String,String>> list = flupTaskService.findInfo(page);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("totalRecord",page.getTotalRecord());
			jsonMap.put("totalPage", page.getTotalPage());
			jsonMap.put("rows", list);
			JsonUtil.jsonData(jsonMap);
	 }
	 
	 public void loadFlupNameType(){
	  FlupNameDict d = flupTaskService.loadFlupNameType(map.get("flupNameId"));
	  HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(d.getFlupType());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
}
