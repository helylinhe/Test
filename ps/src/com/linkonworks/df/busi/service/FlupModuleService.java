package com.linkonworks.df.busi.service;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupModule;

public interface FlupModuleService {
	
	public List<FlupModule> getFlupModule(Page page);
	
	public int savaFlupModule(FlupModule flupModule);
	
	public int updateFlupModule(FlupModule flupModule);

}
