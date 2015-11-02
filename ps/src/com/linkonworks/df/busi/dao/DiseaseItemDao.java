package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DiseaseItem;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupItem;

public interface DiseaseItemDao extends BaseDao<DiseaseItem> {
	public List<DiseaseItem> getPageDisease(Page page);

	public int insert(DiseaseItem diseaseItem);

	public Integer delete(Map<String, Object> map) throws Exception;

	public int update(DiseaseItem diseaseItem);

	public List<DiseaseItem> getPageGroupOne(Page page);
	
	public int checkDiseaseItem(Map<String,String> map);
}