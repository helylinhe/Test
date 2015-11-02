package com.linkonworks.df.busi.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.linkonworks.df.busi.comment.ComparaDiseaseItem;
import com.linkonworks.df.busi.comment.ComparaFlupItem;
import com.linkonworks.df.vo.DiseaseItemTemplate;
import com.linkonworks.df.vo.ExportResponse;
import com.linkonworks.df.vo.FlupGroup;
import com.linkonworks.df.vo.FlupItemResponse;

public class FlupItemResponseTableView {

	public static final List getSelect(int id) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ph", "电话");
		map.put("me", "短信");
		map.put("ch", "微信");
		map.put("cl", "门诊");
		map.put("sf", "随访期");
		map.put("nsf", "非随访期");

		return null;

	}

	public static final String getTable(List<FlupItemResponse> list,
			String showView) {
		Map<String, Map<String, List<FlupItemResponse>>> hashMap = new LinkedHashMap<String, Map<String, List<FlupItemResponse>>>();
		for (int i = 0; i < list.size(); i++) {
			String key = list.get(i).getFlupGroup().getGroupOne();
			// 判断hashMap的键是否重复
			if (!hashMap.containsKey(key)) {
				// 判断二类分组是否为空
				if (list.get(i).getFlupGroup().getGroupTwo() == null
						|| list.get(i).getFlupGroup().getGroupTwo().equals("")) {
					if (list.get(i).getFlupGroup().getRecordType() != null
							&& list.get(i).getFlupGroup().getRecordType()
									.equals("dx")) {
						List<FlupItemResponse> dxtemp = new ArrayList<FlupItemResponse>();
						Map<String, List<FlupItemResponse>> dxm = new TreeMap<String, List<FlupItemResponse>>(
								new Comparator<String>() {

									@Override
									public int compare(String o1, String o2) {
										String oo1 = o1.substring(o1
												.indexOf(",") + 1);
										String oo2 = o2.substring(o2
												.indexOf(",") + 1);
										return Integer.parseInt(oo1)
												- Integer.parseInt(oo2);
									}
								});
						dxtemp.add(list.get(i));
						dxm.put("dx" + "," + list.get(i).getShowNo(), dxtemp);
						hashMap.put(key, dxm);
					} else if (list.get(i).getFlupGroup().getRecordType() != null
							&& list.get(i).getFlupGroup().getRecordType()
									.equals("fx")) {
						List<FlupItemResponse> fxtemp = new ArrayList<FlupItemResponse>();
						Map<String, List<FlupItemResponse>> fxm = new TreeMap<String, List<FlupItemResponse>>(
								new Comparator<String>() {

									@Override
									public int compare(String o1, String o2) {
										String oo1 = o1.substring(o1
												.indexOf(",") + 1);
										String oo2 = o2.substring(o2
												.indexOf(",") + 1);
										return Integer.parseInt(oo1)
												- Integer.parseInt(oo2);
									}
								});
						fxtemp.add(list.get(i));
						fxm.put("fx" + "," + list.get(i).getShowNo(), fxtemp);
						hashMap.put(key, fxm);
					} else {
						List<FlupItemResponse> wbtemp = new ArrayList<FlupItemResponse>();
						Map<String, List<FlupItemResponse>> wbm = new TreeMap<String, List<FlupItemResponse>>(
								new Comparator<String>() {

									@Override
									public int compare(String o1, String o2) {
										String oo1 = o1.substring(o1
												.indexOf(",") + 1);
										String oo2 = o2.substring(o2
												.indexOf(",") + 1);
										return Integer.parseInt(oo1)
												- Integer.parseInt(oo2);
									}
								});
						wbtemp.add(list.get(i));
						wbm.put(list.get(i).getFlupGroup().getItemName() + ","
								+ list.get(i).getShowNo(), wbtemp);
						hashMap.put(key, wbm);
					}

				} else {
					String secondKey = list.get(i).getFlupGroup().getGroupTwo();
					List<FlupItemResponse> temp = new ArrayList<FlupItemResponse>();
					Map<String, List<FlupItemResponse>> m = new TreeMap<String, List<FlupItemResponse>>(
							new Comparator<String>() {

								@Override
								public int compare(String o1, String o2) {
									// TODO Auto-generated method stub
									String oo1 = o1.substring(o1.indexOf(",") + 1);
									String oo2 = o2.substring(o2.indexOf(",") + 1);
									return Integer.parseInt(oo1)
											- Integer.parseInt(oo2);
								}
							});
					temp.add(list.get(i));
					m.put(secondKey + "," + list.get(i).getShowNo(), temp);
					hashMap.put(key, m);

				}
			} else {
				if ((list.get(i).getFlupGroup().getGroupTwo() == null || list
						.get(i).getFlupGroup().getGroupTwo().equals(""))) {
					Map<String, List<FlupItemResponse>> tempMap = (Map<String, List<FlupItemResponse>>) hashMap
							.get(key);
					if (list.get(i).getFlupGroup().getRecordType() != null
							&& list.get(i).getFlupGroup().getRecordType()
									.equals("dx")) {
						boolean dxFlag = false;
						String dxTwoKey = "";
						for (Iterator dxIt = tempMap.keySet().iterator(); dxIt
								.hasNext();) {
							String dxS = (String) dxIt.next();
							String dx = dxS.substring(0, dxS.indexOf(","));
							if (dx != null && dx.equals("dx")) {
								dxFlag = true;
								dxTwoKey = dxS;
								break;

							}
						}
						if (!dxFlag) {
							List<FlupItemResponse> gListdx = new ArrayList<FlupItemResponse>();
							gListdx.add(list.get(i));
							tempMap.put("dx," + list.get(i).getShowNo(),
									gListdx);
							hashMap.put(key, tempMap);
						} else {
							List<FlupItemResponse> gListdxExist = tempMap
									.get(dxTwoKey);
							gListdxExist.add(list.get(i));
							tempMap.put(dxTwoKey, gListdxExist);
							hashMap.put(key, tempMap);
						}
					} else if (list.get(i).getFlupGroup().getRecordType() != null
							&& list.get(i).getFlupGroup().getRecordType()
									.equals("fx")) {
						boolean fxFlag = false;
						String fxTwoKey = "";
						for (Iterator fxIt = tempMap.keySet().iterator(); fxIt
								.hasNext();) {
							String fxS = (String) fxIt.next();
							String fx = fxS.substring(0, fxS.indexOf(","));
							if (fx != null && fx.equals("fx")) {
								fxFlag = true;
								fxTwoKey = fxS;
								break;

							}
						}

						if (!fxFlag) {
							List<FlupItemResponse> gListfx = new ArrayList<FlupItemResponse>();
							gListfx.add(list.get(i));
							tempMap.put("fx," + list.get(i).getShowNo(),
									gListfx);
							hashMap.put(key, tempMap);
						} else {
							List<FlupItemResponse> gListfxExist = tempMap
									.get(fxTwoKey);
							gListfxExist.add(list.get(i));
							tempMap.put(fxTwoKey, gListfxExist);
							hashMap.put(key, tempMap);
						}
					} else {
						boolean flag = false;
						String two = "";
						for (Iterator it = tempMap.keySet().iterator(); it
								.hasNext();) {
							String str = (String) it.next();
							String s = str.substring(0, str.indexOf(","));
							if (s != null
									&& s.equals(list.get(i).getFlupGroup()
											.getGroupTwo())) {
								flag = true;
								two = str;
								break;
							}
						}
						if (!flag) {
							List<FlupItemResponse> gListwb = new ArrayList<FlupItemResponse>();
							gListwb.add(list.get(i));
							tempMap.put(list.get(i).getFlupGroup()
									.getItemName()
									+ "," + list.get(i).getShowNo(), gListwb);
							hashMap.put(key, tempMap);
						} else {
							List<FlupItemResponse> gListfx2 = tempMap.get(two);
							gListfx2.add(list.get(i));
							tempMap.put(two, gListfx2);
							hashMap.put(key, tempMap);
						}
					}
				} else {
					Map<String, List<FlupItemResponse>> map = (Map<String, List<FlupItemResponse>>) hashMap
							.get(key);

					boolean flag = false;
					String two = "";
					for (Iterator it = map.keySet().iterator(); it.hasNext();) {
						String str = (String) it.next();
						String s = str.substring(0, str.indexOf(","));
						if (s != null
								&& s.equals(list.get(i).getFlupGroup()
										.getGroupTwo())) {
							flag = true;
							two = str;
							break;
						}
					}
					if (!flag) {
						List<FlupItemResponse> gListwb2 = new ArrayList<FlupItemResponse>();
						gListwb2.add(list.get(i));
						map.put(list.get(i).getFlupGroup().getGroupTwo() + ","
								+ list.get(i).getShowNo(), gListwb2);
						hashMap.put(key, map);
					} else {
						List<FlupItemResponse> gListfx3 = map.get(two);
						gListfx3.add(list.get(i));
						map.put(two, gListfx3);
						hashMap.put(key, map);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<table id=\"tableView\" border=\"1\" bordercolor=\"#a0c6e5\" width=\"80%\"; style=\"border-collapse:collapse;margin-left: 5%; margin-right: 5%; margin-top:5px;\">");
		for (Iterator<String> it = hashMap.keySet().iterator(); it.hasNext();) {
			String sbKey = it.next();
			Map<String, List<FlupItemResponse>> secondMap = hashMap.get(sbKey);
			sb.append("<tr>");
			sb.append("<td colspan='1' rowspan='" + secondMap.size() + "'>");
			sb.append(sbKey);
			sb.append("</td>");
			int count = 0;
			for (Iterator<String> its = secondMap.keySet().iterator(); its
					.hasNext();) {
				count++;
				String sbTwoKey = its.next();
				List<FlupItemResponse> sblist = secondMap.get(sbTwoKey);
				String twoMapKey = sbTwoKey.substring(0, sbTwoKey.indexOf(","));
				if (twoMapKey != null
						&& (!twoMapKey.equals("dx") && (!twoMapKey.equals("fx")))) {
					String twoShowKey = "";
					if (!twoMapKey.equals(sblist.get(0).getFlupGroup()
							.getItemName())) {
						twoShowKey = twoMapKey;
					}
					if (sblist.size() > 1) {
						Collections.sort(sblist, new ComparaFlupItem());
						sb.append("<td>");
						sb.append(twoMapKey);
						sb.append("</td>");

						boolean flagType = false;
						for (int z = 0; z < sblist.size(); z++) {
							if (sblist.get(z).getFlupGroup().getRecordType()
									.equals("wb")) {
								flagType = true;
								break;
							}
						}
						if (!flagType) {
							sb.append("<td>");
							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(twoMapKey);
									sb.append("<input type='text' class='fluptext'  rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' name='"
											+ twoMapKey
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getItemName()
											+ "\" value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+","+twoShowKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
							}
							sb.append("</td>");
						} else { // 简单的判断单选，复选，文本混合类型
							sb.append("<td>");
							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext' rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getItemName()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' name='"
											+ twoMapKey
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+","+twoShowKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
								sb.append("<br/>");
							}
							sb.append("</td>");
						}
						sb.append("</tr>");
						if (secondMap.size() > 1) {
							if (secondMap.size() != count)
								sb.append("<tr>");
						}
					} else {
						if (twoMapKey.equals(sblist.get(0).getFlupGroup()
								.getItemName())) {
							sb.append("<td>");
							sb.append(twoMapKey);
							sb.append("</td>");

							for (int j = 0; j < sblist.size(); j++) {
								sb.append("<td>");
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append("<input type='text' class='fluptext' rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getItemName()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' name='"
											+ twoMapKey
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+","+twoShowKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
								sb.append("</td>");
							}
							sb.append("</tr>");
							if (secondMap.size() > 1) {
								if (secondMap.size() != count)
									sb.append("<tr>");
							}
						} else {
							sb.append("<td>");
							sb.append(twoMapKey);
							sb.append("</td>");

							for (int j = 0; j < sblist.size(); j++) {
								sb.append("<td>");
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext' rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getItemName()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' name='"
											+ twoMapKey
											+ "' tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ twoShowKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+","+twoShowKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
								sb.append("</td>");
							}
							sb.append("</tr>");
							if (secondMap.size() > 1) {
								if (secondMap.size() != count)
									sb.append("<tr>");
							}
						}
					}
				} else {
					String showKey = "";
					if (!twoMapKey.equals(sblist.get(0).getFlupGroup()
							.getItemName())) {
						showKey = twoMapKey;
					}
					if (twoMapKey.equals("dx")) {
						if (sblist.size() > 1) {
							Collections.sort(sblist, new ComparaFlupItem());
							sb.append("<td>");
							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext'  rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ ""
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' rel=\"单选\" tag=\""
											+ sbKey
											+ ","
											+ ""
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getItemName()
											+ "\" name='"
											+ sbKey
											+ twoMapKey
											+ "' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox'  class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ ""
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
							}
							sb.append("</td>");
							sb.append("<td>");
							sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
							sb.append("</td>");
							sb.append("</tr>");

						} else {
							sb.append("<td>");
							sb.append(twoMapKey);
							sb.append("</td>");

							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext'  rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ ""
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' rel=\"单选\" tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getItemName()
											+ "\" name='"
											+ sbKey
											+ twoMapKey
											+ "' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
								sb.append("</tr>");
								if (secondMap.size() > 1) {
									if (secondMap.size() != count)
										sb.append("<tr>");
								}
							}
						}
					} else if (twoMapKey.equals("fx")) {
						if (sblist.size() > 1) {
							Collections.sort(sblist, new ComparaFlupItem());
							sb.append("<td>");
							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext' rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ ""
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' rel=\"单选\" tag=\""
											+ sbKey
											+ ","
											+ ""
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='"
											+ sbKey
											+ twoMapKey
											+ "' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ ""
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								}
							}
							sb.append("</td>");
							sb.append("<td>");
							sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
							sb.append("</td>");
							sb.append("</tr>");

						} else {
							sb.append("<td>");
							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext' rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' rel=\"单选\" tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='"
											+ sbKey
											+ twoMapKey
											+ "' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sblist.get(j).getFlupGroup()
													.getItemName()
											+ ","
											+ showKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
								sb.append("</td>");
								sb.append("<td>");
								sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
								sb.append("</td>");
								sb.append("</tr>");
								if (secondMap.size() > 1) {
									if (secondMap.size() != count)
										sb.append("<tr>");
								}
							}
						}
					} else {
						if (sblist.size() > 1) {
							Collections.sort(sblist, new ComparaFlupItem());
							sb.append("<td>");
							sb.append(twoMapKey);
							sb.append("</td>");
							sb.append("<td>");
							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext' rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' rel=\"单选\" tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='"
											+ sbKey
											+ twoMapKey
											+ "' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox' class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");

								}
							}
							sb.append("</td>");
							sb.append("<td>");
							sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
							sb.append("</td>");

						} else {
							sb.append("<td>");
							sb.append(twoMapKey);
							sb.append("</td>");
							sb.append("<td>");
							for (int j = 0; j < sblist.size(); j++) {
								if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("wb")) {
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<input type='text' class='fluptext' rel=\"文本\" lang='"
											+ sblist.get(j).getFlupGroup()
													.getItemRequired()
											+ "' tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",wb,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" value=''/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("dx")) {
									sb.append("<input type='radio' class='flupradio' rel=\"单选\" tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",dx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='"
											+ sbKey
											+ twoMapKey
											+ "' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else if (sblist.get(j).getFlupGroup()
										.getRecordType() != null
										&& sblist.get(j).getFlupGroup()
												.getRecordType().equals("fx")) {
									sb.append("<input type='checkbox'  class='flupcheckbox' rel=\"复选\"  tag=\""
											+ sbKey
											+ ","
											+ showKey
											+ ",fx,"
											+ sblist.get(j).getFlupGroup()
													.getFlupGroupId()
											+ ","
											+ sblist.get(j).getFlupGroup()
													.getDataType()
											+ "\" name='' value='"
											+ sblist.get(j).getFlupGroup()
													.getItemName() + "'/>");
									sb.append(sblist.get(j).getFlupGroup()
											.getItemName());
									sb.append("<br/>");
								} else {
									// sb.append("<input type='text' class='tisi' rel=\"提示\"  tag=\""+sbKey+",提示,"+sblist.get(j).getFlupGroup().getFlupGroupId()+","+sblist.get(j).getFlupGroup().getDataType()+"\" name='' readonly='readonly' value='提示'/>");
								}
								sb.append("<td>");
								sb.append("</tr>");
								if (secondMap.size() > 1) {
									if (secondMap.size() != count)
										sb.append("<tr>");
								}
							}
						}
					}
				}

			}
		}
		sb.append("</table>");
		if (showView != null && !showView.equals("")) {
			sb.append("<div style='margin-left:250px;'><input type='button' id='saveFlupItem' value='保存'/></div>");
		}
		return sb.toString();

	}

	/*****
	 * 自定义疾病模板 2014-12-12 韦
	 */
	public static final String getDiseasItemTemplate(
			List<DiseaseItemTemplate> list, String showView) {
	
		List<DiseaseItemTemplate> l = list;
		List<String[]> ls = new ArrayList<String[]>();

		for (int i = 0; i < l.size(); i++) {
			String rows[] = new String[3];
			// 第一列
			rows[0] = l.get(i).getDiseaseItem().getGroupOne().toString();
			// 第二列
			if (l.get(i).getDiseaseItem().getGroupTwo() == null
					|| l.get(i).getDiseaseItem().getGroupTwo() == ""
					&& !l.get(i).getDiseaseItem().getRecordType().toString()
							.equals("dx")) {
				rows[1] = l.get(i).getDiseaseItem().getItemName();
			}
			if (l.get(i).getDiseaseItem().getGroupTwo() == null
					&& l.get(i).getDiseaseItem().getRecordType().toString()
							.equals("dx")) {
				rows[1] = "<input type='radio' name='"+l.get(i).getDiseaseItem().getGroupOne()+l.get(i).getDiseaseItem().getGroupTwo()+"' rel='单选' class='diseaseradio'tag='"+getInputTag(l.get(i))+"' value="
						+ l.get(i).getDiseaseItem().getItemName() + " />"
						+ l.get(i).getDiseaseItem().getItemName();
			}
			if (l.get(i).getDiseaseItem().getGroupTwo() != null) {
				rows[1] = l.get(i).getDiseaseItem().getGroupTwo();
			}
			// 第三列 第二项空，类型文本，显示文本框
			if (l.get(i).getDiseaseItem().getGroupTwo() == null
					|| l.get(i).getDiseaseItem().getGroupTwo() == ""
					&& l.get(i).getDiseaseItem().getRecordType().equals("wb")) {
				rows[2] = "<input type='text' rel='文本' data='"+l.get(i).getDiseaseItem().getDataType()+"' class='diseasetext' name="
						+ l.get(i).getDiseaseItem().getGroupTwo()
						+ " value='' size='15' tag='"+getInputTag(l.get(i))+"' />";
			}
			// 第二项不为空，且文本类型，则显示内容和文本框
			if (l.get(i).getDiseaseItem().getGroupTwo() != null
					&& l.get(i).getDiseaseItem().getRecordType().equals("wb")) {
				rows[2] = l.get(i).getDiseaseItem().getItemName().toString()
						+ "<input type='text' rel='文本' name='' data='"+l.get(i).getDiseaseItem().getDataType()+"' class='diseasetext' value=''size='15' tag='"+getInputTag(l.get(i))+"' />";
			}
			// 第二项不为空，且复选类型，则显示内容和复选
			if (l.get(i).getDiseaseItem().getGroupTwo() != null
					&& l.get(i).getDiseaseItem().getRecordType().equals("fx")) {
				rows[2] = "<input type='checkbox' name=''  rel='复选' class='diseasechekbox' value='"+l.get(i).getDiseaseItem().getItemName()+"'size='15' tag='"+getInputTag(l.get(i))+"' />"
						+ l.get(i).getDiseaseItem().getItemName().toString();
			}
			// 第二项不为空，单选类型，则显示单选按钮
			if (l.get(i).getDiseaseItem().getGroupTwo() != null
					&& l.get(i).getDiseaseItem().getRecordType().toString()
							.equals("dx")) {
				rows[2] = "<input type='radio' rel='单选' class='diseaseradio' name="
						+ l.get(i).getDiseaseItem().getGroupOne()+l.get(i).getDiseaseItem().getGroupTwo() + "  value="
						+ l.get(i).getDiseaseItem().getItemName() + " tag='"+getInputTag(l.get(i))+"' />"
						+ l.get(i).getDiseaseItem().getItemName();
			}
			// 第二项为空，单选类型，则显示单选按钮
			if (l.get(i).getDiseaseItem().getGroupTwo() == null
					&& l.get(i).getDiseaseItem().getRecordType().toString()
							.equals("dx")) {
				rows[2] = "&nbsp;";
			}
			//第二项为空，下拉框类型，则显示下拉框
			if (l.get(i).getDiseaseItem().getGroupTwo() == null
					&& l.get(i).getDiseaseItem().getRecordType().toString()
							.equals("xlk")) {
				rows[2] = getSelectOption(l.get(i));
			}
			if (l.get(i).getDiseaseItem().getGroupTwo() != null
					&& l.get(i).getDiseaseItem().getRecordType().toString()
							.equals("xlk")) {
				rows[2] = getSelectOption(l.get(i));
			}
			

			ls.add(rows);
		}
		int rowspan1 = 1;
		int rowspan2 = 1;
		String cell2 = "";
		String cell1 = "";
		String table = "";
		//合并单元格
		for (int i = ls.size() - 1; i >= 0; i--) {

			String tr = "";
			if (i == 0) {
				cell1 = "";
				cell2 = "";
			} else {
				cell1 = ls.get(i - 1)[0].toString();
				cell2 = ls.get(i - 1)[1].toString();
			}
			// 最后一行与上一行相同，rowspan+1
			if (cell1.equals(ls.get(i)[0].toString())) {
				rowspan1 += 1;
				tr = "<tr>";
			} else {
				tr = "<tr><td rowspan=" + rowspan1 + ">" + ls.get(i)[0]
						+ "</td>";
				rowspan1 = 1;
			}

			// 最后一行与上一行相同，rowspan+1
			if (cell2.equals(ls.get(i)[1].toString())
					&& cell1.equals(ls.get(i)[0].toString())) {
				rowspan2 += 1;
			} else {
				tr = tr + "<td rowspan=" + rowspan2 + ">" + ls.get(i)[1]
						+ "</td>";
				rowspan2 = 1;
			}

			table = tr + "<td>" + ls.get(i)[2]
					+ "</td></tr>" + table;
		}
		table = "<table id=\"tableDiseaseView\" border=\"1\" bordercolor=\"#a0c6e5\" width=\"100%\"; style=\"border-collapse:collapse;margin-left: 5%; margin-right: 5%; margin-top:5px;\">"
				+ table+"</table>";
		//sb.append("</table>");
		if (showView != null && !showView.equals("")) {
			table=table+"<div style='margin-left:250px;'><input type='button' id='saveDisease' value='保存'/></div>";
		}
		return table;
	}

	public static final String viewInspectDeital(List<ExportResponse> list) {
		Map<String, List<String>> hashmap = new LinkedHashMap<String, List<String>>();
		for (int i = 0; i < list.size(); i++) {
			if (!hashmap.containsKey(list.get(i).getGroupName())) {
				List<String> values = new ArrayList<String>();
				values.add(list.get(i).getItemName());
				hashmap.put(list.get(i).getGroupName(), values);
			} else {
				List<String> resultValue = hashmap.get(list.get(i).getGroupName());
				resultValue.add(list.get(i).getItemName());
				hashmap.put(list.get(i).getGroupName(), resultValue);
			}
		}
		StringBuilder builder = new StringBuilder();
		builder.append("<table  border=\"1\" bordercolor=\"#a0c6e5\" width=\"80%\"; style=\"border-collapse:collapse;margin-left: 5%; margin-right: 5%;\">");
		for (Iterator<String> it = hashmap.keySet().iterator(); it.hasNext();) {
			String key = it.next();
		
			List<String> value = hashmap.get(key);
			builder.append("<tr>");
			builder.append("<td rowspan='" + value.size() + "'>");
			builder.append(key);
			builder.append("</td>");
			for (int j = 0; j < value.size(); j++) {
				if (j == 0) {
					builder.append("<td>");
					builder.append(value.get(j));
					builder.append("</td>");
				    builder.append("</tr>");
				} else {
					builder.append("<tr>");
					builder.append("<td>");
					builder.append(value.get(j));
					builder.append("</td>");
					builder.append("</tr>");
				}
				

			}

		}
		return builder.toString();
	}

	/*****
	 * 组装数据
	 * 
	 * @param list
	 * @return
	 */
	public static Map<String, Map<String, List<FlupItemResponse>>> packFlupItem(
			List<FlupItemResponse> list) {
		Map<String, Map<String, List<FlupItemResponse>>> map = new HashMap<String, Map<String, List<FlupItemResponse>>>();
		FlupItemResponse r = null;
		for (int i = 0; i < list.size(); i++) {
			r = list.get(i);
			if (!map.containsKey(r.getFlupGroup().getGroupOne())) {
				List<FlupItemResponse> rflupItem = new ArrayList<FlupItemResponse>();
				Map<String, List<FlupItemResponse>> secondmap = new HashMap<String, List<FlupItemResponse>>();
				if (r.getFlupGroup().getGroupTwo() != null
						&& !r.getFlupGroup().getGroupTwo().equals("")) {
					rflupItem.add(r);
					secondmap.put(r.getFlupGroup().getGroupTwo(), rflupItem);
				} else {
					rflupItem.add(r);
					secondmap.put(r.getFlupGroup().getItemName(), rflupItem);
				}
				map.put(r.getFlupGroup().getGroupOne(), secondmap);
			} else {
				Map<String, List<FlupItemResponse>> samemap = map.get(r
						.getFlupGroup().getGroupOne());
				if (r.getFlupGroup().getGroupTwo() != null
						&& !r.getFlupGroup().getGroupTwo().equals("")) {
					if (!samemap.containsKey(r.getFlupGroup().getItemName())) {
						List<FlupItemResponse> listsameitem = new ArrayList<FlupItemResponse>();
						listsameitem.add(r);
						samemap.put(r.getFlupGroup().getGroupTwo(),
								listsameitem);
					} else {
						List<FlupItemResponse> flupitems = samemap.get(r
								.getFlupGroup().getGroupTwo());
						flupitems.add(r);
						samemap.put(r.getFlupGroup().getGroupTwo(), flupitems);
					}
				} else {
					if (!samemap.containsKey(r.getFlupGroup().getItemName())) {
						List<FlupItemResponse> listsameitem = new ArrayList<FlupItemResponse>();
						listsameitem.add(r);
						samemap.put(r.getFlupGroup().getGroupTwo(),
								listsameitem);
					} else {
						List<FlupItemResponse> flupitems = samemap.get(r
								.getFlupGroup().getGroupTwo());
						flupitems.add(r);
						samemap.put(r.getFlupGroup().getGroupTwo(), flupitems);
					}
				}
				map.put(r.getFlupGroup().getGroupOne(), samemap);
			}
		}
		return map;
	}

	/******
	 * 
	 * 下次随访设置 2014-12-11 韦
	 */
	public static final String getNextTable(List<FlupItemResponse> list) {
		List<FlupItemResponse> l = list;
		StringBuffer sb = new StringBuffer();

		List<String[]> ls = new ArrayList<String[]>();

		for (int i = 0; i < l.size(); i++) {
			String isChecked =""; 
			if(l.get(i).getFlupGroupId2()==null || l.get(i).getFlupGroupId2().equals("")){
				isChecked="";
			}else
				isChecked="checked";
			String rows[] = new String[4];
			// 第一列
			rows[0] = l.get(i).getFlupGroup().getGroupOne().toString();
			// 第二列
			if (l.get(i).getFlupGroup().getGroupTwo() == null
					|| l.get(i).getFlupGroup().getGroupTwo() == ""
					&& !l.get(i).getFlupGroup().getRecordType().toString()
							.equals("dx")) {
				rows[1] = l.get(i).getFlupGroup().getItemName();
			}
			if (l.get(i).getFlupGroup().getGroupTwo() == null
					&& l.get(i).getFlupGroup().getRecordType().toString()
							.equals("dx")) {
				rows[1] = "<input type='radio' value="
						+ l.get(i).getFlupGroup().getItemName() + " />"
						+ l.get(i).getFlupGroup().getItemName();
			}
			if (l.get(i).getFlupGroup().getGroupTwo() != null) {
				rows[1] = l.get(i).getFlupGroup().getGroupTwo();
			}
			// 第三列 第二项空，类型文本，显示文本框
			if (l.get(i).getFlupGroup().getGroupTwo() == null
					|| l.get(i).getFlupGroup().getGroupTwo() == ""
					&& l.get(i).getFlupGroup().getRecordType().equals("wb")) {
				rows[2] = "<input type='text' name="
						+ l.get(i).getFlupGroup().getGroupTwo()
						+ " value=''size='15' />";
			}
			// 第二项不为空，且文本类型，则显示内容和文本框
			if (l.get(i).getFlupGroup().getGroupTwo() != null
					&& l.get(i).getFlupGroup().getRecordType().equals("wb")) {
				rows[2] = l.get(i).getFlupGroup().getItemName().toString()
						+ "<input type='text' value=''size='15' />";
			}
			// 第二项不为空，且复选类型，则显示内容和复选
			if (l.get(i).getFlupGroup().getGroupTwo() != null
					&& l.get(i).getFlupGroup().getRecordType().equals("fx")) {
				rows[2] = "<input type='checkbox' value=''size='15' />"
						+ l.get(i).getFlupGroup().getItemName().toString();
			}
			// 第二项不为空，单选类型，则显示单选按钮
			if (l.get(i).getFlupGroup().getGroupTwo() != null
					&& l.get(i).getFlupGroup().getRecordType().toString()
							.equals("dx")) {
				rows[2] = "<input type='radio' name="
						+ l.get(i).getFlupGroup().getGroupTwo() + "  value="
						+ l.get(i).getFlupGroup().getItemName() + " />"
						+ l.get(i).getFlupGroup().getItemName();
			}
			// 第二项为空，单选类型，则显示单选按钮
			if (l.get(i).getFlupGroup().getGroupTwo() == null
					&& l.get(i).getFlupGroup().getRecordType().toString()
							.equals("dx")) {
				rows[2] = "&nbsp;";
			}

			rows[3] = "<input type='checkbox' name='cb_flup_group' "+isChecked+" value='"
					+ l.get(i).getFlupGroup().getFlupGroupId() + "_"
					+ l.get(i).getShowNo() + "'>";

			ls.add(rows);
		}
		int rowspan1 = 1;
		int rowspan2 = 1;
		String cell2 = "";
		String cell1 = "";
		String table = "";
		//合并单元格
		for (int i = ls.size() - 1; i >= 0; i--) {

			String tr = "";
			if (i == 0) {
				cell1 = "";
				cell2 = "";
			} else {
				cell1 = ls.get(i - 1)[0].toString();
				cell2 = ls.get(i - 1)[1].toString();
			}
			// 最后一行与上一行相同，rowspan+1
			if (cell1.equals(ls.get(i)[0].toString())) {
				rowspan1 += 1;
				tr = "<tr>";
			} else {
				tr = "<tr><td rowspan=" + rowspan1 + ">" + ls.get(i)[0]
						+ "</td>";
				rowspan1 = 1;
			}

			// 最后一行与上一行相同，rowspan+1
			if (cell2.equals(ls.get(i)[1].toString())
					&& cell1.equals(ls.get(i)[0].toString())) {
				rowspan2 += 1;
			} else {
				tr = tr + "<td rowspan=" + rowspan2 + ">" + ls.get(i)[1]
						+ "</td>";
				rowspan2 = 1;
			}

			table = tr + "<td>" + ls.get(i)[3] + "</td><td>" + ls.get(i)[2]
					+ "</td></tr>" + table;
		}
		table = "<table id=\"tableView\" border=\"1\" bordercolor=\"#a0c6e5\" width=\"100%\"; style=\"border-collapse:collapse;margin-left: 5%; margin-right: 5%; margin-top:5px;\">"
				+ table;
		table = table
				+ "<tr><td colspan=4 align='center'><input type='button' id='saveFlupDynamic' value='保存'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' id='closeFlupDynamic' value='取消'></td></tr></table>";
		return table;

	}
	
	public static String getSelectOption(DiseaseItemTemplate d){
		String[] arr = d.getDiseaseItem().getListValue().split(",|，");
		String select="";
		for(int i=0;i<arr.length;i++){
			select +="<option  value='"+arr[i]+"' tag='"+getInputTag(d)+"'>"+arr[i]+"</option>";
		}
		select ="<select class='diseaseselect'>"+select +"</select>";
		return select;
	}
	public static String getInputTag(DiseaseItemTemplate d){
		String recordType =d.getDiseaseItem().getRecordType();
		if(recordType.equals("dx")){
			recordType="单选";
		}
		if(recordType.equals("wb")){
			recordType="文本";
		}
		if(recordType.equals("fx")){
			recordType="复选";
		}
		if(recordType.equals("xlk")){
			recordType="下拉框";
		}
			
		return d.getDiseaseItem().getGroupOne()+","+d.getDiseaseItem().getGroupTwo()+","+recordType+","+d.getDiseaseItem().getDiseaseGroupId()+","+d.getDiseaseItem().getItemName();
	}

}
