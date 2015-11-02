package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.service.FlupTaskService;
import com.linkonworks.df.busi.service.MobileFlupService;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupPlan;
import com.linkonworks.df.vo.FlupTask;
import com.linkonworks.df.vo.MobileFlup;
import com.opensymphony.xwork2.ActionSupport;

public class MobileFlupAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MobileFlup mobileFlup;
	private MobileFlupService mobileFlupService;
	private FlupTaskService flupTaskService;
	private Map<String,String> map=new HashMap<String,String>();
	
	
	public String addBatch(){
		/**
		 * 获取登录信息
		 */
		HttpSession session=ServletActionContext.getRequest().getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		HttpServletRequest  request = ServletActionContext.getRequest();
		String arr[]=request.getParameterValues("map.group[]");
		List<MobileFlup> list=new ArrayList<MobileFlup>();
		//生活指导方式,心里调整,单选,127,zf,良好
		//体征,体重,文本,122,zf,444
		//症状,无症状,复选,116,zf,无症状
		String flupNameId=map.get("flupNameId");
		String patiSerial=map.get("patiSerial");
		String inpatiNumber=map.get("inpatiNumber");
		String evaluate=map.get("evaluate");
		String flupTaskId=map.get("flupTaskId");
		int result=0;
		Map<String,String> checkMobileFlup=new HashMap<String,String>();
		checkMobileFlup.put("patiSerial", patiSerial);
		checkMobileFlup.put("inpatiNumber", inpatiNumber);
		checkMobileFlup.put("taskId", flupTaskId);
		int checkCount=mobileFlupService.checkMobileFlup(checkMobileFlup);
		if(checkCount>0){
			result=0;
		}else{
			for(int i=0;i<arr.length;i++){
				String str[]=arr[i].split(",");
				mobileFlup=new MobileFlup();
				mobileFlup.setGroupOne(str[0]);
				if((str[2]!=null) && (str[2].equals("wb"))){
					mobileFlup.setFlupGroupId(str[3]);
					mobileFlup.setGroupTwo(str[1]);
					mobileFlup.setGroupThree("");
					mobileFlup.setItemName(str[5]);
					mobileFlup.setDataType(str[4]);
					mobileFlup.setRecordType(str[2]);
					if(str.length>6){
						mobileFlup.setItemValue(str[6]);
					}else{
						mobileFlup.setItemValue("");
					}
				}else if((str[2]!=null) && (str[2].equals("dx"))){
					mobileFlup.setFlupGroupId(str[3]);
					mobileFlup.setGroupTwo(str[1]);
					mobileFlup.setGroupThree("");
					mobileFlup.setItemName(str[5]);
					mobileFlup.setDataType(str[4]);
					mobileFlup.setItemValue(str[5]);
					mobileFlup.setRecordType(str[2]);
				}else{
					mobileFlup.setFlupGroupId(str[3]);
					mobileFlup.setGroupTwo(str[1]);
					mobileFlup.setGroupThree("");
					mobileFlup.setItemName(str[5]);
					mobileFlup.setDataType(str[4]);
					mobileFlup.setItemValue(str[5]);
					mobileFlup.setRecordType(str[2]);
				}
				
				
				mobileFlup.setFlupTaskId(flupTaskId);
				mobileFlup.setFlupNameId(flupNameId);
				mobileFlup.setInpatiNumber(inpatiNumber);
				mobileFlup.setPatiSerial(patiSerial);
				
				list.add(mobileFlup);
			}
			
			Map<String,String> mapTask=new HashMap<String,String>();
			mapTask.put("patiSerial",patiSerial);
			mapTask.put("inpatiNumber",inpatiNumber);
			mapTask.put("id", map.get("id"));
			FlupTask task=flupTaskService.findFlupTask(mapTask);
			task.setFlupComplete("1");
			task.setFlupDoctorCode(employee.getJobnum());
			task.setFlupEvaluate(evaluate);
			
			String flupResult=map.get("flupResult") == "" ? "随访成功" : map.get("flupResult");
			String flupReson=map.get("flupFailre");
			if(flupResult!=null && (flupResult.equals(FinalUtil.SUIFANG_STATU0) || flupResult.equals(FinalUtil.SUIFANG_STATU1))){
				//修改 随访计划表
				Map<String,String> planMap=new HashMap<String,String>();
				planMap.put("flupStopState", "1");
				planMap.put("flupStopReason", flupReson);
				planMap.put("patiSerial", patiSerial);
				planMap.put("inpatiNumber", inpatiNumber);
				planMap.put("operateDate", "operateDate");
				planMap.put("flupStatus", "2");
				planMap.put("inpatiSerialNumber", map.get("inpatiSerialNumber"));
				planMap.put("flupNum", map.get("flupNum"));
				planMap.put("operateEmployeeCode",employee.getJobnum());
				planMap.put("flupStatu", map.get("flupStatus"));
				int planResult=mobileFlupService.updateFlupPlan(planMap);
				
				//修改随访属性表
				int patiFlupRules=mobileFlupService.updatePatiFlupRule(planMap);
				
			}
			Integer times=Integer.parseInt(task.getFlupTimes())+1;
			task.setFlupTimes(times.toString());
			task.setId(map.get("id"));
			task.setReturnDate(map.get("returnDate"));
			task.setReturnDeptCode(map.get("returnCode"));
			task.setFlupResult(flupResult);
			task.setFlupFailre(flupReson);
			task.setFlupDate("flupDate");
			task.setActualDoctorCode(employee.getJobnum());
			task.setFlupEvaluate(map.get("flupEvaluate"));
			
			
			//int r=flupTaskService.updateFlupTask(task);
			result=mobileFlupService.insertBatchs(list, task);
		}
		
		HttpServletResponse response=ServletActionContext.getResponse();
			try {
				PrintWriter out=response.getWriter();
				ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
				out.print(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	
	/*****
	 * 获取某个病人的下次随访计划
	 * @return
	 */
	public String findPlan(){
		List<FlupPlan> plan=mobileFlupService.findNext(map);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			if(!plan.isEmpty()){
				JSONArray json=JSONArray.fromObject(plan.get(0));
				out.print(json);
			}else{
				out.print("");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/****
	 * 获取未执行的随访计划
	 * @return
	 */
	public String findListPlans(){
		List<FlupPlan> plans=mobileFlupService.findNextPlans(map);
		JsonUtil.jsonDataList(plans);
		return null;
	}
	
	
	/****
	 * 终止随访计划
	 * @return
	 */
	public String endPlans(){
		Map<String,String> endMap=new HashMap<String,String>();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		endMap.put("patiSerial", map.get("patiSerial"));
		endMap.put("inpatiNumber", map.get("inpatiNumber"));
		endMap.put("inpatiSerialNumber", map.get("inpatiSerialNumber"));
		endMap.put("flupStopState", "1");
		endMap.put("operateDate", "operateDate");
		endMap.put("flupNum",map.get("flupNum"));
		endMap.put("operateEmployeeCode",employee.getJobnum());
		int r=mobileFlupService.updateFlupPlan(endMap);
		int d=mobileFlupService.deleteFlupTask(endMap);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/******
	 * 修改随访计划
	 * @return
	 */
	public String updatePlans(){
		Map<String,String> updatePlan=new HashMap<String,String>();
		updatePlan.put("patiSerial", map.get("patiSerial"));
		updatePlan.put("inpatiNumber", map.get("inpatiNumber"));
		updatePlan.put("inpatiSerialNumber", map.get("inpatiSerialNumber"));
		updatePlan.put("flupPlanDate", map.get("flupPlanDate"));
		HttpServletRequest  request = ServletActionContext.getRequest();
		String arrplans[]=request.getParameterValues("map.flupPlanGroups[]");
		List<FlupPlan> plans=mobileFlupService.findNextPlans(updatePlan);
		FlupPlan flupPlan=null;
		FlupTask task=null;
		int updateFlupDate=0;
		for(int i=0;i<arrplans.length;i++){
			String[] strPlan=arrplans[i].split(",");
			for(int j=0;j<plans.size();j++){
				FlupPlan p=plans.get(j);
				if(strPlan[1].equals(p.getFlupNum())){
					if(strPlan[0]!=null && (!strPlan[0].equals(p.getFlupPlanDate()))){
						if(strPlan[2]!=null && strPlan[2].equals("1")){
							//修改随访计划表   并且修改随访任务表
							task=new  FlupTask();
							task.setPatiSerial(map.get("patiSerial"));
							task.setInpatiNumber(map.get("inpatiNumber"));
							task.setInpatiSerialNumber(map.get("inpatiSerialNumber"));
							task.setFlupTimes(strPlan[1]);
							task.setFlupPlanDate(strPlan[0]);
							mobileFlupService.updateFlupTask(task);
						}
						flupPlan= new FlupPlan();
						flupPlan.setPatiSerial(map.get("patiSerial"));
						flupPlan.setInpatiNumber(map.get("inpatiNumber"));
						flupPlan.setInpatiSerialNumber(map.get("inpatiSerialNumber"));
						flupPlan.setFlupNum(strPlan[1]);
						flupPlan.setFlupPlanDate(strPlan[0]);
						updateFlupDate=mobileFlupService.updateFlupDate(flupPlan);
					}
				}
			}
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(updateFlupDate);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/****
	 * 批量添加随访计划
	 * @return
	 */
	public String addFlupPlan(){
		HttpServletRequest  request = ServletActionContext.getRequest();
		String arrFlupPlans[]=request.getParameterValues("map.flupPlanDate[]");
		FlupPlan flupPlan=null;
		List<FlupPlan> plans=new ArrayList<FlupPlan>();
		int result=0;
		for(int i=0;i<arrFlupPlans.length;i++){
			String[] strplans=arrFlupPlans[i].split(",");
			flupPlan=new FlupPlan();
			flupPlan.setDeptCode(map.get("deptCode"));
			flupPlan.setFlupPlanDate(strplans[0]);
			flupPlan.setFlupNum(strplans[1]);
			flupPlan.setFlupStopState("0");
			flupPlan.setFlupStopReason("");
			flupPlan.setInpatiNumber(map.get("inpatiNumber"));
			flupPlan.setInpatiSerialNumber(map.get("inpatiSerialNumber"));
			flupPlan.setMedicalInsuranceCode("");
			flupPlan.setName(map.get("name"));
			flupPlan.setOperateEmployeeCode("");
			flupPlan.setPatiSerial(map.get("patiSerial"));
			flupPlan.setTaskOpen("0");
			flupPlan.setUnitCode(map.get("unitCode"));
			plans.add(flupPlan);
		}
			result=mobileFlupService.insertAddFlupPlans(plans);
			HttpServletResponse response=ServletActionContext.getResponse();	
		try {
			PrintWriter out=response.getWriter();
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/****
	 * 处理延期随访计划
	 * @return
	 */
	public String delayFlupDate(){
		FlupPlan delayPlan=new FlupPlan();
		delayPlan.setFlupNum(map.get("flupNum"));
		delayPlan.setFlupPlanDate(map.get("delayFlupDate"));
		delayPlan.setPatiSerial(map.get("patiSerial"));
		delayPlan.setInpatiNumber(map.get("inpatiNumber"));
		delayPlan.setInpatiSerialNumber(map.get("inpatiSerialNumber"));
		int result=mobileFlupService.updateFlupDate(delayPlan);
		
		FlupTask t=new FlupTask();
		t.setFlupTimes(map.get("flupNum"));
		t.setFlupPlanDate(map.get("delayFlupDate"));
		t.setPatiSerial(map.get("patiSerial"));
		t.setInpatiNumber(map.get("inpatiNumber"));
		t.setInpatiSerialNumber(map.get("inpatiSerialNumber"));
		t.setId(map.get("flupTaskId"));
		int r=mobileFlupService.updateFlupTask(t);
		if(r>0){
			HttpServletResponse response=ServletActionContext.getResponse();
			try {
				PrintWriter out=response.getWriter();
				out.print(r);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
	/*****
	 * 调用某个人的历史随访信息
	 * @return
	 */
	public String HistoryFlupInfo(){
		List<MobileFlup> data=mobileFlupService.histroyFlupInfo(map);
		JsonUtil.jsonDataList(data);
		return null;
	}
	
	public MobileFlupService getMobileFlupService() {
		return mobileFlupService;
	}


	public void setMobileFlupService(MobileFlupService mobileFlupService) {
		this.mobileFlupService = mobileFlupService;
	}


	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
	}


	public MobileFlup getMobileFlup() {
		return mobileFlup;
	}


	public void setMobileFlup(MobileFlup mobileFlup) {
		this.mobileFlup = mobileFlup;
	}


	public FlupTaskService getFlupTaskService() {
		return flupTaskService;
	}


	public void setFlupTaskService(FlupTaskService flupTaskService) {
		this.flupTaskService = flupTaskService;
	}
	
	
	
}
