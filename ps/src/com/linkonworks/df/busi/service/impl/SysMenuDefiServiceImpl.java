package com.linkonworks.df.busi.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.linkonworks.df.busi.dao.SysMenuDefiDao;
import com.linkonworks.df.busi.service.SysMenuDefiService;
import com.linkonworks.df.vo.SysMenuDefi;

public class SysMenuDefiServiceImpl implements SysMenuDefiService{

	private SysMenuDefiDao sysMenuDefiDao;
	@Override
	public List<SysMenuDefi> getSysMenu(String code){
		return sysMenuDefiDao.getSysMenu(code);
	}
	public SysMenuDefiDao getSysMenuDefiDao() {
		return sysMenuDefiDao;
	}
	public void setSysMenuDefiDao(SysMenuDefiDao sysMenuDefiDao) {
		this.sysMenuDefiDao = sysMenuDefiDao;
	}
	@Override
	public Map<SysMenuDefi,List<SysMenuDefi>> getMenuItems(String employeeCode) {
		List<SysMenuDefi> childMenu=sysMenuDefiDao.getMenuItems(employeeCode);
		List<String> menuCode=new ArrayList<String>();
		for(int i=0;i<childMenu.size();i++){
			menuCode.add(childMenu.get(i).getMenuHigherNo());
		}
		List<SysMenuDefi> parentMenu=sysMenuDefiDao.getParentMenu(menuCode);
		
		
		
		
		
		
		
		
		
		
		Map<SysMenuDefi,List<SysMenuDefi>> map = new TreeMap<SysMenuDefi,List<SysMenuDefi>>(new Comparator<SysMenuDefi>(){
			public int compare(SysMenuDefi o1, SysMenuDefi o2) {
				return o1.getMenuCode().compareTo(o2.getMenuCode());
			}
		});
		for(int j=0;j<parentMenu.size();j++){
			if(!map.containsKey(parentMenu.get(j))){
				map.put(parentMenu.get(j),null);
			}
		}
		for(Iterator<SysMenuDefi> x= map.keySet().iterator();x.hasNext();){
			SysMenuDefi s=x.next();
			List<SysMenuDefi> valueMenu = new ArrayList<SysMenuDefi>();
			for(int z=0;z<childMenu.size();z++){
				if((childMenu.get(z).getMenuHigherNo()!=null && !childMenu.get(z).getMenuHigherNo().equals("")) && childMenu.get(z).getMenuHigherNo().equals(s.getMenuCode())){
					valueMenu.add(childMenu.get(z));
					map.put(s,valueMenu);
				}
			}
			
		}
		
		
		
		
		
		
		
		
		return map;
	}
	@Override
	public int insert(SysMenuDefi sysmenudefi) {
		// TODO Auto-generated method stub
		return sysMenuDefiDao.insert(sysmenudefi);
	}
	@Override
	public List<SysMenuDefi> findListByObject(SysMenuDefi sysmenudefi) {
		// TODO Auto-generated method stub
		return (List<SysMenuDefi>) sysMenuDefiDao.findListByObject(sysmenudefi);
	}
	
	

}
