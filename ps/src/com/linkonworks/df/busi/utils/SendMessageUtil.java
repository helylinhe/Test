package com.linkonworks.df.busi.utils;

import org.tempuri.HospitalSMS;

public class SendMessageUtil {
	public static String sendMessage(String systemName,String content,String phoneNumber){
		HospitalSMS sms=new HospitalSMS();
		org.tempuri.HospitalSMSSoap s=sms.getHospitalSMSSoap();
		String str=s.sendSMS(systemName, content,phoneNumber);
		return str;
		
	}
}
