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
import com.linkonworks.df.busi.service.FlupGroupService;
import com.linkonworks.df.busi.service.MobileFlupService;
import com.linkonworks.df.busi.utils.CnToSpellUtil;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.MobileFlup;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class FlupGroupAction extends ActionSupport implements ModelDriven,
		Preparable {

	/**
	 * 
	 */
	private HttpServletResponse response;
	private static final long serialVersionUID = -1903783015194843068L;
	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Page<FlupGroup> page = new Page<FlupGroup>(); // 参数传递(pageSize
	private FlupGroupService flupGroupService;
	private MobileFlupService mobileFlupService;
	private FlupGroup flupGroup;

	private String groupOne;
	private String groupTwo;
	private String groupThree;

	public String queryPages() {
		if (!"".equals(map.get("searchType")) && map.get("searchType") != null) {
			if (map.get("searchType").matches("^[a-zA-Z]*")) {
				map.put("groupOnePy", map.get("searchType"));
			} else {
				map.put("groupOne", map.get("searchType"));
			}
		}
		List<Department> list = SessionData.getDepartmentCode();
		page.setParams(map);
		page.setList(list);
		Map<String, Object> groupMap = new HashMap<String, Object>();
		groupMap.put("rows", flupGroupService.getPageGroups(page));
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

	public String queryGroupOne() {
		if (!"".equals(map.get("searchType")) && map.get("searchType") != null) {
			if (map.get("searchType").matches("^[a-zA-Z]*")) {
				map.put("groupOnePy", map.get("searchType"));
			} else {
				map.put("groupOne", map.get("searchType"));
			}
		}
		page.setParams(map);
		Map<String, Object> groupMap = new HashMap<String, Object>();
		groupMap.put("rows", flupGroupService.getPageGroupOne(page));
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

	public String flupGroupData() {
		Map<String, Object> flupMap = new HashMap<String, Object>();
		flupMap.put("rows", flupGroupService.getAllFlupGroup());
		JsonUtil.jsonData(flupMap);
		return null;
	}

	public String flupSecondGroupData() {
		Map<String, Object> flupSecondeMap = new HashMap<String, Object>();
		flupSecondeMap.put("rows", flupGroupService.getGroupTwo(map));
		JsonUtil.jsonData(flupSecondeMap);
		return null;
	}

	/**
	 * 检索查询
	 * @return
	 */
	public String flupGroupData2() {
		String info = ServletActionContext.getRequest().getParameter("keyInfo");
		Map<String, Object> map1 = new HashMap<String, Object>();
		if(info.substring(0, info.length()-1).matches("^[a-zA-Z]*")){
			map1.put("searType", "E");
			map1.put("info", info.toLowerCase());
		}else{
			map1.put("info", info.toLowerCase());
		}
	
		Map<String, Object> flupMap = new HashMap<String, Object>();
		flupMap.put("rows", flupGroupService.getAllFlupGroup2(map1));
		JsonUtil.jsonData(flupMap);
		return null;
	}
	
	/**
	 * 检索查询
	 * @return
	 */
	public String flupGroupData3() {
		String info = ServletActionContext.getRequest().getParameter("keyInfo");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("info", info.toLowerCase());
		Map<String, Object> flupMap = new HashMap<String, Object>();
		flupMap.put("rows", flupGroupService.getAllFlupGroup3(map1));
		JsonUtil.jsonData(flupMap);
		return null;
	}
	
	public String addGroup() throws Exception {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Employee e = (Employee) session.getAttribute("employee");
			flupGroup.setEmployeeCode(e.getJobnum());
			flupGroup.setGroupOnePy(CnToSpellUtil.getSpell(flupGroup
					.getGroupOne(), true));
			Map<String,String> checkMap=new HashMap<String,String>();
			checkMap.put("groupOne", flupGroup.getGroupOne());
			checkMap.put("groupTwo", flupGroup.getGroupTwo());
			checkMap.put("groupThree", flupGroup.getGroupThree());
			checkMap.put("itemName", flupGroup.getItemName());
			checkMap.put("recordType", flupGroup.getRecordType());
			checkMap.put("itemRequired", flupGroup.getItemRequired());
			checkMap.put("deptCode", flupGroup.getDeptCode());
			int count=flupGroupService.checkFlupGroup(checkMap);
			String json = "";
			if(count>0){
				response = ServletActionContext.getResponse();
				json = "{\"ok\":" + "\"" + "2" + "\"" + "}";
				response.getWriter().print(json.toString());
			}else{
				Integer result = flupGroupService.insert(flupGroup);
				
				if (result >= 1) {
					response = ServletActionContext.getResponse();
					json = "{\"ok\":" + "\"" + result + "\"" + "}";
					response.getWriter().print(json.toString());
				}
			}
	
		return null;
	}

	/*****
	 * 随访模板中显示随访项
	 * 
	 * @return
	 */
	public String standarTemplateFlupItem() {
		Map<String, Object> flupItemResponseMap = new HashMap<String, Object>();
		page.setParams(map);
		flupItemResponseMap.put("rows", flupGroupService
				.standerTemplateGroup(page));
		flupItemResponseMap.put("totalRecord", page.getTotalRecord());
		flupItemResponseMap.put("totalPage", page.getTotalPage());
		flupItemResponseMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(flupItemResponseMap);
		return null;
	}

	/******
	 * 
	 * 随访模板中右边显示东西
	 */
	public String rigthFlupItem() {
		Map<String, Object> flupItemResponseMap = new HashMap<String, Object>();
		page.setParams(map);
		flupItemResponseMap.put("rows", flupGroupService
				.rightStandTemplateItem(page));
		flupItemResponseMap.put("totalRecord", page.getTotalRecord());
		flupItemResponseMap.put("totalPage", page.getTotalPage());
		flupItemResponseMap.put("pageNo", page.getPageNo());
		
		JsonUtil.jsonData(flupItemResponseMap);
		return null;
	}

	public void updGroup() throws IOException {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			Employee e = (Employee) session.getAttribute("employee");
			flupGroup.setEmployeeCode(e.getJobnum());
			flupGroup.setGroupOnePy(CnToSpellUtil.getSpell(flupGroup
					.getGroupOne(), true));
			Map<String,String> checkMap=new HashMap<String,String>();
			checkMap.put("groupOne", flupGroup.getGroupOne());//I级
			checkMap.put("groupTwo", flupGroup.getGroupTwo());//II级
			checkMap.put("itemName", flupGroup.getItemName());//项目名称
			checkMap.put("recordType", flupGroup.getRecordType());//记录方式
			checkMap.put("itemRequired", flupGroup.getItemRequired());//文本情况
			int count=flupGroupService.checkFlupGroup(checkMap);
			String json = "";
					if(count>0){
						response = ServletActionContext.getResponse();
						json = "{\"ok\":" + "\"" + "2" + "\"" + "}";
						response.getWriter().print(json.toString());
					}else{
						Integer result = flupGroupService.update(flupGroup);
						if(result>=1){
						response = ServletActionContext.getResponse();
						json = "{\"ok\":" + "\"" + result + "\"" + "}";
						response.getWriter().print(json.toString());
						}
					}
			
		
	}

	public void delGroup() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flupGroupId", flupGroup.getFlupGroupId());
			Integer result = flupGroupService.delete(map);
			String json = "";
			if (result >= 1) {
				response = ServletActionContext.getResponse();
				json = "{\"ok\":" + "\"" + result + "\"" + "}";
				response.getWriter().print(json.toString());
			}
		} catch (Exception e) {
		}
	}

	public FlupGroupService getFlupGroupService() {
		return flupGroupService;
	}

	public void setFlupGroupService(FlupGroupService flupGroupService) {
		this.flupGroupService = flupGroupService;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public Object getModel() {
		return flupGroup;
	}

	@Override
	public void prepare() throws Exception {
		flupGroup = new FlupGroup();

	}

	public String getGroupOne() {
		return groupOne;
	}

	public void setGroupOne(String groupOne) {
		this.groupOne = groupOne;
	}

	public String getGroupTwo() {
		return groupTwo;
	}

	public void setGroupTwo(String groupTwo) {
		this.groupTwo = groupTwo;
	}

	public String getGroupThree() {
		return groupThree;
	}

	public void setGroupThree(String groupThree) {
		this.groupThree = groupThree;
	}

	public Page<FlupGroup> getPage() {
		return page;
	}

	public void setPage(Page<FlupGroup> page) {
		this.page = page;
	}

	public FlupGroup getFlupGroup() {
		return flupGroup;
	}

	public void setFlupGroup(FlupGroup flupGroup) {
		this.flupGroup = flupGroup;
	}

	public MobileFlupService getMobileFlupService() {
		return mobileFlupService;
	}

	public void setMobileFlupService(MobileFlupService mobileFlupService) {
		this.mobileFlupService = mobileFlupService;
	}

}
