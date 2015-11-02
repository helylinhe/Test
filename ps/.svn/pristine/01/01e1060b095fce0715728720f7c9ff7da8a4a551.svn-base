package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DeptFlupCount;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.HospitalConfig;
import com.linkonworks.df.vo.LoginLog;

public interface EmployeeService {
	public List<Employee> getPageEmp(Page page);
	
	public int insert(Employee employee);
	
	public Employee login(Employee e);
	
	public int loginInfo(LoginLog loginLog);
	
	public Employee checkJobnum(Map<String,Object> map);
	
	public int update(Employee employee);
	
	/**
	 * 修改密码
	 */
	public int updatePwd(Employee employee);
	//重置密码
	public int updatePwdAll(String[] arr);
//修改密码
	
	public List<DeptFlupCount> getDeptFlupCount(Page page);
	
	public List<DeptFlupCount> getDeptFlupCountBydept(Page page);
	
	public List<DeptFlupCount> findChart(Map map);
	
	
	public List<DeptFlupCount> findFlupNameChart(Map map);
	
	/****
	 * 获取院区
	 * @param list
	 * @return
	 */
	public List<HospitalConfig> getHosptialConfig(List list);
	
}
