package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.InteBusi;
import com.linkonworks.df.vo.Interfactory;
import com.linkonworks.df.vo.PlatformTradelog;

public interface PlatformTradelogDao extends BaseDao<PlatformTradelog>{

	public List<InteBusi> getPageList(Page page);
	
	public List<Interfactory> getFactoryList();
	
	public List<InteBusi> getInteBusi();

	
	public int addInteBusi(InteBusi busi);
	
	public int updateInteBusi(Map<String,String> map);
	
	
	public int updateState(Map<String,String> map);

	
	public List<PlatformTradelog> searchPageList(Page page);
	
	public List<PlatformTradelog> findPageList(Page page);
	
	public List<PlatformTradelog> visitList(Page page);
	

	public List<Map<String,String>> pageImportPage(Page page);
	
	public List<PlatformTradelog> expecetionMessage();
	
	/*****
	 * call center 中心日志
	 */
	public List<Map<String,String>> pageCallCenterLog(Page page);
	

	public List<PlatformTradelog> findChart(Map<String, String> map);
	
	
	public List<InteBusi>  getBusi(Map<String,String> map);
	
	
	
	public List<Map<String,String>> getColums(Map<String,String> map);
	public List<Map<String,Object>> getTabelNameDetail(Page page);
	


}
