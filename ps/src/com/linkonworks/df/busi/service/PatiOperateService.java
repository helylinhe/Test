package com.linkonworks.df.busi.service;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.PatiOperate;

public interface PatiOperateService {
	public List<PatiOperate> getPageOper(Page page);
}
