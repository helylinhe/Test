<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title> 病例信息 </title>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/js/jquery-easyui-1.3.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/apssysframe.css" />
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/content.css" />
    <script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.7.2.min.js"></script>
	<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>  
    <script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/flupTaskExecution/bingliInfo.js"></script>
    <style>
  	     select{
		   width:104px;
		 }
		 
    </style>
	<script>
	     
	</script>
	</head>
  
  <!--新增-->
 <body  topmargin="0" leftmargin="0"> 
       <div  style="height:500px;font-size:12px;width:100%; border:0;" id="addbinli_content">
			
            <div style="width:95%;height:40px;margin-left:10px;">
                 <a href="#" class="easyui-linkbutton" icon="icon-save">保&nbsp;&nbsp;存&nbsp;<a>
                 <a href="#" class="easyui-linkbutton" icon="icon-edit">转为黑名单<a>
            </div>
             <!--左边部分--> 
            <div style="width:650px;height:450px;float:left;left:10px; border:0;"  id="addbinli_content_binlidiv" >
                <fieldset style="border:1px solid #6293BB;height:465px;">
                 <legend>病例基本信息</legend>
                 <table style="width:99%;margin-left:5px;height:95%;" id="addbinli_content_binlidiv_table" cellspacing="0" cellpadding="0">
                 	<tr>
                    	<td align="right" nowrap>住&nbsp;院&nbsp;号：</td>
                        <td><input type="text" style="width:100px;"></td>
                        <td align="right" nowrap>病人编号：</td>
                        <td><input type="text" style="width:100px;"></td>
                        <td align="right" nowrap>医保编号：</td>
                        <td><input type="text" style="width:100px;"></td>
                    </tr>
                    <tr>
                    	<td align="center" nowrap>同户住院号：</td>
                        <td><input type="text" style="width:100px;" /></td>
                    	<td align="right">付款方式：</td>
                    	<td >
                        	<select class="easyui-combobox">   
                               <option>社会保障卡</option>  
                               <option>居民医疗卡</option>
                               <option>综合保险卡</option> 
                            </select>
                        </td>
                    	<td align="right">诊治情况：</td>
                      	<td>
                        	<select  class="easyui-combobox">   
                                <option >健康</option> 
                                <option >待观察</option> 
                                <option >留院观察</option> 
                           </select>
                        </td>
                    </tr>
                    
                    <tr>
                    	<td align="right" nowrap>姓&nbsp;&nbsp;名&nbsp;：</td>
                        <td><input type="text" style="width:100px;"></td>
                        <td align="right">性&nbsp;&nbsp;别&nbsp;：</td>
                        <td><input type="radio" name="nv" checked="checked">男<input type="radio" name="nv">女<input type="radio" name="nv">未知</td>
                        <td align="right" nowrap>出生日期：</td>
                        <td><input  type="text" class="easyui-datebox" style="width:104px;"/></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>年&nbsp;&nbsp;龄&nbsp;：</td>
                        <td><input type="text" style="width:100px;"></td>
                        <td align="right" nowrap>国&nbsp;&nbsp;籍&nbsp;：</td>
                        <td><input type="text" style="width:100px;"></td>
                        <td align="right" nowrap>民&nbsp;&nbsp;族&nbsp;：</td>
                        <td><input type="text" style="width:100px;"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>职&nbsp;&nbsp;业&nbsp;：</td>
                        <td><input type="text" style="width:100px;"></td>
                    	<td align="right" nowrap>&nbsp;证件号码：</td>
                        <td><select  class="easyui-combobox">   
                                 <option>身份证</option>  
                                 <option>驾照</option>
                                 <option>护照</option> 
                                 <option>军官证</option>
                              </select>
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>联系人姓名：</td>
                        <td><input type="text" style="width:100px;"/></td>
                    	<td align="right">联系人电话：</td>
                        <td ><select class="easyui-combobox" id="td_sel_width">
                              <option>子女</option>
                              <option>亲朋</option>
                              <option>同事</option>
                              <option>配偶</option>
                            </select>
                        </td>
                        <td colspan="2"><input type="text" style="width:160px;"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>&nbsp;手机号码：</td>
                        <td colspan="2"><input type="text" style="width:177px;"></td>
                        <td align="right" nowrap>家庭号码：</td>
                        <td colspan="2"><input type="text" style="width:100px;"></td>
                    </tr>
                    <tr>
                    	<td align="right" colspan="3" nowrap>（年龄不足一周岁的）年&nbsp;龄：<input type="text" style="width:74px;"/>月&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td align="right" nowrap>新生儿出生体重：</td>  
                        <td colspan="2"><input type="text" style="width:100px;">克</td>                      
                    </tr>
                    <tr>
                    	<td align="right" nowrap>出生地址：</td>
                        <td colspan="2"><input type="text" style="width:177px;"></td>
                        <td align="right" nowrap>新生儿入院体重：</td>
                        <td colspan="2"><input type="text" style="width:100px;">克</td>
                    </tr>
                    <tr>
                    	
                        <td align="right" nowrap>婚&nbsp;&nbsp;姻&nbsp;：</td>                        
                    	<td colspan="3"><input type="radio" name="nv" checked="checked" >未婚&nbsp;&nbsp;&nbsp;<input type="radio" name="nv">已婚&nbsp;&nbsp;&nbsp;<input type="radio" name="nv">丧偶&nbsp;&nbsp;&nbsp;<input type="radio" name="nv">离婚&nbsp;&nbsp;&nbsp;<input type="radio" name="nv">其他</td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>现住地址：</td>
                        <td  colspan="3" nowrap><input type="text" style="width:342px;"/></td>
                    	<td align="right" nowrap>邮&nbsp;&nbsp;编&nbsp;：</td>
                        <td><input type="text" style="width:100px;"></td>
                    </tr>
                    <tr>
                    	<td align="right" nowrap>户口地址：</td>
                        <td colspan="3"><input type="text" style="width:342px;"/></td>
                    	<td align="right" nowrap>邮&nbsp;&nbsp;编&nbsp;：</td>
                        <td><input type="text" style="width:100px;"></td>
                    </tr>
                    <tr>
                    	<td align="right">住院流水号：</td>
                      	<td><input type="text" style="width:100px;" /></td>
                        <td align="right">&nbsp;是否死亡：</td>
                      	<td><input type="radio" name="life" /> 是  <input type="radio" name="life" checked /> 否</td>
                        <td align="right">随访电话：</td>
                      	<td><input  type="text"style="width:100px;"/> </td>
                    </tr> 
                    <tr>
                    	<td align="right" nowrap>主任医生：</td>
                        <td>
                        	<select  class="easyui-combobox">   
                                <option >徐亮</option> 
                                <option >陈明</option> 
                           </select>
                        </td>
                    	<td align="right">&nbsp;主治医生：</td>
                      	<td>
                        	<select  class="easyui-combobox">   
                                <option >徐亮</option> 
                                <option >陈明</option> 
                           </select>
                        </td>
                        <td align="right">住院医生：</td>
                      	<td>
                        	<select  class="easyui-combobox">   
                                <option >徐亮</option> 
                                <option >陈明</option> 
                           </select>
                        </td>
                    </tr>
                    
                    <tr>
                    	<td align="right" nowrap>所属科室：</td>
                        <td>
                        	<select  class="easyui-combobox">   
                                <option >肝胆外科</option>   
                                <option>胃肠外科</option>   
                                <option>血管/甲状腺/乳腺外科</option>  
                           </select>
                        </td>
                    	<td align="right">住院次数：</td>
                        <td><input type="text" style="width:100px;"/></td>
                        <td align="right">住院天数：</td>
                      	<td><input  type="text" style="width:100px;"/> </td>
                    </tr>
                    <tr>
                    	<td align="right">所属病区：</td>
                      	<td>
                        	<select  class="easyui-combobox" style="padding-left:10px;">   
                                <option > 1病区</option> 
                                <option > 2病区</option> 
                                <option > 3病区</option> 
                           </select>
                        </td>
                        <td align="right">&nbsp;入院日期：</td>
                      	<td><input  type="text" class="easyui-datebox" style="width:104px;"/> </td>
                        <td align="right">出院日期：</td>
                      	<td><input  type="text" class="easyui-datebox" style="width:104px;"/> </td>
                    </tr>   
                    <tr>
                    	<td align="right" nowrap>所属院区：</td>
                        <td>
                        	<select class="easyui-combobox">
                            	<option>南院</option>
                                <option>北院</option>
                            </select>
                        </td>
                        <td colspan="4"></td>
                    </tr>           
                 </table>
            </fieldset>
            </div>
            <div style="width:335px;height:auto;position:static;right:10px;margin-left:650px; padding-right:0px; padding-left:10px; padding-top:8px;" >
                <table  id="grid_table1" class="easyui-datagrid" style="width:335px; margin-bottom:10px;" cellpadding="0" cellspacing="0">
                    <tr>
                        <td>门诊诊断</td>
                        <td align="center">冠心病</td>
                        <td align="center">0011</td>
                    </tr>
                    <tr>
                        <td>出院诊断：主要诊断</td>
                        <td align="center">脑血管病</td>
                        <td align="center">0012</td>
                    </tr>
                    <tr>
                        <td>出院诊断：其他诊断</td>
                        <td align="center">胆结石</td>
                        <td align="center">0013</td>
                    </tr>
                </table>
                <div style="width:auto;height:5px;border:0;"></div>
                <table id="grid_table2" class="easyui-datagrid" style="width:335px" cellpadding="0" cellspacing="0">
                    <tr align="center" nowrap>
                        <td>剖腹产术</td>
                        <td>张楚</td>
                        <td>2005-9-15</td>
                        <td><a href="#" onClick=
                        verdict_open();
                        >调阅</a></td>
                    </tr>
                    <tr align="center">
                        <td>小腿骨折闭合复位术</td>
                        <td>刘明</td>
                        <td>2014-11-3</td>
                        <td><a href="#" onClick=
                        verdict_open();
                        >调阅</a></td>
                    </tr>
                </table>
                <div style="width:auto; height:5px;border:0;"></div>
                <div class="easyui-tabs" style="width:335px; height:215px;" id="test_tab">
                	<!--检验--->
                    <div title="检验" style="padding: 2px">
                        <table id="grid_table3" class="easyui-datagrid" style="width:330px" cellpadding="0" cellspacing="0">
                            <tr align="center" nowrap>
                                <td>血液</td>
                                <td>乙肝病毒检验</td>
                                <td>正常</td>
                                <td>100～500</td>
                                <td>2014-3-10</td>
                                <td>陈明</td>
                                <td>徐亮</td>
                                <td>ml</td>
                            </tr>
                             <tr align="center" nowrap>
                                <td>血液</td>
                                <td>血小板数</td>
                                <td>正常</td>
                                <td>100～500</td>
                                <td>2014-4-12</td>
                                <td>陈坤</td>
                                <td>谢毅辉</td>
                                <td>ml</td>
                            </tr>
                             <tr align="center" nowrap>
                                <td>血液</td>
                                <td>白细胞</td>
                                <td>正常</td>
                                <td>100～500</td>
                                <td>2014-5-12</td>
                                <td>陈明</td>
                                <td>徐亮</td>
                                <td>ml</td>
                            </tr>
                        </table>
                    </div>
                    <!--检查--->
                    <div title="检查" style="padding:2px">
                        <table id="grid_table4" class="easyui-datagrid" style="width:330px" cellpadding="0" cellspacing="0">
                            <tr align="center" nowrap>
                                <td>CT</td>
                                <td>CT号：135</td>
                                <td>2014-3-11</td>
                                <td>胸腔</td>
                                <td>无异常情况</td>
                                <td>正常</td>
                                <td>该患者已痊愈</td>
                                <td>李宗盛</td>
                                <td>范伟</td>
                                <td>唐嫣</td>
                            </tr>
                            <tr align="center" nowrap>
                                <td>B超</td>
                                <td>B超号：246</td>
                                <td>2014-5-12</td>
                                <td>腹部</td>
                                <td>腹内有肿瘤</td>
                                <td>腹内有肿瘤</td>
                                <td>腹内为良性肿瘤</td>
                                <td>蔡健雅</td>
                                <td>黄珊珊</td>
                                <td>董娜</td>
                            </tr>
                        </table>
                    </div>
                </div>
               
            </div>
            <!-- 病人就诊信息 -->
             <div style="width:auto; height:5px; border:0;"></div>
            <div style="width:995px;height:50px; border:1 solid #000;">
                <div id="visit_grid"></div>
            </div>
            
          <!-- 出院小结 -->
          <div id="verdict_windows" iconCls="icon-add"
				style="width: 510px; height: 300px; model: true; padding-left:10px;" closed="true"
				draggable="true" collapsible="true" maximizable="false"
				shadow="true" model="true" inline="false" resizable="false"
				minimizable="false" class="easyui-window" title="小结">
               <fieldset style="width:96%;height:97%;border:1px solid #6293BB;">
                    <legend>小结</legend>
                    
               </fieldset>
          </div>
           
		</div>
 </body>
</html>
