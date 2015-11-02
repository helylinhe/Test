package com.linkonworks.df.busi.action;

import io.netty.handler.codec.http.HttpRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.FileIndexService;
import com.linkonworks.df.busi.service.FlupDynamicService;
import com.linkonworks.df.busi.utils.FlupItemResponseTableView;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.MobileWardUtil;
import com.linkonworks.df.vo.DataImportRule;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FileIndex;
import com.linkonworks.df.vo.FlupDynamic;
import com.linkonworks.df.vo.FlupItemResponse;
import com.opensymphony.xwork2.ActionSupport;

public class FileIndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2751332650489174047L;

	private FileIndexService fileIndexService;
	private FlupDynamicService flupDynamicService;
	private Page<DataImportRule> page = new Page<DataImportRule>(); // 参数传递(pageSize
	// pageNumber)
	private Map<String, String> map = new HashMap<String, String>(); // 参数传递(筛选条件参数)
	private Map<Object, Object> map2 = new HashMap<Object, Object>();
	private FileIndex fileIndex;

	public Map<Object, Object> getMap2() {
		return map2;
	}

	public void setMap2(Map<Object, Object> map2) {
		this.map2 = map2;
	}

	public FlupDynamicService getFlupDynamicService() {
		return flupDynamicService;
	}

	public void setFlupDynamicService(FlupDynamicService flupDynamicService) {
		this.flupDynamicService = flupDynamicService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public FileIndex getFileIndex() {
		return fileIndex;
	}

	public void setFileIndex(FileIndex fileIndex) {
		this.fileIndex = fileIndex;
	}

	public Page<DataImportRule> getPage() {
		return page;
	}

	public void setPage(Page<DataImportRule> page) {
		this.page = page;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public FileIndexService getFileIndexService() {
		return fileIndexService;
	}

	public void setFileIndexService(FileIndexService fileIndexService) {
		this.fileIndexService = fileIndexService;
	}

	// 调阅电子病历
	public String findFileIndex() {
		page.setParams(map);
		List<FileIndex> list = fileIndexService.findPageList(page);
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("rows", list);
		json.put("totalRecord", page.getTotalRecord());
		json.put("totalPage", page.getTotalPage());
		json.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(json);
		return null;
	}

	// 查询病人电子病例信息
	public String findFileIndexShow() {
		String urlString = MobileWardUtil.getPatiFileInfo(
				fileIndex.getPatientId(), fileIndex.getVisitId(),
				fileIndex.getFileNo(), fileIndex.getUnitCode());
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			PrintWriter out = response.getWriter();
			out.print(urlString);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Map<String, Object> json = new HashMap<String, Object>();
		 * json.put("url", urlString); JsonUtil.jsonData(json);
		 */
		return null;
	}

	// 根据病人编号、住院编号、住院流水号查询随访项列表中的所有随访
	public void findAllFlupDynamic() {
		List<FlupItemResponse> list = flupDynamicService
				.findAllFlupDynamic(map);
		int listSize=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFlupGroupId2()!=null)
			{
				listSize=1;
				break;
			}
		}
		if (listSize ==0) {
			list = flupDynamicService.dynamicFlupItems(map);
		}
		String strHtml = FlupItemResponseTableView.getNextTable(list);
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print(strHtml);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.print("error");
			e.printStackTrace();
		}

	}

	// 2014-12-11 韦
	public String addFlupDynamic() {
		HttpServletRequest request = (HttpServletRequest) ServletActionContext
				.getRequest();
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		List<FlupDynamic> list = new ArrayList<FlupDynamic>();
		FlupDynamic d = null;
		String deptCode = map.get("deptCode");
		String jobNum = employee.getJobnum();
		String flupFlag = "1";
		String flupNameId = map.get("flupNameId");
		String flupTimes = map.get("flupTimes");
		String inHospitalDate = map.get("inHospitalDate");
		String outHospitalDate = map.get("outHospitalDate");
		String inpatiNumber = map.get("inpatiNumber");
		String patiSerial = map.get("patiSerial");
		String inpatiSerialNumber = map.get("inpatiSerialNumber");
		String insuranceNo = map.get("insuranceNo");

		String arr[] = request.getParameterValues("map.group[]");
		for (int i = 0; i < arr.length; i++) {
			d = new FlupDynamic();
			String brr[] = arr[i].split("_");
			d.setFlupGroupId(brr[0]);
			d.setShowNo(brr[1].replaceAll(",", ""));
			d.setDeptCode(deptCode);
			d.setEmployeeCode(jobNum);
			d.setFlupFlag(flupFlag);
			d.setFlupNameId(flupNameId);
			d.setFlupTimes(flupTimes);
			d.setInHospitalDate(inHospitalDate);
			d.setOutHospitalDate(outHospitalDate);
			d.setInpatiNumber(inpatiNumber);
			d.setPatiSerial(patiSerial);
			d.setInpatiSerialNumber(inpatiSerialNumber);
			d.setInsuranceNo(insuranceNo);
			list.add(d);

		}
		//删除旧数据
		flupDynamicService.removeFlupDynamic(map);
		//保存新数据
		String result = flupDynamicService.addFlupItems(list);
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print(result);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.print("error");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据选中的用户信息及设置随访项的次数 删除该用户本次随访的随访项 添加用户所选中的随访项
	 */
	public void editFlupDynamic() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		map.put("employeeCode", employee.getJobnum());
		HttpServletRequest request = ServletActionContext.getRequest();
		String flupGroupIds[] = request
				.getParameterValues("map2.flupGroupId[]");
		String showNos[] = request.getParameterValues("map2.showNo[]");

		this.flupDynamicService.removeFlupDynamic(map);
		if (flupGroupIds != null) {
			for (int i = 0; i < flupGroupIds.length; i++) {
				map.put("flupGroupId", flupGroupIds[i]);
				map.put("showNo", showNos[i]);
				this.flupDynamicService.addFlupDynamic(map);
			}
		}

	}
}
