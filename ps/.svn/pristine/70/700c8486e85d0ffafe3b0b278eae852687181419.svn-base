package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.BlackListDao;
import com.linkonworks.df.busi.dao.FlupNameDictDao;
import com.linkonworks.df.busi.service.BlackListDaoService;
import com.linkonworks.df.vo.BlackList;

public class BlackListDaoServiceImpl implements BlackListDaoService {

	

	private BlackListDao blackListDao;




	public void setBlackListDao(BlackListDao blackListDao) {
		this.blackListDao = blackListDao;
	}




	public List<BlackList> getBlackList(Page page) {
		
		return blackListDao.getBlackList(page);
	}






	

}
