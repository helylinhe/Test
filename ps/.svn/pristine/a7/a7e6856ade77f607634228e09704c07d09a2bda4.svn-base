package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.dao.RoleDao;
import com.linkonworks.df.busi.service.RoleService;
import com.linkonworks.df.vo.Role;
import com.linkonworks.df.vo.Tree;

public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao;
	
	@Override
	public List<Tree> findRoleList(Map map) {
		// TODO Auto-generated method stub
		return roleDao.findRoleList(map);
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public int insert(Role role) {
		// TODO Auto-generated method stub
		return roleDao.insert(role);
	}

	@Override
	public List<Tree> findMenuRole(Map map) {
		// TODO Auto-generated method stub
		return roleDao.findMenuRole(map);
	}
	
	

}
