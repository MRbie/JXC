package com.bie.dao;

import java.util.List;

import com.bie.po.JxcEmployee;

/***
 * 
 * @author 别先生
 * 1:员工的dao层接口
 * 	其它dao层的mapper接口继承此公共的接口.
 * 2:继承工具接口以后可以使用里面的方法,不必再重新写
 */
public interface JxcEmployeeMapper extends BaseMapper<JxcEmployee>{
    
	public List<JxcEmployee> selectByEmployeeRole(String roleName);
	
	//管理员登陆系统的方法
	public JxcEmployee adminLogin(JxcEmployee jxcEmployee);
	
	//管理员修改密码的方法
	public boolean modifyPassword(JxcEmployee jxcEmployee);
	
	//根据员工名获取员工信息
	public JxcEmployee findEmployeeByEmployeeName(String employeeName);
	
	//根据员工姓名查询员工的权限
	List<String> findPermissionsByEmployeeName(String employeeName);
	
	//员工报表统计信息
	public List<JxcEmployee> selectByEmployeeRoleType();
	
	//员工薪资统计
	public List<JxcEmployee> selectByEmployeeSalary();
	
	
} 