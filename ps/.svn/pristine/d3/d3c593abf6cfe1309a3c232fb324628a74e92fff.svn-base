package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupModule;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.MobileFlup;

public interface ReportDataDao {

	public List<Map<String,Object>> reportDate(Map<String,Object> map);
	
	
	public List<Map<String,String>> pageList(Page<Object> page);
	
	/*****
	 * 获取随访模板下的随访项
	 */
	public List<FlupGroup> flupItems(String flupNameId);
	
	
	public List<MobileFlup> findMobileItems(Map<String,String> map);
	
	public List<FlupNameDict> loadFlupNameDict(List<Department> d);
	
	
}
