package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.PatiReturnRule;
import com.linkonworks.df.vo.RetdayDetail;


public interface PatiReturnRuleDao extends BaseDao<PatiReturnRule> {
	@Override
	public int insert(PatiReturnRule t);
	public int insertDetail(List<RetdayDetail> t);
	
	public int insertDetail2(RetdayDetail t);//测试用
	
	public List<PatiReturnRule> findPageList(Page page);
	
	public List<RetdayDetail> getReRetdayDetails(RetdayDetail re);
	
	public List<Department> getDepartment(Map<String , Object> map);
	
	public int update(PatiReturnRule t);
	
	public int deleteDetails(Map<String, Object> map);
	
	public int insertDetailHasId(List<RetdayDetail> t);
	
	public int updateRule(String [] arr);
	
}
