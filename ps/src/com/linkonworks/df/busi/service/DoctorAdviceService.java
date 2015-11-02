package com.linkonworks.df.busi.service;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DoctorAdvice;

public interface DoctorAdviceService {
	
	public List<DoctorAdvice> getDoctoradviceList(Page page);
	

}
