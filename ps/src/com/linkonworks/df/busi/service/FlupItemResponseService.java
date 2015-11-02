package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupItemResponse;

public interface FlupItemResponseService {
	
	public List<FlupItemResponse> findPageList(Page page);
	
	public List<FlupItemResponse> findFlupItemPage(Map<String,Object> map);
	
	public List<FlupItemResponse> findPreview(String flupNameId);
	
	public List<FlupItemResponse> findPreviews(Map<String, String> map);
	
	public int insertBatch(List<FlupItemResponse> list);
	
	
	public int insert(FlupItemResponse r);
	
	
	public List<FlupGroup> findFirst(String flupNameId);
	
	public List<FlupItemResponse> findSecond(String groupName);
	
	
	public List<FlupItemResponse> getFlupItemResponseList(String flupNameId);
	
	
	public int updateUseState(List list);
	
	
	public int updateNormalUseState(List list);
	
	
	public List<FlupItemResponse> getFlupItems(String flupNameId);
	
	public int deleteFlupItemResponse(String flupName) ;
}
