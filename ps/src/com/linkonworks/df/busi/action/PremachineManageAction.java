package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PremachineManageDao;
import com.linkonworks.df.busi.service.PremachineManageService;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.BlackList;
import com.linkonworks.df.vo.PremachineManage;
import com.opensymphony.xwork2.ActionSupport;

public class PremachineManageAction extends ActionSupport {

	PremachineManage manage;
public PremachineManage getManage() {
		return manage;
	}

	public void setManage(PremachineManage manage) {
		this.manage = manage;
	}
private PremachineManageService premachineManageService;

public PremachineManageService getPremachineManageService() {
	return premachineManageService;
}

public void setPremachineManageService(
		PremachineManageService premachineManageService) {
		this.premachineManageService = premachineManageService;
}
	private Page<PremachineManage> page = new Page<PremachineManage>();
	private Map<String,String> map = new HashMap<String,String>();
	
public Page<PremachineManage> getPage() {
		return page;
	}

	public void setPage(Page<PremachineManage> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

public String execute(){
	page.setParams(map);
	page.setList(SessionData.getDepartmentCode());
	Map<String,Object> userMap = new HashMap<String,Object>();
	userMap.put("rows",premachineManageService.getPageGroups(page));
	userMap.put("totalRecord",page.getTotalRecord());
	userMap.put("totalPage", page.getTotalPage());
	userMap.put("pageNo", page.getPageNo());
	JSON json=JSONArray.fromObject(userMap);
	HttpServletResponse response=ServletActionContext.getResponse();
	try {
		PrintWriter out=response.getWriter();
		out.print(json.toString());
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;

}
public String add(){
//	
//		manage.setMachine(manage.get("Machine"));
//		manage.setIpAddress(map.get("IpAddress"));
//		System.out.println(manage.getPort());
//		manage.setPort(Integer.parseInt(map.get("Port")));
//		manage.setState(Integer.parseInt(map.get("state")));
	int result=premachineManageService.addBlack(manage);
	HttpServletResponse response=ServletActionContext.getResponse();
	try {
		PrintWriter out=response.getWriter();
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		out.print(result);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public String updatepre(){
	int result=premachineManageService.updatestate(manage);
	HttpServletResponse response=ServletActionContext.getResponse();
	try {
		PrintWriter out=response.getWriter();
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		out.print(result);
	} catch (IOException e) {
		// TODO Auto-generated catch blocouk
		e.printStackTrace();
	}
	return null;

}
public String delete(){
	String id=manage.getId();
	int result=premachineManageService.deleteBlack(id);
	HttpServletResponse response=ServletActionContext.getResponse();
	try {
		PrintWriter out=response.getWriter();
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		out.print(result);
	} catch (IOException e) {
		// TODO Auto-generated catch blocouk
		e.printStackTrace();
	}
	return null;
}

}
