package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.ImpruleDetail;

public interface DataImportRuleDao extends BaseDao<DataImportRule>{
	
	//获取所有的放随访表名称
	List<FlupNameDict> findAllFulpNameDicts(Map<String, Object> map);
	//获取所有的科室
	List<Department> findAllDepartments();
	//根据类型获取dict
	List<Dict> findDictByEchoSerial(String echo);
	//修改导入规则的停用状态
	int updateDataImportRule(DataImportRule dataImportRule);
	//根据科室获取对应的员工
	List<Employee> getEmployeesByeDeptCode(Department department);
	
	int insertImpruleDetail(List<ImpruleDetail> list);
	
	int deleteImpruleDetail(DataImportRule dataImportRule);
	
	int insertImpruleDetailTow(List<ImpruleDetail> list);
	
	List<ImpruleDetail> getDetailInfo(DataImportRule dataImportRule);
	
	List<DataImportRule> insertBoolean(DataImportRule dataImportRule);
	
	/****
	 * 加载随访表下的诊断组
	 */
	public List<Map<String,String>> loadDiagInfo(Map<String,String> map);
}
