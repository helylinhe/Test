package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.Pati;

public interface PatiDao extends BaseDao<Pati> {

	public int insert(Pati pati);

	public int insert(Map<String, Object> map);

	public List<Pati> getPagePati(Page page);

	public int delete(List<String> list);
	
	public Pati getPatiInfo(Map map);
	
	public int update(Pati pati);
	
	public Pati checkPati(Map<String, Object> map);
	
	public List<Map<String,Object>> historyInfo(Page page);
}
