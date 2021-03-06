package com.linkonworks.df.busi.service;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Employee;

public interface DepartmentService {

	public List<Department> getDepartment(Page page);

	public int updateDepartment(Department department);

	public int savaDepartment(Department department);
	

	public List<Department> queryAll();

	public List<Department> findById(List<String> list);
	
	
	public List<Department> getPageDepartment(Page page);
	
	public List<Department> queryAll2();
	
	
	public List<Department> getFlupDepartment(List<String> list);
}
