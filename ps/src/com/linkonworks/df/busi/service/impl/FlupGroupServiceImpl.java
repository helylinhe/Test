package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.FlupGroupDao;
import com.linkonworks.df.busi.service.FlupGroupService;
import com.linkonworks.df.vo.FlupGroup;

public class FlupGroupServiceImpl implements FlupGroupService {

	private FlupGroupDao flupGroupDao;

	@Override
	public List<FlupGroup> getAllFlupGroup() {
		// TODO Auto-generated method stub
		return flupGroupDao.getAllFlupGroup();
	}

	public FlupGroupDao getFlupGroupDao() {
		return flupGroupDao;
	}

	public void setFlupGroupDao(FlupGroupDao flupGroupDao) {
		this.flupGroupDao = flupGroupDao;
	}

	@Override
	public List<FlupGroup> getGroupTwo(Map map) {
		// TODO Auto-generated method stub
		return flupGroupDao.getGroupTwo(map);
	}


	@Override
	public List<FlupGroup> getFlupGroup(String flupNameId) {
		// TODO Auto-generated method stub
		return flupGroupDao.getFlupGroup(flupNameId);
	}
	

	@Override
	public Integer insert(FlupGroup flupGroup) {
		// TODO Auto-generated method stub
		return flupGroupDao.insert(flupGroup);
	}

	@Override
	public Integer insert(Map map) throws Exception {
		// TODO Auto-generated method stub
		return flupGroupDao.insert(map);
	}

	@Override
	public List<FlupGroup> getPageGroups(Page page) {
		return flupGroupDao.getPageGroups(page);
	}

	@Override
	public List<FlupGroup> getPageGroup(Map<String, Object> map) {
		return flupGroupDao.getPageGroup(map);
	}


	@Override
	public List<FlupGroup> standerTemplateGroup(Page page) {
		// TODO Auto-generated method stub
		return flupGroupDao.standerTemplateGroup(page);
	}


	@Override
	public int delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return flupGroupDao.delete(map);
	}

	@Override
	public int update(FlupGroup flupGroup) {
		// TODO Auto-generated method stub
		return flupGroupDao.update(flupGroup);
	}

	@Override
	public int updates(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return flupGroupDao.updates(map);
	}

	@Override
	public List<FlupGroup> rightStandTemplateItem(Page page) {
		// TODO Auto-generated method stub
		return flupGroupDao.rightStandTemplateItem(page);
	}

	@Override
	public List<FlupGroup> getPageGroupOne(Page page) {
		// TODO Auto-generated method stub
		return flupGroupDao.getPageGroupOne(page);
	}

	@Override
	public int checkFlupGroup(Map<String, String> map) {
		// TODO Auto-generated method stub
		return flupGroupDao.checkFlupGroup(map);
	}

	@Override
	public List<FlupGroup> getAllFlupGroup2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return flupGroupDao.getAllFlupGroup2(map);
	}

	@Override
	public List<FlupGroup> getAllFlupGroup3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return flupGroupDao.getAllFlupGroup3(map);
	}


}
