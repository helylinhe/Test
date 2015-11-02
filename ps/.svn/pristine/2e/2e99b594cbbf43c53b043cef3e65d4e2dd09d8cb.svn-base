package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.CheckDao;
import com.linkonworks.df.busi.service.CheckService;
import com.linkonworks.df.vo.Check;

public class CheckServiceImpl implements CheckService {

	private CheckDao checkDao;

	@Override
	public List<Check> getPageCheck(Page page) {
		return checkDao.getPageCheck(page);
	}

	public CheckDao getCheckDao() {
		return checkDao;
	}

	public void setCheckDao(CheckDao checkDao) {
		this.checkDao = checkDao;
	}

}
