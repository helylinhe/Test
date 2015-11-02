package com.linkonworks.df.busi.dao;


import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.DiagKnowledge;
import com.linkonworks.df.vo.DiagnosisDict;
import com.linkonworks.df.vo.Dict;
import com.linkonworks.df.vo.SymptomDict;

public interface DiagKnowledgeDao extends BaseDao<DiagKnowledge>{
	//查询出Dict所有的部位名称
	public List<Dict> findListByCode();
	//根据dict的ID来查询对应的症状
    public List<SymptomDict> findListByDictId(String id);
    //新增主要症状
    public int insertSymptomDict(SymptomDict symptomDict);
    //修改主要症状
    public int updateSymptomDict(SymptomDict symptomDict);
    //修改随访知识库的审核状态
    public int updateDiagKnowledge(DiagKnowledge dsiagKnowledge);
    //检索查询主要诊断
    public List<DiagnosisDict> findDiagnosisDict(Map<String , String> map);

}
