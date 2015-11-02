package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;


import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.InpatiDiagService;
import com.linkonworks.df.busi.utils.ActionUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.FlupItem;
import com.linkonworks.df.vo.InpatiDiag;
import com.opensymphony.xwork2.ActionSupport;

public class InpatiDiagAction extends ActionSupport {
	private static final long serialVersionUID = 3536834499505825783L;
	private InpatiDiagService inpatiDiagService;

	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Page<InpatiDiag> page = new Page<InpatiDiag>(); // 参数传递(pageSize

	public String queryPages() {
		page.setParams(map);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", inpatiDiagService.getPageInpati(page));
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
	
	public String loadPatiInfo(){
		InpatiDiag diag = inpatiDiagService.patiInfo(map);
		JSON json = JSONArray.fromObject(diag);
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
	//医嘱查询中个人信息查询
	public String doctoradvicequery(){
		List<Department> list =SessionData.getDepartmentCode();
		page.setParams(map);
		page.setList(list);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", inpatiDiagService.doctoradvice(page));
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

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Page<InpatiDiag> getPage() {
		return page;
	}

	public void setPage(Page<InpatiDiag> page) {
		this.page = page;
	}

	public InpatiDiagService getInpatiDiagService() {
		return inpatiDiagService;
	}

	public void setInpatiDiagService(InpatiDiagService inpatiDiagService) {
		this.inpatiDiagService = inpatiDiagService;
	}
}
