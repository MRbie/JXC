package com.bie.dao;

import java.util.List;

import com.bie.po.JxcAdmin;

/**
 * 
 * @author 别先生
 * @date 2018年2月23日  
 * 管理员的dao层,继承工具类里面的接口
 */
public interface JxcAdminMapper extends BaseMapper<JxcAdmin>{
    
	//管理员登陆系统的方法
	public JxcAdmin adminLogin(JxcAdmin jxcAdmin);
	
	//管理员插入的方法
	public int insertAdmin(JxcAdmin jxcAdmin);
	
	//管理员查询所有的方法
	public List<JxcAdmin> selectAllAdmin(JxcAdmin jxcAdmin);
	
	//查询个人详细信息
	public JxcAdmin queryBySingle(int adminId);
	
	//修改管理员信息的方法
	public boolean updateAdmin(JxcAdmin jxcAdmin);
	
	//删除管理员信息的方法,这里采用伪删除
	public boolean deleteAdmin(JxcAdmin jxcAdmin);
	
	//管理员按照条件查询的方法
	public List<JxcAdmin> queryByCondition(JxcAdmin jxcAdmin);
	
	//批量删除管理员的方法
	public boolean batchDeleteAdmin(List<Integer> adminIds);
	
	
}