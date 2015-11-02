package com.linkonworks.df.busi.webservice.service;

import java.util.List;

import javax.jws.WebService;

import com.linkonworks.df.vo.Dict;

@WebService
public interface DictWebService {

	List<Dict> getDictAll();
}
