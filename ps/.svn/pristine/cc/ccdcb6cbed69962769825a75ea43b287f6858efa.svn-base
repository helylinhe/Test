package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;



import com.linkonworks.df.busi.service.RoleService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.vo.Role;
import com.linkonworks.df.vo.Tree;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport{

	private RoleService roleService;
	private Map<String,String> map=new HashMap<String,String>();
	private Role role;
	
	public String  findRoleList(){
		
		JSON json=JSONArray.fromObject(roleService.findRoleList(map));
		
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String addRole(){
		role=new Role();
		role.setMemo(map.get("memo"));
		role.setRoleName(map.get("roleName"));
		role.setRoleStatus("1"); //1 表示正常  0表示不正常
		int count=roleService.insert(role);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/***
	 * 菜单权限
	 * @return
	 */
	public String menuRoles(){
		List<Tree> list=roleService.findMenuRole(map);
		Map<Tree,List<Tree>> hashMap=new HashMap<Tree,List<Tree>>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getMenuHigherNo()==null || list.get(i).getMenuHigherNo().equals("")){
				if(!hashMap.containsKey(list.get(i))){
					List<Tree>  arrayList = new ArrayList<Tree>();
					hashMap.put(list.get(i), arrayList);
				}else{
					List<Tree> treeList=hashMap.get(list.get(i));
					treeList.add(list.get(i));
					hashMap.put(list.get(i), treeList);
					
				}
			}else{
				for(Iterator<Tree> x= hashMap.keySet().iterator();x.hasNext();){
						Tree tree=x.next();
					if(list.get(i).getMenuHigherNo()!=null && list.get(i).getMenuHigherNo().equals(tree.getMenuCode())){
						List<Tree> treeList=hashMap.get(tree);
						treeList.add(list.get(i));
					}{
						continue;
					}
				}
			}
		}
		String str="[";
		for(Iterator<Tree> x= hashMap.keySet().iterator();x.hasNext();){
			Tree tree=x.next();
			List<Tree> childTree=hashMap.get(tree);
			str+="{\"id\":\""+""+tree.getId()+"\",\"text\":\""+tree.getText()+"\",\"children\":"+JSONArray.fromObject(childTree)+"}";
			str+=",";
		}
		str=str.substring(0, str.length()-1);
		str+="]";
		
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
