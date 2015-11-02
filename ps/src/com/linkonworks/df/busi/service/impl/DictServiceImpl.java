package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.dao.DictDao;
import com.linkonworks.df.busi.service.DictService;
import com.linkonworks.df.vo.Dict;

public class DictServiceImpl implements DictService{

	public DictDao dictDao;
	
	
	
	public DictDao getDictDao() {
		return dictDao;
	}



	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}



	@Override
	public List<Dict> getCommentCodeType(String echoSerial) {
		// TODO Auto-generated method stub
		return dictDao.getCommentCodeType(echoSerial);
	}



	@Override
	public List<Dict> commentAllCode(List dict) {
		// TODO Auto-generated method stub
		return dictDao.commentAllCode(dict);
	}



	
	public List<Dict> getDictAll() {
		// TODO Auto-generated method stub
		return dictDao.getDictAll();
	}

}
