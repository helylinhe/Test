package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.DepartmentDao;
import com.linkonworks.df.busi.service.DepartmentService;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Employee;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> getDepartment(Page page) {
		// TODO Auto-generated method stub
		return departmentDao.getDepartment(page);
	}

	@Override
	public int updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.updateDepartment(department);
	}

	@Override
	public int savaDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.savaDepartment(department);
	}

	@Override
	public List<Department> queryAll() {
		return departmentDao.queryAll();
	}

	@Override
	public List<Department> findById(List<String> list) {
		// TODO Auto-generated method stub
		return departmentDao.findById(list);
	}

	@Override
	public List<Department> getPageDepartment(Page page) {
		// TODO Auto-generated method stub
		return departmentDao.getPageDepartment(page);
	}

	@Override
	public List<Department> queryAll2() {
		// TODO Auto-generated method stub
		return departmentDao.queryAll2();
	}

	@Override
	public List<Department> getFlupDepartment(List<String> list) {
		// TODO Auto-generated method stub
		return departmentDao.getFlupDepartment(list);
	}

}
