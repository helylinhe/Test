package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.FlupItemService;
import com.linkonworks.df.busi.utils.ActionUtil;
import com.linkonworks.df.busi.utils.CnToSpellUtil;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupItem;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class FlupItemAction extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6278745979337887735L;

	private FlupItemService flupItemService;
	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Page<FlupItem> page = new Page<FlupItem>(); // 参数传递(pageSize
	// pageNumber)
	private FlupItem flupItem;


	public String queryPages() {
		page.setParams(map);
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("rows", flupItemService.getPageFlupItem(page));
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

	public String addItem() {
		ActionUtil.printParamsJSON();
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = ServletActionContext.getRequest().getSession();
			Employee e=(Employee) session.getAttribute("employee");
			flupItem.setEmployeeCode(e.getJobnum());
			flupItem.setDiagCode(CnToSpellUtil.getSpell(flupItem.getDiagName(),
					true));
			int result = 0;
			if ("".equals(flupItem.getFlupItemCode())) {
				result = flupItemService.insert(flupItem);
			} else {
				result = flupItemService.update(flupItem);
			}
			System.out.println(result);
			String json = "";
			if (result ==1) {
				json = "{\"ok\":" + "\"" + result + "\"" + "}";
				response.getWriter().print(json.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String deleteItem() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flupItemCode", flupItem.getFlupItemCode());
			Integer result = flupItemService.delete(map);
			if (result == 1) {
				HttpServletResponse response = ServletActionContext
						.getResponse();
				PrintWriter out = response.getWriter();
				out.print("ok");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Page<FlupItem> getPage() {
		return page;
	}

	public void setPage(Page<FlupItem> page) {
		this.page = page;
	}

	public FlupItemService getFlupItemService() {
		return flupItemService;
	}

	public void setFlupItemService(FlupItemService flupItemService) {
		this.flupItemService = flupItemService;
	}

	public FlupItem getFlupItem() {
		return flupItem;
	}

	public void setFlupItem(FlupItem flupItem) {
		this.flupItem = flupItem;
	}
}
