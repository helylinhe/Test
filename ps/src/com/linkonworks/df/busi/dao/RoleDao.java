package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.Role;
import com.linkonworks.df.vo.Tree;

public interface RoleDao extends BaseDao<Role>{
	
	public List<Tree> findRoleList(Map map);
	
	public List<Tree> findMenuRole(Map map);

}
