package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.dao.RolePrivsDao;
import com.linkonworks.df.busi.service.RolePrivsService;
import com.linkonworks.df.vo.RolePrivs;

public class RolePrivsServiceImpl implements RolePrivsService{

	private RolePrivsDao rolePrivsDao;
	
	
	public RolePrivsDao getRolePrivsDao() {
		return rolePrivsDao;
	}

	public void setRolePrivsDao(RolePrivsDao rolePrivsDao) {
		this.rolePrivsDao = rolePrivsDao;
	}

	@Override
	public int insertBatch(List<RolePrivs> list) {
		// TODO Auto-generated method stub
		return rolePrivsDao.insertBatch(list);
	}

	@Override
	public int deleteRolePrivs(String roleCode) {
		// TODO Auto-generated method stub
		return rolePrivsDao.deleteRolePrivs(roleCode);
	}

	
}
