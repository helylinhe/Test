package com.linkonworks.df.busi.dao;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupModule;
import com.linkonworks.df.vo.ReturnMessage;
import com.linkonworks.df.vo.ReturnTask;

public interface ReturnTaskDao extends BaseDao<ReturnTask> {
	
	public List<ReturnTask> findPageList(Page page);
	
	public List<FlupModule> findFlupModule(FlupModule flupModule);
	
	public int updateMessage(ReturnMessage returnMessage);

}
