package com.linkonworks.df.busi.dao;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupModule;
import com.linkonworks.df.vo.FlupNameDict;

public interface  FlupModuleDao extends BaseDao<FlupModule> {
	
	public List<FlupModule> getFlupModule(Page page);
	
	public int savaFlupModule(FlupModule flupModule);
	
	public int updateFlupModule(FlupModule flupModule);

}
