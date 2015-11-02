package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.InspectService;
import com.linkonworks.df.vo.Inspect;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InspectAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InspectService inspectService;

	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Page<Inspect> page = new Page<Inspect>(); // 参数传递(pageSize

	public String queryPages() {
		page.setParams(map);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", inspectService.getPageInspect(page));
		itemMap.put("totalRecord", page.getTotalRecord());
		itemMap.put("totalPage", page.getTotalPage());
		itemMap.put("pageNo", page.getPageNo());
		JSON json = JSONArray.fromObject(itemMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//调阅检验
	public String queryInspectPages() {
		page.setParams(map);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", inspectService.getInspects(page));
		itemMap.put("totalRecord", page.getTotalRecord());
		itemMap.put("totalPage", page.getTotalPage());
		itemMap.put("pageNo", page.getPageNo());
		JSON json = JSONArray.fromObject(itemMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String queryInspectDetail() {
		String inspectId  = ServletActionContext.getRequest().getParameter("inspectId");
		String itemCode  = ServletActionContext.getRequest().getParameter("itemCode");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("inspectId", inspectId);
		map1.put("itemCode", itemCode);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", inspectService.getInspectsDetail(map1));
		JSON json = JSONArray.fromObject(itemMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String queryHighChars() {
		String patiSerial  = ServletActionContext.getRequest().getParameter("patiSerial");
		String reportItemCode  = ServletActionContext.getRequest().getParameter("reportItemCode");
		String itemName = ServletActionContext.getRequest().getParameter("itemName");
		String inspectDate = ServletActionContext.getRequest().getParameter("itemName");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("patiSerial", patiSerial);
		map1.put("reportItemCode", reportItemCode);
		map1.put("itemName", itemName);
		List<Inspect> list = inspectService.getHighChars(map1);
		List<Inspect> temp = new ArrayList<Inspect>();
		for (Inspect inspect : list) {
//			if(inspect.getInspectResult().matches("^\\-[0-9]+\\.{0,1}[0-9]{0,2}|[0-9]+\\.{0,1}[0-9]{0,2}$")){
				temp.add(inspect);
//			}
		}
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", temp);
		JSON json = JSONArray.fromObject(itemMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//打印随访表
	public String printFollow(){
		 Map<String,Object> flupMap = new HashMap<String,Object>();
		 flupMap.put("patientId", map.get("patientId"));
		 flupMap.put("inpatiNumber", map.get("inpatiNumber"));
		 flupMap.put("visitId", map.get("visitId"));
		 List<Map<String,String>> result = inspectService.printFlupName(flupMap);
		JSON json = JSONArray.fromObject(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Page<Inspect> getPage() {
		return page;
	}

	public void setPage(Page<Inspect> page) {
		this.page = page;
	}

	public InspectService getInspectService() {
		return inspectService;
	}

	public void setInspectService(InspectService inspectService) {
		this.inspectService = inspectService;
	}

}
