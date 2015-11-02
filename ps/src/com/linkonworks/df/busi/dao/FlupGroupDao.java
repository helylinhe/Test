package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupItem;

public interface FlupGroupDao extends BaseDao<FlupGroup> {

	public List<FlupGroup> getAllFlupGroup();
	
	public List<FlupGroup> getAllFlupGroup2(Map<String, Object> map);
	
	public List<FlupGroup> getAllFlupGroup3(Map<String, Object> map);

	public List<FlupGroup> getGroupTwo(Map map);

	public int insert(FlupGroup flupGroup);
	
	public Integer insert(Map map) throws Exception;

	
	public List<FlupGroup> getPageGroups(Page page);
	
	
	public List<FlupGroup> getPageGroup(Map<String,Object> map);


	public List<FlupGroup> getFlupGroup(String flupNameId);

	
	
	public List<FlupGroup> standerTemplateGroup(Page page);
	
	public List<FlupGroup> rightStandTemplateItem(Page page);

	
	public int update(FlupGroup flupGroup);
	
	public int delete(Map<String,Object> map);
	
	public int updates(Map<String,Object> map);
	
	
	public List<FlupGroup> getPageGroupOne(Page page);
	
	
	public  int checkFlupGroup(Map<String,String> map);
	


}
