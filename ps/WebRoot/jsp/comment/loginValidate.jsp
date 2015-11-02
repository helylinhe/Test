<%@ page language="java" import="java.util.*,com.linkonworks.df.vo.Employee" pageEncoding="UTF-8"%>
<%
	//判断所当前用户是否登录；
	String islogin = "0";
	Employee loginuser = (Employee)request.getSession().getAttribute("employee");
	if(loginuser!=null)
	{
		islogin="1";
	}
	
%>
<script type="text/javascript">

	$(function(){
		if("0"=='<%=islogin%>')
		{	
			window.top.location.href = '<%=request.getContextPath()%>/login.jsp';
		}
		
	});
</script>
