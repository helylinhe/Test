package com.linkonworks.df.busi.service.impl;

import java.util.List;

import com.linkonworks.df.busi.comment.Page;
import com.linkonworks.df.busi.dao.FileIndexDao;
import com.linkonworks.df.busi.service.FileIndexService;
import com.linkonworks.df.vo.FileIndex;

public class FileIndexServiceImpl implements FileIndexService {


	private FileIndexDao fileIndexDao;

	public FileIndexDao getFileIndexDao() {
		return fileIndexDao;
	}

	public void setFileIndexDao(FileIndexDao fileIndexDao) {
		this.fileIndexDao = fileIndexDao;
	}

	@Override
	public List<FileIndex> findPageList(Page page) {
		// TODO Auto-generated method stub
		return fileIndexDao.findPageList(page);
	}
	
}
