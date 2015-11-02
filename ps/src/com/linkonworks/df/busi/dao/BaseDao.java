package com.linkonworks.df.busi.dao;

import java.util.List;
import java.util.Map;

import com.linkonworks.df.busi.comment.Page;

public interface BaseDao<T> {
	
	/***
	 * 方法说明：添加方法
	 * 参数说明：VO
	 * @param t
	 * @return
	 * @throws Exception 
	 */
	public int insert(T t);
	
	/***
	 * 方法说明：更新方法
	 * 参数说明：VO
	 * @param t
	 * @return
	 */
	public int update(T t);
	
	/***
	 * 方法说明：删除方法
	 * 参数说明：VO
	 * @param t
	 * @return
	 */
	public int delete(T t);
	
	/***
	 * 方法说明：返回一个Object对象
	 * 参数说明：VO
	 * @param t
	 * @return
	 */
	public T findObject(T t);
	
	/***
	 * 方法说明：查询方法，返回一个List集合
	 * 参数说明： VO
	 * @param 
	 * @return
	 */
	
	public List<T> findListByObject(T t);
	
	/****
	 * 查询方法，返回一个List集合
	 * 参数说明：MAP
	 * @param map
	 * @return
	 */
	public List<T> findList(Map<String,?> map);
	
	/****
	 * 方法说明：调用分页时需要实现的方法用来获取总记录数
	 * 参数说明：MAP
	 * @param map
	 * @return
	 */
	public int findPageSize(Map<String,?> map);
	
	/***
	 * 
	 * 方法说明：调用分页时需要实现的方法用来获取当前页数据
	 * 参数说明：MAP
	 * @param map
	 * @return
	 */
	public List<T> findPageList(Page page);
	
	/**
	 * 
	 * 方法描述：批量新增
	 * 参数说明：list
	 * @param list
	 * @return
	 */
	public int insertBatch(List<T> list);
	
	/**
	 * 
	 * 方法描述：批量删除
	 * 参数说明：list
	 * @param list
	 * @return
	 */
	public int deleteBatch(List<T> list);


}
