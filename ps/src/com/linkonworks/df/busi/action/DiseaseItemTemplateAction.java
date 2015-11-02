package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.DiseaseItemTemplateService;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.busi.utils.FlupItemResponseTableView;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.DiseaseItem;
import com.linkonworks.df.vo.DiseaseItemTemplate;
import com.linkonworks.df.vo.DiseaseNameDict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupItemResponse;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class DiseaseItemTemplateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page<DiseaseItemTemplate> page=new Page<DiseaseItemTemplate>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递
	private DiseaseItemTemplateService diseaseItemTemplateService;
	

	public DiseaseItemTemplateService getDiseaseItemTemplateService() {
		return diseaseItemTemplateService;
	}

	public void setDiseaseItemTemplateService(
			DiseaseItemTemplateService diseaseItemTemplateService) {
		this.diseaseItemTemplateService = diseaseItemTemplateService;
	}
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	

	public Page<DiseaseItemTemplate> getPage() {
		return page;
	}

	public void setPage(Page<DiseaseItemTemplate> page) {
		this.page = page;
	}

	/***
	 * 
	 * 获取一级疾病名称
	 */
	public String firstDiseaseItem(){
		Map<String, Object> diseaseMap = new HashMap<String, Object>();
		diseaseMap.put("rows",diseaseItemTemplateService.diseaseItemFirst());
		JsonUtil.jsonData(diseaseMap);
		return null;
	}
	
	/*****
	 * 获取二级疾病名称
	 */
	public String secondDiseaseItem(){
		Map<String,Object> diseaseSecondMap=new HashMap<String,Object>();
		diseaseSecondMap.put("rows", diseaseItemTemplateService.diseaseItemSeconde(map));
		JsonUtil.jsonData(diseaseSecondMap);
		return null;
	}
	
	/*****
	 * 获取疾病指标模板名称
	 */
	public String diseaseNameDict(){
		List<Department> list = SessionData.getDepartmentCode();
		Map<String,Object> diseaseNameDict=new HashMap<String,Object>();
		diseaseNameDict.put("rows", diseaseItemTemplateService.diseaseNameDict(list));
		JsonUtil.jsonData(diseaseNameDict);
		return null;
	}
	
	/****
	 * 获取疾病名称
	 * 
	 */
	public String pageList(){
		Map<String, Object> diseaseItem=new HashMap<String, Object>();
		List<Department> list  = SessionData.getDepartmentCode();
		page.setList(list);
		page.setParams(map);
		diseaseItem.put("rows",diseaseItemTemplateService.pageListDisease(page));
		diseaseItem.put("totalRecord",page.getTotalRecord());
		diseaseItem.put("totalPage", page.getTotalPage());
		diseaseItem.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(diseaseItem);
		return null;
	}
	
	/*****
	 * 获取疾病名称对应下的疾病指标
	 */
	public String pageListRight(){
		Map<String,Object> hashmap=new HashMap<String,Object>();

		hashmap.put("diseaseNameId",map.get("diseaseNameId").toString());
		hashmap.put("list", SessionData.getDepartmentCode());
//		diseaseItemRight.put("rows",diseaseItemTemplateService.pageListDiseaseRight(hashmap));
		Map<String,Object> diseaseItemRight=new HashMap<String,Object>();
		//List<DiseaseItemTemplate> diseaseList=diseaseItemTemplateService.pageListDiseaseRight(map);
		List<DiseaseItemTemplate> diseaseList=diseaseItemTemplateService.pageListDiseaseRight(hashmap);
		diseaseItemRight.put("rows",diseaseList);
		JsonUtil.jsonData(diseaseItemRight);
		return null;
	}
	
	/*****
	 * 保存疾病模板下的疾病项
	 */
	public String addFlupDiseaseItemTemplate(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		List<DiseaseItemTemplate> list=new ArrayList<DiseaseItemTemplate>();
		String diseaseNameId=map.get("diseaseNameId");
		
		String arr[]=map.get("arrDiseaseGroupId").split(",");
		DiseaseItemTemplate res=null;
		int count=0;
			for(int i=0;i<arr.length;i++){
				res=new DiseaseItemTemplate();
				DiseaseItem group=new DiseaseItem();
				DiseaseNameDict nameDict=new DiseaseNameDict();
				String[] str=arr[i].split("_");
				group.setDiseaseGroupId(str[0]);
				res.setShowNo(str[1]);
				nameDict.setDiseaseNameId(diseaseNameId);
				res.setDiseaseItem(group);
				res.setDiseaseNameDict(nameDict);
				res.setEmployeeCode(employee.getJobnum());
				res.setUseState("1");
				list.add(res);
			}
		diseaseItemTemplateService.deleteDiseaseItem(diseaseNameId);
		if(list.size()>0){
			count=diseaseItemTemplateService.addBatch(list);
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*******
	 * 
	 * 疾病指标模板展示
	 */
	
	public String showView(){
		HttpServletRequest  request = ServletActionContext.getRequest();
		StringBuilder sb = new StringBuilder();
		PrintWriter  out = null; 
		try {
			out = ServletActionContext.getResponse().getWriter();
			String diseasNameId=request.getParameter("diseaseNameId");
			String showView=request.getParameter("showView");
			List<DiseaseItemTemplate> items=diseaseItemTemplateService.diseaseItemTemplates(diseasNameId);
			
			sb.append(FlupItemResponseTableView.getDiseasItemTemplate(items,showView));
			out.print(sb);
		}catch (Exception e) {
			out.print("error");
			e.printStackTrace();
		}
			return null;
	}
	
	/****
	 * 导出化疗信息
	 */
	public String exportData(){
		Map<String,Object> hashmap = new HashMap<String,Object>();
		HSSFWorkbook wb = diseaseItemTemplateService.exportReportData(hashmap);
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
}
