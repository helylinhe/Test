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
import com.linkonworks.df.busi.service.PatiOperateService;
import com.linkonworks.df.vo.PatiOperate;
import com.opensymphony.xwork2.ActionSupport;

public class PatiOperateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1805958365276814216L;

	private PatiOperateService patiOperateService;
	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Page<PatiOperate> page = new Page<PatiOperate>(); // 参数传递(pageSize

	public String queryPages() {
		page.setParams(map);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", patiOperateService.getPageOper(page));
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

	public Page<PatiOperate> getPage() {
		return page;
	}

	public void setPage(Page<PatiOperate> page) {
		this.page = page;
	}

	public PatiOperateService getPatiOperateService() {
		return patiOperateService;
	}

	public void setPatiOperateService(PatiOperateService patiOperateService) {
		this.patiOperateService = patiOperateService;
	}

}
