package com.linkonworks.df.busi.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.service.FirstTreatService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.SessionData;
import com.linkonworks.df.vo.Check;
import com.linkonworks.df.vo.Department;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.Inspect;
import com.linkonworks.df.vo.Pati;
import com.linkonworks.df.vo.PatiOperate;
import com.opensymphony.xwork2.ActionSupport;

public class FirstTreatAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8101343113638655132L;

	private Map<String, String> map = new HashMap<String, String>();
	private FirstTreatService firstTreatService;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public FirstTreatService getFirstTreatService() {
		return firstTreatService;
	}

	public void setFirstTreatService(FirstTreatService firstTreatService) {
		this.firstTreatService = firstTreatService;
	}

	/*****
	 * 获取患者出院当天信息
	 */

	@SuppressWarnings( { "unchecked", "unchecked" })
	public String findPatiInfo() {
		Map<String, Object> hashmap = new HashMap<String, Object>();
		List<Department> deptcodes = SessionData.getDepartmentCode();
		String deptcode = "";
		Employee employee = (Employee) ServletActionContext.getRequest()
				.getSession().getAttribute("employee");
		if (employee.getName() != null
				&& employee.getName().equals("admin")) {
			hashmap.put("deptCode",deptcode);
		} else {

			for (Department d : deptcodes) {
				if (d.getDeptCode() != null && !d.getDeptCode().equals("")) {
					deptcode += d.getDeptCode() + ",";
				} else {
					continue;
				}
			}
			hashmap.put("deptCode", deptcode.substring(0, deptcode.length()));
		}
		hashmap.put("unitCode", map.get("deptCode"));
		hashmap.put("medicalInsuranceCode", map.get("medicalInsuranceCode"));
		hashmap.put("inpatiNumber", map.get("inpatiNumber"));
		hashmap.put("name", map.get("name"));
		 
		
		List<Map<String, String>> list = firstTreatService.getPatiInfo(hashmap);// FirstTreatMapper.xml
		Map<String, Object> obj = new HashMap<String, Object>();
		List<Pati> patiList = new ArrayList<Pati>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Pati p = null;
		for (int i = 0; i < list.size(); i++) {
			p = new Pati();
			p.setInpatiNumber(list.get(i).get("inpatiNumber"));
			p.setPatiSerial(list.get(i).get("patiSerial"));
			p.setInpatiSerialNumber(list.get(i).get("inpatiSerialNumber"));
			p.setBillingName(list.get(i).get("billingName"));
			p.setName(list.get(i).get("name"));
			p.setGender(list.get(i).get("gender"));
			p.setBirthDate(sdf.format(list.get(i).get("birthDate")));
			p.setCountry(list.get(i).get("country"));
			p.setMobileNumber(list.get(i).get("mobileNumber"));
			p.setMarried(list.get(i).get("married"));
			p.setOperationDoctorCode(list.get(i).get("operationDoctorCode"));
			p.setAccountAddr(list.get(i).get("addr"));
			p.setDoctorName(list.get(i).get("doctor"));
			p.setInHospitalDiag(list.get(i).get("inHospDiag"));
			p.setInHospitalDate(sdf.format(list.get(i).get("inHospitalDate")));
			p.setMedicalInsuranceCode(list.get(i).get("medicalInsuranceCode"));
			p.setDeptCode(list.get(i).get("deptCode"));
			// p.setAge(age)

			patiList.add(p);
		}
		obj.put("rows", patiList);
		// JsonUtil.jsonData(obj);

		JSON json = JSONArray.fromObject(obj);
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

	/****
	 * 患者检验信息
	 * 
	 * @return
	 */
	public String findInspectInfo() {
		Map<String, Object> inspectMap = new HashMap<String, Object>();
		List<Inspect> list = firstTreatService.getInspectInfo(map);
		inspectMap.put("rows", list);
		JsonUtil.jsonData(inspectMap);
		return null;
	}

	/*****
	 * 患者检查信息
	 */
	public String findCheckInfo() {
		Map<String, Object> checkMap = new HashMap<String, Object>();
		List<Check> checklist = firstTreatService.getCheckInfo(map);
		checkMap.put("rows", checklist);
		JsonUtil.jsonData(checkMap);
		return null;
	}

	/******
	 * 加载手术信息
	 */
	public String findOperationInfo() {
		PatiOperate operate = firstTreatService.findOperationInfo(map);
		HttpServletResponse response = ServletActionContext.getResponse();
		JSON json = JSONArray.fromObject(operate);
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*****
	 * 保存患者病例信息
	 */
	public String savePatiCase() {
		int result = firstTreatService.savePatiCase(map);
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

}
