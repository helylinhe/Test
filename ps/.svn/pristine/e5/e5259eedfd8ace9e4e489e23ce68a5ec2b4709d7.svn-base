package com.linkonworks.df.busi.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.Employee;

public class SessionData {
	
	
	
	/**
	 * 获得南北院的复诊科室
	 * @param diagCode
	 * @return
	 */
	public static final synchronized List<Department> getDepartment(final String diagCode,final String diagName){
			try {
				List<Department> result = new ArrayList<Department>();
				List<Department> Department = (List<Department>) ServletActionContext.getRequest().getSession().getAttribute("epartmentAll2");
				if(CollectionUtil.checkNull(diagCode)){
					for (int i = 0; i < Department.size(); i++) {
						if(Department.get(i).getUnitCode().trim().equals(diagCode) && (Department.get(i).getDeptName().trim().contains(diagName) || Department.get(i).getInputCode().trim().contains(diagName.toUpperCase()))){
							Department d = new Department();
							d.setDeptCode(Department.get(i).getDeptCode());
							d.setDeptName(Department.get(i).getDeptName());
							result.add(d);
						}
					}
				}
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	
	/**
	 * 从登陆中获得Session当中的数据=============>>dict表
	 * @param session
	 * @param id
	 * @return
	 */
	public static final List<Dict> getSessionDict(HttpSession session,String codeType){
		List<Dict> result = new ArrayList<Dict>();
		List<Dict> dict = (List<Dict>) session.getAttribute(FinalUtil.DICTTABLE);
		if(CollectionUtil.checkNull(codeType)){
							Dict d1 = new Dict();
							d1.setName("不限");
							d1.setCode("");
							result.add(0,d1);
					for (int i = 0; i < dict.size(); i++) {
					
						if(dict.get(i).getCodeType().equalsIgnoreCase(codeType.trim())){
							Dict d = new Dict();
							d.setName(dict.get(i).getName());
							d.setCode(dict.get(i).getCode());
							result.add(d);
						}
					}
		}
		return result;
		
	}
	/**
	 * 获取医生工号
	 * @return
	 */
	public static  String getEmployeeCode(){Employee e = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");return e.getJobnum();}
	/**
	 * 获取医生名字
	 * @return
	 */
	public static  String getEmployeeName(){Employee e = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");return e.getName();}
	
	/**
	 * 获取当前用户所拥有的科室
	 * @return
	 */
	public static List<Department> getDepartmentCode(){return (List<Department>)ServletActionContext.getRequest().getSession().getAttribute("departmentTable");}
	
	
	/**
	 * 获取当前用户对应的角色
	 * @return
	 */
	public static  String getRoleName(){Employee e = (Employee) ServletActionContext.getRequest().getSession().getAttribute("employee");return e.getRoleName();}
	
	
	

}
