package com.linkonworks.df.busi.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PremachineManageDao;
import com.linkonworks.df.busi.service.PremachineManageService;
import com.linkonworks.df.vo.PremachineManage;

public class PremachineManageServiceImpl implements PremachineManageService {

	private PremachineManageDao premachineManageDao;
	
	public PremachineManageDao getPremachineManageDao() {
		return premachineManageDao;
	}

	public void setPremachineManageDao(PremachineManageDao premachineManageDao) {
		try {
			this.premachineManageDao = premachineManageDao;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int addBlack(PremachineManage premachineManage) {
		int ret=0;
		try {
			ret=premachineManageDao.addBlack(premachineManage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int deleteBlack(String id) {
		// TODO Auto-generated method stub
		int ret=0;
		try {
			ret= premachineManageDao.deleteBlack(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<PremachineManage> getPageGroups(Page page) {
		List<PremachineManage> list= new ArrayList<PremachineManage>();
		try {
			list=premachineManageDao.getPageGroups(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updatestate(PremachineManage premachineManage) {
		int ret=0;
		try {
			// TODO Auto-generated method stub
			ret = premachineManageDao.updatestate(premachineManage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

}
