package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupDynamic;
import com.linkonworks.df.vo.FlupItemResponse;

public interface FlupDynamicDao extends BaseDao<FlupDynamic>{
	
	//根据随病人编号、住院号、流水号获取该病人随访表的所有随访项随访项
	public List<FlupItemResponse> findAllFlupDynamic(Map<String,String> map);
	//添加随访项
	public void addFlupDynamic(Map<String,String> map);
	//根据条件删除随访项
	public void removeFlupDynamic(Map<String,String> map);
	
	public List<FlupItemResponse> dynamicFlupItems(Map<String,String> map);
	
	
	
	
}
