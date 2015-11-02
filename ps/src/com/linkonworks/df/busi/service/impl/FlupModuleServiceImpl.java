package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.FlupModuleDao;
import com.linkonworks.df.busi.service.FlupModuleService;
import com.linkonworks.df.vo.FlupModule;

public class FlupModuleServiceImpl implements FlupModuleService {

	private FlupModuleDao flupModuleDao;
	
	public void setFlupModuleDao(FlupModuleDao flupModuleDao) {
		this.flupModuleDao = flupModuleDao;
	}

	public List<FlupModule> getFlupModule(Page page) {
		return flupModuleDao.getFlupModule(page);
	}

	public int savaFlupModule(FlupModule flupModule) {
		return flupModuleDao.savaFlupModule(flupModule);
	}

	public int updateFlupModule(FlupModule flupModule) {
		// TODO Auto-generated method stub
		return flupModuleDao.updateFlupModule(flupModule);
	}

}
