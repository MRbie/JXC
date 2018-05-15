package com.bie.service;

import java.util.List;

/**
 * 
 * @author 别先生
 * @date 2018年2月23日  
 * 
 * @param <T>
 * 1:业务层的抽取
 * 	service层的工具类
 */
public interface BaseService<T> {

	//添加单个对象,
	public boolean insert(T entity) throws Exception;
	
	//修改单个对象,根据对象主键进行修改操作
	public boolean update(T entity) throws Exception;
	 
	//删除单个对象,根据对象主键进行删除操作
	public boolean delete(T entity) throws Exception;
	
	//通过主键（数组）批量删除数据
	public boolean deleteList(List<Integer> pks) throws Exception;
	
	//查询单个对象,,根据对象主键进行查询操作
	public T select(T entity) throws Exception;
	
	//查询所有对象
	public List<T> selectAll(T entity) throws Exception;
}
