package com.linkonworks.df.busi.service;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.vo.PremachineManage;

public interface PremachineManageService {
	
	//全查
	public List<PremachineManage> getPageGroups(Page page);
	//增加
	public int addBlack(PremachineManage premachineManage);
	//删除
	public int deleteBlack(String id);
	//停用 和修改
	public int updatestate(PremachineManage premachineManage);
}
