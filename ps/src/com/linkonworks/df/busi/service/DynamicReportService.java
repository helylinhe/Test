package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.ExportResponse;
import com.linkonworks.df.vo.ReportName;

public interface DynamicReportService {

	public List<Map<String,String>> pageReportItems(Page page);
	
	
	public List<ReportName> findReportName(List<Department> list);
	
	/****
	 * 预览数据
	 * @param tableNameId
	 * @return
	 */
	public List<ExportResponse> findViewReportItems(String tableNameId);
	
	public int insertBatch(List<ExportResponse> list);
	
	public int deleteBatch(String tableNameId);
	
	
	public List<ExportResponse> getReportItems(String deptCode);
	
	public List<Map<String,String>> findReportItems(Page page);

	
	/******
	 * 加载报表项维护右侧数据
	 * @param map
	 * @return
	 */
	public List<Map<String,String>> findRightReporItems(Map<String,String> map);
	
	/****
	 * 动态SQL
	 * @param map
	 * @return
	 */
	public String getDynamicSql(Map<String,String> map);

	
	/*****
	 * 
	 * 动态SQL（用MYBATIS内存分页）
	 */
	public List<Map<String,String>> dynamicPageData(Map<String,String> map);
	
	
	/****
	 * 
	 * 动态报表
	 */
	public HSSFWorkbook exportReportData(Map<String,String> map);
	
	
	/****
	 * 获取报表名称id
	 * 
	 */
	public List<Map<String,String>> getReportName(String deptCode);
	
	/*****
	 * 加载检验检查大类项
	 */
	public List<Map<String,String>> loadInspectCheck(Map<String,Object> param);
	
	/***
	 * 加载大项下面的指标项
	 * @param map
	 * @return
	 */
	public List<Map<String,String>> loadReportItems(Map<String,String> map);
	
	
	
/**------------------------------------------------------------------------------*/
	public List<Map<String,String>> pageReport(Page page);
/**-------------------------------------------------------------------------------*/	
	public void editReport(ReportName reportName);
	/**-----------------------updateStatus----------------------------------*/
	public void editStatus(ReportName reportName);
/**-------------------------------------------------------------------------------*/	
	public void addReport(ReportName reportName);
	//判断是否有重复
	public List<ReportName> toSearch(ReportName reportName);

}
