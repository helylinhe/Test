package com.linkonworks.df.busi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.EmployeeDao;
import com.linkonworks.df.busi.service.EmployeeService;
import com.linkonworks.df.vo.DeptFlupCount;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.HospitalConfig;
import com.linkonworks.df.vo.LoginLog;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getPageEmp(Page page) {
		return employeeDao.getPageEmp(page);
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public int insert(Employee employee) {
		return employeeDao.insert(employee);
	}
	
	@Override
	public Employee login(Employee e) {
		// TODO Auto-generated method stub
		return employeeDao.login(e);
	}

	@Override
	public int loginInfo(LoginLog loginLog) {
		// TODO Auto-generated method stub
		return employeeDao.loginInfo(loginLog);
	}

	public Employee checkJobnum(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return employeeDao.checkJobnum(map);
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.update(employee);
	}

	@Override
	public int updatePwd(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updatePwd(employee);
	}

	@Override
	public int updatePwdAll(String[] arr) {
		// TODO Auto-generated method stub
		return employeeDao.updatePwdAll(arr);
	}

	@Override
	public List<DeptFlupCount> getDeptFlupCount(Page page) {
		List<DeptFlupCount> list= new ArrayList<DeptFlupCount>();
		try {
			list=employeeDao.getDeptFlupCount(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<DeptFlupCount> getDeptFlupCountBydept(Page page) {
		// TODO Auto-generated method stub
		return employeeDao.getDeptFlupCountBydept(page);
	}

	@Override
	public List<HospitalConfig> getHosptialConfig(List list) {
		return employeeDao.getHosptialConfig(list);
	}

	@Override
	public List<DeptFlupCount> findChart(Map map) {
		List<DeptFlupCount> list= new ArrayList<DeptFlupCount>();
		try {
			list=employeeDao.findCharts(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<DeptFlupCount> findFlupNameChart(Map map) {
		// TODO Auto-generated method stub
		return employeeDao.findFlupNameChart(map);
	}

	

	

}
