package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.dao.FlupTaskDao;
import com.linkonworks.df.busi.dao.MobileFlupDao;
import com.linkonworks.df.busi.service.FlupTaskService;
import com.linkonworks.df.busi.service.MobileFlupService;
import com.linkonworks.df.vo.FlupPlan;
import com.linkonworks.df.vo.FlupTask;
import com.linkonworks.df.vo.MobileFlup;

public class MobileFlupServiceImpl implements MobileFlupService {

	private MobileFlupDao mobileFlupDao;
	private FlupTaskDao flupTaskDao;



	public MobileFlupDao getMobileFlupDao() {
		return mobileFlupDao;
	}

	public void setMobileFlupDao(MobileFlupDao mobileFlupDao) {
		this.mobileFlupDao = mobileFlupDao;
	}

	
	public FlupTaskDao getFlupTaskDao() {
		return flupTaskDao;
	}

	public void setFlupTaskDao(FlupTaskDao flupTaskDao) {
		this.flupTaskDao = flupTaskDao;
	}

	@Override
	public int update(MobileFlup mobileFlup) {
		return mobileFlupDao.update(mobileFlup);
	}

	@Override
	public int updateFlupPlan(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.updateFlupPlan(map);
	}

	@Override
	public int updatePatiFlupRule(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.updatePatiFlupRule(map);
	}

	@Override
	public List<FlupPlan> findNextPlans(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.findNextPlans(map);
	}

	@Override
	public List<FlupPlan> findNext(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.findNext(map);
	}

	@Override
	public int deleteFlupTask(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.deleteFlupTask(map);
	}

	@Override
	public int updateFlupDate(FlupPlan p) {
		// TODO Auto-generated method stub
		return mobileFlupDao.updateFlupDate(p);
	}

	@Override
	public int updateFlupTask(FlupTask t) {
		// TODO Auto-generated method stub
		return mobileFlupDao.updateFlupTask(t);
	}

	

	@Override
	public int insertAddFlupPlans(List<FlupPlan> list) {
		// TODO Auto-generated method stub
		return mobileFlupDao.insertAddFlupPlans(list);
	}

	@Override
	public int checkMobileFlup(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.checkMobileFlup(map);
	}

	@Override
	public List<MobileFlup> histroyFlupInfo(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.histroyFlupInfo(map);
	}

	@Override
	public int deleteFlupItem(Map<String, String> map) {
		// TODO Auto-generated method stub
		return mobileFlupDao.deleteFlupItem(map);
	}



	@Override
	public int insertBatch(List<MobileFlup> list) {
		// TODO Auto-generated method stub
		return mobileFlupDao.insertBatch(list);
	}

	@Override
	public int insertBatchs(List<MobileFlup> list, FlupTask task) {
		// TODO Auto-generated method stub
		flupTaskDao.updateFlupTask(task);
		return  mobileFlupDao.insertBatch(list);
	}

	

}
