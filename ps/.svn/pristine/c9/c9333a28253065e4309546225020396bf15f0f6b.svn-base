package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.UserService;
import com.linkonworks.df.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	
	
	private UserService userService;
	
	private Page<User> page=new Page<User>(); //鍙傛暟浼犻�(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //鍙傛暟浼犻�(绛涢�鏉′欢鍙傛暟)
	
	
	
	public String execute(){
		
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag",1);
		map.put("start", 1);
		map.put("end", 2);
		map.put("username","username");
		List arr=new ArrayList();
		arr.add("jack");
		arr.add("dd");
		map.put("names",arr);
		List listUser=userService.findListPage(map);
		System.out.println(listUser.size());*/
		
		
		//Map map=new HashMap();
		//map.put("flag", 1);
		//map.put("username", "username");
		//List arr=new ArrayList();
		//arr.add("jack");
		/*arr.add("dd");
		arr.add("ddss");*/
		//map.put("names",arr);
		//page.setParams(map);
		/*page.setParams(map);
		Map userMap=new HashMap();
		userMap.put("rows",userService.getPageUser(page));
		userMap.put("totalRecord",page.getTotalRecord());
		userMap.put("totalPage", page.getTotalPage());
		JSON json=JSONArray.fromObject(userMap);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		//System.out.println(li.size());
		
		/*Map map=new HashMap();
		map.put("flag", "1");
		map.put("username", "username");
		List arr=new ArrayList();
		arr.add("jack");
		arr.add("dd");
		arr.add("ddss");
		map.put("names",arr);
		List<User> li=userService.getUser(map);
		System.out.println(li.size());*/
		
		
		
		/*Map map=new HashMap();
		map.put("flag", 1);
		List fls=new ArrayList();
		fls.add("jack");
		fls.add("dd");
		map.put("names", fls);
		List<User> listGetUser=userService.getUser(map);*/
		
		/*User user1=new User("jack1","123","1","1","","");
		User user2=new User("jack2","123","1","1","","");
		User user3=new User("jack3","123","1","1","","");
		User user4=new User("jack4","123","1","1","","");
		Map<String,List<User>> map=new HashMap<String,List<User>>();
		List<User> list1=new ArrayList<User>();
		List<User> list2=new ArrayList<User>();
		list1.add(user1);
		list1.add(user2);
		list2.add(user3);
		list2.add(user4);
		map.put("aa", list1);
		map.put("bb", list2);*/
		List<User> list = userService.getAll();
		JSON json=JSONArray.fromObject(list);
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
	
	public String toIndex(){
		System.out.println("DDDD");
		return null;
	}
	
	public String saveUser(){
		//userService.saveUser(user);
		return null;
	}


	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Page<User> getPage() {
		return page;
	}

	public void setPage(Page<User> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	
	
	
}
