package com.bie.service;

import java.util.List;

import com.bie.po.JxcAdmin;

/**
 * 管理员的业务逻辑层
 * @author 别先生
 * 
 * 1:第一个管理员自己写的方法,其他功能进行提取公共的 
 * 	extends BaseService<JxcAdmin>
 */
public interface AdminService{

	//管理员登录的方法
	public JxcAdmin adminLogin(JxcAdmin jxcAdmin) throws Exception;
	
	//管理员插入的方法
	public int insertAdmin(JxcAdmin jxcAdmin) throws Exception;
	
	//查询所有管理员的方法
	public List<JxcAdmin> selectAllAdmin(JxcAdmin jxcAdmin) throws Exception;
	
	//查询个人详细信息
	public JxcAdmin queryBySingle(JxcAdmin jxcAdmin) throws Exception;
	
	//修改管理员信息的方法
	public boolean updateAdmin(JxcAdmin jxcAdmin) throws Exception;
	
	//删除管理员信息的方法,这里采用伪删除
	public boolean deleteAdmin(JxcAdmin jxcAdmin) throws Exception;
	
	//管理员按照条件查询的方法
	public List<JxcAdmin> queryByCondition(JxcAdmin jxcAdmin) throws Exception;
	
	//批量删除管理员的方法
	public boolean batchDeleteAdmin(List<Integer> adminIds) throws Exception;
	
	
	
}
