package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.DiagKnowledge;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.ImpruleDetail;

public interface DataImportRuleDaoService {
	
	public List<DataImportRule> findPageList(Page page);
	//获取所有的放随访表名称
	List<FlupNameDict> findAllFulpNameDicts(Map<String, Object> map);
	//获取所有的科室
	List<Department> findAllDepartments();
	//根据类型获取dict
	List<Dict> findDictByEchoSerial(String echo);
	//新增规则
	public int insert(DataImportRule dataImportRule);
	//修改规则
	public int update(DataImportRule dataImportRule);
	//修改停用状态
	public int updateDataImportRule(DataImportRule dataImportRule);
	
	//根据科室获取对应的员工
	public	List<Employee> getEmployeesByeDeptCode(Department department);
	
	int insertImpruleDetail(List<ImpruleDetail> list);
	
	int insertImpruleDetailTow(List<ImpruleDetail> list);
	
	int deleteImpruleDetail(DataImportRule dataImportRule);
	
	List<ImpruleDetail> getDetailInfo(DataImportRule dataImportRule);
	
	List<DataImportRule> insertBoolean(DataImportRule dataImportRule);
	
	/****
	 * 加载随访表下的诊断组
	 */
	public List<Map<String,String>> loadDiagInfo(Map<String,String> map);
}
