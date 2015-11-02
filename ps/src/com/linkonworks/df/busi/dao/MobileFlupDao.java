package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.vo.FlupPlan;
import com.linkonworks.df.vo.FlupTask;
import com.linkonworks.df.vo.MobileFlup;

public interface MobileFlupDao extends BaseDao<MobileFlup> {

	public int update( MobileFlup mobileFlup);
	
	
	public int updateFlupPlan(Map<String,String> map);
	
	
	public int updatePatiFlupRule(Map<String,String> map);
	

    public List<FlupPlan> findNextPlans(Map<String,String> map);
    
    
    public List<FlupPlan> findNext(Map<String,String> map);
    
    public int deleteFlupTask(Map<String,String> map);
    
    public int updateFlupDate(FlupPlan p);
    
    public int updateFlupTask(FlupTask t);
    
   public int insertAddFlupPlans(List<FlupPlan> list);
   
   
   public int checkMobileFlup(Map<String,String> map);
   
   
   public List<MobileFlup> histroyFlupInfo(Map<String,String> map);
   
   public int deleteFlupItem(Map<String,String> map);

}
