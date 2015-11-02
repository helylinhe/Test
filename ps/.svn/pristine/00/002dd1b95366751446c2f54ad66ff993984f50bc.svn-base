package com.linkonworks.df.busi.service.impl;


import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.ReturnTaskDao;
import com.linkonworks.df.busi.service.ReturnTaskService;
import com.linkonworks.df.vo.FlupModule;
import com.linkonworks.df.vo.ReturnMessage;
import com.linkonworks.df.vo.ReturnTask;

public class ReturnTaskServiceImpl implements ReturnTaskService {
	private ReturnTaskDao returnTaskDao;

	public ReturnTaskDao getReturnTaskDao() {
		return returnTaskDao;
	}

	public void setReturnTaskDao(ReturnTaskDao returnTaskDao) {
		this.returnTaskDao = returnTaskDao;
	}

	@Override
	public List<ReturnTask> findPageList(Page page) {
		// TODO Auto-generated method stub
		return returnTaskDao.findPageList(page);
	}

	@Override
	public List<FlupModule> findFlupModule(FlupModule flupModule) {
		// TODO Auto-generated method stub
		return returnTaskDao.findFlupModule(flupModule);
	}


	@Override
	public int updateMessage(ReturnMessage returnMessage) {
		// TODO Auto-generated method stub
		return returnTaskDao.updateMessage(returnMessage);
	}

	


}
