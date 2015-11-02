package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.service.PrivsService;
import com.linkonworks.df.busi.service.RolePrivsService;
import com.linkonworks.df.vo.Privs;
import com.linkonworks.df.vo.RolePrivs;
import com.opensymphony.xwork2.ActionSupport;

public class RolePrivsAction extends ActionSupport{

	private RolePrivsService rolePrivsService;
	private PrivsService privsService;
	private Map<String,String> map=new HashMap<String,String>();
	
	public String addRolePrivs(){
		String arr[]=map.get("privsId").split(",");
		RolePrivs rp=null;
		List<RolePrivs> list=new ArrayList<RolePrivs>();
		int deleteResult=rolePrivsService.deleteRolePrivs(map.get("roleCode"));
		for(int i=0;i<arr.length;i++){
			rp=new RolePrivs();
			rp.setRoleCode(map.get("roleCode"));
			Privs p=privsService.getPrivsByMenuCode(arr[i]);
			if(p==null){
				rp.setPrivsId(p.getPrivsId());
			}
			rp.setPrivsId(p.getPrivsId());
			list.add(rp);
		}
		int result=rolePrivsService.insertBatch(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public RolePrivsService getRolePrivsService() {
		return rolePrivsService;
	}

	public void setRolePrivsService(RolePrivsService rolePrivsService) {
		this.rolePrivsService = rolePrivsService;
	}

	

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public PrivsService getPrivsService() {
		return privsService;
	}

	public void setPrivsService(PrivsService privsService) {
		this.privsService = privsService;
	}
	
	
}
