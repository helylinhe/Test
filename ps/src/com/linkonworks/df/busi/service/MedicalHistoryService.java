package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.DiagGroup;
import com.linkonworks.df.vo.MedicalHistory;

public interface MedicalHistoryService {

	public List<DiagGroup> findIcd1O(Map<String,String> map);
	
	public int insert(MedicalHistory mh);
}
