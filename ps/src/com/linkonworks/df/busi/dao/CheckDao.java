package com.linkonworks.df.busi.dao;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Check;

public interface CheckDao extends BaseDao<Check> {
	public List<Check> getPageCheck(Page page);
}
