package com.linkonworks.df.busi.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.FlupAdviseDictService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.vo.FlupAdviseDict;
import com.opensymphony.xwork2.ActionSupport;

public class FlupAdviseDictAction extends ActionSupport {

	private Page<FlupAdviseDict>  page=new Page<FlupAdviseDict>();
	private FlupAdviseDictService flupAdviseDictService;
	
	
	public String findAll(){
		Map map=new HashMap();
		List<FlupAdviseDict> list=flupAdviseDictService.getAll();
		map.put("rows", list);
		JsonUtil.jsonData(map);
		return null;
	}


	public FlupAdviseDictService getFlupAdviseDictService() {
		return flupAdviseDictService;
	}


	public void setFlupAdviseDictService(FlupAdviseDictService flupAdviseDictService) {
		this.flupAdviseDictService = flupAdviseDictService;
	}


	public Page<FlupAdviseDict> getPage() {
		return page;
	}


	public void setPage(Page<FlupAdviseDict> page) {
		this.page = page;
	}
	
	
	
}
