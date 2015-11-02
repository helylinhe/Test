package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.service.DictService;
import com.linkonworks.df.vo.Dict;
import com.opensymphony.xwork2.ActionSupport;

public class DictAction extends ActionSupport{

	private DictService dictService;
	private String echoSerial;

	public DictService getDictService() {
		return dictService;
	}

	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	
	public String getEchoSerial() {
		return echoSerial;
	}

	public void setEchoSerial(String echoSerial) {
		this.echoSerial = echoSerial;
	}

	public String dictData(){
		List<Dict> dict=dictService.getCommentCodeType(echoSerial);
		JSON json=JSONArray.fromObject(dict);
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
	
	
	/***
	 * 获取多个字典数据，在JS进行出来分开
	 */
	public String dictAllData(){
		List list=new ArrayList();
		String arr[]=echoSerial.split(",");
		for(int i=0;i<arr.length;i++){
			list.add(arr[i]);
		}
		List<Dict> dict=dictService.commentAllCode(list);
		JSON json=JSONArray.fromObject(dict);
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
	
}
