package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.0
 * 2014-07-07T16:10:24.237+08:00
 * Generated source version: 3.0.0
 * 
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "HospitalSMSSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface HospitalSMSSoap {

    /**
     * 发送短信的方法：SendSMS 参数名称：【systemName：系统名称】、【content：发送的内容】、【phoneNumber：手机号码，多个手机号码用逗号隔开】，返回短信结果的消息
     */
    @WebResult(name = "SendSMSResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "SendSMS", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SendSMS")
    @WebMethod(operationName = "SendSMS", action = "http://tempuri.org/SendSMS")
    @ResponseWrapper(localName = "SendSMSResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SendSMSResponse")
    public java.lang.String sendSMS(
        @WebParam(name = "systemName", targetNamespace = "http://tempuri.org/")
        java.lang.String systemName,
        @WebParam(name = "content", targetNamespace = "http://tempuri.org/")
        java.lang.String content,
        @WebParam(name = "phoneNumber", targetNamespace = "http://tempuri.org/")
        java.lang.String phoneNumber
    );
}
