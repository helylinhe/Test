package com.linkonworks.df.busi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.FlupDynamicDao;
import com.linkonworks.df.busi.service.FlupDynamicService;
import com.linkonworks.df.vo.FlupDynamic;
import com.linkonworks.df.vo.FlupItemResponse;

public class FlupDynamicServiceimpl implements FlupDynamicService {
	
	private FlupDynamicDao flupDynamicDao;
	

	public FlupDynamicDao getFlupDynamicDao() {
		return flupDynamicDao;
	}

	public void setFlupDynamicDao(FlupDynamicDao flupDynamicDao) {
		this.flupDynamicDao = flupDynamicDao;
	}

	/**
	 * 根据病人编号、住院号、住院流水号获取随访列表中的所有随访项
	 */
	@Override
	public List<FlupItemResponse> findAllFlupDynamic(Map<String,String> map) {
		List<FlupItemResponse> list=new ArrayList<FlupItemResponse>();
		try {
			list=this.flupDynamicDao.findAllFlupDynamic(map);
//			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
/**
 * 添加随访项
 */
	@Override
	public void addFlupDynamic(Map<String,String> map) {
		try {
			this.flupDynamicDao.addFlupDynamic(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * 根据用户信息和随访次数删除随访项
 */
	@Override
	public void removeFlupDynamic(Map<String,String> map) {
		try {
			this.flupDynamicDao.removeFlupDynamic(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

@Override
public List<FlupItemResponse> dynamicFlupItems(Map<String, String> map) {
	// TODO Auto-generated method stub
	return flupDynamicDao.dynamicFlupItems(map);
}

@Override
public String addFlupItems(List<FlupDynamic> list) {
	// TODO Auto-generated method stub
	Integer result = flupDynamicDao.insertBatch(list);
	return result.toString();
}


}
