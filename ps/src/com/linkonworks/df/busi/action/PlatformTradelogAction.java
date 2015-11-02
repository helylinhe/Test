package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.PlatformTradelogService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.vo.InteBusi;
import com.linkonworks.df.vo.Interfactory;
import com.linkonworks.df.vo.PlatformTradelog;
import com.opensymphony.xwork2.ActionSupport;

public class PlatformTradelogAction  extends ActionSupport{

	private PlatformTradelogService platformTradelogService;
	private Page  page=new Page();
	private Map<String,String> map=new HashMap<String,String>();
	
	
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public PlatformTradelogService getPlatformTradelogService() {
		return platformTradelogService;
	}

	public void setPlatformTradelogService(
			PlatformTradelogService platformTradelogService) {
		this.platformTradelogService = platformTradelogService;
	}
	
	/****
	 * 获取列表
	 * @return
	 */
	public String pageList(){
		page.setParams(map);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("rows", platformTradelogService.getPageList(page));
		pMap.put("totalRecord", page.getTotalRecord());
		pMap.put("totalPage", page.getTotalPage());
		pMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(pMap);
		return null;
	}
	
	/****
	 * 获取厂家名称
	 */
	public String factoryList(){
		List<Interfactory> list=platformTradelogService.getFactoryList();
		JsonUtil.jsonDataList(list);
		return null;
	}
	
	/****
	 * 获取业务信息
	 */
	public String busiList(){
		List<InteBusi> busiList=platformTradelogService.getInteBusi();
		JsonUtil.jsonDataList(busiList);
		return null;
	}
	/**
	 * 根据条件分页查询配置信息列表
	 */
	public void searchPageList(){
		page.setParams(map);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("rows", platformTradelogService.searchPageList(page));
		pMap.put("totalRecord", page.getTotalRecord());
		pMap.put("totalPage", page.getTotalPage());
		pMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(pMap);
	}
	/**
	 * 查看异常明细
	 */
	public void findPageList(){
		page.setParams(map);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("rows", platformTradelogService.findPageList(page));
		pMap.put("totalRecord", page.getTotalRecord());
		pMap.put("totalPage", page.getTotalPage());
		pMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(pMap);
	}
	/**
	 * 查看访问明细
	 */
	public void visitList(){
		page.setParams(map);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("rows", platformTradelogService.visitList(page));
		pMap.put("totalRecord", page.getTotalRecord());
		pMap.put("totalPage", page.getTotalPage());
		pMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(pMap);
	}
	/**
	 * 获取柱状图数据
	 */
	public void findChart(){
		if(map.get("factoryNo").equals("undefined")){
			map.put("factoryNo", null);
		}
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		List<PlatformTradelog> tradelogs=new ArrayList<PlatformTradelog>();
		tradelogs=platformTradelogService.findChart( map);
	      for (PlatformTradelog pt : tradelogs) {
	    	  Map<String, Object> map1 = new HashMap<String, Object>();  
	    	  /* 获取信息 */  
	    	  map1.put("opeDatetime", pt.getOpeDatetime());
	    	  map1.put("GHW", pt.getGHW());
	    	  map1.put("QMGS", pt.getQMGS());
	    	  list.add(map1);
		}
	      Map<String, Object> map2 = new HashMap<String, Object>();  
	      map2.put("RowCount",list.size());  
	      map2.put("Rows", list);  
	      JsonUtil.jsonData(map2);
	}
	
