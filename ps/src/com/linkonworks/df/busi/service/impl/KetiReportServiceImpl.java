package com.linkonworks.df.busi.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.KetiReportDao;
import com.linkonworks.df.busi.service.KetiReportService;


public class KetiReportServiceImpl implements KetiReportService {

	private KetiReportDao ketiReportDao;

	public KetiReportDao getKetiReportDao() {
		return ketiReportDao;
	}

	public void setKetiReportDao(KetiReportDao ketiReportDao) {
		this.ketiReportDao = ketiReportDao;
	}

	@Override
	public HSSFWorkbook exportReportData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		//String reportName=(String) map.get("reportName");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String d=sdf.format(new Date());
		
		//创建一个workbook
		
		HSSFWorkbook qubbb = new HSSFWorkbook();
		
		/****
		 * 样式设置
		 */
		HSSFCellStyle style = qubbb.createCellStyle(); // 样式对象   
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平   
        style.setWrapText(true); 
       
        /*****
         * 
         * 创建EXCEL HEADER部分
         */
		HSSFSheet sheet = qubbb.createSheet("课题报表");
		sheet.setHorizontallyCenter(true);
		HSSFRow rowTitle= sheet.createRow(0);
		HSSFCell cellTitel = rowTitle.createCell(0);
		HSSFFont  f=qubbb.createFont();
		HSSFCellStyle s = qubbb.createCellStyle(); 
		
		 
        HSSFFont font = qubbb.createFont();
        font.setColor(HSSFFont.COLOR_RED);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        s.setFont(font);
		
		 
		 s.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 s.setFont(font); 
		 s.setFillBackgroundColor(HSSFColor.DARK_BLUE.index);
		 cellTitel.setCellValue("课题报表") ;
	        
