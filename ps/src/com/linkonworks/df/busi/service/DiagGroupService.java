package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DiagGroup;
import com.linkonworks.df.vo.DiagnosisDict;

public interface DiagGroupService {
	public List<DiagGroup> findPageList(Page page);
	public int insert(DiagGroup t);
	
	public int insertIcd(List<DiagGroup> t);
	
	public List<DiagGroup> getDiagGroups(DiagGroup t);
	
	public List<DiagGroup> getAllDiagGroups();
	
	public int update(DiagGroup t);
	//修改诊断组
	public int updateGroup(DiagGroup t);
	//获取诊断组
	public List<DiagnosisDict> findDiagnosisDict(Map<String , Object> map);
	
	public List<DiagGroup> findPageListIcd(Page page);
	
	public int deleteGroupIcd(String[] arr );
	
	public int findIcdByGroupCode(DiagGroup t);
	//删除对应的组里的ICD
	public int deleteGroupIcdByGroupCode(String[] arr );
	//删除诊断组
	public int deleteGroupByGroupCode(String[] arr );
}

