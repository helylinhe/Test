package com.linkonworks.df.busi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.FlupItemResponseDao;
import com.linkonworks.df.busi.service.FlupItemResponseService;
import com.linkonworks.df.busi.utils.FinalUtil;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupItemResponse;

public class FlupItemResponseServiceImpl implements FlupItemResponseService{
	
	
	private FlupItemResponseDao flupItemResponseDao;

	public FlupItemResponseDao getFlupItemResponseDao() {
		return flupItemResponseDao;
	}

	public void setFlupItemResponseDao(FlupItemResponseDao flupItemResponseDao) {
		this.flupItemResponseDao = flupItemResponseDao;
	}

	
	public List<FlupItemResponse> findPageList(Page page) {
		return flupItemResponseDao.findPageList(page);
	}

	
	public List<FlupItemResponse> findFlupItemPage(Map<String,Object> map) {
		return flupItemResponseDao.findFlupItemPage(map);
	}
	
	public int insertBatch(List<FlupItemResponse> list) {
		
		return flupItemResponseDao.insertBatch(list);
	}

	
	public int insert(FlupItemResponse r) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.insert(r);
	}

	@Override
	public List<FlupItemResponse> findPreview(String flupNameId) {
		List<FlupItemResponse> list= new ArrayList<FlupItemResponse>();
		try {
			list=flupItemResponseDao.findPreview(flupNameId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<FlupGroup> findFirst(String flupNameId) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.findFirst(flupNameId);
	}

	@Override
	public List<FlupItemResponse> findSecond(String groupName) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.findSecond(groupName);
	}

	@Override
	public List<FlupItemResponse> getFlupItemResponseList(String flupNameId) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.getFlupItemResponseList(flupNameId);
	}

	@Override
	public int updateUseState(List list) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.updateUseState(list);
	}

	@Override
	public int updateNormalUseState(List list) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.updateNormalUseState(list);
	}

	@Override
	public List<FlupItemResponse> getFlupItems(String flupNameId) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.getFlupItems(flupNameId);
	}

	@Override
	public int deleteFlupItemResponse(String flupName) {
		// TODO Auto-generated method stub
		return flupItemResponseDao.deleteFlupItemResponse(flupName);
	}

	@Override
	public List<FlupItemResponse> findPreviews(Map<String, String> map) {
		return flupItemResponseDao.findPreviews(map);
	}

	
	
	
	
	
	
}
