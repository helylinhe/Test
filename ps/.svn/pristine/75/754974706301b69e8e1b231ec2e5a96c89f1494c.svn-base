package com.linkonworks.df.busi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.FlupTaskDao;
import com.linkonworks.df.busi.service.FlupTaskService;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupDetail;
import com.linkonworks.df.vo.FlupModule;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.FlupTask;
import com.linkonworks.df.vo.TeletePhone;

public class FlupTaskServiceImpl implements FlupTaskService {

	private FlupTaskDao flupTaskDao;

	public FlupTaskDao getFlupTaskDao() {
		return flupTaskDao;
	}

	public void setFlupTaskDao(FlupTaskDao flupTaskDao) {
		this.flupTaskDao = flupTaskDao;
	}

	@Override
	public List<FlupTask> findPageList(Page page) {
		// TODO Auto-generated method stub
		return flupTaskDao.findPageList(page);
	}


	@Override
	public int update(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.update(flupTask);
	}

	@Override
	public int updatePatiFlup(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updatePatiFlup(flupTask);
	}

	@Override
	public List<FlupTask> findflFlupTasksInfo(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.findflFlupTasksInfo(flupTask);
	}
	@Override
	public List<FlupTask> getFlupTask(Page page) {
		// TODO Auto-generated method stub
		return flupTaskDao.getFlupTask(page);
	}

	@Override
	public FlupTask findInfoById(String id) {
		// TODO Auto-generated method stub
		return flupTaskDao.findInfoById(id);
	}

	@Override
	public FlupTask findFlupTask(Map map) {
		// TODO Auto-generated method stub
		return flupTaskDao.findFlupTask(map);
	}

	@Override
	public int updateFlupTask(FlupTask fluptask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updateFlupTask(fluptask);
	}


	@Override
	public List<FlupModule> getFlupModule(String smsstyle) {
		// TODO Auto-generated method stub
		return flupTaskDao.getFlupModule(smsstyle);
	}

	@Override
	public int addFlupDetail(FlupDetail flupDetail) {
		// TODO Auto-generated method stub
		return flupTaskDao.addFlupDetail(flupDetail);
	}

	@Override
	public List<FlupDetail> getByIdQuery(String id) {
		// TODO Auto-generated method stub
		return flupTaskDao.getByIdQuery(id);
	}

	@Override
	public int updateProperty(FlupTask f) {
		// TODO Auto-generated method stub
		return flupTaskDao.updateProperty(f);
	}

	@Override
	public TeletePhone getPhoneByType(TeletePhone t) {
		// TODO Auto-generated method stub
		return flupTaskDao.getPhoneByType(t);
	}

	@Override
	public List<Employee> findALlEmployees(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return flupTaskDao.findALlEmployees(map);
	}

	@Override
	public int updateflupPlan(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updateflupPlan(flupTask);
	}

	@Override
	public int updateFTask(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updateFTask(flupTask);
	}

	@Override
	public int updatePFTask(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updatePFTask(flupTask);
	}

	@Override
	public int updatePati(TeletePhone flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updatePati(flupTask);
	}

	@Override
	public List<FlupTask> findPageListPlan(Page page) {
		// TODO Auto-generated method stub
		return flupTaskDao.findPageListPlan(page);
	}

	@Override
	public List<FlupTask> findPlan(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.findPlan(flupTask);
	}

	@Override
	public int updatePlan(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updatePlan(flupTask);
	}
	@Override
	public int updatePlan2(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updatePlan2(flupTask);
	}

	@Override
	public int stopPlan(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.stopPlan(flupTask);
	}

	@Override
	public int delteTask(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.delteTask(flupTask);
	}

	@Override
	public int updateRuleGz(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updateRuleGz(flupTask);
	}

	@Override
	public int updatePlanJh(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updatePlanJh(flupTask);
	}

	@Override
	public int updateTaskRw(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.updateTaskRw(flupTask);
	}

	@Override
	public List<FlupTask> findPlan2(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.findPlan2(flupTask);
	}

	@Override
	public int addPlanJh(List<FlupTask> list) {
		// TODO Auto-generated method stub
		return flupTaskDao.addPlanJh(list);
	}

	@Override
	public int stoptask(FlupTask flupTask) {
		// TODO Auto-generated method stub
		return flupTaskDao.stoptask(flupTask);
	}

	@Override
	public List<FlupTask> findHospital(Page page) {
		List<FlupTask> list = new ArrayList<FlupTask>();
		try {
			list=flupTaskDao.findHospital(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<FlupTask> findDepatByUnit(Page page) {
		List<FlupTask> list = new ArrayList<FlupTask>();
		try {
			list=flupTaskDao.findDepatByUnit(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Map<String, String>> findInfo(Page page) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try {
			list=flupTaskDao.findInfo(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public FlupNameDict loadFlupNameType(String flupNameId) {
		// TODO Auto-generated method stub
		return flupTaskDao.loadFlupNameType(flupNameId);
	}


}
