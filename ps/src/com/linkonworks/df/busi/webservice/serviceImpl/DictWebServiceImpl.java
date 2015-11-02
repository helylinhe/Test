package com.linkonworks.df.busi.webservice.serviceImpl;

import java.util.List;

import javax.jws.WebService;

import com.linkonworks.df.busi.dao.DictDao;
import com.linkonworks.df.busi.webservice.service.DictWebService;
import com.linkonworks.df.vo.Dict;

@WebService(serviceName="DictWebService")
public class DictWebServiceImpl implements DictWebService{

	private DictDao dictDao;
	
	@Override
	public List<Dict> getDictAll() {
		// TODO Auto-generated method stub
		return dictDao.getDictAll();
	}

	public DictDao getDictDao() {
		return dictDao;
	}

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}
	
	

}
