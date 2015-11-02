package com.linkonworks.df.busi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.PlatformTradelogDao;
import com.linkonworks.df.busi.service.PlatformTradelogService;
import com.linkonworks.df.vo.InteBusi;
import com.linkonworks.df.vo.Interfactory;
import com.linkonworks.df.vo.PlatformTradelog;

public class PlatformTradelogServiceImpl implements PlatformTradelogService {

	
	private PlatformTradelogDao platformTradelogDao;
	
	
	public PlatformTradelogDao getPlatformTradelogDao() {
		return platformTradelogDao;
	}

	public void setPlatformTradelogDao(PlatformTradelogDao platformTradelogDao) {
		this.platformTradelogDao = platformTradelogDao;
	}

	@Override
	public List<Interfactory> getFactoryList() {
		// TODO Auto-generated method stub
		return platformTradelogDao.getFactoryList();
	}

	@Override
	public List<InteBusi> getInteBusi() {
		return platformTradelogDao.getInteBusi();
	}

	@Override
	public List<InteBusi> getPageList(Page page) {
		return platformTradelogDao.getPageList(page);
	}


	@Override
	public int addInteBusi(InteBusi busi) {
		// TODO Auto-generated method stub
		return platformTradelogDao.addInteBusi(busi);
	}


	@Override
	public List<PlatformTradelog> searchPageList(Page page) {
		List<PlatformTradelog> list=new ArrayList<PlatformTradelog>();
		try {
			list=platformTradelogDao.searchPageList(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PlatformTradelog> findPageList(Page page) {
		List<PlatformTradelog> list=new ArrayList<PlatformTradelog>();
		try {
			list=platformTradelogDao.findPageList(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public int updateInteBusi(Map<String, String> map) {
		// TODO Auto-generated method stub
		return platformTradelogDao.updateInteBusi(map);
	}

	@Override
	public int updateState(Map<String, String> map) {
		// TODO Auto-generated method stub
		return platformTradelogDao.updateState(map);
	}


	@Override
	public List<Map<String, String>> pageImportPage(Page page) {
		// TODO Auto-generated method stub
		return platformTradelogDao.pageImportPage(page);
	}

	@Override
	public List<Map<String, String>> pageCallCenterLog(Page page) {
		// TODO Auto-generated method stub
		return platformTradelogDao.pageCallCenterLog(page);
	}


	@Override
	public List<PlatformTradelog> findChart(Map<String, String> map) {
		List<PlatformTradelog> list=new ArrayList<PlatformTradelog>();
		try {
			list=platformTradelogDao.findChart(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<InteBusi> getBusi(Map<String, String> map) {
		// TODO Auto-generated method stub
		return platformTradelogDao.getBusi(map);
	}

	@Override
	public List<PlatformTradelog> visitList(Page page) {
		List<PlatformTradelog> list=new ArrayList<PlatformTradelog>();
		try {
			list=platformTradelogDao.visitList(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getTabelNameDetail(Page page) {
		// TODO Auto-generated method stub
		return platformTradelogDao.getTabelNameDetail(page);
	}

	@Override
	public List<Map<String,String>> getColums(Map<String, String> map) {
		// TODO Auto-generated method stub
		return platformTradelogDao.getColums(map);
	}

	@Override
	public List<PlatformTradelog> expecetionMessage() {
		// TODO Auto-generated method stub
		return platformTradelogDao.expecetionMessage();
	}


	

}
