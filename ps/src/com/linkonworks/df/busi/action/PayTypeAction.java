package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import com.linkonworks.df.busi.service.PayTypeService;
import com.linkonworks.df.vo.PayType;
import com.opensymphony.xwork2.ActionSupport;

public class PayTypeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7311943883371566405L;
	private PayTypeService payTypeService;

	public String queryAll() {
		List<PayType> list = payTypeService.queryAll();
		JSON json = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public PayTypeService getPayTypeService() {
		return payTypeService;
	}

	public void setPayTypeService(PayTypeService payTypeService) {
		this.payTypeService = payTypeService;
	}

}
