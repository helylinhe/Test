package com.linkonworks.df.busi.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.service.PatiDiseaseDetailService;
import com.linkonworks.df.busi.utils.JsonUtil;
import com.linkonworks.df.busi.utils.WordWriterUtil;
import com.linkonworks.df.vo.Employee;
import com.linkonworks.df.vo.FlupTask;
import com.linkonworks.df.vo.MobileFlup;
import com.linkonworks.df.vo.PatiDiseaseDetail;
import com.opensymphony.xwork2.ActionSupport;

public class PatiDiseaseDetailAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PatiDiseaseDetailService patiDiseaseDetailService;
	private Map<String,String> map=new HashMap<String,String>();
	private Page<PatiDiseaseDetail> page=new Page<PatiDiseaseDetail>();
	

	public PatiDiseaseDetailService getPatiDiseaseDetailService() {
		return patiDiseaseDetailService;
	}

	public void setPatiDiseaseDetailService(
			PatiDiseaseDetailService patiDiseaseDetailService) {
		this.patiDiseaseDetailService = patiDiseaseDetailService;
	}
	
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	

	public Page<PatiDiseaseDetail> getPage() {
		return page;
	}

	public void setPage(Page<PatiDiseaseDetail> page) {
		this.page = page;
	}
	
	
	/*****
	 * 加载院区信息
	 */
	public String loadHosptialConfig(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		JsonUtil.jsonDataList((List)session.getAttribute("hospitalCode"));
		return null;
	}

	/*****
	 * 批量添加数据
	 */
	
	public String addDisease(){
		List<PatiDiseaseDetail> list=new ArrayList<PatiDiseaseDetail>();
		/**
		 * 获取登录信息
		 */
		HttpSession session=ServletActionContext.getRequest().getSession();
		Employee employee=(Employee) session.getAttribute("employee");
		HttpServletRequest  request = ServletActionContext.getRequest();
		String arr[]=request.getParameterValues("map.group[]");
		String diseaseNameId=map.get("diseaseNameId");
		String patiSerial=map.get("patiSerial");
		String inpatiNumber=map.get("inpatiNumber");
		String inpatiSerialNumber=map.get("inpatiSerialNumber");
		String medicalInsuranceCode=map.get("medicalInsuranceCode");
		String name=map.get("name");
		String gender=map.get("gender");
		String age=map.get("age");
		String unitCode=map.get("unitCode");
		String detailId=map.get("detailId");
		if(detailId!=null && !detailId.equals("")){
			patiDiseaseDetailService.deletePatiDiseaseDetailInfo(detailId);
		}
		String uuid=UUID.randomUUID().toString();
		PatiDiseaseDetail p=null;
		for(int i=0;i<arr.length;i++){
			String str[]=arr[i].split(",");
			p=new PatiDiseaseDetail();
			p.setGroupOne(str[0].replaceAll("null", ""));
			p.setGroupTwo(str[1].replaceAll("null", ""));
			p.setDataType(str[2].replaceAll("null", ""));
			p.setDiseaseGroupId(str[3].replaceAll("null", ""));
			p.setItemName(str[4].replaceAll("null", ""));
			p.setItemValue(str[5].replaceAll("null", ""));
			p.setDiseaseNameId(diseaseNameId);
			p.setInpatiNumber(inpatiNumber);
			p.setPatiSerial(patiSerial);
			p.setInpatiSerialNumber(inpatiSerialNumber);
			p.setMedicalInsuranceCode(medicalInsuranceCode);
			p.setName(name);
			p.setAge(age);
			p.setGender(gender);
			p.setOperateEmployeeCode(employee.getJobnum());
			p.setUnitCode(unitCode);
			p.setDetailId(uuid);
			list.add(p);
		}
		int result=patiDiseaseDetailService.inserBatch(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			PrintWriter out=response.getWriter();
			out.print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*****
	 * 获取病人下的所有化疗历史记录
	 */
	public String HistoryDiseaseList(){
		page.setParams(map);
		Map<String,Object> maplist=new HashMap<String,Object>();
		maplist.put("rows",patiDiseaseDetailService.historyDiseasePage(page));
		maplist.put("totalRecord",page.getTotalRecord());
		maplist.put("totalPage", page.getTotalPage());
		maplist.put("pageNo", page.getPageNo());
		JsonUtil.jsonData(maplist);
		return null;
	}
	
	/****
	 * 获取历史信息
	 */
	public String HistroyDiseaseItems(){
		List<PatiDiseaseDetail> patisDiseases=patiDiseaseDetailService.diseaseItems(map);
		JsonUtil.jsonDataList(patisDiseases);
			return null;
	}
	
	
	/******
	 * 导出word文档
	 * @throws IOException 
	 */
	public String exportHistoryDiseaseInfo() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		//String name = ServletActionContext.getRequest().getParameter("diseaseName");
		String content = ServletActionContext.getRequest().getParameter("content");
		String html="<html><body>";
		
		html += content;
		html += "</body></html>";
        byte b[] = html.getBytes("UTF-8");    
        ByteArrayInputStream bais = new ByteArrayInputStream(b);    
        POIFSFileSystem poifs = new POIFSFileSystem();    
        DirectoryEntry directory = poifs.getRoot();    
        DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);    
        //输出文件  
        response.reset();  
        String name = "化疗信息";
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
