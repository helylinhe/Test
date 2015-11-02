package com.linkonworks.df.busi.action;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.ReportDataService;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.FlupNameDictVO;
import com.opensymphony.xwork2.ActionSupport;

public class ReportDataAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReportDataService reportDataService;
	private Page<Object> page=new Page<Object>();
	private Map<String,String> map=new HashMap<String,String>();
	private String startDate;
	private String endDate;
	private String flupNameId;
	private String flupTableName;
	private String name;
	private String inpatiNumber;
	private String flupItem;
	private String flupComplete;
	private String deptCode;
	/****
	 * 列表展示
	 */
	public String pageList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Department> list = new ArrayList<Department>();
		if(map.get("deptCode")!=null && !map.get("deptCode").equals("")){
			Department department = new Department();
			department.setDeptCode(map.get("deptCode"));
			list.add(department);
		}else{
			list = SessionData.getDepartmentCode();
		}
		page.setList(list);
		page.setParams(map);
		
		Map<String, Object> results=new HashMap<String, Object>();
		List<Map<String,String>> listdata=reportDataService.pageList(page);
		results.put("rows",listdata);
		results.put("totalRecord",page.getTotalRecord());
		results.put("totalPage", page.getTotalPage());
		results.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(results);
		return null;
		
	}
	
	/*****
	 * 数据导出EXCEL
	 */
	public String execute(){
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		if(deptCode!=null && !deptCode.equals("")){
			Department d = new Department();
			d.setDeptCode(deptCode);
			List<Department> list  = new ArrayList<Department>();
			list.add(d);
			map.put("deptCode", list);
		}else{
			map.put("deptCode",SessionData.getDepartmentCode());
		}
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("flupNameId", flupNameId);
		map.put("flupTableName",flupTableName);
		map.put("name", name);
		map.put("inpatiNumber", inpatiNumber);
		map.put("reportName", employee.getName());
		map.put("flupItem",flupItem);
		map.put("flupComplete", flupComplete);
		
		
		
		HSSFWorkbook wb = reportDataService.exportReportData(map);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/excel");
			SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
			String dateFormate=sdf.format(new Date());
			if(flupTableName!=null && !flupTableName.equals("") && flupTableName.equals("不限")){
				this.setFlupTableName("病人随访信息表");
			}
			String filename = URLEncoder.encode(flupTableName+(dateFormate)+".xls", "UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ filename);
			OutputStream outp = response.getOutputStream();
			wb.write(outp);
			outp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public String loadFlupNameDict(){
		//获取所有的科室
		List<FlupNameDict> rows = reportDataService.loadFlupNameDict(SessionData.getDepartmentCode());
		FlupNameDictVO flupNameDictVO =  new FlupNameDictVO();
		FlupNameDict d=new FlupNameDict();
		d.setFlupName("不限");
		d.setFlupNameId("");
		rows.add(0, d);
		flupNameDictVO.setRows(rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", rows);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}

	public ReportDataService getReportDataService() {
		return reportDataService;
	}


	public void setReportDataService(ReportDataService reportDataService) {
		this.reportDataService = reportDataService;
	}

	

	public Page<Object> getPage() {
		return page;
	}

	public void setPage(Page<Object> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFlupNameId() {
		return flupNameId;
	}

	public void setFlupNameId(String flupNameId) {
		this.flupNameId = flupNameId;
	}

	public String getFlupTableName() {
		return flupTableName;
	}

	public void setFlupTableName(String flupTableName) {
		this.flupTableName = flupTableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInpatiNumber() {
		return inpatiNumber;
	}

	public void setInpatiNumber(String inpatiNumber) {
		this.inpatiNumber = inpatiNumber;
	}

	public String getFlupItem() {
		return flupItem;
	}

	public void setFlupItem(String flupItem) {
		this.flupItem = flupItem;
	}

	public String getFlupComplete() {
		return flupComplete;
	}

	public void setFlupComplete(String flupComplete) {
		this.flupComplete = flupComplete;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	
	
	
	

}
