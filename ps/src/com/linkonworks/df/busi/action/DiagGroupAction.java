package com.linkonworks.df.busi.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.DiagGroupService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.DiagGroup;
import com.linkonworks.df.vo.DiagnosisDict;
import com.linkonworks.df.vo.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.java_cup.internal.internal_error;

public class DiagGroupAction  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8614662556859555067L;

	private DiagGroupService diagGroupService;
	
	private Page<DiagGroup> page=new Page<DiagGroup>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private DiagGroup diagGroup;
	

	
	public DiagGroup getDiagGroup() {
		return diagGroup;
	}

	public void setDiagGroup(DiagGroup diagGroup) {
		this.diagGroup = diagGroup;
	}

	public Page<DiagGroup> getPage() {
		return page;
	}

	public void setPage(Page<DiagGroup> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public DiagGroupService getDiagGroupService() {
		return diagGroupService;
	}

	public void setDiagGroupService(DiagGroupService diagGroupService) {
		this.diagGroupService = diagGroupService;
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
		List<DiagGroup> listdata = diagGroupService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", listdata);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	
	public String loadDataGridIcd(){
		page.setParams(map);
		List<DiagGroup> list = diagGroupService.findPageListIcd(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	
	public String insert(){
		 String info ="添加成功";
		 try {
			 Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
			 diagGroup.setEmployeeCode(e.getJobnum());
			// List<DiagGroup> l = diagGroupService.getDiagGroups(diagGroup);
			 String[] diagCode = diagGroup.getDiagnosisCode().split(",");
			 String[] diagName = diagGroup.getDiagnosisName().split(",");
			 List<DiagGroup> list = new ArrayList<DiagGroup>();
			 for (int i = 0; i < diagName.length; i++) {
				 DiagGroup diag = new DiagGroup();
				 diag.setGroupName(diagGroup.getGroupName());
				 diag.setDiagnosisCode(diagCode[i]);
				 diag.setDiagnosisName(diagName[i]);
				 diag.setGroupCode(diagGroup.getGroupCode());
				 diag.setEmployeeCode(e.getJobnum());
				 list.add(diag);
				 int row = diagGroupService.findIcdByGroupCode(diag);
				 if(row>0){
					 info = "请勿重复添加相同的ICD10！";
					 Map<String, Object> jsonMap = new HashMap<String, Object>();
					 jsonMap.put("success", "false");
					 jsonMap.put("info", info);
					 JsonUtil.jsonData(jsonMap);
					 return null;
				 }
			}
			 diagGroupService.insertIcd(list);
		} catch (Exception e2) {
			 info = "数据发生库异常。";
			 Map<String, Object> jsonMap = new HashMap<String, Object>();
			 jsonMap.put("success", "false");
			 jsonMap.put("info", info);
			 JsonUtil.jsonData(jsonMap);
		}
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("success", "true");
		 jsonMap.put("info", info);
		 JsonUtil.jsonData(jsonMap);
		 return null;
	}
	
	public String insertGroup(){
		 String info ="添加成功";
		 try {
			 Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
			 diagGroup.setEmployeeCode(e.getJobnum());
			 diagGroupService.insert(diagGroup);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("success", "true");
		 jsonMap.put("info", info);
		 JsonUtil.jsonData(jsonMap);
		 return null;
	}
	
	
	public String updateGroup(){
		 String info ="修改成功！";
		 String[] arrId =  diagGroup.getGroupCode().split(",");
		 try {
			 Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
			 diagGroup.setEmployeeCode(e.getJobnum());
			 diagGroupService.updateGroup(diagGroup);
			 if( !diagGroup.getGroupType().equals(diagGroup.getId())){
				 diagGroupService.deleteGroupIcdByGroupCode(arrId);
			 }
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
			 info = "数据库异常,请勿添加重复数据";
			 Map<String, Object> jsonMap = new HashMap<String, Object>();
			 jsonMap.put("success", "false");
			 jsonMap.put("info", info);
			 JsonUtil.jsonData(jsonMap);
		}
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("success", "true");
		 jsonMap.put("info", info);
		 JsonUtil.jsonData(jsonMap);
		 return null;
	}
	
	
	public String update(){
		 String info ="添加成功";
		 try {
			 Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
			 diagGroup.setEmployeeCode(e.getJobnum());
			 diagGroupService.update(diagGroup);
		} catch (Exception e2) {
			// TODO: handle exception
			 info = "数据库异常,请勿添加重复数据";
			 Map<String, Object> jsonMap = new HashMap<String, Object>();
			 jsonMap.put("success", "false");
			 jsonMap.put("info", info);
			 JsonUtil.jsonData(jsonMap);
		}
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("success", "true");
		 jsonMap.put("info", info);
		 JsonUtil.jsonData(jsonMap);
		 return null;
	}
	
	public String loadCombox(){
		List<DiagGroup> diagGroups = diagGroupService.getAllDiagGroups();
		List<Department> deptCode = SessionData.getDepartmentCode();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("diagGroup", diagGroups);
		 jsonMap.put("department", deptCode);
		 jsonMap.put("hdepartment", deptCode);
		 jsonMap.put("udepartment", deptCode);
		 JsonUtil.jsonData(jsonMap);
		return null;
		
	}
	
    //检索查询主要诊断
	public String findDiagnosisDict(){
		String keyInfo  = ServletActionContext.getRequest().getParameter("keyInfo");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyInfo", keyInfo);
		List<Department> dept = SessionData.getDepartmentCode();
		map.put("dept", dept);
		List<DiagnosisDict> list = diagGroupService.findDiagnosisDict(map);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);
		return null;		
	}
	
	  	//删除Icd10
		public String deleteIcd(){
			String[] arrId =  diagGroup.getId().split(",");
			int i =  diagGroupService.deleteGroupIcd(arrId);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			if(i>0){
				jsonMap.put("message", "删除成功!");
			}else{
				jsonMap.put("message", "删除失败!");
			}
			JsonUtil.jsonData(jsonMap);
			return null;		
		}
		
	 	//删除group
			public String deleteGroup(){
				String[] arrId =  diagGroup.getId().split(",");
				int i =  diagGroupService.deleteGroupByGroupCode(arrId);
				Map<String, Object> jsonMap = new HashMap<String, Object>();
				if(i>0){
					diagGroupService.deleteGroupIcdByGroupCode(arrId);
					jsonMap.put("message", "删除成功!");
				}else{
					jsonMap.put("message", "删除失败!");
				}
				JsonUtil.jsonData(jsonMap);
				return null;		
			}
}
