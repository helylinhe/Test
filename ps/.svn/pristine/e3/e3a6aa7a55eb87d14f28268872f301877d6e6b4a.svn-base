package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PatiFlupRuleDao;
import com.linkonworks.df.busi.service.PatiFlupRuleService;
import com.linkonworks.df.vo.PatiFlupRule;

public class PatiFlupRuleImpl implements PatiFlupRuleService{

	private PatiFlupRuleDao patiFlupRuleDao;
	
	
	public PatiFlupRuleDao getPatiFlupRuleDao() {
		return patiFlupRuleDao;
	}

	public void setPatiFlupRuleDao(PatiFlupRuleDao patiFlupRuleDao) {
		this.patiFlupRuleDao = patiFlupRuleDao;
	}

	@Override
	public List<PatiFlupRule> findPageList(Page page) {
		// TODO Auto-generated method stub
		return patiFlupRuleDao.findPageList(page);
	}

	@Override
	public int update(PatiFlupRule rule) {
		// TODO Auto-generated method stub
		return patiFlupRuleDao.update(rule);
	}

	@Override
	public PatiFlupRule flupRuleInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return patiFlupRuleDao.flupRuleInfo(map);
	}

	@Override
	public int update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return patiFlupRuleDao.update(map);
	}
	
	

}
