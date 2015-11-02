package com.linkonworks.df.busi.dao;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.PatiOperate;

public interface PatiOperateDao extends BaseDao<PatiOperate> {

	public List<PatiOperate> getPageOper(Page page);
}
