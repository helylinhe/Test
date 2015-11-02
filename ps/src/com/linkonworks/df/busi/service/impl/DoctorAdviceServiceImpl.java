package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.DoctoradviceDao;
import com.linkonworks.df.busi.service.DoctorAdviceService;
import com.linkonworks.df.vo.DoctorAdvice;

public class DoctorAdviceServiceImpl implements DoctorAdviceService {

	private DoctoradviceDao doctorAdviceDao;
	
	public DoctoradviceDao getDoctorAdviceDao() {
		return doctorAdviceDao;
	}

	public void setDoctorAdviceDao(DoctoradviceDao doctorAdviceDao) {
		this.doctorAdviceDao = doctorAdviceDao;
	}

	@Override
	public List<DoctorAdvice> getDoctoradviceList(Page page) {
		// TODO Auto-generated method stub
		return doctorAdviceDao.getDoctoradviceList(page);
	}

	
	
	

}
