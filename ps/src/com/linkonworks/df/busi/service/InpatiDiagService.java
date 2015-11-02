package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.InpatiDiag;

public interface InpatiDiagService {
	public List<InpatiDiag> getPageInpati(Page page);
	
	
	public List<InpatiDiag> findPatis(Page page);
	
	
	public InpatiDiag  patiInfo(Map<String,String> map);
	
	//医嘱信息页面，查询病患信息
	public List<InpatiDiag> doctoradvice(Page page);
}
