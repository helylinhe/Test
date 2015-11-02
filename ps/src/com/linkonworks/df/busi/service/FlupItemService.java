package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.FlupItem;

public interface FlupItemService {
	public List<FlupItem> getPageFlupItem(Page page);

	public Integer insert(FlupItem flupItem) throws Exception;
	
	public Integer delete(Map<String,Object> map)throws Exception;
	
	public int update(FlupItem flupItem);
}
