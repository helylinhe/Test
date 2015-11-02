package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.DiagGroupDao;
import com.linkonworks.df.busi.service.DiagGroupService;
import com.linkonworks.df.vo.DiagGroup;
import com.linkonworks.df.vo.DiagnosisDict;

public class DiagGroupServiceImpl implements DiagGroupService {


	private DiagGroupDao diagGroupDao;

	public DiagGroupDao getDiagGroupDao() {
		return diagGroupDao;
	}

	public void setDiagGroupDao(DiagGroupDao diagGroupDao) {
		this.diagGroupDao = diagGroupDao;
	}

	@Override
	public List<DiagGroup> findPageList(Page page) {
		// TODO Auto-generated method stub
		return diagGroupDao.findPageList(page);
	}

	@Override
	public int insert(DiagGroup t) {
		// TODO Auto-generated method stub
		return diagGroupDao.insert(t);
	}


	@Override
	public List<DiagGroup> getDiagGroups(DiagGroup t) {
		// TODO Auto-generated method stub
		return diagGroupDao.getDiagGroups(t);
	}

	@Override
	public int insertIcd(List<DiagGroup> t) {
		// TODO Auto-generated method stub
		return diagGroupDao.insertIcd(t);
	}

	@Override
	public List<DiagGroup> getAllDiagGroups() {
		// TODO Auto-generated method stub
		return diagGroupDao.getAllDiagGroups();
	}

	@Override
	public int update(DiagGroup t) {
		// TODO Auto-generated method stub
		return diagGroupDao.update(t);
	}

	@Override
	public int updateGroup(DiagGroup t) {
		// TODO Auto-generated method stub
		return diagGroupDao.updateGroup(t);
	}

	@Override
	public List<DiagnosisDict> findDiagnosisDict(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return diagGroupDao.findDiagnosisDict(map);
	}

	@Override
	public List<DiagGroup> findPageListIcd(Page page) {
		// TODO Auto-generated method stub
		return diagGroupDao.findPageListIcd(page);
	}

	@Override
	public int deleteGroupIcd(String[] arr) {
		// TODO Auto-generated method stub
		return diagGroupDao.deleteGroupIcd(arr);
	}

	@Override
	public int findIcdByGroupCode(DiagGroup t) {
		// TODO Auto-generated method stub
		return diagGroupDao.findIcdByGroupCode(t);
	}

	@Override
	public int deleteGroupIcdByGroupCode(String[] arr) {
		// TODO Auto-generated method stub
		return diagGroupDao.deleteGroupIcdByGroupCode(arr);
	}

	@Override
	public int deleteGroupByGroupCode(String[] arr) {
		// TODO Auto-generated method stub
		return diagGroupDao.deleteGroupByGroupCode(arr);
	}
	
}
