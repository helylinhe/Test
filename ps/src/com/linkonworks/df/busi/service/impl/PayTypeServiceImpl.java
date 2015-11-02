package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.dao.PayTypeDao;
import com.linkonworks.df.busi.service.PayTypeService;
import com.linkonworks.df.vo.PayType;

public class PayTypeServiceImpl implements PayTypeService {
	private PayTypeDao payTypeDao;

	@Override
	public List<PayType> queryAll() {
		return payTypeDao.queryAll();
	}

	public PayTypeDao getPayTypeDao() {
		return payTypeDao;
	}

	public void setPayTypeDao(PayTypeDao payTypeDao) {
		this.payTypeDao = payTypeDao;
	}

}
