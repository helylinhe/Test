package com.linkonworks.df.busi.service.impl;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.FlupItemDao;
import com.linkonworks.df.busi.service.FlupItemService;
import com.linkonworks.df.vo.FlupItem;

public class FlupItemServiceImpl implements FlupItemService {

	private FlupItemDao flupItemDao;

	@Override
	public List<FlupItem> getPageFlupItem(Page page) {
		return flupItemDao.getPageFlupItem(page);
	}

	public FlupItemDao getFlupItemDao() {
		return flupItemDao;
	}

	public void setFlupItemDao(FlupItemDao flupItemDao) {
		this.flupItemDao = flupItemDao;
	}

	@Override
	public Integer insert(FlupItem flupItem) throws Exception {
		return flupItemDao.insert(flupItem);
	}

	@Override
	public Integer delete(Map<String, Object> map) throws Exception {
		return flupItemDao.delete(map);
	}

	@Override
	public int update(FlupItem flupItem) {
		return flupItemDao.update(flupItem);
	}
}
