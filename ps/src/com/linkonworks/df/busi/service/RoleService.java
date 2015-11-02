package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.Role;
import com.linkonworks.df.vo.Tree;

public interface RoleService {

	public List<Tree> findRoleList(Map map);
	
	public int insert(Role role);
	
	
	public List<Tree> findMenuRole(Map map);
}
