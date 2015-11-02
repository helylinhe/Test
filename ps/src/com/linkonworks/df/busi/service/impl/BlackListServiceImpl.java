package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.BlackListDao;
import com.linkonworks.df.busi.dao.FlupNameDictDao;
import com.linkonworks.df.busi.service.BlackListService;
import com.linkonworks.df.vo.BlackList;

public class BlackListServiceImpl implements BlackListService {

	

	private BlackListDao blackListDao;




	public void setBlackListDao(BlackListDao blackListDao) {
		this.blackListDao = blackListDao;
	}




	public List<BlackList> getBlackList(Page page) {
		
		return blackListDao.getBlackList(page);
	}
	public List<BlackList> getBlackListTwo(Page page) {
		return blackListDao.getBlackListTwo(page);
	}




	public int addBlack(BlackList blackList) {
		// TODO Auto-generated method stub
		return blackListDao.addBlack(blackList);
	}




	public int deleteBlack(String id) {
		// TODO Auto-generated method stub
		return blackListDao.deleteBlack(id);
	}




	@Override
	public int updataBlack(String id) {
		// TODO Auto-generated method stub
		return blackListDao.updataBlack(id);
	}




	@Override
	public int updatePati(String id) {
		// TODO Auto-generated method stub
		return blackListDao.updatePati(id);
	}




	@Override
	public int updatePatiTwo(String id) {
		// TODO Auto-generated method stub
		return blackListDao.updatePatiTwo(id);
	}




	@Override
	public int updatePati(BlackList blackList) {
		// TODO Auto-generated method stub
		return blackListDao.updatePati(blackList);
	}




	@Override
	public int updataBlack(BlackList blackList) {
		// TODO Auto-generated method stub
		return blackListDao.updataBlack(blackList);
	}




	@Override
	public int updatePatiTwo(BlackList blackList) {
		// TODO Auto-generated method stub
		return blackListDao.updatePatiTwo(blackList);
	}




	@Override
	public List<BlackList> selectBlack(BlackList b) {
		// TODO Auto-generated method stub
		return blackListDao.selectBlack(b);
	}




	@Override
	public int updataBlackTwo(BlackList blackList) {
		// TODO Auto-generated method stub
		return blackListDao.updataBlackTwo(blackList);
	}




	@Override
	public List<Map<String, String>> findList(Page page) {
		// TODO Auto-generated method stub
		return blackListDao.findList(page);
	}








	




	






	

}
