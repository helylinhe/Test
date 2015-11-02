package com.linkonworks.df.busi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.vo.Employee;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String url=request.getRequestURL().toString();
		String method=url.substring(url.indexOf("!")+1);
		if(!("login.action").equals(method)){
			Employee employee=(Employee) session.getAttribute("employee");
			if(employee!=null && !employee.equals("")){
				return invocation.invoke();
			}
			return Action.LOGIN;
		}else{
			return invocation.invoke();
		}*/
		return invocation.invoke();
	}

}
