package com.linkonworks.df.busi.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.struts2.ServletActionContext;
import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.DataImportRuleDaoService;
import com.linkonworks.df.busi.service.DiagKnowledgeService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.CnToSpellUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.DiagKnowledge;
import com.linkonworks.df.vo.DiagnosisDict;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.SymptomDict;
import com.opensymphony.xwork2.ActionSupport;

public class DiagKnowledgeAction  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -258472026755876939L;
	private Page<DiagKnowledge> page=new Page<DiagKnowledge>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private DiagKnowledge diagKnowledge = new DiagKnowledge();//维护字典表注入的实体 
	private SymptomDict  symptomDict = new SymptomDict();//新增需要的实体
	private String dictId;//查询symptom时需要的dictid
	private DiagKnowledgeService diagKnowledgeService;
	private DataImportRuleDaoService dataImportRuleService;
	
	public DataImportRuleDaoService getDataImportRuleService() {
		return dataImportRuleService;
	}
	public void setDataImportRuleService(
			DataImportRuleDaoService dataImportRuleService) {
		this.dataImportRuleService = dataImportRuleService;
	}
	public SymptomDict getSymptomDict() {
		return symptomDict;
	}
	public void setSymptomDict(SymptomDict symptomDict) {
		this.symptomDict = symptomDict;
	}
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public Page<DiagKnowledge> getPage() {
		return page;
	}
	public void setPage(Page<DiagKnowledge> page) {
		this.page = page;
	}
	public DiagKnowledge getDiagKnowledge() {
		return diagKnowledge;
	}
	public void setDiagKnowledge(DiagKnowledge diagKnowledge) {
		this.diagKnowledge = diagKnowledge;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public DiagKnowledgeService getDiagKnowledgeService() {
		return diagKnowledgeService;
	}
	public void setDiagKnowledgeService(DiagKnowledgeService diagKnowledgeService) {
		this.diagKnowledgeService = diagKnowledgeService;
	}
	
	public String loadDG(){
		List<Department> list = new ArrayList<Department>();
		if(map.get("deptCode")!=null && !map.get("deptCode").equals("")){
			Department department = new Department();
			department.setDeptCode(map.get("deptCode"));
			list.add(department);
			
		}else{
			list = SessionData.getDepartmentCode();
		}
		page.setParams(map);
		page.setList(list);
		List<DiagKnowledge> listdata = diagKnowledgeService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", listdata);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	//加载dict
	public String loadDict(){
		List<Dict> dict = diagKnowledgeService.findListByCode();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("dict", dict);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	
	public String insertOrUpdateDiagKnowledge(){
		String mainSymptoSpell =CnToSpellUtil.getSpell(diagKnowledge.getMainSymptom(),true);
		diagKnowledge.setMainSymptomSpell(mainSymptoSpell);
		Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
		diagKnowledge.setLogEmpolyeeCode(e.getJobnum());
		int rows=0;
		String message="";
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		String type= ServletActionContext.getRequest().getParameter("type");
		if("update".equals(type)||type=="update"){
			rows = diagKnowledgeService.update(diagKnowledge);
			if(rows>0){
				jsonMap.put("success",true);
				message="修改成功！";
			}else{
				jsonMap.put("success",false);
				message = "修改失败,请仔细填写内容！";
			}
		}else {
		    rows= diagKnowledgeService.insert(diagKnowledge);
			if(rows>0){
				jsonMap.put("success",true);
				message="新增随访成功！";
			}else{
				jsonMap.put("success",false);
				message = "新增失败,请仔细填写内容！";
			}
		}
		jsonMap.put("message",message);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	//根据症状部位查询对应的主要症状
	public String findSymptomDictByDcitId(){
		List<SymptomDict> list = diagKnowledgeService.findListByDictId(dictId);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	public String insertSymptomdict(){
		String inputCode =CnToSpellUtil.getSpell(symptomDict.getSymptomName(),true);
		symptomDict.setInputCode(inputCode);
		String message ="";
		int rows = diagKnowledgeService.insertSymptomDict(symptomDict);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(rows>0){
			jsonMap.put("success",true);
			message="新增症状成功！";
		}else{
			jsonMap.put("success",false);
			message = "新增症状失败,请仔细填写内容！";
		}
		jsonMap.put("message", message);
		JsonUtil.jsonData(jsonMap);
		return null;
	}	
	//修改主要症状的方法
	public String updateSymptomdict(){
		String message ="";
		int rows = diagKnowledgeService.updateSymptomDict(symptomDict);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(rows>0){
			jsonMap.put("success",true);
			message="修改症状成功！";
		}else{
			jsonMap.put("success",false);
			message = "修改症状失败,请仔细填写内容！";
		}
		jsonMap.put("message", message);
		JsonUtil.jsonData(jsonMap);
		return null;		
	}
	//修改随访知识库状态的的方法
	public String updatdiagKnowledge(){
		int rows=0;
		String message ="";
		Employee e  = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");
		diagKnowledge.setLogEmpolyeeCode(e.getJobnum());
		String info = ServletActionContext.getRequest().getParameter("allKnowledgeCode");
		String[] KnowledgeCode = info.split(",");
		for (int i = 0; i < KnowledgeCode.length; i++) {
			diagKnowledge.setKnowledgeCode(KnowledgeCode[i]);
			rows = diagKnowledgeService.updateDiagKnowledge(diagKnowledge);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(rows>0){
			jsonMap.put("success",true);
			message="修改状态成功！";
		}else{
			jsonMap.put("success",false);
			message = "修改状态失败,请仔细填写内容！";
		}
		jsonMap.put("message", message);
		JsonUtil.jsonData(jsonMap);
		return null;		
	}
	     //检索查询主要诊断
		public String findDiagnosisDict(){
			String keyInfo  = ServletActionContext.getRequest().getParameter("keyInfo");
			String groupType  = ServletActionContext.getRequest().getParameter("groupType");
			Map<String, String> map = new HashMap<String, String>();
			map.put("groupType", groupType);
			if(keyInfo.substring(0, keyInfo.length()-1).matches("^[a-zA-Z]*")){
				map.put("searType", "E");
				map.put("keyInfo", keyInfo.toUpperCase());
			}else{
				map.put("keyInfo", keyInfo.toUpperCase());
			}
			List<DiagnosisDict> list = diagKnowledgeService.findDiagnosisDict(map);
			Map<String, Object> jsonMap = new HashMap<String, Object>();
			jsonMap.put("rows", list);
			JsonUtil.jsonData(jsonMap);
			return null;		
		}
		
		public String  loadCombobox(){
			Map<String, Object> jsonMap = new HashMap<String, Object>();
//			Department d= new Department();
//			d.setDeptCode("");
//			d.setDeptName("不限");
		    //加载combobox所需要的数据(所有的科室)
		    List<Department> department =SessionData.getDepartmentCode();
//			department.set(0, d);
			jsonMap.put("department", department);
			JsonUtil.jsonData(jsonMap);	
			return null;
		}
	
}
