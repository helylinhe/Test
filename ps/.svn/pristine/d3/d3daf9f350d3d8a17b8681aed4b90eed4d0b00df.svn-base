package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PatiOperateDao;
import com.linkonworks.df.busi.service.PatiOperateService;
import com.linkonworks.df.vo.PatiOperate;

public class PatiOperateServiceImpl implements PatiOperateService {
	private PatiOperateDao patiOperateDao;

	@Override
	public List<PatiOperate> getPageOper(Page page) {
		return patiOperateDao.getPageOper(page);
	}

	public PatiOperateDao getPatiOperateDao() {
		return patiOperateDao;
	}

	public void setPatiOperateDao(PatiOperateDao patiOperateDao) {
		this.patiOperateDao = patiOperateDao;
	}

}
