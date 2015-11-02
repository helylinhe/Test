package com.linkonworks.df.busi.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.FlupItemResponseService;
import com.linkonworks.df.busi.service.FlupNameDictService;
import com.linkonworks.df.busi.utils.FlupItemResponseTableView;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupItemResponse;
import com.linkonworks.df.vo.FlupNameDict;
import com.linkonworks.df.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class FlupItemResponseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlupItemResponseService flupItemResponseService;
	private FlupNameDictService flupNameDictService;
	
	private Page<User> page=new Page<User>(); //参数传递(pageSize pageNumber)
	private Map<String,String> map=new HashMap<String,String>(); //参数传递(筛选条件参数)
	
	
	
	public FlupNameDictService getFlupNameDictService() {
		return flupNameDictService;
	}

	public void setFlupNameDictService(FlupNameDictService flupNameDictService) {
		this.flupNameDictService = flupNameDictService;
	}

	public FlupItemResponseService getFlupItemResponseService() {
		return flupItemResponseService;
	}

	public void setFlupItemResponseService(
			FlupItemResponseService flupItemResponseService) {
		this.flupItemResponseService = flupItemResponseService;
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

	/***
	 * 异步加载随访表名
	 * @return
	 */
	public String flupNamDict(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Department> departments= (List<Department>) session.getAttribute("departmentTable");
		List<String> deptcodes=new ArrayList<String>();
		for(Department d:departments){
			deptcodes.add(d.getDeptCode());
		}
		List<FlupNameDict> list=flupNameDictService.findByDeptCode(deptcodes);
		Map map=new HashMap();
		map.put("rows",list);
		JsonUtil.jsonData(map);
		return null;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public String pageList(){
		Map<String, Object> flupItemResponseMap=new HashMap<String, Object>();
		List<Department> list = SessionData.getDepartmentCode();
		page.setList(list);
		page.setParams(map);
		flupItemResponseMap.put("rows",flupItemResponseService.findPageList(page));
		flupItemResponseMap.put("totalRecord",page.getTotalRecord());
		flupItemResponseMap.put("totalPage", page.getTotalPage());
		flupItemResponseMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(flupItemResponseMap);
		return null;
	}
	
	/****
	 * 随访表名对应的分页查询
	 * @return
	 */
	public String pageFlupItemList(){
		Map<String,Object> pageFlupItemResponse=new HashMap<String,Object>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("flupNameId", map.get("flupNameId"));
		param.put("list", SessionData.getDepartmentCode());
		pageFlupItemResponse.put("rows", flupItemResponseService.findFlupItemPage(param));
		JsonUtil.jsonData(pageFlupItemResponse);
		return null;
	}
	
	/****
	 * 保存模板下的随访项目
	 * @return
	 */
	public String addFlupItemResponse(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		List<FlupItemResponse> list=new ArrayList<FlupItemResponse>();
		String flupNameId=map.get("flupNameId");
		String arr[]=map.get("arrFlupGroupId").split(",");
		FlupItemResponse res=null;
		int count=0;
		for(int i=0;i<arr.length;i++){
			res=new FlupItemResponse();
			FlupGroup group=new FlupGroup();
			FlupNameDict nameDict=new FlupNameDict();
			String[] s=arr[i].split("_");
			group.setFlupGroupId(s[0]);
			res.setShowNo(s[1]);
			nameDict.setFlupNameId(flupNameId);
			res.setFlupGroup(group);
			res.setFlupNameDict(nameDict);
			res.setEmployeeCode(employee.getJobnum());
			res.setUseState("1");
			list.add(res);
		}
		/*List<String> diffList =new ArrayList<String>();
		Map<String,String> itemList =new HashMap<String,String>();
		List<String> updateList =new ArrayList<String>();
		List<String> updateUseStateList=new ArrayList<String>();
		int count=0;
		if(items.size()>0){
			for(FlupItemResponse r:items){
				itemList.put(r.getFlupGroup().getFlupGroupId(), r.getId()+","+r.getUseState());
			}
			for(Iterator<String> i = itemList.keySet().iterator(); i.hasNext();){
				String key=i.next();
				if(!stooges.contains(key)){
					String[] value=itemList.get(key).split(",");
					updateList.add(value[0]);
				}
			}
			for(String str:stooges){
				if(!itemList.containsKey(str)){
					diffList.add(str);
				}else{
					String [] val=itemList.get(str).split(",");
					if(val[1]!=null && val[1].equals("0")){
						updateUseStateList.add(val[0]);
					}
					
				}
			}
			*//*****
			 * 添加数据
			 *//*
			for(int j=0;j<diffList.size();j++){
				res=new FlupItemResponse();
				FlupGroup group=new FlupGroup();
				FlupNameDict nameDict=new FlupNameDict();
				group.setFlupGroupId(diffList.get(j));
				nameDict.setFlupNameId(flupNameId);
				res.setFlupGroup(group);
				res.setFlupNameDict(nameDict);
				res.setEmployeeCode(employee.getJobnum());
				res.setUseState("1");
				list.add(res);
			}
			*//******
			 * 修改状态
			 *//*
			if(updateList.size()>0){
				count=flupItemResponseService.updateUseState(updateList);
			}
			*//*****
			 * 把停用的修改掉正常状态
			 *//*
			if(updateUseStateList.size()>0){
				count=flupItemResponseService.updateNormalUseState(updateUseStateList);
			}
			
		}else{
			for(int i=0;i<arr.length;i++){
				res=new FlupItemResponse();
				FlupGroup group=new FlupGroup();
				FlupNameDict nameDict=new FlupNameDict();
				group.setFlupGroupId(arr[i]);
				nameDict.setFlupNameId(flupNameId);
				res.setFlupGroup(group);
				res.setFlupNameDict(nameDict);
				res.setEmployeeCode(employee.getJobnum());
				res.setUseState("1");
				list.add(res);
			}
		}*/
		flupItemResponseService.deleteFlupItemResponse(flupNameId);
		if(list.size()>0){
			count=flupItemResponseService.insertBatch(list);
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String findFlupView(){
		HttpServletRequest  request = ServletActionContext.getRequest();
		StringBuilder sb = new StringBuilder();
		PrintWriter  out = null; 
		try {
			out = ServletActionContext.getResponse().getWriter();
			List<FlupItemResponse>  list=new ArrayList<FlupItemResponse>();
			list = flupItemResponseService.findPreview(request.getParameter("flupNameId"));
			sb.append(FlupItemResponseTableView.getTable(list,request.getParameter("showButton")));
			out.print(sb);
		}catch (Exception e) {
			out.print("error");
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	 * 下次随访设置
	 * @return
	 */
	public String findPreviewGroup(){
		HttpServletRequest  request = ServletActionContext.getRequest();
		StringBuilder sb = new StringBuilder();
		PrintWriter  out = null; 
		try {
			out = ServletActionContext.getResponse().getWriter();
			List<FlupItemResponse>  list=new ArrayList<FlupItemResponse>();
			if(map.get("flupTimes").equals("1")){
				list = flupItemResponseService.findPreview(request.getParameter("flupNameId"));
			}else{
				 list = flupItemResponseService.findPreviews(map);
				 if(list==null || list.size()==0){
					 list = flupItemResponseService.findPreview(request.getParameter("flupNameId"));
				 }
			}
			sb.append(FlupItemResponseTableView.getTable(list,request.getParameter("showButton")));
			out.print(sb);
		}catch (Exception e) {
			out.print("error");
			e.printStackTrace();
		}
			return null;
	}
	
	
	/***
	 * 预览下分组查询
	 */
	public String findFlupTemplate(){
		HttpServletRequest  request = ServletActionContext.getRequest();
		StringBuilder sb = new StringBuilder();
		PrintWriter out=null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			List<FlupItemResponse>  list = flupItemResponseService.findPreview(request.getParameter("flupNameId"));
			sb.append(FlupItemResponseTableView.getTable(list,request.getParameter("showButton")));
			out.print(sb);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.print("error");
			e.printStackTrace();
		} 
		
		return null;
	}
	
	/******
	 * 查询
	 */
	public String findItems(){
		
			List<FlupItemResponse>  list = flupItemResponseService.getFlupItems(map.get("flupNameId"));
			Map<String,List<FlupItemResponse>> m=new HashMap<String,List<FlupItemResponse>>();
			m.put("rows", list);
			JsonUtil.jsonData(m);
			return null;
	}
	
	/****
	 * 导出到word文档
	 * @throws IOException 
	 */
	public String exportWord() throws IOException{
		StringBuffer sb = new StringBuffer("");
		HttpServletResponse response = ServletActionContext.getResponse();
		String name = ServletActionContext.getRequest().getParameter("flupNames");
		String flupNameId = ServletActionContext.getRequest().getParameter("flupNameId");
		//姓名等
		String Patientname = ServletActionContext.getRequest().getParameter("Patientname");
		String gender = ServletActionContext.getRequest().getParameter("Patgender");
		String age = ServletActionContext.getRequest().getParameter("Patage");
		String patiSerial = ServletActionContext.getRequest().getParameter("PatpatiSerial");
		String PatfamilyNumber = ServletActionContext.getRequest().getParameter("PatfamilyNumber");
		String PatrelationMobileNumber = ServletActionContext.getRequest().getParameter("PatrelationMobileNumber");
		String department = ServletActionContext.getRequest().getParameter("Patdepartment");
		List<FlupItemResponse>  list = flupItemResponseService.findPreview(flupNameId);
//		List<FlupItemResponse>  list = flupItemResponseService.findPreviews(map);
		if(list.size()>0){
			sb.append(FlupItemResponseTableView.getTable(list,ServletActionContext.getRequest().getParameter("showButton")));
		}
		String html="<html><body>";
		html+="<table style='width: 1100px;'>";
		html+="<tr><td colSpan='4' align='center'><h2>上海市东方医院（同济大学附属医院）</h2></td></tr>";
		html+="<tr><td colSpan='4' align='center'>"+name+"&nbsp;</td></tr>";
		html+="<tr><td>姓名："+Patientname+"&nbsp;</td><td>性别："+gender+"&nbsp;</td><td>年龄："+age+"&nbsp;</td><td>住院号："+patiSerial+"&nbsp;</td></tr>";
		html+="<tr><td colSpan='2' >联系方式（电话或手机）："+PatfamilyNumber+"("+PatrelationMobileNumber+")"+"&nbsp;</td><td colSpan='2'>出院科室："+department+"&nbsp;</td></tr>";
		html+="</table>";
		html+= sb.toString();
		html += "</body></html>";
        byte b[] = html.getBytes("UTF-8");    
        ByteArrayInputStream bais = new ByteArrayInputStream(b);    
        POIFSFileSystem poifs = new POIFSFileSystem();    
        DirectoryEntry directory = poifs.getRoot();    
        DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);    
        //输出文件  
        response.reset();  
        response.setHeader("Content-Disposition",  
                 "attachment;filename=" +  
                 new String( (name + ".doc").getBytes(),  
                            "iso-8859-1"));  
        response.setContentType("application/msword");  
        OutputStream ostream = response.getOutputStream();   
        //输出到本地文件的话，new一个文件流  
        //FileOutputStream ostream = new FileOutputStream(path+ fileName);    
        poifs.writeFilesystem(ostream);    
        bais.close();    
        ostream.close();   
		return null;
	}
}
