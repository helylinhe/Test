package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.InspectDao;
import com.linkonworks.df.busi.service.InspectService;
import com.linkonworks.df.vo.Inspect;

public class InspectServiceImpl implements InspectService {
	private InspectDao inspectDao;

	@Override
	public List<Inspect> getPageInspect(Page page) {
		return inspectDao.getPageInspect(page);
	}

	public InspectDao getInspectDao() {
		return inspectDao;
	}

	public void setInspectDao(InspectDao inspectDao) {
		this.inspectDao = inspectDao;
	}

	@Override
	public List<Inspect> getInspects(Page page) {
		// TODO Auto-generated method stub
		return inspectDao.getInspects(page);
	}

	@Override
	public List<Inspect> getInspectsDetail(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return inspectDao.getInspectsDetail(map);
	}

	@Override
	public List<Inspect> getHighChars(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return inspectDao.getHighChars(map);
	}

	@Override
	public List<Map<String, String>> printFlupName(Map<String, Object> map) {
		// TODO Auto-generated method stub
		inspectDao.printFlupName(map);
		return (List<Map<String, String>>) map.get("someList");
	}

	

}