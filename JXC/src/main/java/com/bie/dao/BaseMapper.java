package com.bie.dao;

import java.util.List;

/**
 * 
 * @author 别先生
 * @date 2018年2月23日  
 * 1:dao层提取的工具接口,dao层抽取的公共的接口方法
 * 2:配合事务进行方法起名称
 */
public interface BaseMapper<T> {

	//添加单个对象,由于是提取公共的,所以参数传入泛型
	public boolean insert(T entity);
	
	//修改单个对象,根据对象的主键进行修改操作
	public boolean update(T entity);
	
	//删除单个对象,根据对象的主键进行删除操作
	public boolean delete(T entity);
	
	//通过主键批量删除数据
	public boolean deleteList(List<Integer> pks);
	
	//查询单个对象,根据对象的主键进行查询操作
	public T select(T entity);
	
	//查询所有对象
	public List<T> selectAll(T entity);
}
