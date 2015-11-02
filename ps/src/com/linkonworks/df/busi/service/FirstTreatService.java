package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.Check;
import com.linkonworks.df.vo.Inspect;
import com.linkonworks.df.vo.PatiOperate;

public interface FirstTreatService {
	
	public List<Map<String,String>> getPatiInfo(Map<String,Object> map);

	public List<Inspect> getInspectInfo(Map<String,String> map);
	
	public List<Check>  getCheckInfo(Map<String,String> map);
	
	public int  savePatiCase(Map<String,String> map);
	
	public PatiOperate findOperationInfo(Map<String,String> map);
}