package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PatiReturnRuleDao;
import com.linkonworks.df.busi.service.PatiReturnRuleService;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.PatiReturnRule;
import com.linkonworks.df.vo.RetdayDetail;

public class PatiReturnRuleServiceImpl implements PatiReturnRuleService {
	
	private PatiReturnRuleDao patiReturnRuleDao;

	public PatiReturnRuleDao getPatiReturnRuleDao() {
		return patiReturnRuleDao;
	}

	public void setPatiReturnRuleDao(PatiReturnRuleDao patiReturnRuleDao) {
		this.patiReturnRuleDao = patiReturnRuleDao;
	}

	@Override
	public int insert(PatiReturnRule t) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.insert(t);
	}

	@Override
	public int insertDetail(List<RetdayDetail> t) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.insertDetail(t);
	}

	@Override
	public int insertDetail2(RetdayDetail t) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.insertDetail2(t);
	}

	@Override
	public List<PatiReturnRule> findPageList(Page page) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.findPageList(page);
	}

	@Override
	public List<RetdayDetail> getReRetdayDetails(RetdayDetail re) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.getReRetdayDetails(re);
	}

	@Override
	public List<Department> getDepartment(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.getDepartment(map);
	}

	@Override
	public int update(PatiReturnRule t) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.update(t);
	}

	@Override
	public int deleteDetails(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.deleteDetails(map);
	}

	@Override
	public int insertDetailHasId(List<RetdayDetail> t) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.insertDetailHasId(t);
	}

	@Override
	public int updateRule(String[] arr) {
		// TODO Auto-generated method stub
		return patiReturnRuleDao.updateRule(arr);
	}

	


}
