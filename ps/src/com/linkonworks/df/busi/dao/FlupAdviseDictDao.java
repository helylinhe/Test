package com.linkonworks.df.busi.dao;

import java.util.List;

import com.linkonworks.df.vo.FlupAdviseDict;

public interface FlupAdviseDictDao extends BaseDao<FlupAdviseDict>{

	public List<FlupAdviseDict> getAll();
}
