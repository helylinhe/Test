package com.linkonworks.df.busi.action;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.KetiReportService;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Employee;
import com.opensymphony.xwork2.ActionSupport;

public class KetiReportAction extends ActionSupport{

	private KetiReportService ketiReportService;
	private String startDate;
	private String endDate;
	private String inpatiNumber;
	private String name;
	private Page<Object> page=new Page<Object>();
	private Map<String,String> map=new HashMap<String,String>();

	
	
	public String pageList(){
		page.setParams(map);
		page.setList(SessionData.getDepartmentCode());
		Map<String,Object> results=new HashMap<String,Object>();
		List<Map<String,String>> list=ketiReportService.pageList(page);
		results.put("rows",list);
		results.put("totalRecord",page.getTotalRecord());
		results.put("totalPage", page.getTotalPage());
		results.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(results);
		return null;
	}
	
	/*****
	 * 数据导出EXCEL
	 */
	public String exportData(){
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		
		if((employee.getRoleName()!=null && employee.getRoleName().equals(FinalUtil.DEPART)) || (employee.getRoleName()!=null && employee.getRoleName().equals(FinalUtil.ADMIN))){
			map.put("deptCode","");
		}else{
			map.put("deptCode",Arrays.asList(employee.getDeptCode().split(",")));
		}
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("name", name);
		map.put("inpatiNumber", inpatiNumber);		
		HSSFWorkbook wb = ketiReportService.exportReportData(map);
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/excel");
			SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
			String dateFormate=sdf.format(new Date());
			
			String filename = URLEncoder.encode("课题报表"+dateFormate+".xls", "UTF-8");
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
	
	
	public KetiReportService getKetiReportService() {
		return ketiReportService;
	}

	public void setKetiReportService(KetiReportService ketiReportService) {
		this.ketiReportService = ketiReportService;
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


	public String getInpatiNumber() {
		return inpatiNumber;
	}


	public void setInpatiNumber(String inpatiNumber) {
		this.inpatiNumber = inpatiNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
	
}
