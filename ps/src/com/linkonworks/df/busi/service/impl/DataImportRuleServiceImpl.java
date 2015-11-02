package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.DataImportRuleDao;
import com.linkonworks.df.busi.service.DataImportRuleDaoService;
import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.DiagKnowledge;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.ImpruleDetail;

public class DataImportRuleServiceImpl implements DataImportRuleDaoService {
	
	private DataImportRuleDao dataImportRuleDao;

	public DataImportRuleDao getDataImportRuleDao() {
		return dataImportRuleDao;
	}

	public void setDataImportRuleDao(DataImportRuleDao dataImportRuleDao) {
		this.dataImportRuleDao = dataImportRuleDao;
	}

	@Override
	public List<Department> findAllDepartments() {
		// TODO Auto-generated method stub
		return dataImportRuleDao.findAllDepartments();
	}

	@Override
	public List<Dict> findDictByEchoSerial(String echo) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.findDictByEchoSerial(echo);
	}

	@Override
	public List<DataImportRule> findPageList(Page page) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.findPageList(page);
	}

	@Override
	public int insert(DataImportRule dataImportRule) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.insert(dataImportRule);
	}

	@Override
	public int update(DataImportRule dataImportRule) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.update(dataImportRule);
	}

	@Override
	public int updateDataImportRule(DataImportRule dataImportRule) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.updateDataImportRule(dataImportRule);
	}

	@Override
	public List<Employee> getEmployeesByeDeptCode(Department department) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.getEmployeesByeDeptCode(department);
	}

	@Override
	public List<FlupNameDict> findAllFulpNameDicts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.findAllFulpNameDicts(map);
	}

	@Override
	public int insertImpruleDetail(List<ImpruleDetail> list) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.insertImpruleDetail(list);
	}

	@Override
	public int deleteImpruleDetail(DataImportRule dataImportRule) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.deleteImpruleDetail(dataImportRule);
	}

	@Override
	public int insertImpruleDetailTow(List<ImpruleDetail> list) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.insertImpruleDetailTow(list);
	}

	@Override
	public List<ImpruleDetail> getDetailInfo(DataImportRule dataImportRule) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.getDetailInfo(dataImportRule);
	}

	@Override
	public List<DataImportRule> insertBoolean(DataImportRule dataImportRule) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.insertBoolean(dataImportRule);
	}

	@Override
	public List<Map<String, String>> loadDiagInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dataImportRuleDao.loadDiagInfo(map);
	}




	


}
