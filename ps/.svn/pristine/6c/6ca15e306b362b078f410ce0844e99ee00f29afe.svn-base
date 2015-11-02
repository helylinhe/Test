package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;

import com.linkonworks.df.busi.dao.FlupNameDictDao;
import com.linkonworks.df.busi.service.FlupNameDictService;
import com.linkonworks.df.vo.FlupNameDict;

public class FlupNameDictServiceImpl implements FlupNameDictService{

	private FlupNameDictDao flupNameDictDao;

	public void setFlupNameDictDao(FlupNameDictDao flupNameDictDao) {
		this.flupNameDictDao = flupNameDictDao;
	}


	public List<FlupNameDict> getFlupNameDict(Page page) {
		
		return flupNameDictDao.getFlupNameDict(page);
	}


	public int savaFlupNameDict(FlupNameDict flupNameDict) {
		return flupNameDictDao.savaFlupNameDict(flupNameDict);
	}


	
	public List<FlupNameDict> findList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return flupNameDictDao.findList(map);
	}


	public FlupNameDictDao getFlupNameDictDao() {
		return flupNameDictDao;
	}


	public int updateFlupNameDict(FlupNameDict flupNameDict) {
		
		return flupNameDictDao.updateFlupNameDict(flupNameDict);
	}


	@Override
	public int updateState(FlupNameDict flupNameDict) {
		// TODO Auto-generated method stub
		return flupNameDictDao.updateState(flupNameDict);
	}


	@Override
	public List<FlupNameDict> findByDeptCode(List list) {
		// TODO Auto-generated method stub
		return flupNameDictDao.findByDeptCode(list);
	}


	


	








}
