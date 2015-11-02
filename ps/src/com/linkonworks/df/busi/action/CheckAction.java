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
import com.linkonworks.df.busi.service.CheckService;
import com.linkonworks.df.busi.utils.ActionUtil;
import com.linkonworks.df.vo.Check;
import com.opensymphony.xwork2.ActionSupport;

public class CheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8101343113638655132L;

	private CheckService checkService;

	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Page<Check> page = new Page<Check>(); // 参数传递(pageSize

	public String queryPages() {
		//ActionUtil.printParamsJSON();
		page.setParams(map);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", checkService.getPageCheck(page));
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

	public String queryPages2() {
		ActionUtil.printParamsJSON();
		page.setParams(map);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", checkService.getPageCheck(page));
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
	public CheckService getCheckService() {
		return checkService;
	}

	public void setCheckService(CheckService checkService) {
		this.checkService = checkService;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Page<Check> getPage() {
		return page;
	}

	public void setPage(Page<Check> page) {
		this.page = page;
	}

}
