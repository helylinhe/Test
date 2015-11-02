package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.linkonworks.df.busi.service.PrivsService;
import com.linkonworks.df.busi.service.SysMenuDefiService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.Privs;
import com.linkonworks.df.vo.SysMenuDefi;
import com.opensymphony.xwork2.ActionSupport;

public class SysMenuDefiAction extends ActionSupport{

	private SysMenuDefiService sysMenuDefiService;
	private PrivsService privsService;
	private Map<String,String> map=new HashMap<String,String>();
	private SysMenuDefi sysmenudefi;

	public SysMenuDefiService getSysMenuDefiService() {
		return sysMenuDefiService;
	}

	public void setSysMenuDefiService(SysMenuDefiService sysMenuDefiService) {
		this.sysMenuDefiService = sysMenuDefiService;
	}
	
	/***
	 * 菜单编码
	 * @return
	 */
	public String menuList(){
		List<SysMenuDefi> list=sysMenuDefiService.getSysMenu(map.get("code"));
		JsonUtil.jsonDataList(list);
		return null;
	}

	
	/****
	 * 菜单左边
	 * @return
	 */
	public String leftMenuItems(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		HttpServletRequest request=ServletActionContext.getRequest();
		String p=request.getContextPath();
		Employee employee=(Employee) session.getAttribute("employee");
		Map<SysMenuDefi,List<SysMenuDefi>> hashmap=(Map<SysMenuDefi, List<SysMenuDefi>>) sysMenuDefiService.getMenuItems(employee.getRoleCode());
		StringBuffer sb=new StringBuffer("");
		sb.append("<div id='menuDiv' class='easyui-accordion bgcolor' border='false' fit='true' animate='false' style='overflow: hidden'>");
		if(hashmap.size()>0){
			for(Iterator<SysMenuDefi> x=hashmap.keySet().iterator();x.hasNext();){
				SysMenuDefi sd=x.next();
				List<SysMenuDefi> value=hashmap.get(sd);
				sb.append("<div title='"+sd.getMenuName()+"' style='overflow: auto;'>");
				sb.append("<ul class='easyui-tree'>");
				for(int i=0;i<value.size();i++){
					String path=value.get(i).getUrlAddress();
					path=p+path;
					sb.append("<li><a onclick=\"leftmenu_click(this,'"+path+"')\">"+value.get(i).getMenuName()+"</a></li>");
				}
				sb.append("</ul>");
				sb.append("</div>");
			}
		}
		sb.append("</div>");
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/****
	 * 菜单项添加
	 * @return
	 */
	public String addMenuItem(){
		SysMenuDefi s=new SysMenuDefi();
		HttpSession session=ServletActionContext.getRequest().getSession();
		Employee e=(Employee) session.getAttribute("employee");
		String menuCode=UUID.randomUUID().toString();
		s.setDelState("0");
		s.setMenuLevel("2");
		s.setMenuNo("1");
		s.setProgName("院后随访系统");
		s.setOperateEmployeeCode("001");
		s.setMenuCode(menuCode);
		s.setMenuHigherNo(map.get("menuHigherNo"));
		s.setMenuName(map.get("menuName"));
		s.setUrlAddress(map.get("urlAddress"));
		int result=sysMenuDefiService.insert(s);
		/*******
		 * 
		 * 权限表添加对应的数据
		 */
		Privs p=new Privs();
		p.setPrivsName(map.get("menuName"));
		p.setMenuCode(menuCode);
		p.setPrivsType("不限");
		p.setProgName("院后随访系统");
		p.setMemo("菜单添加");
		
		privsService.insert(p);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print("success");
		} catch (IOException ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		return null;
	}
	
	
	/***
	 * 获取父菜单
	 * @return
	 */
	public String parentMenuItem(){
		List<SysMenuDefi> list=sysMenuDefiService.findListByObject(sysmenudefi);
		JsonUtil.jsonDataList(list);
		return null;
	}
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public SysMenuDefi getSysmenudefi() {
		return sysmenudefi;
	}

	public void setSysmenudefi(SysMenuDefi sysmenudefi) {
		this.sysmenudefi = sysmenudefi;
	}

	public PrivsService getPrivsService() {
		return privsService;
	}

	public void setPrivsService(PrivsService privsService) {
		this.privsService = privsService;
	}
	
	
	
}
