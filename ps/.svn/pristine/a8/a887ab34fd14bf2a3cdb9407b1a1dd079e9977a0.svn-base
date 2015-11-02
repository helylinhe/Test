package com.linkonworks.df.busi.utils;

import org.tempuri.MobileWard;
import org.tempuri.MobileWardSoap;

public class MobileWardUtil {

	public static String getPatiFileInfo(String patiSerial,String inpatiSerialNumber,String fileNo,String unitCode){
		if(unitCode!=null  && unitCode.equals("2")){
			MobileWard mw=new MobileWard();
			MobileWardSoap m=mw.getMobileWardSoap();
			String str=m.getPatientFilePath(patiSerial, inpatiSerialNumber, fileNo);
			return str;
		}else{
			return null;
		}
	}
}
