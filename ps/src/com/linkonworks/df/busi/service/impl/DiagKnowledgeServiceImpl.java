package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.DiagKnowledgeDao;
import com.linkonworks.df.busi.service.DiagKnowledgeService;
import com.linkonworks.df.vo.DiagKnowledge;
import com.linkonworks.df.vo.DiagnosisDict;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.SymptomDict;

public class DiagKnowledgeServiceImpl implements DiagKnowledgeService {

	private DiagKnowledgeDao diagKnowledgeDao;
	

	public DiagKnowledgeDao getDiagKnowledgeDao() {
		return diagKnowledgeDao;
	}

	public void setDiagKnowledgeDao(DiagKnowledgeDao diagKnowledgeDao) {
		this.diagKnowledgeDao = diagKnowledgeDao;
	}

	@Override
	public List<DiagKnowledge> findPageList(Page page) {
		return diagKnowledgeDao.findPageList(page);
	}

	@Override
	public int insert(DiagKnowledge diagKnowledge) {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.insert(diagKnowledge);
	}
	
	@Override
	public int update(DiagKnowledge diagKnowledge) {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.update(diagKnowledge);
	}

	@Override
	public List<Dict> findListByCode() {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.findListByCode();
	}

	@Override
	public List<SymptomDict> findListByDictId(String id) {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.findListByDictId(id);
	}

	@Override
	public int insertSymptomDict(SymptomDict symptomDict) {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.insertSymptomDict(symptomDict);
	}

	@Override
	public int updateSymptomDict(SymptomDict symptomDict) {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.updateSymptomDict(symptomDict);
	}

	@Override
	public int updateDiagKnowledge(DiagKnowledge dsiagKnowledge) {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.updateDiagKnowledge(dsiagKnowledge);
	}


	@Override
	public List<DiagnosisDict> findDiagnosisDict(Map<String, String> map) {
		// TODO Auto-generated method stub
		return diagKnowledgeDao.findDiagnosisDict(map);
	}




}
