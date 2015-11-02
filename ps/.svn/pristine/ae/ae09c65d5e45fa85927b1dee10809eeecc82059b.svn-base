package com.linkonworks.df.busi.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * Action工具类
 * 
 * @author lili
 * 
 */
public abstract class ActionUtil {

	/**
	 * 获得HttpServletResponse对象
	 */
	public static HttpServletResponse getHttpServletResponse() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		return response;
	}

	/**
	 * 获得HttpServletRequest对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		return request;
	}

	/**
	 * 获取HttpSession对象
	 * 
	 * @return
	 */
	public static Map<String, Object> getHttpSession() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		return session;
	}

	/**
	 * 获取Application对象
	 * 
	 * @return
	 */
	public static Map<String, Object> getApplication() {
		Map<String, Object> application = ActionContext.getContext()
				.getApplication();
		return application;
	}

	/**
	 * 输出字符串
	 */
	public static void print(Object str) {
		try {
			PrintWriter out = getHttpServletResponse().getWriter();
			out.print(str.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 以JSON格式打印参数信息（调试方法）
	 */
	public static void printParamsJSON() {
		JSONObject jsonObject = new JSONObject();
		Map paramMap = getHttpServletRequest().getParameterMap();
		jsonObject.putAll(paramMap);
		System.out.println("请求参数：" + jsonObject);
	}

	// 编码
	public static String paramEncoding(String title)
			throws UnsupportedEncodingException {
		String method = ActionUtil.getHttpServletRequest().getMethod();
		if (method.equalsIgnoreCase("get")) {
			if (title != null) {
				title = java.net.URLDecoder.decode(title);
				title = new String(title.getBytes("iso-8859-1"), "UTF-8");
			}
		} else {
			try {
				ActionUtil.getHttpServletRequest()
						.setCharacterEncoding("UTF-8");

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return title;
	}

}
