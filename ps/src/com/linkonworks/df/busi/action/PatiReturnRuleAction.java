package com.linkonworks.df.busi.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.PatiReturnRuleService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.PatiReturnRule;
import com.linkonworks.df.vo.RetdayDetail;
import com.opensymphony.xwork2.ActionSupport;

public class PatiReturnRuleAction extends ActionSupport {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -6804181179184013750L;
	private PatiReturnRuleService patiReturnRuleService;
	private Page<PatiReturnRule> page=new Page<PatiReturnRule>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	private DataImportRuleAction dataImportRuleAction;
	private DiagGroupAction diagGroupAction;
	private PatiReturnRule patiReturnRule;
	private RetdayDetail retdayDetail;
	
	
	public RetdayDetail getRetdayDetail() {
		return retdayDetail;
	}

	public void setRetdayDetail(RetdayDetail retdayDetail) {
		this.retdayDetail = retdayDetail;
	}

	public PatiReturnRule getPatiReturnRule() {
		return patiReturnRule;
	}

	public void setPatiReturnRule(PatiReturnRule patiReturnRule) {
		this.patiReturnRule = patiReturnRule;
	}

	public DiagGroupAction getDiagGroupAction() {
		return diagGroupAction;
	}

	public void setDiagGroupAction(DiagGroupAction diagGroupAction) {
		this.diagGroupAction = diagGroupAction;
	}

	public DataImportRuleAction getDataImportRuleAction() {
		return dataImportRuleAction;
	}

	public void setDataImportRuleAction(DataImportRuleAction dataImportRuleAction) {
		this.dataImportRuleAction = dataImportRuleAction;
	}

	public Page<PatiReturnRule> getPage() {
		return page;
	}

	public void setPage(Page<PatiReturnRule> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public PatiReturnRuleService getPatiReturnRuleService() {
		return patiReturnRuleService;
	}

	public void setPatiReturnRuleService(PatiReturnRuleService patiReturnRuleService) {
		this.patiReturnRuleService = patiReturnRuleService;
	}
	 
	
	public String loadCombobox(){
	    List<Department> department=SessionData.getDepartmentCode();
	    Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("department", department);
		JsonUtil.jsonData(jsonMap);
		return null;
	}
	
	public String loadDateGrid(){
		page.setParams(map);
		List<PatiReturnRule> list = patiReturnRuleService.findPageList(page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("totalRecord",page.getTotalRecord());
		jsonMap.put("totalPage", page.getTotalPage());
		jsonMap.put("pageNo", page.getPageNo());
		jsonMap.put("rows", list);
		JsonUtil.jsonData(jsonMap);	
		return null;
	}
	
	public String insert(){
		String type = ServletActionContext.getRequest().getParameter("type");
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 patiReturnRule.setOperateEmployeeCode(SessionData.getEmployeeCode());
		if(type.equals("update")||type=="update"){
			int up = patiReturnRuleService.update(patiReturnRule);
			Map<String , Object> map3 = new HashMap<String, Object>();
			map3.put("id", patiReturnRule.getId());
			patiReturnRuleService.deleteDetails(map3);
			String day=patiReturnRule.getReturnDay();
		    String info = patiReturnRule.getReturnInfo();
		    String[] arrday = day.split(",");
		    String[] arrinfo=info.split(","); 
		    List<RetdayDetail> list = new ArrayList<RetdayDetail>();
		    for (int j = 0; j < arrinfo.length; j++) {
		    	RetdayDetail re= new RetdayDetail();
		    	re.setReturnSerialNumber(arrday[j]);
		    	re.setReturnContent(arrinfo[j]);
		    	re.setReturnNumber(String.valueOf(j+1));
		    	re.setRuleId(patiReturnRule.getId());
		    	list.add(re);
			}
		      patiReturnRuleService.insertDetailHasId(list);
		      jsonMap.put("message", "修改成功！");
		}else{
		    int i=patiReturnRuleService.insert(patiReturnRule);
		    String day=patiReturnRule.getReturnDay();
		    String info = patiReturnRule.getReturnInfo();
		    String[] arrday = day.split(",");
		    String[] arrinfo=info.split(","); 
		    List<RetdayDetail> list = new ArrayList<RetdayDetail>();
		    for (int j = 0; j < arrinfo.length; j++) {
		    	RetdayDetail re= new RetdayDetail();
		    	re.setReturnSerialNumber(arrday[j]);
		    	re.setReturnContent(arrinfo[j]);
		    	re.setReturnNumber(String.valueOf(j+1));
		    	list.add(re);
			}
		    int row = patiReturnRuleService.insertDetail(list);
		    if(row>0){
		    	jsonMap.put("message", "添加成功！");
		    }
		}
		
	    JsonUtil.jsonData(jsonMap);
		return null;
	}

	public String getReRetdayDetails(){
		 List<RetdayDetail> row = patiReturnRuleService.getReRetdayDetails(retdayDetail);
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("rows", row);
		 JsonUtil.jsonData(jsonMap);
		 return null;
	}
	
	public String getDepartmentInfo(){
		Map<String, Object> map2 = new HashMap<String, Object>();
		String keyInfo=ServletActionContext.getRequest().getParameter("keyInfo");
		if(keyInfo.substring(0, keyInfo.length()-1).matches("^[a-zA-Z]*")){
			//	System.out.println(keyInfo.toUpperCase());
			map2.put("searType", "E");
			map2.put("keyInfo", keyInfo.toUpperCase());
			}else{
			map2.put("keyInfo", keyInfo.toUpperCase());
			}
			List<Department> row = patiReturnRuleService.getDepartment(map2);
			 Map<String, Object> jsonMap = new HashMap<String, Object>();
			 jsonMap.put("rows", row);
			 JsonUtil.jsonData(jsonMap);
		     return null;
	}
	
	public String updateRule(){
		String id = ServletActionContext.getRequest().getParameter("id");
		String[] arr= id.split(",");
		 int row = patiReturnRuleService.updateRule(arr);
		 Map<String, Object> jsonMap = new HashMap<String, Object>();
		 jsonMap.put("message", "删除成功!");
		 JsonUtil.jsonData(jsonMap);
		 return null;
	}
	
}
