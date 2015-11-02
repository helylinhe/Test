package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;

public interface KetiReportDao {

	
	/****
	 * 列表展示
	 * @param page 分页
	 * @return 
	 */
	public List<Map<String,String>> pageList(Page<Object> page);
	
	
	/*****
	 * 报表导出
	 * @param map 
	 * @return
	 */
	public List<Map<String,Object>> reportDate(Map<String,Object> map);
	
}
