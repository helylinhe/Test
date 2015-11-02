package com.linkonworks.df.busi.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.DiseaseItem;
import com.linkonworks.df.vo.DiseaseItemTemplate;
import com.linkonworks.df.vo.DiseaseNameDict;

public interface DiseaseItemTemplateService {

	/****
	 * 获取一级疾病名称
	 * @param map
	 * @return
	 */
	public List<DiseaseItem> diseaseItemFirst();
	
	/****
	 * 获取二级疾病名称
	 * @param map
	 * @return
	 */
	public List<DiseaseItem> diseaseItemSeconde(Map<String,String> map);
	
	/*****
	 * 获取疾病指标模板名称
	 * @return
	 */
	public List<DiseaseNameDict> diseaseNameDict(List list);
	
	/*****
	 * 
	 * 获取疾病指标list
	 */
	public List<DiseaseItem> pageListDisease(Page page);
	
	
	/*****
	 * 获取疾病模板对应下的疾病指标
	 */
	//public List<DiseaseItemTemplate> pageListDiseaseRight(Map<String,Object> map);
	public List<DiseaseItemTemplate> pageListDiseaseRight(Map<String,Object> map);
	
	/****
	 * 获取疾病模板下的所有疾病项
	 */
	public List<DiseaseItemTemplate> diseaseItemTemplates(String diseaseItemId);
	
	/****
	 * 批量添加疾病项
	 */
	public int addBatch(List<DiseaseItemTemplate> list);
	
	/****
	 * 批量修改状态
	 * @param list
	 * @return
	 */
	
	public int updateUseState(List list);
	
	/*****
	 * 批量修改状态
	 * @param list
	 * @return
	 */
	public int updateNormalUseState(List list);
	
	/****
	 * 删除疾病项
	 */
	public int deleteDiseaseItem(String diseasName);
	
	/*****
	 * 导出化疗信息
	 */
	public HSSFWorkbook exportReportData(Map<String,Object> map);
}