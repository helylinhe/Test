package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.linkonworks.df.busi.comment.Page;

public interface KetiReportService {

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
}
