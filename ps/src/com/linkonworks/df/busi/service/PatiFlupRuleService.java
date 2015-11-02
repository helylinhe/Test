package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.PatiFlupRule;

public interface PatiFlupRuleService {

	public List<PatiFlupRule> findPageList(Page page);
	
	public int update(PatiFlupRule rule);
	
	public PatiFlupRule flupRuleInfo(Map<String,String> map);
	
	public int update(Map<String,Object> map);
}