	/*****
	 * 保存业务信息
	 */
	public String addIntentBusi(){
		InteBusi busi=new InteBusi();
		busi.setBusiState("1");
		busi.setAbnormalNum(map.get("abnormalNum"));
		busi.setBusiName(map.get("busiName"));
		busi.setBusiNo(map.get("busiNo"));
		busi.setCallNum(map.get("callNum"));
		busi.setFactoryId(map.get("factoryId"));
		busi.setFactoryName(map.get("factoryName"));
		int result=platformTradelogService.addInteBusi(busi);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*****
	 * 修改业务信息
	 */
	public String updateIntBusi(){
		
		int result=platformTradelogService.updateInteBusi(map);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*****
	 * 修改业务状态
	 */
	public String updateIntState(){
		int result=platformTradelogService.updateState(map);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/****
	 * 平台接入字典表展示
	 */
	public String pageImportTables(){
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("rows", platformTradelogService.pageImportPage(page));
		pMap.put("totalRecord", page.getTotalRecord());
		pMap.put("totalPage", page.getTotalPage());
		pMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(pMap);
		return null;
	}
	
	/****
	 * callcenter中心日志列表
	 */
	public String pageCallCenter(){
		page.setParams(map);
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("rows", platformTradelogService.pageCallCenterLog(page));
		pMap.put("totalRecord", page.getTotalRecord());
		pMap.put("totalPage", page.getTotalPage());
		pMap.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(pMap);
		return null;
	}
	
	
	public String getIntenBusi(){
		List<InteBusi> busi=platformTradelogService.getBusi(map);
		JsonUtil.jsonDataList(busi);
		return null;
	}
	
	
	/****
	 * 调用表详细信息
	 */
	@SuppressWarnings("deprecation")
	public String getTableNameDetail(){
		
		List<Map<String,String>> list=platformTradelogService.getColums(map);
		Map<String,String> hashmap = new HashMap<String,String>();
		hashmap.put("tableName", "LKPSPF."+map.get("tableName").toString());
		hashmap.put("unitCode", map.get("unitCode"));
		page.setParams(hashmap);
		List<Map<String,Object>> tables=platformTradelogService.getTabelNameDetail(page);
		String str="";
		String userStr="";
		for(Map<String, String> mc : list){
			int zc=1;
			str += "{";
			for (String keycolumn : mc.keySet()) {
				if(zc==mc.keySet().size()){
		    		str += "\"title\":"+"\""+JsonUtil.replaceBlank(mc.get(keycolumn).trim())+"\"";
		    	}else{
		    		str += "\"field\":"+"\""+JsonUtil.replaceBlank(mc.get(keycolumn).trim())+"\",";
		    		
		    	}
		    	zc++;
			}
			str+=",\"width\":100,\"resizable\":true},";
		}
		for (Map<String, Object> m : tables) {
			userStr +="{";
			int z=1;
		    for (String k : m.keySet()) {
		    	if(z==m.keySet().size()){
		    		userStr += "\""+k+"\"" + ":"+"\""+JsonUtil.replaceBlank(m.get(k).toString().trim())+"\"";
		    	}else{
		    		userStr += "\""+k+"\"" + ":"+"\""+JsonUtil.replaceBlank(m.get(k).toString().trim())+"\",";
		    	}
		    	z++;
		    }
		    userStr+="},";
		}
		String rows="";
		if(userStr!=null && !userStr.equals("")){
			 rows=userStr.substring(0, userStr.length()-1);
		}else{
			rows=userStr;
		}
		String columns=str.substring(0, str.length()-1);
		//String result="{\"total\":2,\"columns\":[[{\"field\":\"ROLE_ID\",\"title\":\"ROLE_ID\",\"width\":100,\"resizable\":true},{\"field\":\"NAME\",\"title\":\"NAME\",\"width\":100,\"resizable\":true}]],\"rows\":[{\"NAME\":\"调度人员\",\"ROLE_ID\":\"8\"},{\"NAME\":\"调度人员\",\"ROLE_ID\":\"9\"}]}";
		String result="{\"total\":"+page.getTotalRecord()+",\"columns\":[["+columns+"]],\"rows\":["+rows+"]}";
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/****
	 * 获取异常信息
	 */
	public String ExceptionMessage(){
		List<PlatformTradelog> expections=platformTradelogService.expecetionMessage();
		JsonUtil.jsonDataList(expections);
		return null;
	}
}
