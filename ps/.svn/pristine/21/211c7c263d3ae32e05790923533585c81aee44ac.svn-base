package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.MobileFlup;



public interface ReportDataService {

	/**
	 * 获取报表数据
	 * @param param
	 * @return
	 */
	public HSSFWorkbook exportReportData(Map<String,Object> map);
	
	/****
	 * 获取列表数据
	 * @param page
	 * @return
	 */
	public List<Map<String,String>> pageList(Page<Object> page);
	
	
	/*****
	 * 获取随访模板下的随访项
	 */
	public List<FlupGroup> flupItems(String flupNameId);
	
	
	/****
	 * 
	 *获取科室下面的随访表
	 */
	public List<FlupNameDict> loadFlupNameDict(List<Department> d);
	
	
	
	
	
}
