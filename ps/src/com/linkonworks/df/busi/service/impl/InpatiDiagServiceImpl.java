package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.InpatiDiagDao;
import com.linkonworks.df.busi.service.InpatiDiagService;
import com.linkonworks.df.vo.InpatiDiag;

public class InpatiDiagServiceImpl implements InpatiDiagService {

	private InpatiDiagDao inpatiDiagDao;

	@Override
	public List<InpatiDiag> getPageInpati(Page page) {
		return inpatiDiagDao.getPageInpati(page);
	}

	public InpatiDiagDao getInpatiDiagDao() {
		return inpatiDiagDao;
	}

	public void setInpatiDiagDao(InpatiDiagDao inpatiDiagDao) {
		this.inpatiDiagDao = inpatiDiagDao;
	}

	@Override
	public List<InpatiDiag> findPatis(Page page) {
		// TODO Auto-generated method stub
		return inpatiDiagDao.findPatis(page);
	}

	@Override
	public InpatiDiag patiInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return inpatiDiagDao.patiInfo(map);
	}

	@Override
	public List<InpatiDiag> doctoradvice(Page page) {
		// TODO Auto-generated method stub
		return inpatiDiagDao.doctoradvice(page);
	}

}
