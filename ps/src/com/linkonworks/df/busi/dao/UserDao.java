package com.linkonworks.df.busi.dao;

import java.util.List;

import com.linkonworks.df.vo.User;

public interface UserDao extends BaseDao<User>{

	public List<User> getAll();
	
	
	
	
	
}
