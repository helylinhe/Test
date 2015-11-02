package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.PatiFlupRule;

public interface PatiFlupRuleDao extends BaseDao<PatiFlupRule>{

	
	public PatiFlupRule flupRuleInfo(Map<String,String> map);
	
	public int update(Map<String,Object> map);
}
