package com.linkonworks.df.busi.webservice.util;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	public AuthInterceptor() {
		super(Phase.PRE_INVOKE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		System.out.println(message);
		System.out.println("拦截器进来了。。。。。。。。。。");
	 	List<Header> headers=message.getHeaders();
	 	if(headers==null || headers.size()<1){
	 		System.out.println("调用失败");
	 		throw new Fault(new IllegalArgumentException("需要传用户名，密码"));
	 		
	 	}
	 	Header header=headers.get(0);
	 	Element element=(Element) header.getObject();
	 	NodeList userIds=element.getElementsByTagName("userId");
	 	NodeList passIds=element.getElementsByTagName("passId");
	 	String userId=userIds.item(0).getTextContent();
	 	String passId=passIds.item(0).getTextContent();
	 	if(!userId.equals("123") || !passId.equals("123")){
	 		throw new Fault(new IllegalArgumentException("用户名和密码格式不正确"));
	 	}
	}

	

}
