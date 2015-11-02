package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.BlackList;

public interface BlackListDao extends BaseDao<BlackList>{

	
	public List<BlackList> getBlackList(Page page);
	
	public List<BlackList> getBlackListTwo(Page page);
	
	public int addBlack(BlackList blackList);
	
	public int deleteBlack(String id);
	
	public int updataBlack(String id);
	
	public int updatePati(String id);
	
	public int updatePatiTwo(String id);
	
	public int updatePati(BlackList blackList);
	public int updataBlack(BlackList blackList);
	public int updatePatiTwo(BlackList blackList);
	
	//修改黑名单状态为黑名单
	public int updataBlackTwo(BlackList blackList);
	//查看数据库是否存在改用户
	public List<BlackList> selectBlack(BlackList b);
	
	public List<Map<String,String>> findList(Page page);
	
	
	
	
	
}
