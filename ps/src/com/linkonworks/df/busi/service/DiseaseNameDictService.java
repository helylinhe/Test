package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DiagnosisDict;
import com.linkonworks.df.vo.DiseaseNameDict;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.User;


public interface DiseaseNameDictService {
	
	public List<DiseaseNameDict> getDiseaseNameDict(Page page);
	
	public int updateState(DiseaseNameDict diseaseNameDict);
	
	public int updateDiseaseNameDict(DiseaseNameDict diseaseNameDict);
	
	public int addDiseaseNameDict(DiseaseNameDict diseaseNameDict);
	
	//限制遍历重复添加
	public  int checkFlupGroup(DiseaseNameDict f);
	

}
