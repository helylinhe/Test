package com.linkonworks.df.busi.dao;

import java.util.List;

import com.linkonworks.df.vo.NationDict;

public interface NationDictDao extends BaseDao<NationDict>{

	
	public List<NationDict> getAll();
}