	        //可以设置跨行，跨列显示
	         sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,89));
			//创建行
			HSSFRow row= sheet.createRow(1);
			HSSFCell cell = row.createCell(0);
			cell.setCellStyle(s);
	        cell.setCellValue("一般指标");
	        //可以设置跨行，跨列显示
	         sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 8));
	         
	          HSSFCell cell1=row.createCell(9);
	          cell1.setCellStyle(s);
	          cell1.setCellValue("肝功能");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 9, 14));
	          
	          
	          HSSFCell cell2=row.createCell(15);
	          cell2.setCellStyle(s);
	          cell2.setCellValue("肾功能");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 15,19));
	          
	          HSSFCell cell3=row.createCell(20);
	          cell3.setCellStyle(s);
	          cell3.setCellValue("血脂全套");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 20,24));
	          
	          HSSFCell cell4=row.createCell(25);
	          cell4.setCellStyle(s);
	          cell4.setCellValue("电解质");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 25,29));
	          
	          HSSFCell cell5=row.createCell(30);
	          cell5.setCellStyle(s);
	          cell5.setCellValue("血糖指标");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 30,37));
	          
	          
	          HSSFCell cell6=row.createCell(38);
	          cell6.setCellStyle(s);
	          cell6.setCellValue("胰岛素相关抗体");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 38,40));
	          
	          
	          HSSFCell cell7=row.createCell(41);
	          cell7.setCellStyle(s);
	          cell7.setCellValue("精氨酸实验");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 41,50));
	          
	          HSSFCell cell8=row.createCell(51);
	          cell8.setCellStyle(s);
	          cell8.setCellValue("尿蛋白");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 51,52));
	          
	          HSSFCell cell9=row.createCell(53);
	          cell9.setCellStyle(s);
	          cell9.setCellValue("甲状腺功能");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 53,61));
	          
	          HSSFCell cell10=row.createCell(62);
	          cell10.setCellStyle(s);
	          cell10.setCellValue("骨指标");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 62,67));
	          
	          HSSFCell cell11=row.createCell(68);
	          cell11.setCellStyle(s);
	          cell11.setCellValue("肿瘤指标");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 68,76));
	          
	          HSSFCell cell12=row.createCell(77);
	          cell12.setCellStyle(s);
	          cell12.setCellValue("血管超声");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 77,81));
	          
	          HSSFCell cell13=row.createCell(82);
	          cell13.setCellStyle(s);
	          cell13.setCellValue("甲状腺超声");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 82,82));
	          
	          HSSFCell cell14=row.createCell(83);
	          cell14.setCellStyle(s);
	          cell14.setCellValue("甲状腺疾病相关治疗");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 83,83));
	          
	          HSSFCell cell15=row.createCell(84);
	          cell15.setCellStyle(s);
	          cell15.setCellValue("眼底检查");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 84,84));
	          
	          HSSFCell cell16=row.createCell(85);
	          cell16.setCellStyle(s);
	          cell16.setCellValue("既往降糖用药");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 85,87));
	          
	          HSSFCell cell17=row.createCell(88);
	          cell17.setCellStyle(s);
	          cell17.setCellValue("出院治疗方案");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 88,88));
	          
	          HSSFCell cell18=row.createCell(89);
	          cell18.setCellStyle(s);
	          cell18.setCellValue("既往疾病");
	          sheet.addMergedRegion(new CellRangeAddress(1, 1, 89,89));
	          
	          /*
	           * 创建列名称
	           */
	         
	          HSSFRow row1= sheet.createRow(2);
	          
	          HSSFCell inpatiNumber= row1.createCell(0);
	          inpatiNumber.setCellStyle(s);
	          inpatiNumber.setCellValue("住院号");
	          
	          HSSFCell name= row1.createCell(1);
	          name.setCellStyle(s);
	          name.setCellValue("姓名");
	          
	          HSSFCell gender= row1.createCell(2);
	          gender.setCellStyle(s);
	          gender.setCellValue("性别");
	          
	          HSSFCell age= row1.createCell(3);
	          age.setCellStyle(s);
	          age.setCellValue("年龄");
	          
	          HSSFCell shengao= row1.createCell(4);
	          shengao.setCellStyle(s);
	          shengao.setCellValue("身高(cm)");
	          
	          HSSFCell weight= row1.createCell(5);
	          weight.setCellStyle(s);
	          weight.setCellValue("体重(kg)");
	          
	          HSSFCell bmi= row1.createCell(6);
	          bmi.setCellStyle(s);
	          bmi.setCellValue("BMI(kg/m2)");
	          
	          HSSFCell highBloodPressure= row1.createCell(7);
	          highBloodPressure.setCellStyle(s);
	          highBloodPressure.setCellValue("有无合并高血压");
	          
	          HSSFCell diabetes = row1.createCell(8);
	          diabetes.setCellStyle(s);
	          diabetes.setCellValue("糖尿病病程");
	          
	          
	          HSSFCell column1= row1.createCell(9);
	          column1.setCellStyle(s);
	          column1.setCellValue("ALT(U/L)");
	          
	          
	          HSSFCell column2= row1.createCell(10);
	          column2.setCellStyle(s);
	          column2.setCellValue("AST(U/L)");
	          
	          //AST(U/L)
	          
	          HSSFCell column3= row1.createCell(11);
	          column3.setCellStyle(s);
	          column3.setCellValue("r-GT(U/L)");
	          
	          HSSFCell column4= row1.createCell(12);
	          column4.setCellStyle(s);
	          column4.setCellValue("ALP");
	          
	        
	          HSSFCell column5= row1.createCell(13);
	          column5.setCellStyle(s);
	          column5.setCellValue("白蛋白(g/L)");
	          
	          
	          HSSFCell column6= row1.createCell(14);
	          column6.setCellStyle(s);
	          column6.setCellValue("前白蛋白(mg/L)");
	          
	          HSSFCell column7= row1.createCell(15);
	          column7.setCellStyle(s);
	          column7.setCellValue("肌酐(umol/L)");
	          
	          
	         
	          
	          HSSFCell column8= row1.createCell(16);
	          column8.setCellStyle(s);
	          column8.setCellValue("尿素氮(mmol/L)");
	          
	          HSSFCell column9= row1.createCell(17);
	          column9.setCellStyle(s);
	          column9.setCellValue("尿酸(umol/L)");
	          
	          HSSFCell column10= row1.createCell(18);
	          
	          column10.setCellStyle(s);
	          
	          column10.setCellValue("视黄醇蛋白(mg/L)");
	          
	          HSSFCell column11= row1.createCell(19);
	          column11.setCellStyle(s);
	          column11.setCellValue("胱抑素C(mg/L)");
	          
	          HSSFCell column12= row1.createCell(20);
	          column12.setCellStyle(s);
	          column12.setCellValue("甘油三脂(mmol/L)");
	          
	          HSSFCell column13= row1.createCell(21);
	          column13.setCellStyle(s);
	          column13.setCellValue("总胆固醇(mmol/L)");
	          
	          HSSFCell column14= row1.createCell(22);
	          column14.setCellStyle(s);
	          column14.setCellValue("LDL(mmol/L)");
	          
	          HSSFCell column15= row1.createCell(23);
	          column15.setCellStyle(s);
	          column15.setCellValue("HDL(mmol/L)");
	          
	         
	          
	          HSSFCell column16= row1.createCell(24);
	          column16.setCellStyle(s);
	          column16.setCellValue("脂蛋白a");
	          
	          HSSFCell column17= row1.createCell(25);
	          column17.setCellStyle(s);
	          column17.setCellValue("钾(mmol/L)");
	          
	          HSSFCell column18= row1.createCell(26);
	          column18.setCellStyle(s);
	          column18.setCellValue("钠（mmol/L）");
	          
	          HSSFCell column19= row1.createCell(27);
	          column19.setCellStyle(s);
	          column19.setCellValue("钙（mmol/L）");
	          
	          HSSFCell column20= row1.createCell(28);
	          column20.setCellStyle(s);
	          column20.setCellValue("磷（mmol/L）");
	          
	          
	          HSSFCell column21= row1.createCell(29);
	          column21.setCellStyle(s);
	          column21.setCellValue("镁（mmol/L）");
	          
	          HSSFCell column22= row1.createCell(30);
	          column22.setCellStyle(s);
	          column22.setCellValue("空腹血糖（mmol/L)");
	          
	          
	          HSSFCell column23= row1.createCell(31);
	          column23.setCellStyle(s);
	          column23.setCellValue("餐后2h血糖(mmol/L)");
	          
	          
	          HSSFCell column24= row1.createCell(32);
	          column24.setCellStyle(s);
	          column24.setCellValue("空腹胰岛素(uU/Ml)");
	          
	          
	          HSSFCell column25= row1.createCell(33);
	          column25.setCellStyle(s);
	          column25.setCellValue("餐后2h胰岛素");
	          
	          HSSFCell column26= row1.createCell(34);
	          column26.setCellStyle(s);
	          column26.setCellValue("空腹c肽(ng/Ml)");
	          
	          HSSFCell column27= row1.createCell(35);
	          column27.setCellStyle(s);
	          column27.setCellValue("餐后2h c肽");
	          
	          HSSFCell column28= row1.createCell(36);
	          column28.setCellStyle(s);
	          column28.setCellValue("HBA1C%");
	          
	          HSSFCell column29= row1.createCell(37);
	          column29.setCellStyle(s);
	          column29.setCellValue("果糖胺%");
	          
	          HSSFCell column30= row1.createCell(38);
	          column30.setCellStyle(s);
	          column30.setCellValue("IAA");
	          
	          HSSFCell column31= row1.createCell(39);
	          column31.setCellStyle(s);
	          column31.setCellValue("ICA");
	          
	          HSSFCell column32= row1.createCell(40);
	          column32.setCellStyle(s);
	          column32.setCellValue("GAD-Ab");
	          
	          HSSFCell column33= row1.createCell(41);
	          column33.setCellStyle(s);
	          column33.setCellValue("空腹胰岛素(uU/l)");
	          
	          HSSFCell column34= row1.createCell(42);
	          column34.setCellStyle(s);
	          column34.setCellValue("2分钟胰岛素(uU/l)");
	          
	          HSSFCell column35= row1.createCell(43);
	          column35.setCellStyle(s);
	          column35.setCellValue("4分钟胰岛素(uU/l)");
	          
	          
	          HSSFCell column36= row1.createCell(44);
	          column36.setCellStyle(s);
	          column36.setCellValue("6分钟胰岛素(uU/l)");
	          
	          
	          HSSFCell column37= row1.createCell(45);
	          column37.setCellStyle(s);
	          column37.setCellValue("8分钟胰岛素(uU/l)");
	          
	          
	          HSSFCell column38= row1.createCell(46);
	          column38.setCellStyle(s);
	          column38.setCellValue("空腹c肽(ng/Ml)");
	          
	          
	          HSSFCell column39= row1.createCell(47);
	          column39.setCellStyle(s);
	          column39.setCellValue("2分钟c肽(ng/Ml)");
	          
	          
	          HSSFCell column40= row1.createCell(48);
	          column40.setCellStyle(s);
	          column40.setCellValue("4分钟c肽(ng/Ml)");
	          
	          HSSFCell column41= row1.createCell(49);
	          column41.setCellStyle(s);
	          column41.setCellValue("6分钟c肽(ng/Ml)");
	          
	          HSSFCell column42= row1.createCell(50);
	          column42.setCellStyle(s);
	          column42.setCellValue("8分钟c肽(ng/Ml)");
	          
	          
	          HSSFCell column43= row1.createCell(51);
	          column43.setCellStyle(s);
	          column43.setCellValue("尿微量白蛋白(mg/dl)");
	          
	          
	          HSSFCell column44= row1.createCell(52);
	          column44.setCellStyle(s);
	          column44.setCellValue("24h尿蛋白定量(g/24h)");
	          
	          
	          HSSFCell column45= row1.createCell(53);
	          column45.setCellStyle(s);
	          column45.setCellValue("TT3(ng/ml)");
	          
	          
	          
	          HSSFCell column46= row1.createCell(54);
	          column46.setCellStyle(s);
	          column46.setCellValue("TT4(ug/dl)");
	          
	          
	          HSSFCell column47= row1.createCell(55);
	          column47.setCellStyle(s);
	          column47.setCellValue("FT3(ng/dl)");
	          
	          HSSFCell column48= row1.createCell(56);
	          column48.setCellStyle(s);
	          column48.setCellValue("FT4(ng/dl)");
	          
	          HSSFCell column49= row1.createCell(57);
	          column49.setCellStyle(s);
	          column49.setCellValue("TSH(uIU/ml)");
	          
	          
	          HSSFCell column50= row1.createCell(58);
	          column50.setCellStyle(s);
	          column50.setCellValue("Tg-Ab(IU/ml)");
	          
	          HSSFCell column51= row1.createCell(59);
	          column51.setCellStyle(s);
	          column51.setCellValue("TPO-Ab(IU/ML)");
	          
	          HSSFCell column52= row1.createCell(60);
	          column52.setCellStyle(s);
	          column52.setCellValue("Tr-Ab(IU/l)");
	          
	          
	          HSSFCell column53= row1.createCell(61);
	          column53.setCellStyle(s);
	          column53.setCellValue("Tg（ng/ml）");
	          
	          
	          HSSFCell column54= row1.createCell(62);
	          column54.setCellStyle(s);
	          column54.setCellValue("PTH（pg/ml）");
	          
	          HSSFCell column55= row1.createCell(63);
	          column55.setCellStyle(s);
	          column55.setCellValue("骨钙素N端中分子片段（N-MID）ng/ml");
	          
	          
	          HSSFCell column56= row1.createCell(64);
	          column56.setCellStyle(s);
	          column56.setCellValue("B-胶原降解产物ng/ml");
	          
	          HSSFCell column57= row1.createCell(65);
	          column57.setCellStyle(s);
	          column57.setCellValue("25羟基VitD ng/ml");
	          
	          HSSFCell column58= row1.createCell(66);
	          column58.setCellStyle(s);
	          column58.setCellValue("I型胶原氨基末端肽（PINP）ng/ml");
	          
	          HSSFCell column59= row1.createCell(67);
	          column59.setCellStyle(s);
	          column59.setCellValue("降钙素CT2 pg/ml");
	          
	          HSSFCell column60= row1.createCell(68);
	          column60.setCellStyle(s);
	          column60.setCellValue("AFP(ng/ml)");
	          
	          
	          HSSFCell column61= row1.createCell(69);
	          column61.setCellStyle(s);
	          column61.setCellValue("CEA(ng/ml)");
	          
	          
	          HSSFCell column62= row1.createCell(70);
	          column62.setCellStyle(s);
	          column62.setCellValue("CA-199 U/ml");
	          
	          HSSFCell column63= row1.createCell(71);
	          column63.setCellStyle(s);
	          column63.setCellValue("CA-242 IU/ml");
	          
	          
	          HSSFCell column64= row1.createCell(72);
	          column64.setCellStyle(s);
	          column64.setCellValue("CA-50 IU/ml");
	          
	          
	          HSSFCell column65= row1.createCell(73);
	          column65.setCellStyle(s);
	          column65.setCellValue("NSE ng/ml");
	          
	          
	          HSSFCell column66= row1.createCell(74);
	          column66.setCellStyle(s);
	          column66.setCellValue("PSA ng/ml");
	          
	          
	          HSSFCell column67= row1.createCell(75);
	          column67.setCellStyle(s);
	          column67.setCellValue("FPSA ng/ml");
	          
	          HSSFCell column68= row1.createCell(76);
	          column68.setCellStyle(s);
	          column68.setCellValue("fPSA/tPSA %");
	          
	          HSSFCell column69= row1.createCell(77);
	          column69.setCellStyle(s);
	          column69.setCellValue("斑块（有/无）");
	          
	          
	          HSSFCell column70= row1.createCell(78);
	          column70.setCellStyle(s);
	          column70.setCellValue("左侧颈部（cm）");
	          
	          
	          HSSFCell column71= row1.createCell(79);
	          column71.setCellStyle(s);
	          column71.setCellValue("右侧颈部（cm）");
	          
	          
	          HSSFCell column72= row1.createCell(80);
	          column72.setCellStyle(s);
	          column72.setCellValue("左侧下肢（cm）");
	          
	          HSSFCell column73= row1.createCell(81);
	          column73.setCellStyle(s);
	          column73.setCellValue("右侧下肢（cm）");
	          
	          
	          HSSFCell column74= row1.createCell(82);
	          column74.setCellStyle(s);
	          column74.setCellValue("");
	          
	          
	          HSSFCell column75= row1.createCell(83);
	          column75.setCellStyle(s);
	          column75.setCellValue("");
	          
	          
	          HSSFCell column76= row1.createCell(84);
	          column76.setCellStyle(s);
	          column76.setCellValue("");
	          
	          
	          HSSFCell column77= row1.createCell(85);
	          column77.setCellStyle(s);
	          column77.setCellValue("胰岛素");
	          
	          HSSFCell column78= row1.createCell(86);
	          column78.setCellStyle(s);
	          column78.setCellValue("口服药");
	          
	          
	          HSSFCell column79= row1.createCell(87);
	          column79.setCellStyle(s);
	          column79.setCellValue("胰岛素+口服药");
	          
	          HSSFCell column80= row1.createCell(88);
	          column80.setCellStyle(s);
	          column80.setCellValue("");
	          
	          HSSFCell column81= row1.createCell(89);
	          column81.setCellStyle(s);
	          column81.setCellValue("");
	          
	        
	          
	           
	          
			/*
			 * 
			 * 处理excel Body部分
			 * 
			 */
	          int currentrows=2;
	          List<Map<String,Object>> list=ketiReportDao.reportDate(map);
	         for(int i=0;i<list.size();i++){
	        	 currentrows++;
	        	 HSSFRow rows= sheet.createRow(currentrows);
	        	 Map<String,Object> hashMap=list.get(i);
	        	 
	        	 HSSFCell cells0 = rows.createCell(0);
	        	 cells0.setCellStyle(style);
	        	 cells0.setCellValue(hashMap.get("inpatiNumber").toString());
	        	 
	        	 HSSFCell cells1 = rows.createCell(1);
	        	 cells1.setCellStyle(style);
	        	 if(hashMap.get("name")!=null){
	        		 cells1.setCellValue(hashMap.get("name").toString());
		      		}else{
		      			cells1.setCellValue("");
		      		}
		      		
	        	
	      		 
	      		HSSFCell cells2 = rows.createCell(2);
	      		cells2.setCellStyle(style);
	      		if(hashMap.get("gender")!=null){
	      			cells2.setCellValue(hashMap.get("gender").toString());
		      		}else{
		      		cells2.setCellValue("");
		      		}
	      		
	      		HSSFCell cells3 = rows.createCell(3);
	      		cells3.setCellStyle(style);
	      		if(hashMap.get("age")!=null){
	      			cells3.setCellValue(hashMap.get("age").toString());
		      	}else{
		      		cells3.setCellValue("");
		      	}
	      		
	      		
	      		
	      		HSSFCell cells4 = rows.createCell(4);
	      		cells4.setCellStyle(style);
	      		cells4.setCellValue("");

	        	 
	      		
	      		HSSFCell cells5 = rows.createCell(5);
	      		cells5.setCellStyle(style);
	      		cells5.setCellValue("");
	      		
	      		
	      		HSSFCell cells6 = rows.createCell(6);
	      		cells6.setCellStyle(style);
	      		cells6.setCellValue("");
	      		
	      		HSSFCell cells7= rows.createCell(7);
	      		cells7.setCellStyle(style);
	      		cells7.setCellValue("");
	      		
	      		HSSFCell cells8= rows.createCell(8);
	      		cells8.setCellStyle(style);
	      		cells8.setCellValue("");
	      		
	      		HSSFCell cells9= rows.createCell(9);
	      		cells9.setCellStyle(style);
	      		cells9.setCellStyle(style);
	      		if(hashMap.get("column1")!=null){
	      			cells9.setCellValue(hashMap.get("column1").toString());
	      		}else{
	      			cells9.setCellValue("");
	      		}
	      		
	      		
	      		HSSFCell cells10= rows.createCell(10);
	      		cells10.setCellStyle(style);
	      		if(hashMap.get("column2")!=null){
	      			cells10.setCellValue(hashMap.get("column2").toString());
	      		}else{
	      			cells10.setCellValue("");
	      		}
	      		
	      		HSSFCell cells11= rows.createCell(11);
	      		cells11.setCellStyle(style);
	      		if(hashMap.get("column3")!=null){
	      			cells11.setCellValue(hashMap.get("column3").toString());
	      		}else{
	      			cells11.setCellValue("");
	      		}
	      		
	      		HSSFCell cells12= rows.createCell(12);
	      		cells12.setCellStyle(style);
	      		if(hashMap.get("column4")!=null){
	      			cells12.setCellValue(hashMap.get("column4").toString());
	      		}else{
	      			cells12.setCellValue("");
	      		}
	      		
	      		
	      		HSSFCell cells13= rows.createCell(13);
	      		cells13.setCellStyle(style);
	      		if(hashMap.get("column5")!=null){
	      			cells13.setCellValue(hashMap.get("column5").toString());
	      		}else{
	      			cells13.setCellValue("");
	      		}
	      		
	      		HSSFCell cells14= rows.createCell(14);
	      		cells14.setCellStyle(style);
	      		if(hashMap.get("column6")!=null){
	      			cells14.setCellValue(hashMap.get("column6").toString());
	      		}else{
	      			cells14.setCellValue("");
	      		}
	      		
	      		
	      		HSSFCell cells15= rows.createCell(15);
	      		cells15.setCellStyle(style);
	      		if(hashMap.get("column7")!=null){
	      			cells15.setCellValue(hashMap.get("column7").toString());
	      		}else{
	      			cells15.setCellValue("");
	      		}
	      		
	      		HSSFCell cells16= rows.createCell(16);
	      		cells16.setCellStyle(style);
	      		if(hashMap.get("column8")!=null){
	      			cells16.setCellValue(hashMap.get("column8").toString());
	      		}else{
	      			cells16.setCellValue("");
	      		}	
	      		HSSFCell cells17= rows.createCell(17);
	      		cells17.setCellStyle(style);
	      		if(hashMap.get("column9")!=null){
	      			cells17.setCellValue(hashMap.get("column9").toString());
	      		}else{
	      			cells17.setCellValue("");
	      		}	
	      		HSSFCell cells18= rows.createCell(18);
	      		cells18.setCellStyle(style);
	      		if(hashMap.get("column10")!=null){
	      			cells18.setCellValue(hashMap.get("column10").toString());
	      		}else{
	      			cells18.setCellValue("");
	      		}	
	      		HSSFCell cells19= rows.createCell(19);
	      		cells19.setCellStyle(style);
	      		if(hashMap.get("column11")!=null){
	      			cells19.setCellValue(hashMap.get("column11").toString());
	      		}else{
	      			cells19.setCellValue("");
	      		}	
	      		HSSFCell cells20= rows.createCell(20);
	      		cells20.setCellStyle(style);
	      		if(hashMap.get("column12")!=null){
	      			cells20.setCellValue(hashMap.get("column12").toString());
	      		}else{
	      			cells20.setCellValue("");
	      		}
	      		
	      		HSSFCell cells21= rows.createCell(21);
	      		cells21.setCellStyle(style);
	      		if(hashMap.get("column13")!=null){
	      			cells21.setCellValue(hashMap.get("column13").toString());
	      		}else{
	      			cells21.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells22= rows.createCell(22);
	      		cells22.setCellStyle(style);
	      		if(hashMap.get("column14")!=null){
	      			cells22.setCellValue(hashMap.get("column14").toString());
	      		}else{
	      			cells22.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells23= rows.createCell(23);
	      		cells23.setCellStyle(style);
	      		if(hashMap.get("column15")!=null){
	      			cells23.setCellValue(hashMap.get("column15").toString());
	      		}else{
	      			cells23.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells24= rows.createCell(24);
	      		cells24.setCellStyle(style);
	      		if(hashMap.get("column16")!=null){
	      			cells24.setCellValue(hashMap.get("column16").toString());
	      		}else{
	      			cells24.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells25= rows.createCell(25);
	      		cells25.setCellStyle(style);
	      		if(hashMap.get("column17")!=null){
	      			cells25.setCellValue(hashMap.get("column17").toString());
	      		}else{
	      			cells25.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells26= rows.createCell(26);
	      		cells26.setCellStyle(style);
	      		if(hashMap.get("column18")!=null){
	      			cells26.setCellValue(hashMap.get("column18").toString());
	      		}else{
	      			cells26.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells27= rows.createCell(27);
	      		cells27.setCellStyle(style);
	      		if(hashMap.get("column19")!=null){
	      			cells27.setCellValue(hashMap.get("column19").toString());
	      		}else{
	      			cells27.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells28= rows.createCell(28);
	      		cells28.setCellStyle(style);
	      		if(hashMap.get("column20")!=null){
	      			cells28.setCellValue(hashMap.get("column20").toString());
	      		}else{
	      			cells28.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells29= rows.createCell(29);
	      		cells29.setCellStyle(style);
	      		if(hashMap.get("column21")!=null){
	      			cells29.setCellValue(hashMap.get("column21").toString());
	      		}else{
	      			cells29.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells30= rows.createCell(30);
	      		cells30.setCellStyle(style);
	      		if(hashMap.get("column22")!=null){
	      			cells30.setCellValue(hashMap.get("column22").toString());
	      		}else{
	      			cells30.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells31= rows.createCell(31);
	      		cells31.setCellStyle(style);
	      		if(hashMap.get("column23")!=null){
	      			cells31.setCellValue(hashMap.get("column23").toString());
	      		}else{
	      			cells31.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells32= rows.createCell(32);
	      		cells32.setCellStyle(style);
	      		if(hashMap.get("column24")!=null){
	      			cells32.setCellValue(hashMap.get("column24").toString());
	      		}else{
	      			cells32.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells33= rows.createCell(33);
	      		cells33.setCellStyle(style);
	      		if(hashMap.get("column25")!=null){
	      			cells33.setCellValue(hashMap.get("column25").toString());
	      		}else{
	      			cells33.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells34= rows.createCell(34);
	      		cells34.setCellStyle(style);
	      		if(hashMap.get("column26")!=null){
	      			cells34.setCellValue(hashMap.get("column26").toString());
	      		}else{
	      			cells34.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells35= rows.createCell(35);
	      		cells35.setCellStyle(style);
	      		if(hashMap.get("column27")!=null){
	      			cells35.setCellValue(hashMap.get("column27").toString());
	      		}else{
	      			cells35.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells36= rows.createCell(36);
	      		cells36.setCellStyle(style);
	      		if(hashMap.get("column28")!=null){
	      			cells36.setCellValue(hashMap.get("column28").toString());
	      		}else{
	      			cells36.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells37= rows.createCell(37);
	      		cells37.setCellStyle(style);
	      		if(hashMap.get("column29")!=null){
	      			cells37.setCellValue(hashMap.get("column29").toString());
	      		}else{
	      			cells37.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells38= rows.createCell(38);
	      		cells38.setCellStyle(style);
	      		if(hashMap.get("column30")!=null){
	      			cells38.setCellValue(hashMap.get("column30").toString());
	      		}else{
	      			cells38.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells39= rows.createCell(39);
	      		cells39.setCellStyle(style);
	      		if(hashMap.get("column31")!=null){
	      			cells39.setCellValue(hashMap.get("column31").toString());
	      		}else{
	      			cells39.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells40= rows.createCell(40);
	      		cells40.setCellStyle(style);
	      		if(hashMap.get("column32")!=null){
	      			cells40.setCellValue(hashMap.get("column32").toString());
	      		}else{
	      			cells40.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells41= rows.createCell(41);
	      		cells41.setCellStyle(style);
	      		if(hashMap.get("column33")!=null){
	      			cells41.setCellValue(hashMap.get("column33").toString());
	      		}else{
	      			cells41.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells42= rows.createCell(42);
	      		cells42.setCellStyle(style);
	      		if(hashMap.get("column34")!=null){
	      			cells42.setCellValue(hashMap.get("column34").toString());
	      		}else{
	      			cells42.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells43= rows.createCell(43);
	      		cells43.setCellStyle(style);
	      		if(hashMap.get("column35")!=null){
	      			cells43.setCellValue(hashMap.get("column35").toString());
	      		}else{
	      			cells43.setCellValue("");
	      		}	
	      		HSSFCell cells44= rows.createCell(44);
	      		cells44.setCellStyle(style);
	      		if(hashMap.get("column36")!=null){
	      			cells44.setCellValue(hashMap.get("column36").toString());
	      		}else{
	      			cells44.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells45= rows.createCell(45);
	      		cells45.setCellStyle(style);
	      		if(hashMap.get("column37")!=null){
	      			cells45.setCellValue(hashMap.get("column37").toString());
	      		}else{
	      			cells45.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells46= rows.createCell(46);
	      		cells46.setCellStyle(style);
	      		if(hashMap.get("column38")!=null){
	      			cells46.setCellValue(hashMap.get("column38").toString());
	      		}else{
	      			cells46.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells47= rows.createCell(47);
	      		cells47.setCellStyle(style);
	      		if(hashMap.get("column39")!=null){
	      			cells47.setCellValue(hashMap.get("column39").toString());
	      		}else{
	      			cells47.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells48= rows.createCell(48);
	      		cells48.setCellStyle(style);
	      		if(hashMap.get("column40")!=null){
	      			cells48.setCellValue(hashMap.get("column40").toString());
	      		}else{
	      			cells48.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells49= rows.createCell(49);
	      		cells49.setCellStyle(style);
	      		if(hashMap.get("column41")!=null){
	      			cells49.setCellValue(hashMap.get("column41").toString());
	      		}else{
	      			cells49.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells50= rows.createCell(50);
	      		cells50.setCellStyle(style);
	      		if(hashMap.get("column42")!=null){
	      			cells50.setCellValue(hashMap.get("column42").toString());
	      		}else{
	      			cells50.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells51= rows.createCell(51);
	      		cells51.setCellStyle(style);
	      		if(hashMap.get("column43")!=null){
	      			cells51.setCellValue(hashMap.get("column43").toString());
	      		}else{
	      			cells51.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells52= rows.createCell(52);
	      		cells52.setCellStyle(style);
	      		if(hashMap.get("column44")!=null){
	      			cells52.setCellValue(hashMap.get("column44").toString());
	      		}else{
	      			cells52.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells53= rows.createCell(53);
	      		cells53.setCellStyle(style);
	      		if(hashMap.get("column45")!=null){
	      			cells53.setCellValue(hashMap.get("column45").toString());
	      		}else{
	      			cells53.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells54= rows.createCell(54);
	      		cells54.setCellStyle(style);
	      		if(hashMap.get("column46")!=null){
	      			cells54.setCellValue(hashMap.get("column46").toString());
	      		}else{
	      			cells54.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells55= rows.createCell(55);
	      		cells55.setCellStyle(style);
	      		if(hashMap.get("column47")!=null){
	      			cells55.setCellValue(hashMap.get("column47").toString());
	      		}else{
	      			cells55.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells56= rows.createCell(56);
	      		cells56.setCellStyle(style);
	      		if(hashMap.get("column48")!=null){
	      			cells56.setCellValue(hashMap.get("column48").toString());
	      		}else{
	      			cells56.setCellValue("");
	      		}	
	      		HSSFCell cells57= rows.createCell(57);
	      		cells57.setCellStyle(style);
	      		if(hashMap.get("column49")!=null){
	      			cells57.setCellValue(hashMap.get("column49").toString());
	      		}else{
	      			cells57.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells58= rows.createCell(58);
	      		cells58.setCellStyle(style);
	      		if(hashMap.get("column50")!=null){
	      			cells58.setCellValue(hashMap.get("column50").toString());
	      		}else{
	      			cells58.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells59= rows.createCell(59);
	      		cells59.setCellStyle(style);
	      		if(hashMap.get("column51")!=null){
	      			cells59.setCellValue(hashMap.get("column51").toString());
	      		}else{
	      			cells59.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells60= rows.createCell(60);
	      		cells60.setCellStyle(style);
	      		if(hashMap.get("column52")!=null){
	      			cells60.setCellValue(hashMap.get("column52").toString());
	      		}else{
	      			cells60.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells61= rows.createCell(61);
	      		cells61.setCellStyle(style);
	      		if(hashMap.get("column53")!=null){
	      			cells61.setCellValue(hashMap.get("column53").toString());
	      		}else{
	      			cells61.setCellValue("");
	      		}	
	      		HSSFCell cells62= rows.createCell(62);
	      		cells62.setCellStyle(style);
	      		if(hashMap.get("column54")!=null){
	      			cells62.setCellValue(hashMap.get("column54").toString());
	      		}else{
	      			cells62.setCellValue("");
	      		}	
	      		HSSFCell cells63= rows.createCell(63);
	      		cells63.setCellStyle(style);
	      		if(hashMap.get("column55")!=null){
	      			cells63.setCellValue(hashMap.get("column55").toString());
	      		}else{
	      			cells63.setCellValue("");
	      		}	
	      		HSSFCell cells64= rows.createCell(64);
	      		cells64.setCellStyle(style);
	      		if(hashMap.get("column56")!=null){
	      			cells64.setCellValue(hashMap.get("column56").toString());
	      		}else{
	      			cells64.setCellValue("");
	      		}	
	      		HSSFCell cells65= rows.createCell(65);
	      		cells65.setCellStyle(style);
	      		if(hashMap.get("column57")!=null){
	      			cells65.setCellValue(hashMap.get("column57").toString());
	      		}else{
	      			cells65.setCellValue("");
	      		}	
	      		HSSFCell cells66= rows.createCell(66);
	      		cells66.setCellStyle(style);
	      		if(hashMap.get("column58")!=null){
	      			cells66.setCellValue(hashMap.get("column58").toString());
	      		}else{
	      			cells66.setCellValue("");
	      		}	
	      		HSSFCell cells67= rows.createCell(67);
	      		cells67.setCellStyle(style);
	      		if(hashMap.get("column59")!=null){
	      			cells67.setCellValue(hashMap.get("column59").toString());
	      		}else{
	      			cells67.setCellValue("");
	      		}	
	      		HSSFCell cells68= rows.createCell(68);
	      		cells68.setCellStyle(style);
	      		if(hashMap.get("column60")!=null){
	      			cells68.setCellValue(hashMap.get("column60").toString());
	      		}else{
	      			cells68.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells69= rows.createCell(69);
	      		cells69.setCellStyle(style);
	      		if(hashMap.get("column61")!=null){
	      			cells69.setCellValue(hashMap.get("column61").toString());
	      		}else{
	      			cells69.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells70= rows.createCell(70);
	      		cells70.setCellStyle(style);
	      		if(hashMap.get("column62")!=null){
	      			cells70.setCellValue(hashMap.get("column62").toString());
	      		}else{
	      			cells70.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells71= rows.createCell(71);
	      		cells71.setCellStyle(style);
	      		if(hashMap.get("column63")!=null){
	      			cells71.setCellValue(hashMap.get("column63").toString());
	      		}else{
	      			cells71.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells72= rows.createCell(72);
	      		cells72.setCellStyle(style);
	      		if(hashMap.get("column64")!=null){
	      			cells72.setCellValue(hashMap.get("column64").toString());
	      		}else{
	      			cells72.setCellValue("");
	      		}	
	      		
	      		
	      		HSSFCell cells73= rows.createCell(73);
	      		cells73.setCellStyle(style);
	      		if(hashMap.get("column65")!=null){
	      			cells73.setCellValue(hashMap.get("column65").toString());
	      		}else{
	      			cells73.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells74= rows.createCell(74);
	      		cells74.setCellStyle(style);
	      		if(hashMap.get("column66")!=null){
	      			cells74.setCellValue(hashMap.get("column66").toString());
	      		}else{
	      			cells74.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells75= rows.createCell(75);
	      		cells75.setCellStyle(style);
	      		if(hashMap.get("column67")!=null){
	      			cells75.setCellValue(hashMap.get("column67").toString());
	      		}else{
	      			cells75.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells76= rows.createCell(76);
	      		cells76.setCellStyle(style);
	      		if(hashMap.get("column68")!=null){
	      			cells76.setCellValue(hashMap.get("column68").toString());
	      		}else{
	      			cells76.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells77= rows.createCell(77);
	      		cells77.setCellStyle(style);
	      		if(hashMap.get("column69")!=null){
	      			
	      			cells77.setCellValue(hashMap.get("column69").toString());
	      			sheet.addMergedRegion(new CellRangeAddress((i+3),(i+3), 77,81));
	      		}else{
	      			cells77.setCellValue("");
	      			sheet.addMergedRegion(new CellRangeAddress((i+3),(i+3), 77,81));
	      		}	
	      		
	/*      		HSSFCell cells78= rows.createCell(78);
	      		cells78.setCellStyle(style);
	      		if(hashMap.get("column70")!=null){
	      			cells78.setCellValue(hashMap.get("column70").toString());
	      		}else{
	      			cells78.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells79= rows.createCell(79);
	      		cells79.setCellStyle(style);
	      		if(hashMap.get("column71")!=null){
	      			cells79.setCellValue(hashMap.get("column71").toString());
	      		}else{
	      			cells79.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells80= rows.createCell(80);
	      		cells80.setCellStyle(style);
	      		if(hashMap.get("column72")!=null){
	      			cells80.setCellValue(hashMap.get("column72").toString());
	      		}else{
	      			cells80.setCellValue("");
	      		}	
	      		
	      		HSSFCell cells81= rows.createCell(81);
	      		cells81.setCellStyle(style);
	      		if(hashMap.get("column73")!=null){
	      			cells81.setCellValue(hashMap.get("column73").toString());
	      		}else{
	      			cells81.setCellValue("");
	      		}*/	
	      		
	      		
	      		
	      			
	         }
	        /* HSSFRow rowsTotal= sheet.createRow(3+(list.size()));
	         HSSFCell cellsExplainTotal= rowsTotal.createCell(0);
	         sheet.addMergedRegion(new CellRangeAddress(list.size()+3, list.size()+3, 0,15));
	         HSSFCell cellDate= rowsTotal.createCell(16);
	         cellDate.setCellValue(d);
	         HSSFCell cellReportName= rowsTotal.createCell(17);
	         cellReportName.setCellStyle(s);
	         cellReportName.setCellValue(reportName);
	         cellsExplainTotal.setCellStyle(s);
	         cellsExplainTotal.setCellValue("合计："+list.size());
	         cellDate.setCellStyle(s);*/
	         
		
		return qubbb;
	}

	@Override
	public List<Map<String, String>> pageList(Page<Object> page) {
		// TODO Auto-generated method stub
		return ketiReportDao.pageList(page);
	}
	
	
}