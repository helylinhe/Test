package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.LoginLog;
import com.linkonworks.df.vo.*;

public interface EmployeeDao extends BaseDao<Employee> {
	public Employee login(Employee e);

	public List<Employee> getPageEmp(Page page);

	public int insert(Employee employee);

	public int loginInfo(LoginLog loginLog);

	public Employee checkJobnum(Map<String, Object> map);

	public int update(Employee employee);
	
	
	/**
	 * 修改密码
	 */
	public int updatePwd(Employee employee);
	//重置密码
	public int updatePwdAll(String[] arr);
	
	public List<DeptFlupCount> getDeptFlupCount(Page page);
	
	public List<DeptFlupCount> getDeptFlupCountBydept(Page page);

	public List<HospitalConfig> getHosptialConfig(List list);

	public List<DeptFlupCount> findCharts(Map map);
	
	
	/****
	 * 加载随访表的统计信息
	 */
	public List<DeptFlupCount> findFlupNameChart(Map map);
	
	/****
	 * 加载科室下面的医生
	 */
	//public List<Employee> loadDeptEmployee(List<Department> list);
	
	
}
