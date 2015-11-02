package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.User;


public interface FlupNameDictService {
	
	public List<FlupNameDict> getFlupNameDict(Page page);

	
	
	public List<FlupNameDict> findList(Map<String,String> map);

	
	public int savaFlupNameDict(FlupNameDict flupNameDict);
	
	public int updateFlupNameDict(FlupNameDict flupNameDict);
	
	public int updateState(FlupNameDict flupNameDict);
	
	public List<FlupNameDict> findByDeptCode(List list);

}
