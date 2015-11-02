package com.linkonworks.df.busi.service;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Check;

public interface CheckService {
	public List<Check> getPageCheck(Page page);
}
