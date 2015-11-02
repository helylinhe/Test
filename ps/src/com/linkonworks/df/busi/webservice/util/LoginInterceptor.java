package com.linkonworks.df.busi.webservice.util;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.namespace.QName; 

public class LoginInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	private String userId;  
    private String userPass;  
      
    public LoginInterceptor(String userId, String userPass) {  
        super(Phase.PREPARE_SEND);  
        this.userId = userId;  
        this.userPass = userPass;  
    }  
  
    @Override  
    public void handleMessage(SoapMessage msg) throws Fault {  
          
        List<Header> headers = msg.getHeaders();  
        //创建Document对象  
        Document doc = DOMUtils.createDocument();  
        Element ele = doc.createElement("authHeader");  
        //配置服务器端Head信息的用户密码  
        Element eleId= doc.createElement("userId");  
        eleId.setTextContent(userId);  
        Element elePass = doc.createElement("userPass");  
        elePass.setTextContent(userPass);  
          
        ele.appendChild(eleId);  
        ele.appendChild(elePass);  
        /** 
         * 生成的XML文档 
         * <authHeader> 
         *      <userId>lzw</userId> 
         *      <userPass>123456</userPass> 
         * </authHeader> 
         */  
        headers.add(new Header(new QName(""), ele));  
    }  

	

}
