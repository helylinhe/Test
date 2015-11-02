package com.linkonworks.df.busi.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;




public  class CollectionUtil {
	
	public static Logger logger = Logger.getLogger(CollectionUtil.class);
	
	public Map ListToMap(List list){
		Map map =new HashMap();
		if(list!=null){
			for(int i=0;i<list.size();i++){
				Object obj[]=(Object[])list.get(i);
				map.put(obj[0]+"", obj[1]);
			}
		}
		return map;
	}
	
	public static boolean checkNull(String str){
		if(str!=null && !"".equals(str) && !"null".equals(str) && str !="" && !str.equals(null) && str != "null"){
			return true;
		}
		return false;
	}
	
	public  static  String getScale(String s1,String s2){
		Float l1=Float.parseFloat(s1);
		Float l2=Float.parseFloat(s2);
		String Rate=(new DecimalFormat("###,###,###.##").format(l1/l2*100))+"%";
		return Rate;
	}

	
	
}
