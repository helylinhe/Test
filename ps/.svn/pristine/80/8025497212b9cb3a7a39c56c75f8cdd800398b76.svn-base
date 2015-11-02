package com.linkonworks.df.busi.service.impl;

import com.linkonworks.df.busi.dao.PrivsDao;
import com.linkonworks.df.busi.service.PrivsService;
import com.linkonworks.df.vo.Privs;

public class PrivsServiceImpl implements PrivsService{

	private PrivsDao privsDao;
	
	@Override
	public Privs getPrivsByMenuCode(String menuCode) {
		// TODO Auto-generated method stub
		return privsDao.getPrivsByMenuCode(menuCode);
	}

	public PrivsDao getPrivsDao() {
		return privsDao;
	}

	public void setPrivsDao(PrivsDao privsDao) {
		this.privsDao = privsDao;
	}

	@Override
	public int insert(Privs p) {
		// TODO Auto-generated method stub
		return privsDao.insert(p);
	}

	
	
}
