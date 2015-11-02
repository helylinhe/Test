package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.DiseaseItemService;
import com.linkonworks.df.busi.utils.CnToSpellUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.DiseaseItem;
import com.linkonworks.df.vo.Employee;
import com.opensymphony.xwork2.ActionSupport;

public class DiseaseItemAction extends ActionSupport {
	private DiseaseItemService diseaseItemService;
	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Page<DiseaseItem> page = new Page<DiseaseItem>(); // 参数传递(pageSize
	private DiseaseItem diseaseItem;

	public String queryPages() {
		//HttpSession session = ServletActionContext.getRequest().getSession();
		//Employee employee = (Employee) session.getAttribute("employee");
		List<Department> list = SessionData.getDepartmentCode();
		page.setParams(map);
		page.setList(list);
		Map<String, Object> groupMap = new HashMap<String, Object>();
		groupMap.put("rows", diseaseItemService.getPageDisease(page));
		groupMap.put("totalRecord", page.getTotalRecord());
		groupMap.put("totalPage", page.getTotalPage());
		groupMap.put("pageNo", page.getPageNo());
		JSON json = JSONArray.fromObject(groupMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		String s = "sds,dsafdsa";
		System.out.print(s.matches("^[.,]*"));
		
		//s.contains(s)
	}

	public String queryGroupOne() {
		if (!"".equals(map.get("oneSearchType"))
				&& map.get("oneSearchType") != null) {
			if (map.get("oneSearchType").matches("^[a-zA-Z]*")) {
				map.put("groupOnePy", map.get("oneSearchType"));
			} else {
				map.put("groupOne", map.get("oneSearchType"));
			}
		} else {
			map.put("groupOne", "");
			map.put("groupOnePy", "");
		}
		page.setParams(map);
		Map<String, Object> groupMap = new HashMap<String, Object>();
		groupMap.put("rows", diseaseItemService.getPageGroupOne(page));
		groupMap.put("totalRecord", page.getTotalRecord());
		groupMap.put("totalPage", page.getTotalPage());
		groupMap.put("pageNo", page.getPageNo());
		JSON json = JSONArray.fromObject(groupMap);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public void addDis() {
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			HttpServletResponse response = ServletActionContext.getResponse();
			Employee e = (Employee) session.getAttribute("employee");
			diseaseItem.setEmployeeCode(e.getJobnum());
			diseaseItem.setGroupOnePy(CnToSpellUtil.getSpell(diseaseItem
					.getGroupOne(), true));
			Map<String,String> hashmap = new HashMap<String,String>();
			hashmap.put("groupOne", diseaseItem.getGroupOne());
			hashmap.put("groupTwo", diseaseItem.getGroupTwo());
			hashmap.put("itemName", diseaseItem.getItemName());
			hashmap.put("deptCode", diseaseItem.getDeptCode());
			hashmap.put("recordType", diseaseItem.getRecordType());
			int r = diseaseItemService.checkDiseaseItem(hashmap);
			String json = "";
			if(r>0){
				json = "{\"ok\":" + "\"" + 0 + "\"" + "}";
				response.getWriter().print(json.toString());
			}else{
				Integer result = diseaseItemService.insert(diseaseItem);
				if (result >= 1) {
					response = ServletActionContext.getResponse();
					json = "{\"ok\":" + "\"" + result + "\"" + "}";
					response.getWriter().print(json.toString());
				}
			}
		} catch (Exception e) {
		}
	}

	public void updDis() {
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Employee e = (Employee) session.getAttribute("employee");
			diseaseItem.setEmployeeCode(e.getJobnum());
			diseaseItem.setGroupOnePy(CnToSpellUtil.getSpell(diseaseItem
					.getGroupOne(), true));
			HttpServletResponse response = ServletActionContext.getResponse();
			Map<String,String> hashmap = new HashMap<String,String>();
			hashmap.put("groupOne", diseaseItem.getGroupOne());
			hashmap.put("groupTwo", diseaseItem.getGroupTwo());
			hashmap.put("itemName", diseaseItem.getItemName());
			hashmap.put("deptCode", diseaseItem.getDeptCode());
			hashmap.put("recordType", diseaseItem.getRecordType());
			int r = diseaseItemService.checkDiseaseItem(hashmap);
			String json = "";
			/*if(r>0){
				json = "{\"ok\":" + "\"" + 0 + "\"" + "}";
				response.getWriter().print(json.toString());
			}else{*/
				Integer result = diseaseItemService.update(diseaseItem);
			//	if (result >= 1) {
					response = ServletActionContext.getResponse();
					json = "{\"ok\":" + "\"" + result + "\"" + "}";
					response.getWriter().print(json.toString());
			//	}
			//}
		} catch (Exception e) {
		}
	}

	public void delDis() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("diseaseGroupId", diseaseItem.getDiseaseGroupId());
			Integer result = diseaseItemService.delete(map);
			HttpServletResponse response = ServletActionContext.getResponse();
			String json = "";
			if (result >= 1) {
				response = ServletActionContext.getResponse();
				json = "{\"ok\":" + "\"" + result + "\"" + "}";
				response.getWriter().print(json.toString());
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiseaseItemService getDiseaseItemService() {
		return diseaseItemService;
	}

	public void setDiseaseItemService(DiseaseItemService diseaseItemService) {
		this.diseaseItemService = diseaseItemService;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Page<DiseaseItem> getPage() {
		return page;
	}

	public void setPage(Page<DiseaseItem> page) {
		this.page = page;
	}

	public DiseaseItem getDiseaseItem() {
		return diseaseItem;
	}

	public void setDiseaseItem(DiseaseItem diseaseItem) {
		this.diseaseItem = diseaseItem;
	}

}
