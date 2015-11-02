package com.linkonworks.df.busi.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.InpatiDiagService;
import com.linkonworks.df.busi.service.PatiDiseaseDictService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.DiseaseNameDict;
import com.linkonworks.df.vo.InpatiDiag;
import com.linkonworks.df.vo.Pati;
import com.linkonworks.df.vo.PatiDiseaseDetail;
import com.linkonworks.df.vo.PatiDiseaseDict;
import com.opensymphony.xwork2.ActionSupport;

public class PatiDiseaseDictAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3778748474638838537L;
	private PatiDiseaseDictService patiDiseaseDictService;
	private Pati pati;
	private PatiDiseaseDict patiDiseaseDict;
	private InpatiDiagService inpatiDiagServices;
	private Page<DataImportRule> page=new Page<DataImportRule>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private  PatiDiseaseDetail patiDiseaseDetail;
	
	public PatiDiseaseDetail getPatiDiseaseDetail() {
		return patiDiseaseDetail;
	}
	public void setPatiDiseaseDetail(PatiDiseaseDetail patiDiseaseDetail) {
		this.patiDiseaseDetail = patiDiseaseDetail;
	}
	public PatiDiseaseDict getPatiDiseaseDict() {
		return patiDiseaseDict;
	}
	public void setPatiDiseaseDict(PatiDiseaseDict patiDiseaseDict) {
		this.patiDiseaseDict = patiDiseaseDict;
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
	public Pati getPati() {
		return pati;
	}
	public void setPati(Pati pati) {
		this.pati = pati;
	}
	
	public InpatiDiagService getInpatiDiagServices() {
		return inpatiDiagServices;
	}
	public void setInpatiDiagServices(InpatiDiagService inpatiDiagServices) {
		this.inpatiDiagServices = inpatiDiagServices;
	}
	public PatiDiseaseDictService getPatiDiseaseDictService() {
		return patiDiseaseDictService;
	}
	public void setPatiDiseaseDictService(
			PatiDiseaseDictService patiDiseaseDictService) {
		this.patiDiseaseDictService = patiDiseaseDictService;
	}
	/****
	 * 加载科室下的疾病模板信息
	 * @return
	 */
	public String loadCombobox(){
		//加载combobox所需要的数据(所有的科室)
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list",  SessionData.getDepartmentCode());
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<DiseaseNameDict> list = patiDiseaseDictService.findDiseaseNameDict(map);
		jsonMap.put("diseaseName", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	/****
	 * 通过查询获取病人住院信息
	 * @return
	 */
	public String getPatiInfo(){
		page.setParams(map);
		List<Department> list = new ArrayList<Department>();
		list = SessionData.getDepartmentCode();
		page.setList(list);
		List<InpatiDiag> listdata =inpatiDiagServices.findPatis(page);
		Map<String, Object> inpatiDiagMap = new HashMap<String, Object>();
		inpatiDiagMap.put("totalRecord",page.getTotalRecord());
		inpatiDiagMap.put("totalPage", page.getTotalPage());
		inpatiDiagMap.put("pageNo", page.getPageNo());
		inpatiDiagMap.put("rows", listdata);
		JsonUtil.jsonData(inpatiDiagMap);
		return null;
	}
	/****
	 * 加载某个病人下的疾病指标
	 * @return
	 */
	public String loadDG(){
		page.setParams(map);
		List<PatiDiseaseDict> list = patiDiseaseDictService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	/******
	 * 为某个病人添加疾病指标
	 * @return
	 */
	public String insert(){
		String info ="";
		
		patiDiseaseDict.setOperateEmployeeCode(SessionData.getEmployeeCode());
		int i = patiDiseaseDictService.insert(patiDiseaseDict);
		if(i>0){
			info ="添加成功";
		}else{
			info="添加失败";
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("info", info);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	public String delete(){
		String info ="";
		String id = ServletActionContext.getRequest().getParameter("id");
		String [] arr = id.split(",");
		int i = patiDiseaseDictService.delete(arr);
		if(i>0){
			info ="删除成功";
		}else{
			info="删除失败";
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("info", info);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	public String findDate(){
		List<PatiDiseaseDetail> list = patiDiseaseDictService.findDate(patiDiseaseDetail);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("date", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}

}
