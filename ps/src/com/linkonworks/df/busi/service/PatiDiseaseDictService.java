package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DiseaseNameDict;
import com.linkonworks.df.vo.InpatiDiag;
import com.linkonworks.df.vo.PatiDiseaseDetail;
import com.linkonworks.df.vo.PatiDiseaseDict;

public interface PatiDiseaseDictService {
	public List<PatiDiseaseDict> findPageList(Page page);
	
	
	
	public List<DiseaseNameDict> findDiseaseNameDict(Map<String, Object> map);
	
	public int insert(PatiDiseaseDict patiDiseaseDict);
	
	public int delete(String[] arr);
	
	public List<PatiDiseaseDetail> findDate(PatiDiseaseDetail patiDiseaseDetail);
}
